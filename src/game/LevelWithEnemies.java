package game;

import java.util.Timer;
import java.util.TimerTask;

import entities.EnemyShip;
import entities.Player;
import entities.Wall;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class LevelWithEnemies extends GameLevelDefaultImpl{
	
	protected static int nbEnemies;
	public static int count = 0;
	public static Timer timer = new Timer();
	
	public LevelWithEnemies(GameData data, int nbEnemies) {
		super(data);
		LevelWithEnemies.nbEnemies = nbEnemies;
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		Player aPlayer = new Player(data.getCanvas(),data);
		Wall w = new Wall(data.getCanvas());
			TimerTask task = new TimerTask()
			{
				@Override
				public void run() 
				{
					System.out.println("Waiting finshed");
					count++;
				     if (count >= nbEnemies) {
				         timer.cancel();
				         timer.purge();
				         return;
				     }
					data.getUniverse().addGameEntity(new EnemyShip(data.getCanvas(), data));
				}	
			};
			timer.scheduleAtFixedRate(task, 0, 2000);
		data.getUniverse().addGameEntity(aPlayer);
		
	}

}
