package entities.enemies;
import java.awt.Point;

import gameframework.assets.Sound;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;

public class Rock extends Enemy{
	
	protected GameData data;
	protected Sound boom;

	public Rock(GameData prmData) {
		this.data = prmData;
		this.init(data.getCanvas(), data);
		try {
			boom = new Sound("/sounds/boom.wav");
		} catch (Exception e) {}
	}

	@Override
	public String getStringImagePath() {
		return "/images/rock.png";
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
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(this.random(2, -1), 1));
		ms.setSpeed(this.random(12, 5));
		this.moveDriver.setStrategy(ms);
		return ms;
	}

	public void hit() {
		this.setActive(false);
		boom.play();
		data.getScore().setValue(data.getScore().getValue() + this.getScore());
		data.getUniverse().removeGameEntity(this);
	}
	
}
