package pqtwindows;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyListener;

import gameframework.drawing.GameCanvas;

public class GameCanvasSB implements GameCanvas {

	protected final Canvas canvas;

	public Canvas getCanvas() {
		return canvas;
	}

	public GameCanvasSB() {
		canvas = new Canvas();
	}
	
	public Graphics getCanvasGraphic(){
		return canvas.getGraphics();
	}

	public Image createBuffer() {
		return canvas.createImage(canvas.getWidth(), canvas.getHeight());
	}

	public MediaTracker createMediaTracker() {
		return new MediaTracker(canvas);
	}

	public void drawImage(Graphics graphics, Image image, int x, int y) {
		if (x <= canvas.getWidth() && y <= canvas.getHeight())
			graphics.drawImage(image, x, y, canvas);
		else
			graphics.drawImage(image, 0, 0, canvas);
	}

	public void drawFullSizeImage(Graphics graphics, Image image) {
		graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(),
				canvas);
	}

	public void drawFullSizeImage(Image image) {
		Graphics tmp = canvas.getGraphics();
		tmp.drawImage(image, 0, 0, canvas.getWidth(),
				canvas.getHeight(), canvas);
	}

	public void setBounds(int x, int y, int width, int height) {
		canvas.setBounds(x, y, width, height);
	}

	public int getWidth() {
		return canvas.getWidth();
	}

	public int getHeight() {
		return canvas.getHeight();
	}

	public void setSize(int width, int height) {
		canvas.setSize(width, height);
	}

	public void addTo(Frame frame) {
		frame.add(canvas);
	}

	public void addKeyListener(KeyListener keyStr) {
		canvas.addKeyListener(keyStr);
	}

	public void removeKeyListener(KeyListener keyStr) {
		canvas.removeKeyListener(keyStr);
	}

	public KeyListener[] getKeyListeners() {
		return canvas.getKeyListeners();
	}

}
