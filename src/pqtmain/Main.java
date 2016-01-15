package pqtmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import pqtwindows.GameCanvasSB;

import gameframework.base.ObservableValue;
import gameframework.drawing.*;
import gameframework.game.*;
import gameframework.gui.*;



public class Main {
	
	public static void main(String[] args) {
		//Settings.
		GameConfiguration aGameConfiguration = new GameConfiguration(30,30,10,3);
		GameData aGameData = new GameData(aGameConfiguration);
		GameCanvasSB aGameCanvas = new GameCanvasSB();
		aGameCanvas.setBounds(0, 0, 200, 200);
		String windowsName = "SpaceBattle2016ExtendedUltimateVersionDeluxePremium2";
		
		GameLevelDefaultImpl gl = new GameLevelDefaultImpl(aGameData) {
			
			@Override
			protected void init() {
				
			}
		};
		
		
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
		GameWindow aGameWindow = new GameWindow(windowsName, aGameCanvas, aGameConfiguration/*,aBarElement,aBarElement2*/);
		
		//display the windows
		aGameWindow.createGUI();
	}

}
