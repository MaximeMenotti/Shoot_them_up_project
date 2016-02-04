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
    protected Shoot shoot;
    final protected int SHIP_SIZE = 50;

    /**
     * Constructor private of Player because of the using of the singleton design pattern
     * 
     */
    private Player() {
        super();
    }
    
    private static Player INSTANCE;
    
	public static Player getInstance(GameData data){	
		if(INSTANCE == null){
			INSTANCE = new Player();
			INSTANCE.init(data);
		}
		return INSTANCE;
	}
    
    public void init(GameData prmData){
    	this.data = prmData;
        
        this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/images/playersprite.png", data.getCanvas()), SHIP_SIZE, 3);
        this.position = new Point(data.getCanvas().getWidth()/2-SHIP_SIZE, data.getCanvas().getHeight()-SHIP_SIZE);
        //initialize sprite manager
        this.sprite.reset();

        //for playing with keyboard
        MoveStrategyKeyboard direction = new MoveStrategyKeyboard8Dir(false, new SpeedVector(new Point(0,0), 20));
        
        this.shoot = new Shoot(prmData, this);
        
        data.getCanvas().addKeyListener(direction);
        data.getCanvas().addKeyListener(this.shoot);
        this.moveDriver.setStrategy(direction);
        this.moveDriver.setmoveBlockerChecker(prmData.getMoveBlockerChecker());
		prmData.getUniverse().addGameEntity(this);
        try {
			outch = new Sound("/sounds/outch.wav");
		} catch (Exception e) {
		}
    }
    
    

    /**
     * draw the player spaceship on the canvas at the defined position
     * sprite the player for see a different view if it go to left or right or
     * if it static
     * @param g
     */
    public void draw(Graphics g) {
        this.sprite.draw(g, this.position);
    }

    /**
     * define if the player is a movable object
     *
     * @return true because the player space ship move at left to right
     * or right to left
     */
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
    
    /**
     * get the dimension of the player
     * @return a rectangle who defined the object's borders
     */
    public Rectangle getBoundingBox() {
            return new Rectangle( position.x, position.y, SHIP_SIZE, SHIP_SIZE);
	}
    
    /**
     * get the player position
     * @return a point of actual player position
     */
	public Point getPosition(){
		return this.position;
	}

    /**
     * call when the player was touched by an other entity, if he has got life, the life'score was decrease
     * and if there aren't any life, we remove the player on the screen
     */
	public void hit() {
		outch.play();
		data.decreaseLife(1);		
		if(data.getLife().getValue() <= 0){
			data.getEndOfGame().setValue(true);
			data.getUniverse().removeGameEntity(this);
		}
	}

    /**
     * Return the boolean value true because the player is always an active entity
     * @return the active value
     */
	public boolean isActive() {
		return true;
	}

	public int getSHIP_SIZE() {
		return SHIP_SIZE;
	}
		
}
