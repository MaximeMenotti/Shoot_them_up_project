package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.overlapping.Overlappable;

public class Fireball extends GameMovable implements Overlappable, GameEntity, Drawable, Entity{
	
	final static int BULLET_SIZE = 12;
	//these OFFSET is used for adjust the fireball to the spaceship.
	final int OFFSET_X = 18;
	final int OFFSET_Y = 0;
	protected boolean isActive = true;
	protected SpriteManagerDefaultImpl sprite;
	protected boolean isFriendly;
	protected GameData data;

	public Fireball(GameData prmData, Point position, int speed, boolean isFriendly) {
		String path;
		MoveStrategyStraightLine ms;
		this.data = prmData;
		if(isFriendly){
			path = "/images/fire.png";
			ms = new MoveStrategyStraightLine(new Point(0, data.getCanvas().getHeight()), new Point(0, 0));
		}
		else {
			path = "/images/acid.png";
			ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, data.getCanvas().getHeight()));
		}
		ms.setSpeed(speed);
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage(path, data.getCanvas()), BULLET_SIZE, 1);
		this.position = new Point((int) position.getX() + OFFSET_X, (int) position.getY() + OFFSET_Y);
		this.sprite.reset();			
		this.moveDriver.setStrategy(ms);
		this.isFriendly = isFriendly;
		prmData.getOverlapProcessor().addOverlappable(this);
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(BULLET_SIZE, BULLET_SIZE);
	}

	public boolean isMovable() {
		return true;
	}
	
	public void draw(Graphics g) {
	        this.sprite.draw(g, this.position);
	}
	
	public boolean isFriendly(){
		return isFriendly;
	}

	@Override
	public void oneStepMoveAddedBehavior() {		
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void hit() {
		this.setActive(false);
		data.getUniverse().removeGameEntity(this);
	}
}
