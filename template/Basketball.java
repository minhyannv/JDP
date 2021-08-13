package jdp.template;

/**
 * @author wmy
 * @date 2021/8/12 10:20
 */

/**
 * 具体模板类 - 打篮球游戏
 */
public class Basketball extends Game {
    @Override
    void endPlay() {
        System.out.println("Basketball Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Basketball Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Basketball Game Started. Enjoy the game!");
    }

}
