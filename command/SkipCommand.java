package jdp.command;

/**
 * @author wmy
 * @date 2021/8/12 9:44
 */

/**
 * 命令实现类：跳过
 */
public class SkipCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public SkipCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.skip();
    }
}
