package entities.enemies;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

public class RockTest extends EnemyTest{
	@Override
	public Enemy createInstance(GameCanvas canvas, GameData prmData) {
		return new RockMock(canvas, prmData);
	}

	@Override
	public String getExpectedStringPath() {
		return "/images/rock.png";
	}

	@Override
	public int getExpectedSize() {
		return 50;
	}

	@Override
	public int getExpectedScore() {
		return 50;
	}
}
