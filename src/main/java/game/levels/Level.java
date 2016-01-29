package game.levels;

import java.util.Timer;
import java.util.TimerTask;

import entities.Player;
import entities.Wall;
import game.GameUniverseViewPortSB;
import game.OverlapSB;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import java.util.ArrayList;

public abstract class Level extends GameLevelDefaultImpl{
	protected static int nbEnemies;
	public static int count = 0;
	public static Timer timer = new Timer();

	public abstract TimerTask getTimerTask();
	
	public Level(GameData data, int nbEnemiesToAdd) {
		super(data);
		nbEnemies = nbEnemiesToAdd;
		OverlapSB rules = new OverlapSB();
		rules.setGameData(data);
		data.getOverlapProcessor().setOverlapRules(rules);
		data.getOverlapProcessor().processOverlapsAll();
	}
	
	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortSB(this.data);	
		
                ArrayList<Wall> walls = new ArrayList<Wall>();
                for(int i = 0 ; i < 4 ; i++){
                    walls.add(new Wall(data.getCanvas()));
                    data.getUniverse().addGameEntity(walls.get(i));
                }
		TimerTask task = this.getTimerTask();
		timer.scheduleAtFixedRate(task, 0, 2000);
                Player aPlayer = new Player(data.getCanvas(),data);
		data.getUniverse().addGameEntity(aPlayer);
                
	}
	
}
