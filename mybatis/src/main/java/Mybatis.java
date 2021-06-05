/**
 *
 */
public class Mybatis {
    private static Mybatis ourInstance = new Mybatis();

    public static Mybatis getInstance() {
        return ourInstance;
    }

    private Mybatis() {
    }
}
