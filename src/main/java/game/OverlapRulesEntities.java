package game;

import java.util.Vector;

import entities.*;
import entities.enemies.EnemyShip;
import entities.enemies.Rock;
import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapRulesEntities extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
			
	public void overlapRule(Rock e1, Player e2){
		checkActive(e1, e2);
	}
	
	public void overlapRule(EnemyShip e1, Player e2){
		checkActive(e1, e2);
	}
	
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
	
	public void overlapRule(Player e1, Fireball e2){
		if(!e2.isFriendly()){
			checkActive(e2, e1);
		}
	}

	public void setGameData(GameData data) {
		this.data = data;		
	}

	public void applyOverlapRules(Vector<Overlap> overlaps) {
		super.applyOverlapRules(overlaps);
	}
	
	public void checkActive(Entity anEntity_A, Entity anEntity_B){
		if(anEntity_A.isActive()){
			anEntity_A.hit();
			anEntity_B.hit();
		}
	}
}
