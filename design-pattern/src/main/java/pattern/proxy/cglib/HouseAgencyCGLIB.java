package pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import pattern.proxy.House;
import pattern.proxy.HouseFactory;

import java.lang.reflect.Method;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseAgencyCGLIB implements MethodInterceptor {

    private House house;

    public HouseBuyer2 getInstance(Class clazz){
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(clazz);
//        enhancer.setCallback(this);
//        enhancer.create();
        return (HouseBuyer2) Enhancer.create(clazz,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
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
