package game;

import entities.Player;
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
		this.data.getCanvas().setSize(1366, 768);
		Player p = new Player();
		this.universe.addGameEntity(p);
	}
		
}
