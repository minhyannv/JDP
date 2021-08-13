package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:47
 */

/**
 * 命令接收者
 */
public class MusicPlayer {
    public void play() {
        System.out.println("播放...");
    }

    public void skip() {
        System.out.println("跳过...");
    }

    public void stop() {
        System.out.println("停止...");
    }
}
