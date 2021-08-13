package jdp.strategy;

/**
 * @author wmy
 * @date 2021/8/11 17:10
 */

/**
 * 商品类
 */
public class Goods {
    private String name;
    private Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
