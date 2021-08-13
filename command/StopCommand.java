package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:44
 */

/**
 * 命令实现类：暂停
 */
public class StopCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public StopCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.stop();
    }
}
