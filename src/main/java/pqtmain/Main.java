package pqtmain;

import entities.Player;
import game.levels.LevelWithEnemies;
import game.levels.LevelWithRocks;
import gameframework.game.*;
import gameframework.gui.*;



public class Main {
	
	public static void main(String[] args) {
		//Constant
		final String WINDOWS_NAME = "SpaceBattle";
		final int NB_ROWS = 70;
		final int NB_COLUMNS = 120;
		final int SPRITE_SIZE = 10;
		final int DEFAULT_NB_LIVES = 3;
		
		//Settings.
		GameConfiguration configuration = new GameConfiguration(NB_ROWS,NB_COLUMNS,SPRITE_SIZE,DEFAULT_NB_LIVES);
		GameData data = new GameData(configuration);
                
        GameDefaultImpl game = new GameDefaultImpl(data);

		//Creation of the game window.
		GameWindow gameWindow = new GameWindow(WINDOWS_NAME, data.getCanvas(), data);

		Player.getInstance(data);
		
		//display the windows
		gameWindow.createGUI();
		
        level1(data);
        level2(data);
        game.start();
	}
	
	public static void level1(GameData data){
		LevelWithRocks level = new LevelWithRocks(data,5);
		data.addLevel(level);
	}
	
	public static void level2(GameData data){
		LevelWithEnemies level2 = new LevelWithEnemies(data,10);
		data.addLevel(level2);
	}
}
