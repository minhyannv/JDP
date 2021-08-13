package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:46
 */

/**
 * 请求者角色,接收客户端发送过来的指令
 */

public class MusicInvoker {
    private Command playCommand;
    private Command skipCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setSkipCommand(Command skipCommand) {
        this.skipCommand = skipCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    public void play() {
        playCommand.execute();
    }

    public void skip() {
        skipCommand.execute();
    }

    public void stop() {
        stopCommand.execute();
    }
}
