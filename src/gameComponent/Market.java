package gameComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import cardInfo.Cards;
import cardsDetails.CoreSet;
import cardsDetails.United;

public class Market {
	private static ArrayList<Cards> explorers = new ArrayList<>(); // pile explorers
	private static ArrayList<Cards> market = new ArrayList<>(); // pioche de cartes
	private static ArrayList<Cards> shownMarket  = new ArrayList<>();
	
	
	/* CODE */
	
	private static void initializeAlly() {
		
		CoreSet.battleBlob.addAlly("Draw", 1);
		CoreSet.battlePod.addAlly("AttackPoint", 2);
		//CoreSet.blobCarrier acquire any ship without paying
		// Destroyer destroy target base or scrap card in trade row
		CoreSet.blobFighter.addAlly("Draw", 1);
		CoreSet.mothership.addAlly("Draw", 1);
		CoreSet.ram.addAlly("AttackPoint", 2);
		CoreSet.theHive.addAlly("Draw", 1);
		CoreSet.tradePod.addAlly("AttackPoint", 2);
		
		/* machine cult */
		CoreSet.battleMech.addAlly("Draw", 1);
		CoreSet.missileBot.addAlly("AttackPoint", 2);
		CoreSet.missileMech.addAlly("Draw", 1);
		// patrolMech scrap in hand or in discard pile
		CoreSet.supplyBot.addAlly("AttackPoint", 2);
		CoreSet.tradeBot.addAlly("AttackPoint", 2);
		
		/* star empire */
		CoreSet.battleCruiser.addAlly("OpponentDiscard", 1);
		CoreSet.corvette.addAlly("AttackPoint", 2);
		CoreSet.imperialFighter.addAlly("AttackPoint", 2);
		CoreSet.imperialFrigate.addAlly("AttackPoint", 2);
		CoreSet.royalRedoubt.addAlly("OpponentDiscard", 1);
		CoreSet.spaceStation.addAlly("AttackPoint", 2);
		CoreSet.warWorld.addAlly("AttackPoint", 4);
		
		/* trade federation */
		CoreSet.centralOffice.addAlly("Draw", 1);
		//CoreSet.commandShip destroy target base
		CoreSet.cutter.addAlly("AttackPoint", 4);
		CoreSet.defenseCenter.addAlly("AttackPoint", 2);
		CoreSet.federationShuttle.addAlly("Authority", 4);
		CoreSet.flagship.addAlly("Authority", 5);
		// freighter you may put the next ship...
		CoreSet.tradeEscort.addAlly("Draw", 1);
		
		/* PACK UNITED */
		United.allianceTransport.addAlly("Authority", 4);
		United.blobBot.addAlly("TradePoint", 5); // seulement pour fac blob ?! comment faire
		
	}
	
	private static void initializeScrap() {//initialise les capacités scrap
		
		/* Blob */
		CoreSet.battleBlob.addScrap("AttackPoint",4);
		CoreSet.blobWheel.addScrap("Draw", 2);
		CoreSet.ram.addScrap("TradePoint", 3);
		
		/* Machine Cult */
		CoreSet.battleStation.addScrap("AttackPoint", 5);
		
		/* Star Empire */
		CoreSet.battleCruiser.addScrap("Draw", 1);
		CoreSet.dreadnaught.addScrap("AttackPoint", 5);
		CoreSet.imperialFrigate.addScrap("Draw", 1);
		CoreSet.spaceStation.addScrap("TradePoint", 4);
		CoreSet.surveyShip.addScrap("OpponentDiscard",1);
		
		/* Trade Federation */
		CoreSet.barterWorld.addScrap("AttackPoint", 5);
		CoreSet.portOfCall.addScrap("Draw", 1);
		CoreSet.tradingPost.addScrap("AttackPoint", 3);
		
		CoreSet.explorer.addScrap("AttackPoint", 2);
		
		/* PACK UNITED */
		United.tradeStar.addScrap("AttackPoint", 2);
	}
	
	private static void initializeCapacity() {//initialise les capacités de toutes les cartes
		
		
		/* PATTERN CHOIX :
		 * 1 : Autorithy or Trade 
		 * 2 : Trade or Combat
		 * 3 : Combat or Special Action
		 * 4 : Authority or Combat
		 * 
		 * Après avoir renseigné le premier digit (pattern de choix) collez y la valeur de la première possibilitée puis de la deuxieme dans l'ordre
		 * Par ex: Pour 2 pts trade ou 5 pts combat on écrira : addCapacity("Choice", 225);
		 */
		
		/* Blob */
		CoreSet.battleBlob.addCapacity("AttackPoint", 8);
		CoreSet.battlePod.addCapacity("AttackPoint", 4);
		CoreSet.blobCarrier.addCapacity("AttackPoint", 7);
		CoreSet.blobDestroyer.addCapacity("AttackPoint", 6);
		CoreSet.blobFighter.addCapacity("AttackPoint", 3);
		CoreSet.blobWheel.addCapacity("AttackPoint", 1);
		CoreSet.blobWorld.addCapacity("AttackPoint",5);
		CoreSet.mothership.addCapacity("AttackPoint",6);
		CoreSet.ram.addCapacity("AttackPoint", 5);
		CoreSet.theHive.addCapacity("AttackPoint", 3);
		CoreSet.tradePod.addCapacity("TradePoint",3);
		
		/* Machine Cult */
		CoreSet.battleMech.addCapacity("AttackPoint", 4);
		// brainworld voir pour adapter car choix !
		// junkyard scrap or discard pile
		// machinebase draw a card, then scrap
		CoreSet.missileBot.addCapacity("AttackPoint", 2);
		CoreSet.missileMech.addCapacity("AttackPoint", 6);
		CoreSet.patrolMech.addCapacity("Choice", 235);
		
		// stealth needle copy another ship
		CoreSet.supplyBot.addCapacity("TradePoint", 2);
		CoreSet.tradeBot.addCapacity("TradePoint", 1);
		
		/* Star Empire */
		CoreSet.battleCruiser.addCapacity("AttackPoint", 5);
		CoreSet.battleCruiser.addCapacity("Draw", 1);
		CoreSet.corvette.addCapacity("AttackPoint", 2);
		CoreSet.corvette.addCapacity("Draw", 1);
		CoreSet.dreadnaught.addCapacity("AttackPoint", 7);
		CoreSet.dreadnaught.addCapacity("Draw", 1);
		CoreSet.fleetHQ.addCapacity("FleetHQ", 1);
		CoreSet.imperialFighter.addCapacity("AttackPoint", 2);
		CoreSet.imperialFighter.addCapacity("OpponentDiscard", 1);
		CoreSet.imperialFrigate.addCapacity("AttackPoint", 4);
		CoreSet.imperialFrigate.addCapacity("OpponentDiscard", 1);
		// recycling station CHOIX add 1 trade or  discard up to two cards, then draw that many cards
		CoreSet.royalRedoubt.addCapacity("AttackPoint", 3);
		CoreSet.spaceStation.addCapacity("AttackPoint", 2);
		CoreSet.surveyShip.addCapacity("TradePoint", 1);
		CoreSet.warWorld.addCapacity("AttackPoint", 3);
		
		/* Trade Federation */
		CoreSet.barterWorld.addCapacity("Choice", 122);
		CoreSet.centralOffice.addCapacity("TradePoint", 2);
		CoreSet.commandShip.addCapacity("Authority", 4);
		CoreSet.commandShip.addCapacity("AttackPoint", 5);
		CoreSet.commandShip.addCapacity("Draw", 2);
		CoreSet.cutter.addCapacity("Authority", 4);
		CoreSet.cutter.addCapacity("TradePoint", 2);
		CoreSet.defenseCenter.addCapacity("Choice", 432);
		// CoreSet.defenseCenter CHOIX
		CoreSet.embassyYacht.addCapacity("Authority", 3);
		CoreSet.embassyYacht.addCapacity("TradePoint", 2);
		CoreSet.embassyYacht.addCapacity("EmbassyYatch", 0);
		CoreSet.federationShuttle.addCapacity("TradePoint", 2);
		CoreSet.federationShuttle.addCapacity("Authority", 4);
		CoreSet.flagship.addCapacity("AttackPoint", 5);
		CoreSet.flagship.addCapacity("Draw", 1);
		CoreSet.freighter.addCapacity("TradePoint", 4);
		CoreSet.portOfCall.addCapacity("TradePoint", 3);
		CoreSet.tradeEscort.addCapacity("Authority", 4);
		CoreSet.tradeEscort.addCapacity("AttackPoint", 4);
		CoreSet.tradingPost.addCapacity("Choice", 111);
		
		
		CoreSet.explorer.addCapacity("TradePoint", 2);
		CoreSet.scout.addCapacity("TradePoint", 1);
		CoreSet.viper.addCapacity("AttackPoint", 1);	
		
		
		/* PACK UNITED */
		United.allianceTransport.addCapacity("TradePoint", 2);
		United.blobBot.addCapacity("AttackPoint", 5);
		United.coalitionMessenger.addCapacity("TradePoint", 2);
		/* Embassy BASE cap spé a faire */
		United.exchangePoint.addCapacity("AttackPoint", 2);
		United.lookoutPost.addCapacity("Draw", 1);
		United.tradeStar.addCapacity("TradePoint", 2);
		United.unionStronghold.addCapacity("AttackPoint", 3);
		United.allianceFrigate.addCapacity("AttackPoint", 4);
		United.allianceLanding.addCapacity("TradePoint", 2);
		United.assaultPod.addCapacity("AttackPoint", 3);
		United.coalitionFortress.addCapacity("TradePoint", 2);
		United.coalitionFreighter.addCapacity("TradePoint", 3);
		United.unionCluster.addCapacity("AttackPoint", 4);
		United.unityFighter.addCapacity("AttackPoint", 3);
		/* unity Station cap spé a faire */
		
	}
	
	public static void initializeCards() {
		initializeCapacity();
		initializeScrap();
		initializeAlly();
		
		market.add(CoreSet.tradeEscort);
		market.add(CoreSet.portOfCall);
		market.add(CoreSet.defenseCenter);
		market.add(CoreSet.commandShip);
		market.add(CoreSet.centralOffice);
		market.add(CoreSet.royalRedoubt);
		market.add(CoreSet.fleetHQ);
		market.add(CoreSet.battleCruiser);
		market.add(CoreSet.stealthNeedle);
		market.add(CoreSet.missileMech);
		market.add(CoreSet.mechWorld);
		market.add(CoreSet.machineBase);
		market.add(CoreSet.junkyard);
		market.add(CoreSet.brainWorld);
		market.add(CoreSet.battleMech);
		market.add(CoreSet.theHive);
		market.add(CoreSet.mothership);
		market.add(CoreSet.blobWorld);
		market.add(CoreSet.blobCarrier);
		market.add(CoreSet.battleBlob);
		market.add(CoreSet.dreadnaught);
		market.add(CoreSet.warWorld);
		market.add(CoreSet.flagship);
		market.add(United.embassyBase);
		market.add(United.exchangePoint);
		market.add(United.lookoutPost);
		market.add(United.unionStronghold);
		market.add(United.allianceLanding);
		market.add(United.coalitionFortress);
		market.add(United.unionCluster);
		for (int i = 0; i < 3; i++) {
			market.add(CoreSet.surveyShip);
			market.add(CoreSet.imperialFrigate);
			market.add(CoreSet.imperialFighter);
			market.add(CoreSet.tradeBot);
			market.add(CoreSet.supplyBot);
			market.add(CoreSet.missileBot);
			market.add(CoreSet.blobWheel);
			market.add(CoreSet.blobFighter);
			market.add(CoreSet.tradePod);
			market.add(CoreSet.cutter);
			market.add(CoreSet.federationShuttle);
		}
		for (int i = 0; i < 2; i++) {
			market.add(CoreSet.tradingPost);
			market.add(CoreSet.freighter);
			market.add(CoreSet.barterWorld);
			market.add(CoreSet.recyclingStation);
			market.add(CoreSet.patrolMech);
			market.add(CoreSet.battleStation);
			market.add(CoreSet.battlePod);
			market.add(CoreSet.blobDestroyer);
			market.add(CoreSet.ram);
			market.add(CoreSet.corvette);
			market.add(CoreSet.spaceStation);
			market.add(CoreSet.embassyYacht);
			market.add(United.allianceTransport);
			market.add(United.blobBot);
			market.add(United.coalitionMessenger);
			market.add(United.tradeStar);
			market.add(United.allianceFrigate);
			market.add(United.assaultPod);
			market.add(United.coalitionFreighter);
			market.add(United.unityFighter);
		}
		
		for (int i = 0; i < 10; i++) {
			explorers.add(CoreSet.explorer);
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
