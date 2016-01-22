package pqtmain;

import pqtwindows.GameCanvasSB;
import game.GameLevelSB;
import gameframework.game.*;
import gameframework.gui.*;



public class Main {
	
	public static void main(String[] args) {
		//Settings.
		GameConfiguration configuration = new GameConfiguration(50,50,10,3);
		GameData data = new GameData(configuration);
		String windowsName = "SpaceBattle";
		GameLevelSB level = new GameLevelSB(data);
		data.addLevel(level);

		//Creation of the game window.
		GameWindow gameWindow = new GameWindow(windowsName, data.getCanvas(), configuration);
		
		//display the windows
		gameWindow.createGUI();
		
		level.start();
	}

}
