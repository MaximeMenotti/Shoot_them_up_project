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
    
    /**
     * constructor
     * @param canvas
     */
	public Wall(int x, int y, int width, int height) {
		this.position = new Point(x, y);
		this.width = width;
		this.height = height;
	}

    /**
     * get the dimension of this wall
     * @return a rectangle who defined the object's borders
     */
    public Rectangle getBoundingBox() {
		return new Rectangle(position.x, position.y, width , height);
	}

    /**
     * define if this wall is a movable obect
     *
     * @return false because the wall don't move
     */
    public boolean isMovable() {
		return false;
	}

    /**
     * draw this wall on the canvas at the defined position
     * @param g
     */
	public void draw(Graphics g) {
	}
	
    /**
     * @return return a point of this wall's actual position
     */
	public Point getPosition(){
		return this.position;
	}

}
