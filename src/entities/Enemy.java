package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;
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
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.overlapping.Overlappable;

public class Enemy extends GameMovable implements Overlappable, GameEntity, Drawable{
	
	protected SpriteManagerDefaultImpl sprite;
	final static int SHIP_SIZE = 50;
	
	public Enemy(GameCanvas canvas, GameData prmData) {
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/resources/enemy.png", canvas), SHIP_SIZE, 1);
		this.position = new Point(this.random(canvas.getWidth(), 0), (this.random(canvas.getHeight()*2, 15))*-1);
		this.sprite.reset();
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(7);
		this.moveDriver.setStrategy(ms);
		new Task(prmData).run();
	}
	
	public boolean isMovable() {
        return true;
    }

	public Rectangle getBoundingBox() {
		return new Rectangle(SHIP_SIZE, SHIP_SIZE);
	}
	
	public int random(int higher, int lower){
		return (int)(Math.random() * (higher-lower)) + lower;
	}

	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		
	}
	
	public void fire(GameData data){
		data.getUniverse().addGameEntity(new Fireball(data.getCanvas(), data, position, 15, false));
	}

	Timer timer = new Timer();

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
            //System.out.println(new Date());
        }

    }
}
