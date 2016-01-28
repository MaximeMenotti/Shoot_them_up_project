package entities.enemies;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

public class EnemyShipTest extends EnemyTest{

	@Override
	public Enemy createInstance(GameCanvas canvas, GameData prmData) {
		return new EnemyShip(canvas, prmData);
	}

	@Override
	public String getExpectedStringPath() {
		return "/images/enemy.png";
	}

	@Override
	public int getExpectedSize() {
		return 50;
	}

	@Override
	public int getExpectedScore() {
		return 100;
	}

}
