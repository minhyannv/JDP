package jdp.template;

/**
 * @author wmy
 * @date 2021/8/12 10:21
 */

/**
 * 测试模板方法模式
 */
public class TestTemplate {
    public static void main(String[] args) {

        Game game = new Basketball();
        game.play();
        System.out.println();
        game = new Football();
        game.play();

    }
}
