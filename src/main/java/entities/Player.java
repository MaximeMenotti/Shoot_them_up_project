package entities;

import gameframework.assets.Sound;
import gameframework.drawing.Drawable;
import java.awt.Graphics;
import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.SpeedVector;
import gameframework.motion.overlapping.Overlappable;

import java.awt.Rectangle;

import game.Shoot;
import gameframework.motion.blocking.MoveBlocker;

public class Player extends GameMovable implements Overlappable, GameEntity, Drawable, MoveBlocker, Entity {

    protected SpriteManagerDefaultImpl sprite;
    protected GameData data;
    protected Sound outch;
    
    final protected int SHIP_SIZE = 50;

    public Player(GameData prmData) {
        super();
        this.data = prmData;
        this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/images/playersprite.png", data.getCanvas()), SHIP_SIZE, 3);
        this.position = new Point(data.getCanvas().getWidth()/2-SHIP_SIZE, data.getCanvas().getHeight()-SHIP_SIZE);
        this.sprite.reset();

        MoveStrategyKeyboard direction = new MoveStrategyKeyboard8Dir(false, new SpeedVector(new Point(0,0), 20));
        
        Shoot guns = new Shoot(prmData, this);
        
        data.getCanvas().addKeyListener(direction);
        data.getCanvas().addKeyListener(guns);
        this.moveDriver.setStrategy(direction);
        this.moveDriver.setmoveBlockerChecker(prmData.getMoveBlockerChecker());
        
        try {
			outch = new Sound("/sounds/outch.wav");
		} catch (Exception e) {
		}
    }

    public void draw(Graphics g) {
        this.sprite.draw(g, this.position);
    }

    public boolean isMovable() {
        return true;
    }

    @Override
    public void oneStepMoveAddedBehavior() {
        Point directionActual = this.moveDriver.getSpeedVector(this).getDirection();
        if (directionActual.equals(new Point(1, 0))){
            this.sprite.setIncrement(2);
        } else if (directionActual.equals(new Point(-1, 0))){
            this.sprite.setIncrement(0);
        } else {
        	this.sprite.setIncrement(1);
        }
    }
    
	public Rectangle getBoundingBox() {
            return new Rectangle( position.x, position.y, SHIP_SIZE, SHIP_SIZE);
	}
	
	public Point getPosition(){
		return this.position;
	}

	public void hit() {
		if(data.getLife().getValue() == 0){
			data.getUniverse().removeGameEntity(this);
		}
		else {
			outch.play();
			data.decreaseLife(1);
		}
	}

	public boolean isActive() {
		return true;
	}
		
}
