package game;

import entities.Enemy;
import entities.Player;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class LevelWithEnemies extends GameLevelDefaultImpl{
	
	protected int nbEnemies;
	
	public LevelWithEnemies(GameData data, int nbEnemies) {
		super(data);
		this.nbEnemies = nbEnemies;
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		Player aPlayer = new Player(data.getCanvas(),data);
		for(int i = 0 ; i < nbEnemies; i ++){
			data.getUniverse().addGameEntity(new Enemy(data.getCanvas(), data));
		}
		data.getUniverse().addGameEntity(aPlayer);
		
	}

}
