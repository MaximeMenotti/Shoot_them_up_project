package entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Wall implements MoveBlocker, GameEntity {

	protected Point position;
   	protected int width;
   	protected int height;
       
	public Wall(int x, int y, int width, int height) {
		this.position = new Point(x, y);
		this.width = width;
		this.height = height;
	}

	public Rectangle getBoundingBox() {
		return new Rectangle(position.x, position.y, width , height);
	}

	public boolean isMovable() {
		return false;
	}

	public void draw(Graphics g) {
	}
	
	public Point getPosition(){
		return this.position;
	}

}
