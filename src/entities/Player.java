package entities;

import java.awt.Graphics;

import gameframework.game.GameEntity;

public class Player implements GameEntity{

	public void draw(Graphics g) {
		System.out.println("a");
		g.drawOval(100, 100, 50, 50);
	}

	public boolean isMovable() {
		return false;
	}

}
