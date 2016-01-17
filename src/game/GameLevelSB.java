package game;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.game.GameUniverseDefaultImpl;

public class GameLevelSB extends GameLevelDefaultImpl{

	public GameLevelSB(GameData data) {
		super(data);
	}

	@Override
	protected void init() {
		this.universe = new GameUniverseDefaultImpl();
		this.universe.setGameData(this.data);
		this.gameBoard = new GameUniverseViewPortSB(this.data);		
	}
		
}
