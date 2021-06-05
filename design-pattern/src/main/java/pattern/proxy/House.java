package pattern.proxy;

/**
 * @author zkj
 * @date 2019/4/5
 */
public class House {
    private int size;
    private int price;

    public House(int size, int price) {
        this.size = size;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " 面积："+size+"平，价钱："+price+"万的房子";
    }
}
