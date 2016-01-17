package game;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class GameUniverseViewPortSB extends GameUniverseViewPortDefaultImpl {
	
	public GameUniverseViewPortSB (GameData data) {
		super(data);
	}
	
	protected URL backgroundImage() {
		return this.getClass().getResource("/resources/spaceBG.jpg");
	}

}
