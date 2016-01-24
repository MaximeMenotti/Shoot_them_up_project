package game;

import entities.Player;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class GameLevelSB extends GameLevelDefaultImpl{

	public GameLevelSB(GameData data) {
		super(data);
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);		
		this.data.getCanvas().setSize(1366, 768);
		Player p = new Player(data.getCanvas(),data);
		data.getUniverse().addGameEntity(p);
	}
		
}
