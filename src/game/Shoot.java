package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Fireball;
import entities.Player;
import gameframework.game.GameData;

public class Shoot implements KeyListener {
	
	final static int MAIN_GUN = 32;
	
	protected GameData data;
	protected Player ship;
	
	public Shoot(GameData data, Player ship){
		this.data = data;
		this.ship = ship;
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == MAIN_GUN){			
			fire("PRESSED", arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public void fire(String from, KeyEvent e){
		if( data.getLife().getValue() > 0 ){
		data.getUniverse().addGameEntity(new Fireball(data.getCanvas(), data, ship.getPosition(), 15, true));
		}
	}

}
