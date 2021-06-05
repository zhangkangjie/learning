package pattern.proxy.cglib;


import pattern.proxy.House;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseBuyer2 {

    public void buy(House house) {
        System.out.println("面积价格合适");
        System.out.println("买到房子："+house);
    }
}
