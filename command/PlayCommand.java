package jdp.command;

import java.util.ArrayList;

/**
 * @author wmy
 * @date 2021/8/12 9:44
 */

/**
 * 命令实现类：播放
 */
public class PlayCommand implements Command {

    /**
     * 接收者
     */
    private MusicPlayer musicPlayer;

    public PlayCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.play();
    }
}
