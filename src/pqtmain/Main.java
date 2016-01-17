package pqtmain;

import pqtwindows.GameCanvasSB;
import game.GameLevelSB;
import gameframework.game.*;
import gameframework.gui.*;



public class Main {
	
	public static void main(String[] args) {
		//Settings.
		GameConfiguration configuration = new GameConfiguration(30,30,10,3);
		GameData data = new GameData(configuration);
		GameCanvasSB canvas = new GameCanvasSB();
		canvas.setBounds(0, 0, 500, 500);
		String windowsName = "SpaceBattle";
		GameLevelSB level = new GameLevelSB(data);
		data.addLevel(level);
		
		
		
		/*GameStatusBar aStuBar = new GameStatusBar();
		GameStatusBarElement<Integer> aBarElement = new GameStatusBarElement<Integer>("life", new ObservableValue<Integer>(3));
		GameStatusBarElement<String> aBarElement2 = new GameStatusBarElement<String>("azerty", new ObservableValue<String>("azerty"));
		
		DrawableImage bg = new BackgroundImage("/resources/spaceBG.jpg", aGameCanvas);	
		
				
		//Graphics tmp = aGameCanvas.getCanevasGraphic();
		
		/*bg.draw(new MockGraphics() {

			@Override
			public boolean drawImage(Image img, int x, int y, int width,
					int height, ImageObserver observer) {
				this.setColor(Color.BLACK);
				return true;
			}

		});
		//aGameWindow.
		
		
		/*MyGraphics graphic = new MyGraphics();
		graphic.create(0, 0, 200, 200);
		aGameCanvas.getCanvas().paint(graphic);
		
		//Change the value of the 2nd element
		aBarElement2.getElement().setValue("test");*/


		//Creation of the game window.
		GameWindow gameWindow = new GameWindow(windowsName, canvas, configuration/*,aBarElement,aBarElement2*/);
		
		//display the windows
		gameWindow.createGUI();
		
		level.start();
	}

}
