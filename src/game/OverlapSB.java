package game;

import java.util.Vector;

import entities.*;
import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapSB extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
			
	public void overlapRule(Rock e1, Player e2){
		data.getUniverse().removeGameEntity(e1);
		decreaseLife();
	}
	
	public void overlapRule(Enemy e1, Player e2){
		System.out.println("outch");
		e1.stopTask();
		data.getUniverse().removeGameEntity(e1);
		decreaseLife();
	}
	
	public void overlapRule(Enemy e1, Fireball e2){
		if(e2.isFriendly()){
			e1.stopTask();
			data.getUniverse().removeGameEntity(e1);
			data.getUniverse().removeGameEntity(e2);
		}
	}
	
	public void overlapRule(Rock e1, Fireball e2){
		if(e2.isFriendly()){
			data.getUniverse().removeGameEntity(e1);
			data.getUniverse().removeGameEntity(e2);
		}
	}
	
	public void overlapRule(Player e1, Fireball e2){
		if(!e2.isFriendly()){
			System.out.println("outch");
			data.getUniverse().removeGameEntity(e2);
			decreaseLife();
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
