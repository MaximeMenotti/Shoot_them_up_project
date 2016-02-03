package entities.enemies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Wall;

public class WallTest {

	public Wall wall; 
	
	@Before
	public void init() {
		this.wall = new Wall(0, 0, 0, 0);
	}
	
	@Test
	public void getBoudingBoxTest() {
		assertEquals(this.wall.getBoundingBox().height, this.wall.getWidth());
		assertEquals(this.wall.getBoundingBox().width, this.wall.getHeight());
	}
	
	@Test
	public void testIsMovable() {
		assertFalse(this.wall.isMovable());
	}
}
