package game.levels;

import java.util.TimerTask;

import entities.enemies.EnemyShip;
import entities.enemies.Rock;
import gameframework.game.GameData;

public class LevelWithRocks extends Level{
	
    /**
     * The constructor
     * @param data the game data for initialize this level
     * @param nbRocks  the number of rock wanted for this level
     */
	public LevelWithRocks(GameData data, int nbRocks) {
		super(data, nbRocks);
	}

    /**
     *@return return a timerTesk object
     * the timer create a defined number of rock object and show them on the screen
     */
	@Override
	public TimerTask getTimerTask() {
		return new TimerTask()
		{
			@Override
			public void run() 
			{
				count++;
				if (count >= nbEnemies || isFinished) {
					timer.cancel();
					timer.purge();
					return;
				}
				data.getUniverse().addGameEntity(new Rock(data));
			}	
		};
	}
}
