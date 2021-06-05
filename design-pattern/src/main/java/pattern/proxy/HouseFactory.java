package pattern.proxy;

import java.util.Random;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseFactory {
    public static House getHouse(){
        return new House(100,90);
    }
}
