package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.overlapping.Overlappable;

public class Rock extends GameMovable implements Overlappable, GameEntity, Drawable{
	protected SpriteManagerDefaultImpl sprite;
	protected int spriteManagerSize = 30;
	
	public Rock(GameCanvas canvas, GameData prmData) {
		this.spriteManagerSize = this.random(60, 30);
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/resources/rock.png", canvas), this.spriteManagerSize, 1);
		this.sprite.reset();
		this.position = new Point(this.random(canvas.getWidth(), 0), 0);
		this.moveDriver.setStrategy(new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight())));
	}
	
	public int random(int higher, int lower){
		return (int)(Math.random() * (higher-lower)) + lower;
	}
	
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.spriteManagerSize, this.spriteManagerSize);
        return rectangle;
	}
	public boolean isMovable() {
		return true;
	}
	public void draw(Graphics g) {
	        this.sprite.draw(g, this.position);
	}
	public Point getPosition() {
		return this.position;
	}
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}	
}
