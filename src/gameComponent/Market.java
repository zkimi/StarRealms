package gameComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import cardInfo.Cards;
import cardsDetails.ColonyWars;
import cardsDetails.CoreSet;
import cardsDetails.United;

public class Market {
	private static ArrayList<Cards> explorers = new ArrayList<>(); // pile explorers
	private static ArrayList<Cards> market = new ArrayList<>(); // pioche de cartes
	private static ArrayList<Cards> shownMarket  = new ArrayList<>();
	
	
	/* CODE */
	
	
	public static void initializeCards() {
		//Ces dictionnaires serviront à initialiser le jeu avec les packs que l'on souhaite inserer.
		HashMap<String, Cards> coreSet = CoreSet.initCoreSet();
		HashMap<String, Cards> colonyWars = ColonyWars.initColonyWars();
		HashMap<String, Cards> united = United.initUnited();

		
		market.add(coreSet.get("Trade Escort"));
		market.add(coreSet.get("Port Of Call"));
		market.add(coreSet.get("Defense Center"));
		market.add(coreSet.get("Command Ship"));
		market.add(coreSet.get("Central Office"));
		market.add(coreSet.get("Royal Redoubt"));
		market.add(coreSet.get("Fleet HQ"));
		market.add(coreSet.get("Battlecruiser"));
		market.add(coreSet.get("Stealth Needle"));
		market.add(coreSet.get("Missile Mech"));
		market.add(coreSet.get("Mech World"));
		market.add(coreSet.get("Machine Base"));
		market.add(coreSet.get("Junkyard"));
		market.add(coreSet.get("Brain World"));
		market.add(coreSet.get("Battle Mech"));
		market.add(coreSet.get("The Hive"));
		market.add(coreSet.get("Mothership"));
		market.add(coreSet.get("Blob World"));
		market.add(coreSet.get("Blob Carrier"));
		market.add(coreSet.get("Battle Blob"));
		market.add(coreSet.get("Dreadnaught"));
		market.add(coreSet.get("War World"));
		market.add(coreSet.get("Flagship"));
		
		market.add(united.get("Embassy Base"));
		market.add(united.get("Exchange Point"));
		market.add(united.get("Lookout Post"));
		market.add(united.get("Union Stronghold"));
		market.add(united.get("Alliance Landing"));
		market.add(united.get("Coalition Fortress"));
		market.add(united.get("Union Cluster"));
		market.add(united.get("CEO Shaner"));
		market.add(united.get("Commodore Zhang"));
		market.add(united.get("Confessor Morris"));
		market.add(united.get("Hive Lord"));
		
		market.add(colonyWars.get("Leviathan"));
		market.add(colonyWars.get("Moonwurm"));
		market.add(colonyWars.get("Parasite"));
		market.add(colonyWars.get("Plasma Vent"));
		market.add(colonyWars.get("Frontier Station"));
		market.add(colonyWars.get("Mech Cruiser"));
		market.add(colonyWars.get("Stealth Tower"));
		market.add(colonyWars.get("The Incinerator"));
		market.add(colonyWars.get("The Oracle"));
		market.add(colonyWars.get("The Wrecker"));
		market.add(colonyWars.get("Aging Battleship"));
		market.add(colonyWars.get("Emperors Dreadnaught"));
		market.add(colonyWars.get("Heavy Cruiser"));
		market.add(colonyWars.get("Imperial Palace"));
		market.add(colonyWars.get("Supply Depot"));
		market.add(colonyWars.get("Colony Seed Ship"));
		market.add(colonyWars.get("Factory World"));
		market.add(colonyWars.get("Federation Shipyard"));
		market.add(colonyWars.get("Loyal Colony"));
		market.add(colonyWars.get("Peacekeeper"));
		
		for (int i = 0; i < 3; i++) {
			market.add(coreSet.get("Survey Ship"));
			market.add(coreSet.get("Imperial Frigate"));
			market.add(coreSet.get("Imperial Fighter"));
			market.add(coreSet.get("Trade Bot"));
			market.add(coreSet.get("Supply Bot"));
			market.add(coreSet.get("Missile Bot"));
			market.add(coreSet.get("Blob Wheel"));
			market.add(coreSet.get("Blob Fighter"));
			market.add(coreSet.get("Trade Pod"));
			market.add(coreSet.get("Cutter"));
			market.add(coreSet.get("Federation Shuttle"));
			
			market.add(colonyWars.get("Cargo Pod"));
			market.add(colonyWars.get("Predator"));
			market.add(colonyWars.get("Stellar Reef"));
			market.add(colonyWars.get("Swarmer"));
			market.add(colonyWars.get("Battle Bot"));
			market.add(colonyWars.get("Convoy Bot"));
			market.add(colonyWars.get("Repair Bot"));
			market.add(colonyWars.get("Warning Beacon"));
			market.add(colonyWars.get("Lancer"));
			market.add(colonyWars.get("Orbital Platform"));
			market.add(colonyWars.get("Star Barge"));
			market.add(colonyWars.get("patrol Cutter"));
			market.add(colonyWars.get("solar Skiff"));
			market.add(colonyWars.get("Trade Hauler"));
		}
		for (int i = 0; i < 2; i++) {
			market.add(coreSet.get("Trading Post"));
			market.add(coreSet.get("Freighter"));
			market.add(coreSet.get("Barter World"));
			market.add(coreSet.get("Recycling Station"));
			market.add(coreSet.get("Patrol Mech"));
			market.add(coreSet.get("Battle Station"));
			market.add(coreSet.get("Battle Pod"));
			market.add(coreSet.get("Blob Destroyer"));
			market.add(coreSet.get("Ram"));
			market.add(coreSet.get("Corvette"));
			market.add(coreSet.get("Space Station"));
			market.add(coreSet.get("Embassy Yacht"));
			
			market.add(united.get("Alliance Transport"));
			market.add(united.get("Blob Bot"));
			market.add(united.get("Coalition Messenger"));
			market.add(united.get("Trade Star"));
			market.add(united.get("Alliance Frigate"));
			market.add(united.get("Assault Pod"));
			market.add(united.get("Coalition Freighter"));
			market.add(united.get("Unity Fighter"));
			market.add(united.get("Chairman Haygan"));
			market.add(united.get("Chancellor Hartman"));
			market.add(united.get("Commander Klik"));
			market.add(united.get("Screecher"));
			
			market.add(colonyWars.get("Bioformer"));
			market.add(colonyWars.get("Ravager"));
			market.add(colonyWars.get("Mining Mech"));
			market.add(colonyWars.get("Command Center"));
			market.add(colonyWars.get("Falcon"));
			market.add(colonyWars.get("Gunship"));
			market.add(colonyWars.get("Central Station"));
			market.add(colonyWars.get("Frontier Ferry"));
			market.add(colonyWars.get("Storage Silo"));
		}
		
		for (int i = 0; i < 10; i++) {
			explorers.add(coreSet.get("Explorer"));
		}
		
		Collections.shuffle(market); // on mélange :)
		
		
		
		
	}
	
	public static ArrayList<Cards> initializeTradeCards(){
		if(shownMarket.size() < 5) {
			if (market.size() > 0) {
			for (int i = shownMarket.size(); i < 5; i++) { // pour le nombre de cartes manquant
				
				Random random = new Random();
				int randomInteger = random.nextInt(market.size());
				
				shownMarket.add(market.get(randomInteger)); // on l'ajoute au paquet visible
				market.remove(market.get(randomInteger)); // du coup on la supprime de la pioche commerce
			} 
			} else {
				System.out.println("Plus de cartes dans le marché!");
			
			}
		}
		return shownMarket;
	}
	
	public static ArrayList<Cards> getDrawer(){
		return market;
	}
	
	public static ArrayList<Cards> getShownMarket(){
		return shownMarket;
	}
	
	public static ArrayList<Cards> getExplorers(){
		return explorers;
	}
	
	public static Cards getFirstExplorer(){ // seulement pour le visuel sur l'interface graphique
		if (explorers.size() != 0) {
			return explorers.get(0);
		}
		return null;
	}
	
	public static void addExplorer(Cards c) {
		explorers.add(c);
	}
	
	
	public static String explorerToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : explorers) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	
	public static String marketToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : market) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	
	public static String showMarketToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : shownMarket) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}


	
	
	
}
