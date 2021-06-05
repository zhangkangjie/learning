package pattern.proxy.jdk;


import pattern.proxy.House;
import pattern.proxy.Ibuy;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseBuyer implements Ibuy<House> {
    @Override
    public void buy(House house) {
        System.out.println("面积价格合适");
        System.out.println("买到房子："+house);
    }
}
