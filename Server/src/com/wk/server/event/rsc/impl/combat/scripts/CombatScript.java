package com.wk.server.event.rsc.impl.combat.scripts;

import com.wk.server.model.entity.Mob;
/**
 * 
 * @author n0m
 *
 */
public interface CombatScript {
	
	public void executeScript(Mob attacker, Mob victim);
	
	public boolean shouldExecute(Mob attacker, Mob victim);
	
	public boolean shouldCombatStop();
}
