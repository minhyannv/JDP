package jdp.factory.simple_factory;

/**
 * @author wmy
 * @date 2021/8/12 16:09
 */

/**
 * 食物工厂
 */
class FoodFactory {
    /**
     * 根据需求制造食品
     *
     * @param n
     * @return
     */
    public static Food getFood(int n) {
        Food food = null;
        switch (n) {
            case 1:
                food = new Hambuger();
                break;
            case 2:
                food = new FrenchFries();
                break;
            case 3:
                food = new Drumstick();
                break;
        }
        return food;
    }
}
