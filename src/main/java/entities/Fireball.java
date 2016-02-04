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

    /**
     * The constructor
     *
     * @param canvas for drawing fireball to the screen
     * @param prmData   the game data
     * @param position  the initial fireball's position
     * @param speed the fireball'speed
     */
    
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
	}
	
    /**
     * get the dimension of this fireball
     * @return a rectangle who defined the object's borders
     */
	public Rectangle getBoundingBox() {
		return new Rectangle(BULLET_SIZE, BULLET_SIZE);
	}

    /**
     * define if the fireball is a movable obect
     *
     * @return true because fireball isn't a static object
     */
	public boolean isMovable() {
		return true;
	}
	
    /**
     * draw the fireball on the canvas at the defined position
     * @param g
     */
	public void draw(Graphics g) {
	        this.sprite.draw(g, this.position);
	}
	
    /**
     * return the boolean value for knowing if this fireball is friendly or enemy
     * @return true if this was shoot by the player
     *         false if this was shoot by an enemy
     */
	public boolean isFriendly(){
		return isFriendly;
	}

	@Override
	public void oneStepMoveAddedBehavior() {		
	}

    /**
     * Return a boolean value : true if the fireball is active and false on the other case (not active)
     * @return the active value
     */
	public boolean isActive() {
		return isActive;
	}
    
    /**
     *define with the boolean parameter if the fireball is active
     * @oarameter the value of active
     */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

    /**
     * Call when the fireball touch an other entities ( player or ennemie) desactive the boolean value of active
     * and remove this (fireball will be invisible on the screen)
     */
	public void hit() {
		this.setActive(false);
		data.getUniverse().removeGameEntity(this);
		data.getLevels().get(0).end();
	}
}
