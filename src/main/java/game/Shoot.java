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
	
    /**
     * The constructor for the player can shoot
     *
     * @param data : the game data
     * @param ship : reference to the player object
     */
	public Shoot(GameData data, Player ship){
		this.data = data;
		this.ship = ship;
	}

    /**
     * Event : call when a keyborad key was pressed
     * @param arg0 the event , with this object we can have the key pressed
     */
	public void keyPressed(KeyEvent arg0) {
	}

    /**
     * Event : call when a keyborad key was released : in this method
     * we call the fire method for the player shoot one fireball
     * @param arg0 the event , with this object we can have the key pressed
     */
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == MAIN_GUN){		
			fire(arg0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
    /**
     * This methode create a fire ball friendly
     * it was called when player shoot
     * @param from the name of the event
     * @param e the key event
     */
	public void fire(KeyEvent e){
		if( data.getLife().getValue() > 0 && ship != null){
			data.getUniverse().addGameEntity(new Fireball(data, ship.getPosition(), 15, true));
		}
	}

}
