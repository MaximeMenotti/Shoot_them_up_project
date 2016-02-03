package entities.enemies;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import entities.Entity;
import entities.Fireball;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.overlapping.Overlappable;

public abstract class Enemy extends GameMovable implements Overlappable, GameEntity, Drawable, Entity{
	
	protected SpriteManagerDefaultImpl sprite;
	protected int enemySize, score;
	protected boolean isActive = true;
	
	/**
     *initialise the enemy's attribut : size, picture , position , score
     */
    public void init(GameCanvas canvas, GameData prmData){
		this.enemySize = this.getNewSize();
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage(this.getStringImagePath(), canvas), this.enemySize, 1);
		this.sprite.reset();
		this.position = new Point(this.random(canvas.getWidth()-enemySize, 0), -enemySize);
		this.score = this.getScore();
		this.moveDriver.setStrategy(this.getNewMoveStrategy(canvas));	
	}
	
    /**
     *abstract method for customize the different type of enemy
     */
	protected abstract String getStringImagePath();
	protected abstract int getNewSize();
	protected abstract int getScore();
	protected abstract MoveStrategy getNewMoveStrategy(GameCanvas canvas);
	
    /**
     * generate an random integer
     * @param higher the upper bound
     * @param lower  the lower bound
     * @return the random integer
     */
    public int random(int higher, int lower){
		return (int)(Math.random() * (higher-lower)) + lower;
	}
	
    /**
     * get the dimension of the enemy
     * @return a rectangle who defined the object's borders
     */
	public Rectangle getBoundingBox() {
		return new Rectangle(this.enemySize, this.enemySize);
	}
	
    /**
     * draw the enemy on the canvas at the defined position
     * @param g
     */
	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		
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
     * with this method, an entity like player or spaceship enemy can shoot fireball 
     */
	public void fire(GameData data){
		new Fireball(data, position, 15, false);
	}

    /**
     * Return a boolean value : true if the enemy is active and false on the other case (not active)
     * @return the active value
     */
	public boolean isActive() {
		return isActive;
	}
    
    /**
     *define with the boolean parameter if the enemy is active
     * @oarameter the value of active
     */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}