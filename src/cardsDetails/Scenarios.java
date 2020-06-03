package cardsDetails;

import java.util.HashMap;

import cardInfo.Cards;
import cardInfo.Scenario;

public class Scenarios {
	
	private static HashMap<String, Cards> scenarios = new HashMap<String, Cards>();
	
	private static Cards borderSkirmish = new Scenario("Border Skirmish","desc", 0,"Undefined");
	
	private static Cards buyersMarket = new Scenario("Buyer's Market","desc", 0,"Undefined");
	
	private static Cards commitmentToTheCause = new Scenario("Commitment to the Cause","desc", 0,"Undefined");
	
	private static Cards earlyRecruitment = new Scenario("Early Recruitment","desc", 0,"Undefined");
	
	private static Cards emergencyRepairs = new Scenario("Emergency Repairs","desc", 0,"Undefined");
	
	private static Cards entrenchedLoyalties = new Scenario("Entrenched Loyalties","desc", 0,"Undefined");
	
	private static Cards flareMining = new Scenario("Flare Mining","desc", 0,"Undefined");
	
	private static Cards fleetingOpportunities = new Scenario("Fleeting Opportunities","desc", 0,"Undefined");
	
	private static Cards franticPreparations = new Scenario("Frantic Preparations","desc", 0,"Undefined");
	
	private static Cards frontierExpedition = new Scenario("Frontier Expedition","desc", 0,"Undefined");
	
	private static Cards maximumWarp = new Scenario("Maximum Warp","desc", 0,"Undefined");
	
	private static Cards pickingSides = new Scenario("Picking Sides","desc", 0,"Undefined");
	
	private static Cards prolongedConflict = new Scenario("Prolonged Conflict","desc", 0,"Undefined");
	
	private static Cards rapidConstruction = new Scenario("Rapid Construction","desc", 0,"Undefined");
	
	private static Cards readyReserves = new Scenario("Ready Reserves","desc", 0,"Undefined");
	
	private static Cards recruitingDrive = new Scenario("Recruiting Drive","desc", 0,"Undefined");
	
	private static Cards rushedDefenses = new Scenario("Rushed Defenses","desc", 0,"Undefined");
	
	private static Cards ruthlessEfficiency = new Scenario("Ruthless Efficiency","desc", 0,"Undefined");
	
	private static Cards totalWar = new Scenario("Total War","desc", 0,"Undefined");
	
	private static Cards warpgateNexus = new Scenario("Warpgate Nexus","desc", 0,"Undefined");
	
	
	
	public static HashMap<String,Cards> initScenarios() {
		
		initCap();
		
		scenarios.put("Border Skirmish", borderSkirmish);
		scenarios.put("Buyer's Market", buyersMarket);
		scenarios.put("Commitment to the Cause", commitmentToTheCause);
		scenarios.put("Early Recruitment", earlyRecruitment);
		scenarios.put("Emergency Repairs", emergencyRepairs);
		scenarios.put("Entrenched Loyalties", entrenchedLoyalties);
		scenarios.put("Flare Mining", flareMining);
		scenarios.put("Fleeting Opportunities", fleetingOpportunities);
		scenarios.put("Frantic Preparations", franticPreparations);
		scenarios.put("Frontier Expedition", frontierExpedition);
		scenarios.put("Maximum Warp", maximumWarp);
		scenarios.put("Picking Sides", pickingSides);
		scenarios.put("Prolonged Conflict", prolongedConflict);
		scenarios.put("Rapid Construction", rapidConstruction);
		scenarios.put("Ready Reserves", readyReserves);
		scenarios.put("Recruiting Drive", recruitingDrive);
		scenarios.put("Rushed Defenses", rushedDefenses);
		scenarios.put("Ruthless Efficiency", ruthlessEfficiency);
		scenarios.put("Total War", totalWar);
		scenarios.put("Warpgate Nexus", warpgateNexus);
		
		return scenarios;		
	}
	
	public static void initCap() {
		
	}
}
