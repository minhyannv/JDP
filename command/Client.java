package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:59
 */
public class Client {
    public static void main(String[] args) {
        // 创建 Receiver(接收者)
        MusicPlayer musicPlayer = new MusicPlayer();
        // Command(抽象命令类)
        Command playCommand = new PlayCommand(musicPlayer);
        Command skipCommand = new SkipCommand(musicPlayer);
        Command stopCommand = new StopCommand(musicPlayer);
        // 创建 Invoker(调用者)
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
