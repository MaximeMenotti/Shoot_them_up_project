package entities;
import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class Rock extends Enemy{

	public Rock(GameCanvas canvas, GameData data) {
		this.init(canvas, data);
	}

	@Override
	public String getStringImagePath() {
		return "/resources/rock.png";
	}

	@Override
	public int getNewSize() {
		return this.random(60, 30);
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
	
}
