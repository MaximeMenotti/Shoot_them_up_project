package game;

import entities.Player;
import entities.Rock;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class LevelWithRocks extends GameLevelDefaultImpl{
	
	final static int ROCK_SPEED = 12;
	
	protected int nbRocks;
	
	public LevelWithRocks(GameData data, int nbRocks) {
		super(data);
		this.nbRocks = nbRocks;
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		Player aPlayer = new Player(data.getCanvas(),data);
		for(int i = 0 ; i < nbRocks; i ++){
			data.getUniverse().addGameEntity(new Rock(data.getCanvas(), data));
		}
		data.getUniverse().addGameEntity(aPlayer);
		
	}

}
