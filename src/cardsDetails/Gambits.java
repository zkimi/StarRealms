package cardsDetails;

import java.util.HashMap;

import cardInfo.Cards;
import cardInfo.Gambit;
import cardInfo.Ship;

public class Gambits {
	
	private static HashMap<String, Cards> gambits = new HashMap<String, Cards>();
	
	private static Cards mercCruiser = new Ship("Merc Cruiser","desc.", 3,"Unaligned");
	
	private static Cards boldRaid = new Gambit("Bold Raid","desc", 0,"Unaligned");
	
	private static Cards energyShield = new Gambit("Energy Shield","desc", 0,"Unaligned");

	private static Cards frontierFleet = new Gambit("Frontier Fleet","desc", 0,"Unaligned");

	private static Cards politicalManeuver = new Gambit("Political Maneuver","desc", 0,"Unaligned");

	private static Cards riseToPower = new Gambit("Rise to Power","desc", 0,"Unaligned");
	
	private static Cards salvageOperation = new Gambit("Salvage Operation","desc", 0,"Unaligned");
	
	private static Cards smugglingRun = new Gambit("Smuggling Run","desc", 0,"Unaligned");
	
	private static Cards surpriseAssault = new Gambit("Surprise Assault","desc", 0,"Unaligned");

	private static Cards unlikelyAlliance = new Gambit("Unlikely Alliance","desc", 0,"Unaligned");

	private static Cards wildGambit = new Gambit("Wild Gambit","desc", 0,"Unaligned");

	
	public static HashMap<String,Cards> initGambits() {
		
		initCap();
		initScrap();
		
		gambits.put("Merc Cruiser", mercCruiser);
		gambits.put("Bold Raid", boldRaid);
		gambits.put("Energy Shield", energyShield);
		gambits.put("Frontier Fleet", frontierFleet);
		gambits.put("Political Maneuver", politicalManeuver);
		gambits.put("Rise to Power", riseToPower);
		gambits.put("Salvage Operation", salvageOperation);
		gambits.put("Smuggling Run", smugglingRun);
		gambits.put("Surprise Assault", surpriseAssault);
		gambits.put("Unlikely Alliance", unlikelyAlliance);
		gambits.put("Wild Gambit", wildGambit);

		
		return gambits;		
	}
	
	public static void initCap() {
		mercCruiser.addCapacity("AttackPoint", 5);
		
	}
	
	public static void initScrap() {
		boldRaid.addScrap("Draw", 1);
		politicalManeuver.addScrap("TradePoint", 2);
		riseToPower.addScrap("Authority", 8);
		riseToPower.addScrap("Draw", 1);
		surpriseAssault.addScrap("AttackPoint", 8);
		unlikelyAlliance.addScrap("Draw", 2);
	}

}

