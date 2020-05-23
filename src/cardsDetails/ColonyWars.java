package cardsDetails;

import java.util.HashMap;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Ship;

public class ColonyWars {
	
	private static HashMap<String, Cards> colonyWars = new HashMap<String, Cards>();

	private static Cards bioformer = new Base(false, 4, "Bioformer", "desc", 4, "Blob");

	private static Cards cargoPod = new Ship("Cargo Pod", "desc.", 3, "Blob");
	
	private static Cards leviathan = new Ship("Leviathan", "desc.", 8, "Blob");
	
	private static Cards moonwurm = new Ship("Moonwurm", "desc.", 7, "Blob");
	
	private static Cards parasite = new Ship("Parasite", "desc.", 5, "Blob");
	
	private static Cards plasmaVent = new Base(false, 5, "Plasma Vent", "desc", 6, "Blob");

	private static Cards predator = new Ship("Predator", "desc.", 2, "Blob");
	
	private static Cards ravager = new Ship("Ravager", "desc.", 3, "Blob");
	
	private static Cards stellarReef = new Base(false,3, "Stellar Reef", "desc", 2, "Blob");

	private static Cards swarmer = new Ship("Swarmer", "desc.", 1, "Blob");
	
	private static Cards battleBot = new Ship("Battle Bot", "desc.", 1, "Machine Cult");

	private static Cards convoyBot = new Ship("Convoy Bot", "desc.", 3, "Machine Cult");

	private static Cards frontierStation = new Base(true,6, "Frontier Station", "desc", 6, "Machine Cult");

	private static Cards mechCruiser = new Ship("Mech Cruiser", "desc.", 5, "Machine Cult");

	private static Cards miningMech = new Ship("Mining Mech", "desc.", 4, "Machine Cult");
	
	private static Cards repairBot = new Ship("Repair Bot", "desc.", 2, "Machine Cult");
	
	private static Cards stealthTower = new Base(true,5, "Stealth Tower", "desc", 5, "Machine Cult");

	private static Cards theIncinerator = new Base(true,6, "The Incinerator", "desc", 8, "Machine Cult");

	private static Cards theOracle = new Base(true,5, "The Oracle", "desc", 4, "Machine Cult");

	private static Cards theWrecker = new Ship("The Wrecker", "desc.", 7, "Machine Cult");
	
	private static Cards warningBeacon = new Base(true,2, "Warning Beacon", "desc", 2, "Machine Cult");

	private static Cards agingBattleship = new Ship("Aging Battleship", "desc.", 5, "Star Empire");
	
	private static Cards commandCenter = new Base(true,4, "Command Center", "desc", 4, "Star Empire");
	
	private static Cards emperorsDreadnaught = new Ship("Emperors Dreadnaught", "desc.", 8, "Star Empire");
	
	private static Cards falcon = new Ship("Falcon", "desc.", 3, "Star Empire");
	
	private static Cards gunship = new Ship("Gunship", "desc.", 4, "Star Empire");
	
	private static Cards heavyCruiser = new Ship("Heavy Cruiser", "desc.", 5, "Star Empire");
	
	private static Cards imperialPalace = new Base(true,6, "Imperial Palace", "desc", 4, "Star Empire");
	
	private static Cards lancer = new Ship("Lancer", "desc.", 2, "Star Empire");
	
	private static Cards orbitalPlatform = new Base(false,4, "Orbital Platform", "desc", 3, "Star Empire");
	
	private static Cards starBarge = new Ship("Star Barge", "desc.", 1, "Star Empire");
	
	private static Cards supplyDepot = new Base(true,5, "Supply Depot", "desc", 6, "Star Empire");
	
	private static Cards centralStation = new Base(false,5, "Central Station", "desc", 4, "Trade Federation");
	
	private static Cards colonySeedShip = new Ship("Colony Seed Ship", "desc.", 5, "Trade Federation");
	
	private static Cards factoryWorld = new Base(true,6, "Factory World", "desc", 8, "Trade Federation");
	
	private static Cards federationShipyard = new Base(true,6, "Federation Shipyard", "desc", 6, "Trade Federation");
	
	private static Cards frontierFerry = new Ship("Frontier Ferry", "desc.", 4, "Trade Federation");
	
	private static Cards loyalColony = new Base(false,6, "Loyal Colony", "desc", 7, "Trade Federation");
	
	private static Cards patrolCutter = new Ship("Patrol Cutter", "desc.", 3, "Trade Federation");
	
	private static Cards peacekeeper = new Ship("Peacekeeper", "desc.", 6, "Trade Federation");
	
	private static Cards solarSkiff = new Ship("Solar Skiff", "desc.", 1, "Trade Federation");
	
	private static Cards storageSilo = new Base(false,3, "Storage Silo", "desc", 2, "Trade Federation");
	
	private static Cards tradeHauler = new Ship("Trade Hauler", "desc.", 2, "Trade Federation");
	
	public static HashMap<String,Cards> initColonyWars() {
		
		//on initialise les capacités
		initAlly();
		initScrap();
		initCap();
		
		colonyWars.put("Bioformer",bioformer);
		
		colonyWars.put("Cargo Pod",cargoPod);
		
		colonyWars.put("Leviathan",leviathan);
		
		colonyWars.put("Moonwurm",moonwurm);
		
		colonyWars.put("Parasite",parasite);
		
		colonyWars.put("Plasma Vent", plasmaVent);
		
		colonyWars.put("Ravager",ravager);
		
		colonyWars.put("Stellar Reef",stellarReef);
		
		colonyWars.put("Swarmer", swarmer);
		
		colonyWars.put("Predator", predator);
		
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
		
		colonyWars.put("Storage Silo", storageSilo);
		
		colonyWars.put("Trade Hauler", tradeHauler);
		
		return colonyWars;
		
	}

	//On ajoute les capacité aux cartes
	private static void initCap() {
		/* EXTENSION COLONYWARS */
		bioformer.addCapacity("AttackPoint", 3);
		cargoPod.addCapacity("TradePoint", 3);
		leviathan.addCapacity("AttackPoint", 9);
		leviathan.addCapacity("Draw", 1);
		moonwurm.addCapacity("AttackPoint", 8);
		moonwurm.addCapacity("Draw", 1);
		/* parasite choix spé */
		plasmaVent.addCapacity("AttackPoint", 4);
		predator.addCapacity("AttackPoint", 4);
		ravager.addCapacity("AttackPoint", 6);
		stellarReef.addCapacity("TradePoint", 1);
		swarmer.addCapacity("AttackPoint", 3);
		battleBot.addCapacity("AttackPoint", 2);
		convoyBot.addCapacity("AttackPoint", 4);
		frontierStation.addCapacity("Choice", 223);
		mechCruiser.addCapacity("AttackPoint", 4);
		miningMech.addCapacity("TradePoint", 3);
		repairBot.addCapacity("TradePoint", 2);
		/* stealth tower, the incenarator capa spé */
		theWrecker.addCapacity("AttackPoint", 6);
		warningBeacon.addCapacity("AttackPoint", 2);
		agingBattleship.addCapacity("AttackPoint", 5);
		commandCenter.addCapacity("TradePoint", 2);
		emperorsDreadnaught.addCapacity("AttackPoint", 8);
		emperorsDreadnaught.addCapacity("Draw", 1);
		falcon.addCapacity("AttackPoint", 2);
		falcon.addCapacity("Draw", 1);
		gunship.addCapacity("AttackPoint", 5);
		heavyCruiser.addCapacity("AttackPoint", 4);
		imperialPalace.addCapacity("OpponentDiscard", 1);
		imperialPalace.addCapacity("Draw", 1);
		lancer.addCapacity("AttackPoint", 4);
		// orbitalplatform capa spé
		starBarge.addCapacity("TradePoint", 2);
		// supply depot capa spé
		centralStation.addCapacity("TradePoint", 2);
		colonySeedShip.addCapacity("TradePoint", 3);
		colonySeedShip.addCapacity("AttackPoint", 3);
		colonySeedShip.addCapacity("Authority", 3);
		factoryWorld.addCapacity("TradePoint", 3);
		federationShipyard.addCapacity("TradePoint", 2);
		frontierFerry.addCapacity("TradePoint", 3);
		frontierFerry.addCapacity("Authority", 4);
		loyalColony.addCapacity("TradePoint", 3);
		loyalColony.addCapacity("AttackPoint", 3);
		loyalColony.addCapacity("Authority", 3);
		patrolCutter.addCapacity("TradePoint", 2);
		patrolCutter.addCapacity("AttackPoint", 3);
		peacekeeper.addCapacity("AttackPoint", 6);
		peacekeeper.addCapacity("Authority", 6);
		solarSkiff.addCapacity("TradePoint", 2);
		storageSilo.addCapacity("Authority", 2);
		tradeHauler.addCapacity("TradePoint", 3);
	}
	
	private static void initScrap() {
		bioformer.addScrap("TradePoint", 3);
		cargoPod.addScrap("AttackPoint", 3);
		stellarReef.addScrap("AttackPoint", 3);
		repairBot.addScrap("AttackPoint", 2);
		agingBattleship.addScrap("AttackPoint", 2);
		agingBattleship.addScrap("Draw", 2);
		gunship.addScrap("TradePoint", 4);
	}
	
	private static void initAlly() {
		cargoPod.addAlly("AttackPoint", 3);
		predator.addAlly("Draw", 1);
		swarmer.addAlly("AttackPoint", 2);
		battleBot.addAlly("AttackPoint", 2);
		convoyBot.addAlly("AttackPoint", 2);
		miningMech.addAlly("AttackPoint", 3);
		theOracle.addAlly("AttackPoint", 3);
		theWrecker.addAlly("Draw", 1);
		agingBattleship.addAlly("Draw", 2);
		heavyCruiser.addAlly("Draw", 1);
		imperialPalace.addAlly("AttackPoint", 4);
		lancer.addAlly("OpponentDiscard", 1);
		orbitalPlatform.addAlly("AttackPoint", 3);
		starBarge.addAlly("AttackPoint", 2);
		starBarge.addAlly("OpponentDiscard", 1);
		supplyDepot.addAlly("Draw", 1);
		patrolCutter.addAlly("Authority", 4);
		peacekeeper.addAlly("Draw", 1);
		solarSkiff.addAlly("Draw", 1);
		storageSilo.addAlly("TradePoint", 2);
		tradeHauler.addAlly("Authority", 3);
	}
}
