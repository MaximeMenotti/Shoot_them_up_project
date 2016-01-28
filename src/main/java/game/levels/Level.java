package game.levels;

import java.util.Timer;
import java.util.TimerTask;

import entities.Player;
import game.GameUniverseViewPortSB;
import game.OverlapSB;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public abstract class Level extends GameLevelDefaultImpl{
	protected static int nbEnemies;
	public static int count = 0;
	public static Timer timer = new Timer();

	public abstract TimerTask getTimerTask();
	
	public Level(GameData data, int nbEnemiesToAdd) {
		super(data);
		nbEnemies = nbEnemiesToAdd;
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}
	
	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		Player aPlayer = new Player(data.getCanvas(),data);
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
		data.getUniverse().addGameEntity(aPlayer);
	}
	
}
