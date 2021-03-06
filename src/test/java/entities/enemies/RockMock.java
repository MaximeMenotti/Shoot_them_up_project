package entities.enemies;

import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class RockMock extends Enemy{

	public RockMock(GameCanvas canvas, GameData data) {
		super(data);
	}

	@Override
	public String getStringImagePath() {
		return "/images/rock.png";
	}

	@Override
	public int getNewSize() {
		return 50;
	}

	@Override
	public int getScore() {
		return 50;
	}

	@Override
	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(0, canvas.getHeight()));
		ms.setSpeed(this.random(12, 5));
		this.moveDriver.setStrategy(ms);
		return ms;
	}

	public void hit() {
				
	}
}
