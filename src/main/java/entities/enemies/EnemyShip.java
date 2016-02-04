package entities.enemies;

import java.awt.Point;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class EnemyShip extends Enemy {

	protected Task task;
	protected Timer timer = new Timer();

    /**
     * the constructor of one enemy : this is a spaceship who can shoot to the
     * player direction and hitting him.
     * define the sound who was played when we destroy this enemy
     *
     * @param prmData the game data
     */
    public EnemyShip(GameData prmData) {
		super(prmData);
		this.task = new Task(prmData);
		this.task.run();
	}


	public class Task extends TimerTask {
    	GameData data;

        /**
         * constructor of the timer task
         * @param data the game data
         */
        public Task(GameData data){
    		this.data = data;
    	}


        /**
         * run the timer, with this method, this enemy shooting
         */
        @Override
        public void run() {
            int delay = (3 + new Random().nextInt(3)) * 1000;
            timer.schedule(new Task(data), delay);
            fire(data);
        }

    }

    /**
     * stop the timer's task
     */
	public void stopTask(){
		task.cancel();
		timer.cancel();
		timer.purge();
	}

	/**
     *@return return a string with the enemy spaceship picture's path
     */
	@Override
	public String getStringImagePath() {
		return "/images/enemy.png" ;
	}

    /**
     *@return return the size value by default is 50
     */
	@Override
	public int getNewSize() {
		return 50;
	}

    /**
     * get the score earned when this enemy was destroyed
     * @return the integer score value by default is 100
     */
	@Override
	public int getScore() {
		return 100;
	}

    /**
     * Define how the enemy spaceship move
     * @return return a MoveStrategy 's object with this data : direction and speed
     */
	@Override
	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(12, 5));
		return ms;
	}

    /**
     * Call when the spaceship was touched by an other entities ( player or fireball) disable the boolean value
     * of active and remove this (enemy'spaceship will be invisible on the screen), disable the timer task too
     * Add the score earned to the player score and play a destroy song
     */
		 public void hit() {
	 		this.stopTask();
	 		this.remove();
	 	}
}
