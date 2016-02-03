package game.levels;

import java.util.TimerTask;

import entities.enemies.EnemyShip;
import gameframework.game.GameData;

public class LevelWithEnemies extends Level{	
	
    /**
     * The constructor
     * @param data the game data for initialize this level
     * @param nbEnemies wanted for this level
     */
    public LevelWithEnemies(GameData data, int nbEnemies) {
		super(data, nbEnemies);
	}

    /**
     *@return return a timerTesk object 
     * the timer create a defined number of enemy'spaceship object and show them on the screen
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

				System.out.println("Creation");
				data.getUniverse().addGameEntity(new EnemyShip(data));
			}	
		};
	}
}
