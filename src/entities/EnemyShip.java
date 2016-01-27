package entities;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class EnemyShip extends Enemy {	
	public EnemyShip(GameCanvas canvas, GameData prmData) {
		this.init(canvas, prmData);
	}

	@Override
	public String getStringImagePath() {
		return "/resources/enemy.png" ;
	}

	@Override
	public int getNewSize() {
		return 50;
	}


	@Override
	public int getNewScore() {
		return 100;
	}


	@Override
	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(12, 5));
		return ms;
	}
}
