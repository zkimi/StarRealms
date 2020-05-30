package cardsDetails;

import java.util.HashMap;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Explorer;
import cardInfo.Ship;

public class CoreSet {
	
	private static HashMap<String, Cards> coreSet = new HashMap<String, Cards>();

	/* BLOB */
	
	private static Cards battleBlob = new Ship("Battle Blob","Draw a card.", 6,"Blob");
	
	private static Cards battlePod = new Ship("Battle Pod","You may scrap the card in a trade row", 2,"Blob");
	
	private static Cards blobCarrier = new Ship("Blob Carrier","Is that a... whale ?", 6,"Blob");
	
	private static Cards blobDestroyer = new Ship("Blob Destroyer","When this monstrous ship shows up on a colony's sensors, they know the end is near...",4,"Blob");
	
	private static Cards blobFighter = new Ship("Blob Fighter","Either kill it before it signals the hive or run. There are other choices, but none you'll live through", 1 ,"Blob");
	
	private static Cards blobWheel = new Base(false, 5,"Blob Wheel","desc", 3,"Blob");
	
	private static Cards blobWorld = new Base(false, 0,"Blob World","desc", 8,"Blob");
	
	private static Cards mothership = new Ship("Mothership","desc",7,"Blob");
	
	private static Cards ram = new Ship("Ram","desc", 3,"Blob");
	
	private static Cards theHive = new Base(false, 5,"The Hive","desc", 5,"Blob");
	
	private static Cards tradePod = new Ship("Trade Pod","The loading and offloading process is efficient, but disgusting.", 2,"Blob");
	
	/* MACHINE CULT */
	
	private static Cards battleMech = new Ship("Battle Mech","desc", 5,"Machine Cult");
	
	private static Cards battleStation = new Base(true, 5,"Battle Station","desc", 3,"Machine Cult");
	
	private static Cards brainWorld = new Base(true, 6,"Brain World","desc", 8,"Machine Cult");
	
	private static Cards junkyard = new Base(true, 5,"Junkyard","desc", 6,"Machine Cult");
	
	private static Cards machineBase = new Base(true,6,"Machine Base","desc",7,"Machine Cult");
	
	private static Cards mechWorld = new Base(true, 6,"Mech World","desc",5,"Machine Cult");
	
	private static Cards missileBot = new Ship("Missile Bot","desc", 2,"Machine Cult");
	
	private static Cards missileMech = new Ship("Missile Mech","desc", 6,"Machine Cult");
	
	private static Cards patrolMech = new Ship("Patrol Mech","desc", 4,"Machine Cult");
	
	private static Cards stealthNeedle = new Ship("Stealth Needle","desc", 4,"Machine Cult");
	
	private static Cards supplyBot = new Ship("Supply Bot","desc", 3,"Machine Cult");
	
	private static Cards tradeBot = new Ship("Trade Bot","desc", 1,"Machine Cult");	
	
	
	/* STAR EMPIRE */
	
	private static Cards battleCruiser = new Ship("Battlecruiser","desc",6 ,"Star Empire");
	
	private static Cards corvette = new Ship("Corvette","desc", 2,"Star Empire");
	
	private static Cards dreadnaught = new Ship("Dreadnaught","desc", 7,"Star Empire");
	
	private static Cards fleetHQ = new Base(false, 8,"Fleet HQ","desc", 8,"Star Empire");
	
	private static Cards imperialFighter = new Ship("Imperial Fighter","desc", 1,"Star Empire");
	
	private static Cards imperialFrigate = new Ship("Imperial Frigate","desc", 3,"Star Empire");
	
	private static Cards recyclingStation = new Base(true,4,"Recycling Station","desc",4,"Star Empire");
	
	private static Cards royalRedoubt = new Base(true,6,"Royal Redoubt","desc",6,"Star Empire");
	
	private static Cards spaceStation = new Base(true, 4,"Space Station","desc", 4,"Star Empire");
	
	private static Cards surveyShip = new Ship("Survey Ship","desc",3,"Star Empire");
	
	private static Cards warWorld = new Base(true, 4,"War World","desc", 5,"Star Empire");
	
	/* TRADE FEDERATION */
	
	private static Cards barterWorld = new Base(false,4,"Barter World","desc",4,"Trade Federation");
	
	private static Cards centralOffice = new Base(false,6,"Central Office","desc",7,"Trade Federation");
	
	private static Cards commandShip = new Ship("Command Ship","desc",8,"Trade Federation");
	
	private static Cards cutter = new Ship("Cutter","Built for cargo, armed for conflict. Versatility for an unpredictable universe. - Premier Aerospace Cargo Enterprises", 2,"Trade Federation");

	private static Cards defenseCenter = new Base(true,5,"Defense Center","desc",5,"Trade Federation");
	
	private static Cards embassyYacht = new Ship("Embassy Yacht","If you have two or more bases in play, draw two cards. War should always be a last resort, it's bad for the bottom line.", 3,"Trade Federation");
	
	private static Cards federationShuttle = new Ship("Federation Shuttle","Fast? This baby doesn't just haul cargo. She hauls.", 1,"Trade Federation");

	private static Cards flagship = new Ship("Flagship","desc.", 6,"Trade Federation"); // ally add 5 authority
	
	private static Cards freighter = new Ship("Freighter","desc",4,"Trade Federation");
	
	private static Cards portOfCall = new Base(true,6,"Port Of Call","desc",6,"Trade Federation");
	
	private static Cards tradeEscort = new Ship("Trade Escort","desc",5,"Trade Federation");
	
	private static Cards tradingPost = new Base(true,4,"Trading Post","desc",3,"Trade Federation");
	
	
	/* UNALIGNED */
	
	public static Cards explorer = new Explorer("Explorer","desc.", 2,"Unaligned", 0);
	
	public static Cards scout = new Ship("Scout","desc.", 0,"Unaligned");
	
	public static Cards viper = new Ship("Viper","desc.", 0,"Unaligned");
	
	public static HashMap<String, Cards> initCoreSet() {
		//on initialise les capacités
		initAlly();
		initScrap();
		initCap();
		
		coreSet.put("Battle Blob",battleBlob);
		coreSet.put("Battle Pod",battlePod);
		coreSet.put("Blob Carrier",blobCarrier);
		coreSet.put("Blob Destroyer",blobDestroyer);
		coreSet.put("Blob Fighter",blobFighter);
		coreSet.put("Blob Wheel",blobWheel);
		coreSet.put("Blob World",blobWorld);
		coreSet.put("Mothership",mothership);
		coreSet.put("Ram",ram);
		coreSet.put("The Hive",theHive);
		coreSet.put("Trade Pod",tradePod);

		coreSet.put("Battle Mech",battleMech);
		coreSet.put("Battle Station",battleStation);
		coreSet.put("Brain World",brainWorld);
		coreSet.put("Junkyard",junkyard);
		coreSet.put("Machine Base",machineBase);
		coreSet.put("Mech World",mechWorld);
		coreSet.put("Missile Bot",missileBot);
		coreSet.put("Missile Mech",missileMech);
		coreSet.put("Patrol Mech",patrolMech);
		coreSet.put("Stealth Needle",stealthNeedle);
		coreSet.put("Supply Bot",supplyBot);
		coreSet.put("Trade Bot",tradeBot);

		coreSet.put("Battlecruiser",battleCruiser);
		coreSet.put("Corvette",corvette);
		coreSet.put("Dreadnaught",dreadnaught);
		coreSet.put("Fleet HQ",fleetHQ);
		coreSet.put("Imperial Fighter",imperialFighter);
		coreSet.put("Imperial Frigate",imperialFrigate);
		coreSet.put("Recycling Station",recyclingStation);
		coreSet.put("Royal Redoubt",royalRedoubt);
		coreSet.put("Space Station",spaceStation);
		coreSet.put("Survey Ship",surveyShip);
		coreSet.put("War World",warWorld);

		coreSet.put("Barter World",barterWorld);
		coreSet.put("Central Office",centralOffice);
		coreSet.put("Command Ship",commandShip);
		coreSet.put("Cutter",cutter);
		coreSet.put("Defense Center",defenseCenter);
		coreSet.put("Embassy Yacht",embassyYacht);
		coreSet.put("Federation Shuttle",federationShuttle);
		coreSet.put("Flagship",flagship);
		coreSet.put("Freighter",freighter);
		coreSet.put("Port Of Call",portOfCall);
		coreSet.put("Trade Escort",tradeEscort);
		coreSet.put("Trading Post",tradingPost);

		coreSet.put("Explorer",explorer);
		coreSet.put("Scout",scout);
		coreSet.put("Viper",viper);
		
		
		
		return coreSet;
	}
	
	
	private static void initCap() {
		
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
		battleBlob.addCapacity("AttackPoint", 8);
		battlePod.addCapacity("AttackPoint", 4);
		blobCarrier.addCapacity("AttackPoint", 7);
		blobDestroyer.addCapacity("AttackPoint", 6);
		blobFighter.addCapacity("AttackPoint", 3);
		blobWheel.addCapacity("AttackPoint", 1);
		blobWorld.addCapacity("AttackPoint",5);
		mothership.addCapacity("AttackPoint",6);
		ram.addCapacity("AttackPoint", 5);
		theHive.addCapacity("AttackPoint", 3);
		tradePod.addCapacity("TradePoint",3);
		
		/* Machine Cult */
		battleMech.addCapacity("AttackPoint", 4);
		// brainworld voir pour adapter car choix !
		// junkyard scrap or discard pile
		// machinebase draw a card, then scrap
		missileBot.addCapacity("AttackPoint", 2);
		missileMech.addCapacity("AttackPoint", 6);
		patrolMech.addCapacity("Choice", 235);
		
		// stealth needle copy another ship
		supplyBot.addCapacity("TradePoint", 2);
		tradeBot.addCapacity("TradePoint", 1);
		
		/* Star Empire */
		battleCruiser.addCapacity("AttackPoint", 5);
		battleCruiser.addCapacity("Draw", 1);
		corvette.addCapacity("AttackPoint", 2);
		corvette.addCapacity("Draw", 1);
		dreadnaught.addCapacity("AttackPoint", 7);
		dreadnaught.addCapacity("Draw", 1);
		fleetHQ.addCapacity("FleetHQ", 1);
		imperialFighter.addCapacity("AttackPoint", 2);
		imperialFighter.addCapacity("OpponentDiscard", 1);
		imperialFrigate.addCapacity("AttackPoint", 4);
		imperialFrigate.addCapacity("OpponentDiscard", 1);
		// recycling station CHOIX add 1 trade or  discard up to two cards, then draw that many cards
		royalRedoubt.addCapacity("AttackPoint", 3);
		spaceStation.addCapacity("AttackPoint", 2);
		surveyShip.addCapacity("TradePoint", 1);
		warWorld.addCapacity("AttackPoint", 3);
		
		/* Trade Federation */
		barterWorld.addCapacity("Choice", 122);
		centralOffice.addCapacity("TradePoint", 2);
		commandShip.addCapacity("Authority", 4);
		commandShip.addCapacity("AttackPoint", 5);
		commandShip.addCapacity("Draw", 2);
		cutter.addCapacity("Authority", 4);
		cutter.addCapacity("TradePoint", 2);
		defenseCenter.addCapacity("Choice", 432);
		// defenseCenter CHOIX
		embassyYacht.addCapacity("Authority", 3);
		embassyYacht.addCapacity("TradePoint", 2);
		embassyYacht.addCapacity("EmbassyYatch", 0);
		federationShuttle.addCapacity("TradePoint", 2);
		federationShuttle.addCapacity("Authority", 4);
		flagship.addCapacity("AttackPoint", 5);
		flagship.addCapacity("Draw", 1);
		freighter.addCapacity("TradePoint", 4);
		portOfCall.addCapacity("TradePoint", 3);
		tradeEscort.addCapacity("Authority", 4);
		tradeEscort.addCapacity("AttackPoint", 4);
		tradingPost.addCapacity("Choice", 111);
		
		
		explorer.addCapacity("TradePoint", 2);
		scout.addCapacity("TradePoint", 1);
		viper.addCapacity("AttackPoint", 1);
	}
	
	private static void initAlly() {
		battleBlob.addAlly("Draw", 1);
		battlePod.addAlly("AttackPoint", 2);
		//blobCarrier acquire any ship without paying
		// Destroyer destroy target base or scrap card in trade row
		blobFighter.addAlly("Draw", 1);
		mothership.addAlly("Draw", 1);
		ram.addAlly("AttackPoint", 2);
		theHive.addAlly("Draw", 1);
		tradePod.addAlly("AttackPoint", 2);
		
		/* machine cult */
		battleMech.addAlly("Draw", 1);
		missileBot.addAlly("AttackPoint", 2);
		missileMech.addAlly("Draw", 1);
		// patrolMech scrap in hand or in discard pile
		supplyBot.addAlly("AttackPoint", 2);
		tradeBot.addAlly("AttackPoint", 2);
		
		/* star empire */
		battleCruiser.addAlly("OpponentDiscard", 1);
		corvette.addAlly("AttackPoint", 2);
		imperialFighter.addAlly("AttackPoint", 2);
		imperialFrigate.addAlly("AttackPoint", 2);
		royalRedoubt.addAlly("OpponentDiscard", 1);
		spaceStation.addAlly("AttackPoint", 2);
		warWorld.addAlly("AttackPoint", 4);
		
		/* trade federation */
		centralOffice.addAlly("Draw", 1);
		//commandShip destroy target base
		cutter.addAlly("AttackPoint", 4);
		defenseCenter.addAlly("AttackPoint", 2);
		federationShuttle.addAlly("Authority", 4);
		flagship.addAlly("Authority", 5);
		// freighter you may put the next ship...
		tradeEscort.addAlly("Draw", 1);
	}
	
	private static void initScrap() {
		/* Blob */
		battleBlob.addScrap("AttackPoint",4);
		blobWheel.addScrap("Draw", 2);
		ram.addScrap("TradePoint", 3);
		
		/* Machine Cult */
		battleStation.addScrap("AttackPoint", 5);
		
		/* Star Empire */
		battleCruiser.addScrap("Draw", 1);
		dreadnaught.addScrap("AttackPoint", 5);
		imperialFrigate.addScrap("Draw", 1);
		spaceStation.addScrap("TradePoint", 4);
		surveyShip.addScrap("OpponentDiscard",1);
		
		/* Trade Federation */
		barterWorld.addScrap("AttackPoint", 5);
		portOfCall.addScrap("Draw", 1);
		tradingPost.addScrap("AttackPoint", 3);
		
		explorer.addScrap("AttackPoint", 2);
	}
	
	public static Cards getExplorer() {
		return explorer;
	}
	
	public static HashMap<String, Cards> getCards(){
		return coreSet;
	}
}
