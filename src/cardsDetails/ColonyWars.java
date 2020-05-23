package cardsDetails;

import java.util.HashMap;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Ship;

public class ColonyWars {
	
	public static HashMap<String, Cards> colonyWars = new HashMap<String, Cards>();

	public static Cards bioformer = new Base(false, 4, "Bioformer", "desc", 4, "Blob");

	public static Cards cargoPod = new Ship("Cargo Pod", "desc.", 3, "Blob");
	
	public static Cards leviathan = new Ship("Leviathan", "desc.", 8, "Blob");
	
	public static Cards moonwurm = new Ship("Moonwurm", "desc.", 7, "Blob");
	
	public static Cards parasite = new Ship("Parasite", "desc.", 5, "Blob");
	
	public static Cards plasmaVent = new Base(false, 5, "Plasma Vent", "desc", 6, "Blob");

	public static Cards predator = new Ship("Predator", "desc.", 2, "Blob");
	
	public static Cards ravager = new Ship("Ravager", "desc.", 3, "Blob");
	
	public static Cards stellarReef = new Base(false,3, "Stellar Reef", "desc", 2, "Blob");

	public static Cards swarmer = new Ship("Swarmer", "desc.", 1, "Blob");
	
	public static Cards battleBot = new Ship("Battle Bot", "desc.", 1, "Machine Cult");

	public static Cards convoyBot = new Ship("Convoy Bot", "desc.", 3, "Machine Cult");

	public static Cards frontierStation = new Base(true,6, "Frontier Station", "desc", 6, "Machine Cult");

	public static Cards mechCruiser = new Ship("Mech Cruiser", "desc.", 5, "Machine Cult");

	public static Cards miningMech = new Ship("Mining Mech", "desc.", 4, "Machine Cult");
	
	public static Cards repairBot = new Ship("Repair Bot", "desc.", 2, "Machine Cult");
	
	public static Cards stealthTower = new Base(true,5, "Stealth Tower", "desc", 5, "Machine Cult");

	public static Cards theIncinerator = new Base(true,6, "The Incinerator", "desc", 8, "Machine Cult");

	public static Cards theOracle = new Base(true,5, "The Oracle", "desc", 4, "Machine Cult");

	public static Cards theWrecker = new Ship("The Wrecker", "desc.", 7, "Machine Cult");
	
	public static Cards warningBeacon = new Base(true,2, "Warning Beacon", "desc", 2, "Machine Cult");

	public static Cards agingBattleship = new Ship("Aging Battleship", "desc.", 5, "Star Empire");
	
	public static Cards commandCenter = new Base(true,4, "Command Center", "desc", 4, "Star Empire");
	
	public static Cards emperorsDreadnaught = new Ship("Emperors Dreadnaught", "desc.", 8, "Star Empire");
	
	public static Cards falcon = new Ship("Falcon", "desc.", 3, "Star Empire");
	
	public static Cards gunship = new Ship("Gunship", "desc.", 4, "Star Empire");
	
	public static Cards heavyCruiser = new Ship("Heavy Cruiser", "desc.", 5, "Star Empire");
	
	public static Cards imperialPalace = new Base(true,6, "Imperial Palace", "desc", 4, "Star Empire");
	
	public static Cards lancer = new Ship("Lancer", "desc.", 2, "Star Empire");
	
	public static Cards orbitalPlatform = new Base(false,4, "Orbital Platform", "desc", 3, "Star Empire");
	
	public static Cards starBarge = new Ship("Star Barge", "desc.", 1, "Star Empire");
	
	public static Cards supplyDepot = new Base(true,5, "Supply Depot", "desc", 6, "Star Empire");
	
	public static Cards centralStation = new Base(false,5, "Central Station", "desc", 4, "Trade Federation");
	
	public static Cards colonySeedShip = new Ship("Colony Seed Ship", "desc.", 5, "Trade Federation");
	
	public static Cards factoryWorld = new Base(true,6, "Factory World", "desc", 8, "Trade Federation");
	
	public static Cards federationShipyard = new Base(true,6, "Federation Shipyard", "desc", 6, "Trade Federation");
	
	public static Cards frontierFerry = new Ship("Frontier Ferry", "desc.", 4, "Trade Federation");
	
	public static Cards loyalColony = new Base(false,6, "Loyal Colony", "desc", 7, "Trade Federation");
	
	public static Cards patrolCutter = new Ship("Patrol Cutter", "desc.", 3, "Trade Federation");
	
	public static Cards peacekeeper = new Ship("Peacekeeper", "desc.", 6, "Trade Federation");
	
	public static Cards solarSkiff = new Ship("Solar Skiff", "desc.", 1, "Trade Federation");
	
	public static Cards storageSilo = new Base(false,3, "Storage Silo", "desc", 2, "Trade Federation");
	
	public static Cards tradeHauler = new Ship("Trade Hauler", "desc.", 2, "Trade Federation");
	
	public static void initColonyWars() {
		
		colonyWars.put("Bioformer",bioformer);
		
		colonyWars.put("Cargo Pod",cargoPod);
		
		colonyWars.put("Leviathan",leviathan);
		
		colonyWars.put("Moonwurm",moonwurm);
		
		colonyWars.put("Parasite",parasite);
		
		colonyWars.put("Plasma Vent", plasmaVent);
		
		colonyWars.put("Predator",plasmaVent);
		
		colonyWars.put("Ravager",ravager);
		
		colonyWars.put("Stellar Reef",stellarReef);
		
		colonyWars.put("Swarmer", swarmer);
		
		colonyWars.put("Predator", predator);
		
		colonyWars.put("Stellar Reef",stellarReef);
		
		colonyWars.put("Battle Bot", battleBot);
		
		colonyWars.put("Convoy Bot", convoyBot);
		
		colonyWars.put("Frontier Station", frontierStation);
		
		colonyWars.put("Mech Cruiser", mechCruiser);
		
		colonyWars.put("Mining Mech", miningMech);
		
		colonyWars.put("Repair Bot", repairBot);
		
		colonyWars.put("Stealth Tower", stealthTower);
		
		colonyWars.put("The Incinerator", theIncinerator);
		
		colonyWars.put("The Oracle", theOracle);
		
		colonyWars.put("The Wrecker", theWrecker);
		
		colonyWars.put("Warning Beacon", warningBeacon);
		
		colonyWars.put("Aging Battleship", agingBattleship);
		
		colonyWars.put("Command Center", commandCenter);
		
		colonyWars.put("Emperors Dreadnaught", emperorsDreadnaught);
		
		colonyWars.put("Falcon", falcon);
		
		colonyWars.put("Gunship", gunship);
		
		colonyWars.put("Heavy Cruiser", heavyCruiser);
		
		colonyWars.put("Imperial Palace", imperialPalace);
		
		colonyWars.put("Lancer",lancer);
		
		colonyWars.put("Orbital Platform", orbitalPlatform);
		
		colonyWars.put("Star Barge", starBarge);
		
		colonyWars.put("Supply Depot", supplyDepot);
		
		colonyWars.put("Central Station", centralStation);
		
		colonyWars.put("Colony Seed Ship", colonySeedShip);
		
		colonyWars.put("Factory World", factoryWorld);
		
		colonyWars.put("Federation Shipyard", federationShipyard);
		
		colonyWars.put("Frontier Ferry", frontierFerry);
		
		colonyWars.put("Loyal Colony", loyalColony);
		
		colonyWars.put("Patrol Cutter", patrolCutter);
		
		colonyWars.put("Peacekeeper", peacekeeper);
		
		colonyWars.put("Solar Skiff", solarSkiff);
		
		colonyWars.put("Storage Solo", storageSilo);
		
		colonyWars.put("Trade Hauler", tradeHauler);
		
	}
	
}
