package entities;

import gameframework.drawing.Drawable;
import java.awt.Graphics;
import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.MoveStrategyKeyboard8Dir;
import gameframework.motion.SpeedVector;
import gameframework.motion.overlapping.Overlappable;
import java.awt.Rectangle;


import game.Shoot;

public class Player extends GameMovable implements Overlappable, GameEntity, Drawable {

    protected SpriteManagerDefaultImpl sprite;
    
    final protected int SHIP_SIZE = 50;

    public Player(GameCanvas canvas, GameData prmData) {
        this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/resources/playersprite.png", canvas), SHIP_SIZE, 3);

        this.position = new Point(canvas.getWidth()/2, canvas.getHeight()/2);
        
        //initialize sprite manager
        this.sprite.reset();

        //for playing with keyboard
        MoveStrategyKeyboard direction = new MoveStrategyKeyboard8Dir(false, new SpeedVector(new Point(0,0), 20));
        
        Shoot guns = new Shoot(prmData, this);
        
        this.moveDriver = new GameMovableDriverDefaultImpl();
        //this.moveDriver.setStrategy(new MoveStrategyStraightLine(new Point(500, 500), new Point(600, 600)));
        
        canvas.addKeyListener(direction);
        canvas.addKeyListener(guns);
        this.moveDriver.setStrategy(direction);
        
        /*moveDriver.setmoveBlockerChecker(gameData.getMoveBlockerChecker());
       
        setDriver(moveDriver);
        gameData.getCanvas().addKeyListener(this);

        gameData.getLife().addObserver(this);*/
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
		Rectangle rectangle = new Rectangle(this.SHIP_SIZE, this.SHIP_SIZE);
        return rectangle;
	}
	
	public Point getPosition(){
		return this.position;
	}
		
}
