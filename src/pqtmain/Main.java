package pqtmain;
import java.awt.BorderLayout;
import java.awt.Menu;

import game.LevelWithEnemies;
import game.LevelWithRocks;
import gameframework.game.*;
import gameframework.gui.*;



public class Main {
	
	public static void main(String[] args) {
		//Constant
		final String WINDOWS_NAME = "SpaceBattle";
		final int NB_ROWS = 70;
		final int NB_COLUMNS = 120;
		final int SPRITE_SIZE = 10;
		final int DEFAULT_NB_LIVES = 3 ;
		
		//Settings.
		GameConfiguration configuration = new GameConfiguration(NB_ROWS,NB_COLUMNS,SPRITE_SIZE,DEFAULT_NB_LIVES);
		GameData data = new GameData(configuration);

		//Creation of the game window.
		GameWindow gameWindow = new GameWindow(WINDOWS_NAME, data.getCanvas(), configuration, 
				new GameStatusBarElement<Integer>("Score:", data.getScore()),
				new GameStatusBarElement<Integer>("Life:", data.getLife()));

		//display the windows
		gameWindow.createGUI();
		
		level2(data);
	}
	
	public static void level1(GameData data){
		LevelWithRocks level = new LevelWithRocks(data,25);
		data.addLevel(level);
		level.start();
	}
	
	public static void level2(GameData data){
		LevelWithEnemies level2 = new LevelWithEnemies(data,10);
		data.addLevel(level2);
		level2.start();
	}
}
