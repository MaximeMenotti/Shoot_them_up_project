package pqtwindows;

import java.awt.Graphics;

import gameframework.drawing.GameCanvasDefaultImpl;

public class GameCanvasSB extends GameCanvasDefaultImpl {
	
	public Graphics getCanvasGraphic(){
		return canvas.getGraphics();
	}

}
