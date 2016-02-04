package entities.enemies;
import java.awt.Point;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyStraightLine;
import pqtmain.Main;

public class Rock extends Enemy{

    /**
     * Constructor
     * @param prmData
     */
	public Rock(GameData prmData) {
		super(prmData);
	}

    /**
     * @return return a string with the rock's picture path
     */
	@Override
	public String getStringImagePath() {
		return "/images/rock.png";
	}

    /**
     * @return return a integer with the rock' size
     */
	@Override
	public int getNewSize() {
		return this.random(60, 30);
	}

    /**
     * @return return a integer who contain this rock score by default it's 50
     */
	@Override
	public int getScore() {
		return 50;
	}

    /**
     * Define the moveStrategy of this rock with a randomming point and the speed
     * @return this data on a MoveStrategy's object
     */
	@Override
	public MoveStrategy getNewMoveStrategy(GameCanvas canvas) {
		MoveStrategyStraightLine ms = new MoveStrategyStraightLine(new Point(0, 0), new Point(this.random(2, -1), 1));
		ms.setSpeed(this.random(12, 5));
		this.moveDriver.setStrategy(ms);
		return ms;
	}

    /**
     * Call when the rock was touched by an other entities (player or fireball) desactive the boolean value of
     * active and remove this (rock will be invisible on the screen)
     */
		 public void hit() {
	 		this.setActive(false);
	 		boom.play();
	 		data.getLevels().get(Main.getCurrentLevel()).end();
	 		data.getScore().setValue(data.getScore().getValue() + this.getScore());
	 		data.getUniverse().removeGameEntity(this);
	 	}

}
