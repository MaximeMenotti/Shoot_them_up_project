package game;

import java.util.Vector;

import entities.*;
import entities.enemies.EnemyShip;
import entities.enemies.Rock;
import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapRulesEntities extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
			
    /**
     * this method is called when the player is hit by a rock
     * @param e1 the rock who hit the player
     * @param e2 the player spaceship
     */
    public void overlapRule(Rock e1, Player e2){
		checkActive(e1, e2);
	}
	
    /**
     * this method is called when the player is hit by an enemy
     * @param e1 the enemy ship where the shot comes
     * @param e2 the player spaceship
     */
	public void overlapRule(EnemyShip e1, Player e2){
		checkActive(e1, e2);
	}
	
    /**
     * Rules for all enemy's fireballs (shoot)
     * call at the game's initialization
     * @param e1 enemy ship who shoot this fireball
     * @param e2 the fireball object
     */
	public void overlapRule(EnemyShip e1, Fireball e2){
		if(e2.isFriendly()){
			checkActive(e1, e2);
		}
	}
	
	public void overlapRule(Rock e1, Fireball e2){
		if(e2.isFriendly()){
			checkActive(e1, e2);
		}
	}
	
    /**
     * this method is called when the player is hit by an enemy
     * @param e1 the player spaceship
     * @param e2 the fireball who hit the player
     */
	public void overlapRule(Player e1, Fireball e2){
		if(!e2.isFriendly()){
			checkActive(e2, e1);
		}
	}

    /**
     * setter for the game data.
     * @param data the game data of the actual level
     */
	public void setGameData(GameData data) {
		this.data = data;		
	}

    /**
     * this method is called to initialize the game.
     * Applies the defined rules
     * @param overlaps : all of the rules
     */
	public void applyOverlapRules(Vector<Overlap> overlaps) {
		super.applyOverlapRules(overlaps);
	}
	
    /**
     * verify if an entity is active. in the true case we call the hit method for the 2 entities (the hitter and 
     * the hitting)
     */
	public void checkActive(Entity anEntity_A, Entity anEntity_B){
		if(anEntity_A.isActive()){
			anEntity_A.hit();
			anEntity_B.hit();
		}
	}
}
