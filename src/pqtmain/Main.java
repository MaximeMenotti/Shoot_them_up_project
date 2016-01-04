package pqtmain;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
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
		String windowsName = "SpaceBattle2016ExtendedUltimateVersionDeluxePremium2";
		
		GameStatusBar aStuBar = new GameStatusBar();
		GameStatusBarElement<Integer> aBarElement = new GameStatusBarElement<Integer>("life", new ObservableValue<Integer>(3));
		GameStatusBarElement<String> aBarElement2 = new GameStatusBarElement<String>("azerty", new ObservableValue<String>("azerty"));
		
		BackgroundImage bg = new BackgroundImage("/resources/spaceBg.jpg", aGameCanvas);
		
		//Creation of the game window.
		GameWindow aGameWindow = new GameWindow(windowsName, aGameCanvas, aGameConfiguration,aBarElement,aBarElement2);
		Graphics tmp = aGameCanvas.getCanevasGraphic();
		bg.draw(tmp);
		aGameWindow.createGUI();

		
		//Change the value of the 2nd element
		aBarElement2.getElement().setValue("test");
		
	}

}
