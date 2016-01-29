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
        
        final protected int WALL_SIZE = 50;

        public Wall() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
	public Wall(GameCanvas canvas) {
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/images/wall.png", canvas), WALL_SIZE, 1);
		this.position = new Point(canvas.getWidth()/4, canvas.getHeight()/4);
		this.sprite.reset();
	}

	public Rectangle getBoundingBox() {
		return new Rectangle(WALL_SIZE, WALL_SIZE);
	}

	public boolean isMovable() {
		return false;
	}

	public void draw(Graphics g) {
		this.sprite.draw(g, this.position);
	}

}
