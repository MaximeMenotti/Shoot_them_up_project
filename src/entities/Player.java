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
import gameframework.motion.MoveStrategyStraightLine;
import gameframework.motion.overlapping.Overlappable;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class Player extends GameMovable implements Observer,
        Overlappable, GameEntity, Drawable, KeyListener {

    protected SpriteManagerDefaultImpl sprite;
    protected GameCanvas canvas;
    protected GameData gameData;
    protected int initialX;
    protected int initialY;
    protected int spriteManagerSize = 50;
    protected String[] spriteType = {"left","middle","right"};

    public Player(GameCanvas canvas, GameData prmData) {
        //initialisation of the position at the game beginning    
        initialX = 50;
        initialY = 60;
        this.canvas = canvas;
        this.gameData = prmData;
        this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/resources/playersprite.png", canvas), spriteManagerSize, 3);

        //initialise sprite manager
        this.sprite.setTypes(spriteType[0], spriteType[1],spriteType[2]);
        this.sprite.reset();

        //for playing with keyboard
        MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard8Dir();
        
        this.moveDriver = new GameMovableDriverDefaultImpl();
        this.moveDriver.setStrategy(new MoveStrategyStraightLine(new Point(500, 500), new Point(600, 600)));
        
        
        /*moveDriver.setmoveBlockerChecker(gameData.getMoveBlockerChecker());

        gameData.getCanvas().addKeyListener(keyboard);
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
        if (directionActual.equals(new Point(1, 0))) {
            this.sprite.setType(spriteType[2]);
        } else if (directionActual.equals(new Point(-1, 0))) {
            this.sprite.setType(spriteType[0]);
        }
    }

	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.spriteManagerSize, this.spriteManagerSize);
        return rectangle;
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

    /*@Override
    public Rectangle getBoundingBox() {
        Rectangle rectangle = new Rectangle(this.spriteManagerSize, this.spriteManagerSize);
        return rectangle;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //remettre le vaisseau a plat
        this.sprite.setType(spriteType[1]);
    }*/

}
