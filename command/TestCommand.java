package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:59
 */

/**
 * 测试命令模式
 */
public class TestCommand {
    public static void main(String[] args) {
        // 创建 接收者
        MusicPlayer musicPlayer = new MusicPlayer();
        // 创建命令
        Command playCommand = new PlayCommand(musicPlayer);
        Command skipCommand = new SkipCommand(musicPlayer);
        Command stopCommand = new StopCommand(musicPlayer);
        // 创建命令请求者
        MusicInvoker invoker = new MusicInvoker();
        invoker.setPlayCommand(playCommand);
        invoker.setSkipCommand(skipCommand);
        invoker.setStopCommand(stopCommand);
        // 测试
        invoker.play();
        invoker.skip();
        invoker.stop();
        invoker.play();
        invoker.stop();
    }
}
