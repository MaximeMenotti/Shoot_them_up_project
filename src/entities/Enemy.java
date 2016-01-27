package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public abstract class Enemy extends GameMovable implements Overlappable, GameEntity, Drawable{
	protected SpriteManagerDefaultImpl sprite;
	protected int enemySize;
	protected Task task;
	protected int score;
	
	public void init(GameCanvas canvas, GameData prmData){
		this.enemySize = this.getNewSize();
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage(this.getStringImagePath(), canvas), this.enemySize, 1);
		this.sprite.reset();
		this.position = new Point(this.random(canvas.getWidth()-enemySize, 0), -enemySize);
		this.score = this.getNewScore();
		this.moveDriver.setStrategy(this.getNewMoveStrategy(canvas));	
		this.task = new Task(prmData);
		this.task.run();
		prmData.getOverlapProcessor().addOverlappable(this);
	}
	
	public int random(int higher, int lower){
		return (int)(Math.random() * (higher-lower)) + lower;
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(this.enemySize, this.enemySize);
	}
	
	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		
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
	
	public boolean isMovable() {
        return true;
    }
	
	public void fire(GameData data){
		data.getUniverse().addGameEntity(new Fireball(data.getCanvas(), data, position, 15, false));
	}

	Timer timer = new Timer();
    
    public void stopTask(){
    	task.cancel();
    	timer.cancel();
    	timer.purge();
    }
    
    public int getScore() {
    	return this.score;
    }
	public abstract String getStringImagePath();
	public abstract int getNewSize();
	public abstract int getNewScore();
	public abstract MoveStrategy getNewMoveStrategy(GameCanvas canvas);
}