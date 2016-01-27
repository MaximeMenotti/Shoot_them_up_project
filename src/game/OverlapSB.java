package game;

import java.util.Vector;

import entities.*;
import entities.enemies.EnemyShip;
import entities.enemies.Rock;
import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapSB extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
			
	public void overlapRule(Rock e1, Player e2){
		if(e1.isActive()){
			e1.setActive(false);
			data.getUniverse().removeGameEntity(e1);
			decreaseLife();
			removePlayer(e2);			
		}
	}
	
	public void overlapRule(EnemyShip e1, Player e2){
		if(e1.isActive()) {
			e1.setActive(false);
			System.out.println("outch");
			e1.stopTask();
			data.getUniverse().removeGameEntity(e1);
			decreaseLife();
			removePlayer(e2);
		}
	}
	
	public void overlapRule(EnemyShip e1, Fireball e2){
		if(e2.isFriendly()){
			if(e1.isActive()) {
				e1.setActive(false);
				e1.stopTask();
				data.getUniverse().removeGameEntity(e1);
				data.getUniverse().removeGameEntity(e2);
				data.getScore().setValue(data.getScore().getValue() + e1.getScore());
			}
		}
	}
	
	public void overlapRule(Rock e1, Fireball e2){
		if(e2.isFriendly()){
			if(e1.isActive()) {
				e1.setActive(false);
				data.getUniverse().removeGameEntity(e1);
				data.getUniverse().removeGameEntity(e2);
				data.getScore().setValue(data.getScore().getValue() + e1.getScore());
			}
		}
	}
	
	public void overlapRule(Player e1, Fireball e2){
		if(!e2.isFriendly()){
			if(e2.isActive()) {
				e2.setActive(false);
				System.out.println("outch");
				data.getUniverse().removeGameEntity(e2);
				decreaseLife();
				removePlayer(e1);
			}
		}
	}

	public void removePlayer(Player e1){
		if (this.data.getLife().getValue() == 0 ){
			data.getUniverse().removeGameEntity(e1);

		}
	}
	public void setGameData(GameData data) {
		this.data = data;		
	}

	public void applyOverlapRules(Vector<Overlap> overlaps) {
		super.applyOverlapRules(overlaps);
	}
	
	public void decreaseLife(){
		this.data.decreaseLife(1);
	}

}
