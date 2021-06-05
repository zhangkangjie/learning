#### Spring Bean的几种注册方式

##### XML 方式

在spring的XML配置文件中使用Bean标签注册。这种方式是比较传统的注册方式，随着Spring 的迭代，Spring 越来越多在完善和推荐基于java配置的注解`Java-based Configurations`来简化Spring的配置，因此基于XML 的配置的也就简单介绍至此。

```xml
<beans>
    <bean class="com.zkj.springframework.beanRegister.Person" />
</beans>
```

##### 基于Java代码配置的方式

###### @Component 和@ComponentScan 

基于组件注解和组件扫描的方式是比较常用的，使用方式就是将需要注册的Bean标记注解`@Component`，通过组件扫描将标记的bean注册入Spring容器。除`@Component`组件注解外，还有可以是其派生的一些注解，如常用的`@Service` `@Controller` `@Repository` 等，还可以是基于@Component 自定义注解。这种方式在不需要太多关注组件创建过程或定义组件的时候使用比较多。这种注册的bean name 默认情况下是类的首字母小写的简写名 。如示例中的就是myComponentPerson

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MyComponent {

}	
```

```java
@Data
@MyComponent
public class MyComponentPerson {
    private String name;
}
```

###### @Bean

这种方式通常是在@Configuration类的方法上中声明`@Bean` ，被标记方法的返回对象将被注册入容器。这种方式适合注册第三方库的类或者需要创建自定义bean的时候。这种注册的bean name 是在默认情况下是bean方法名

```java
@Configuration
public class BeanConfig {
    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("tom");
        return person;
    }
}
```

除了可以返回普通Bean外，还可以返回BeanFacory 注册bean ，这点与使用XML配置中的<bean factory-bean ='' /> 类似。

```java
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
```

```java
@Bean
public PersonFactoryBean person(){
    return new PersonFactoryBean();
}
```

```java
@Test
public void beanFactory(){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    Object person = context.getBean("person");
    Object personFactory = context.getBean(BeanFactory.FACTORY_BEAN_PREFIX+"person");
}
```

###### @Import

1. @Import 的普通类会注册为bean ，这种注册的bean name是类的全限定名

   ```java
   @Import(Person.class)
   @Configuration
   public class BeanImportConfig {
   }
   ```

   

2. 导入ImportSelector的实现类，ImportSelector 的实现类的selectImports 方法返回的类将会被注册bean

   ```java
   @Import(MyImportSelector.class)
   @Configuration
   public class BeanImportSelectorConfig {
       
   }
   ```

   ```java
   public class MyImportSelector implements ImportSelector {
       /**
        *
        * @param importingClassMetadata Import所在类的类信息
        */
       @Override
       public String[] selectImports(AnnotationMetadata importingClassMetadata) {
           //返回类名数组
           return new String[]{"com.zkj.springframework.beanRegister.Person"};
       }
   }
   ```

3. 导入ImportBeanDefinitionRegistrar的实现类，在实现类中可以通过BeanDefinitionRegistry的实例 registry 注册bean

   ```java
   @Import(MyImportBeanDefinitionRegistrar.class)
   @Configuration
   public class BeanImportBeanDefinitionRegistrarConfig {
   }
   ```

   ```java
   public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
       /**
        *
        * @param importingClassMetadata Import所在类的类信息
        * @param registry bean注册器
        */
       @Override
       public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
           RootBeanDefinition beanDefinition = new RootBeanDefinition(Person.class);
           registry.registerBeanDefinition("person",beanDefinition);
       }
   }
   ```

