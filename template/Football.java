package jdp.template;

/**
 * @author wmy
 * @date 2021/8/12 10:20
 */

/**
 * 具体模板类 - 踢足球游戏
 */
public class Football extends Game {
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

}
