package game;

import java.util.Vector;

import entities.*;
import gameframework.game.GameData;
import gameframework.motion.overlapping.*;

public class OverlapSB extends OverlapRulesApplierDefaultImpl {
	
	protected GameData data;
			
	public void overlapRule(Rock e1, Player e2){
		System.out.println("outch");
		decreaseLife();
	}
	
	public void overlapRule(Enemy e1, Player e2){
		System.out.println("outch");
		decreaseLife();
	}
	
	public void overlapRule(Player e1, Fireball e2){
		if(!e2.isFriendly()){
			System.out.println("outch");
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
