package pattern.proxy.jdk;

import pattern.proxy.House;
import pattern.proxy.HouseFactory;
import pattern.proxy.Ibuy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseAgencyJDK implements InvocationHandler {
    /**
     * 持有对象的引用
     */
    private HouseBuyer target;

    private House house;

    public Ibuy<House> getInstance(HouseBuyer target) {
        this.target = target;
        Class<? extends HouseBuyer> clazz = target.getClass();
        return (Ibuy<House>) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before() {
        System.out.println("询问购房要求");
        System.out.println("找到了房子" + findHouse());
    }

    private void after() {
        System.out.println("购房愉快");
    }

    public House findHouse() {
        this.house = HouseFactory.getHouse();
        return house;
    }


}
