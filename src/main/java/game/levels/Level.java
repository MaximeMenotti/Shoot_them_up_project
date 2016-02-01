package game.levels;

import java.util.Timer;
import java.util.TimerTask;

import entities.Player;
import entities.Wall;
import game.GameUniverseViewPortSB;
import game.OverlapRulesEntities;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public abstract class Level extends GameLevelDefaultImpl{
	protected static int nbEnemies;
	public static int count = 0;
	public static Timer timer = new Timer();

	public abstract TimerTask getTimerTask();
	
	/**
     * the constructor : defined number of enemy we must create and defined the game's rules
     * @param : the game data
     * @param : the enemy 's number we will create
     */
    public Level(GameData data, int nbEnemiesToAdd) {
		super(data);
		nbEnemies = nbEnemiesToAdd;
		OverlapRulesEntities rules = new OverlapRulesEntities();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}
	
    /**
     * initializes the level with a number of defined enemy
     */
	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		Player aPlayer = new Player(data);
		createWalls();
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
		data.getUniverse().addGameEntity(aPlayer);
                
	}
	
    /**
     * created the wall around the canvas to avoid the player'ship to leave the playing area
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
	
}
