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
	public EnemyShip(GameCanvas canvas, GameData prmData) {
		this.init(canvas, prmData);
		this.task = new Task(prmData);
		this.task.run();
	}
	
	Timer timer = new Timer();
    
    public void stopTask(){
    	task.cancel();
    	timer.cancel();
    	timer.purge();
    }
	
	class Task extends TimerTask {
    	GameData data;
    	
    	public Task(GameData data){
    		this.data = data;
    	}
        @Override
        public void run() {
            int delay = (3 + new Random().nextInt(3)) * 1000;
            timer.schedule(new Task(data), delay);
            fire(data);
        }

    }

	@Override
	public String getStringImagePath() {
		return "/resources/enemy.png" ;
	}

	@Override
	public int getNewSize() {
		return 50;
	}
	
	@Override
	public int getScore() {
		return 100;
	}


	@Override
	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(12, 5));
		return ms;
	}
}
