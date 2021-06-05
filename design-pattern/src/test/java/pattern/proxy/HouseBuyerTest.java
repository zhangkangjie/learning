package pattern.proxy;

import org.junit.Test;
import pattern.proxy.cglib.HouseAgencyCGLIB;
import pattern.proxy.jdk.HouseAgencyJDK;
import pattern.proxy.cglib.HouseBuyer2;
import pattern.proxy.jdk.HouseBuyer;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class HouseBuyerTest {

    @Test
    public void buyHouse(){
        HouseAgencyJDK houseAgency = new HouseAgencyJDK();
        Ibuy instance = houseAgency.getInstance(new HouseBuyer());
        instance.buy(houseAgency.findHouse());

    }

    @Test
    public void buyHouseCGLIB(){
        HouseAgencyCGLIB houseAgency = new HouseAgencyCGLIB();
        HouseBuyer2 instance = houseAgency.getInstance(HouseBuyer2.class);
        instance.buy(houseAgency.findHouse());

    }
}