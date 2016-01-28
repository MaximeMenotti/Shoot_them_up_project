package game.levels;

import java.util.TimerTask;

import entities.enemies.EnemyShip;
import gameframework.game.GameData;

public class LevelWithEnemies extends Level{	
	public LevelWithEnemies(GameData data, int nbEnemies) {
		super(data, nbEnemies);
	}

	@Override
	public TimerTask getTimerTask() {
		return new TimerTask()
		{
			@Override
			public void run() 
			{
				count++;
			     if (count >= nbEnemies) {
			         timer.cancel();
			         timer.purge();
			         return;
			     }
				data.getUniverse().addGameEntity(new EnemyShip(data.getCanvas(), data));
			}	
		};
	}
}
