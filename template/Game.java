package jdp.template;

/**
 * @author wmy
 * @date 2021/8/12 10:18
 */

/**
 * 抽象模板 - 游戏
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板方法
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }

}
