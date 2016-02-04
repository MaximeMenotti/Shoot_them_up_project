package game.levels;

import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import entities.Wall;
import game.GameUniverseViewPortWithCustomBackground;
import game.OverlapRulesEntities;
import gameframework.assets.Sound;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import pqtmain.Main;

public abstract class Level extends GameLevelDefaultImpl implements Observer{
	protected int nbEnemiesToKill;
	protected int nbEnemiesKilled = 0;
	protected Timer timer = new Timer();
	protected Sound gameOver;
	protected Sound win;

	public abstract TimerTask getTimerTask();

	/**
     * the constructor : defined number of enemy we must create and defined the game's rules
     * @param : the game data
     * @param : the enemy 's number we will create
     */
    public Level(GameData data, int nbEnemiesToKill) {
		super(data);
		this.nbEnemiesToKill = nbEnemiesToKill;
		OverlapRulesEntities rules = new OverlapRulesEntities();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
		try {
			gameOver = new Sound("/sounds/game_over.wav");
			win = new Sound("/sounds/win.wav");
		} catch (Exception e) {}
		data.getEndOfGame().addObserver(this);
	}

    public void incrementNbEnemiesKilled(){
    	this.nbEnemiesKilled++;
    }

    /**
     * Initializes the level with a number of defined enemy
     */
	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortWithCustomBackground(this.data);
		createWalls();
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
	}

	/**
	 * Ends the game if the number of killed enemy is equals or higher to the number of enemies of the level
	 */
	@Override
	public void end() {
		incrementNbEnemiesKilled();
		if(nbEnemiesToKill <= nbEnemiesKilled){
			Main.incrementCurrentLevel();
			stopGameLoop = true;
			this.stopTask();
		}
	}

    /**
     * Creates the wall around the canvas to avoid the player'ship to leave the playing area
     */
	public void createWalls(){
		//North
        data.getUniverse().addGameEntity(new Wall(0,0,data.getCanvas().getWidth(), 1));

        //South
        data.getUniverse().addGameEntity(new Wall(0,data.getCanvas().getHeight(), data.getCanvas().getWidth() ,1));

        //East
        data.getUniverse().addGameEntity(new Wall(data.getCanvas().getWidth(),0 ,1, data.getCanvas().getHeight()));

        //West
        data.getUniverse().addGameEntity(new Wall(0,0 ,1, data.getCanvas().getHeight() ));
	}

	/**
	 * Stops all the running task
	 */
	public void stopTask(){
		this.getTimerTask().cancel();
		timer.cancel();
		timer.purge();
	}

	/**
	 * Called when the game is over
	 */
	public void update(Observable o, Object arg) {
		gameOver.play();
		this.stopTask();
		data.getUniverse().removeAllGameEntities();
	}

}
