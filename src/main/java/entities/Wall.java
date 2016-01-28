package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Wall implements MoveBlocker, GameEntity, Drawable {

	protected SpriteManagerDefaultImpl sprite;
	protected Point position = new Point();

	public Wall(GameCanvas canvas) {
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/images/wall.png", canvas), 1, 1);
		this.position = new Point(canvas.getWidth()/2, canvas.getHeight()/2);
		this.sprite.reset();
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle(1, 1);
	}

	public boolean isMovable() {
		return false;
	}

	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}

}
