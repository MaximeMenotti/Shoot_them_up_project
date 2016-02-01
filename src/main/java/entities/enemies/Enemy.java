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
	
	public void init(GameCanvas canvas, GameData prmData){
		this.enemySize = this.getNewSize();
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage(this.getStringImagePath(), canvas), this.enemySize, 1);
		this.sprite.reset();
		this.position = new Point(this.random(canvas.getWidth()-enemySize, 0), -enemySize);
		this.score = this.getScore();
		this.moveDriver.setStrategy(this.getNewMoveStrategy(canvas));	
		prmData.getOverlapProcessor().addOverlappable(this);
	}
	
	protected abstract String getStringImagePath();
	protected abstract int getNewSize();
	protected abstract int getScore();
	protected abstract MoveStrategy getNewMoveStrategy(GameCanvas canvas);
	
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
	
	public boolean isMovable() {
        return true;
    }
	
	public void fire(GameData data){
		data.getUniverse().addGameEntity(new Fireball(data, position, 15, false));
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}