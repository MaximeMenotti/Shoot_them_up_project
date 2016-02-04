package game;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class GameUniverseViewPortWithCustomBackground extends GameUniverseViewPortDefaultImpl {
	
    /**
     * constructor
     * @param data the game data
     */
    public GameUniverseViewPortWithCustomBackground (GameData data) {
		super(data);
	}
	
    /**
     * get the picture's path for load the game's wallpaper
     * @return the picture path
     */
    protected URL backgroundImage() {
		return this.getClass().getResource("/images/spaceBG.jpg");
	}

}
