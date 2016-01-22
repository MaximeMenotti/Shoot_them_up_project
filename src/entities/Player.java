package entities;

import java.awt.Graphics;
import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameEntity;

public class Player implements GameEntity {
	
	protected SpriteManagerDefaultImpl sprite;
	
	public Player(GameCanvas canvas) {
		this.sprite = new SpriteManagerDefaultImpl(new DrawableImage("/resources/player.png", canvas), 50, 1);
	}
	
	public void draw(Graphics g) {
		this.sprite.draw(g, new Point(500,500));
	}

	public boolean isMovable() {
		return false;
	}

}
