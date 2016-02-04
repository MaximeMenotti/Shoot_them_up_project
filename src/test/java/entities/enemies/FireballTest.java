package entities.enemies;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import entities.Fireball;
import game.levels.Level;
import game.levels.LevelWithEnemies;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class FireballTest {
	
	public GameConfiguration configuration;
	public GameData data;
	public Fireball fireball;
	
	@Before
	public void init() {
		this.configuration = new GameConfiguration(10,10,10,1);
		this.data = new GameData(configuration);
		this.fireball = new Fireball(data, new Point(0, 0), 15, true);
		Level level = new LevelWithEnemies(data,1);
		data.addLevel(level);
	}
	
	@Test
	public void isMovableTest() {
		assertTrue(this.fireball.isMovable());
	}
	
	@Test
	public void getBoudingBoxTest() {
		assertEquals(this.fireball.getBoundingBox().width, Fireball.getBulletSize());
		assertEquals(this.fireball.getBoundingBox().height, Fireball.getBulletSize());
	}
	
	@Test
	public void isFriendlyTest() {
		assertTrue(this.fireball.isFriendly());
	}
	
	@Test
	public void hitTest() {
		assertTrue(this.fireball.isActive());
		this.fireball.hit();
		assertFalse(this.fireball.isActive());
	}
	
}