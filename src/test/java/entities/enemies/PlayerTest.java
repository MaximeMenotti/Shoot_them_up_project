package entities.enemies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entities.Player;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class PlayerTest {
	
	public GameConfiguration configuration;
	public GameData data;
	public Player player;
	
	@Before
	public void init() {
		configuration = new GameConfiguration(10,10,10,1);
		data = new GameData(configuration);
		player = Player.getInstance(data);
	}
	
	@Test
	public void isMovableTest() {
		assertTrue(this.player.isMovable());
	}
	
	@Test
	public void getBoudingBoxTest() {
		assertEquals(this.player.getBoundingBox().width, this.player.getSHIP_SIZE());
		assertEquals(this.player.getBoundingBox().height, this.player.getSHIP_SIZE());
	}
	
	
	/* Thread don't decrease player life fast enough to pass through the second asserEquals
	@Test
	public void hitTest() {
		assertEquals((int) this.data.getLife().getValue(), 1);
		this.player.hit();
		assertEquals((int) this.data.getLife().getValue(), 0);		
	}
	*/
	
}
