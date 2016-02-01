package game.levels;

import java.util.TimerTask;

import entities.enemies.Rock;
import gameframework.game.GameData;

public class LevelWithRocks extends Level{	
	protected int nbRocks;
	
	public LevelWithRocks(GameData data, int nbRocks) {
		super(data, nbRocks);
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
				data.getUniverse().addGameEntity(new Rock(data));
			}	
		};
	}
}
