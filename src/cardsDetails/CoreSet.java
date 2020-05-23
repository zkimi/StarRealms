package cardsDetails;

import java.util.HashMap;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Explorer;
import cardInfo.Ship;

public class CoreSet {
	
	public static HashMap<String, Cards> coreSet = new HashMap<String, Cards>();

	/* BLOB */
	
	public static Cards battleBlob = new Ship("Battle Blob", "Draw a card.", 6, "Blob");
	
	public static Cards battlePod = new Ship("Battle Pod", "You may scrap the card in a trade row", 2, "Blob");
	
	public static Cards blobCarrier = new Ship("Blob Carrier", "Is that a... whale ?", 6, "Blob");
	
	public static Cards blobDestroyer = new Ship("Blob Destroyer", "When this monstrous ship shows up on a colony's sensors, they know the end is near...",4,"Blob");
	
	public static Cards blobFighter = new Ship("Blob Fighter", "Either kill it before it signals the hive or run. There are other choices, but none you'll live through", 1 , "Blob");
	
	public static Cards blobWheel = new Base(false, 5, "Blob Wheel", "desc", 3, "Blob");
	
	public static Cards blobWorld = new Base(false, 0, "Blob World", "desc", 8, "Blob");
	
	public static Cards mothership = new Ship("Mothership","desc",7,"Blob");
	
	public static Cards ram = new Ship("Ram", "desc", 3, "Blob");
	
	public static Cards theHive = new Base(false, 5, "The Hive", "desc", 5, "Blob");
	
	public static Cards tradePod = new Ship("Trade Pod", "The loading and offloading process is efficient, but disgusting.", 2, "Blob");
	
	/* MACHINE CULT */
	
	public static Cards battleMech = new Ship("Battle Mech", "desc", 5, "Machine Cult");
	
	public static Cards battleStation = new Base(true, 5, "Battle Station", "desc", 3, "Machine Cult");
	
	public static Cards brainWorld = new Base(true, 6, "Brain World", "desc", 8, "Machine Cult");
	
	public static Cards junkyard = new Base(true, 5, "Junkyard", "desc", 6, "Machine Cult");
	
	public static Cards machineBase = new Base(true,6,"Machine Base","desc",7,"Machine Cult");
	
	public static Cards mechWorld = new Base(true, 6,"Mech World","desc",5,"Machine Cult");
	
	public static Cards missileBot = new Ship("Missile Bot", "desc", 2, "Machine Cult");
	
	public static Cards missileMech = new Ship("Missile Mech", "desc", 6,"Machine Cult");
	
	public static Cards patrolMech = new Ship("Patrol Mech", "desc", 4, "Machine Cult");
	
	public static Cards stealthNeedle = new Ship("Stealth Needle", "desc", 4, "Machine Cult");
	
	public static Cards supplyBot = new Ship("Supply Bot", "desc", 3, "Machine Cult");
	
	public static Cards tradeBot = new Ship("Trade Bot", "desc", 1, "Machine Cult");	
	
	
	/* STAR EMPIRE */
	
	public static Cards battleCruiser = new Ship("Battlecruiser", "desc",6 ,"Star Empire");
	
	public static Cards corvette = new Ship("Corvette", "desc", 2, "Star Empire");
	
	public static Cards dreadnaught = new Ship("Dreadnaught", "desc", 7, "Star Empire");
	
	public static Cards fleetHQ = new Base(false, 8, "Fleet HQ", "desc", 8, "Star Empire");
	
	public static Cards imperialFighter = new Ship("Imperial Fighter", "desc", 1, "Star Empire");
	
	public static Cards imperialFrigate = new Ship("Imperial Frigate", "desc", 3, "Star Empire");
	
	public static Cards recyclingStation = new Base(true,4,"Recycling Station","desc",4,"Star Empire");
	
	public static Cards royalRedoubt = new Base(true,6,"Royal Redoubt","desc",6,"Star Empire");
	
	public static Cards spaceStation = new Base(true, 4, "Space Station", "desc", 4, "Star Empire");
	
	public static Cards surveyShip = new Ship("Survey Ship","desc",3,"Star Empire");
	
	public static Cards warWorld = new Base(true, 4, "War World", "desc", 5, "Star Empire");
	
	/* TRADE FEDERATION */
	
	public static Cards barterWorld = new Base(false,4,"Barter World","desc",4,"Trade Federation");
	
	public static Cards centralOffice = new Base(false,6,"Central Office","desc",7,"Trade Federation");
	
	public static Cards commandShip = new Ship("Command Ship","desc",8,"Trade Federation");
	
	public static Cards cutter = new Ship("Cutter", "Built for cargo, armed for conflict. Versatility for an unpredictable universe. - Premier Aerospace Cargo Enterprises", 2, "Trade Federation");

	public static Cards defenseCenter = new Base(true,5,"Defense Center","desc",5,"Trade Federation");
	
	public static Cards embassyYacht = new Ship("Embassy Yacht", "If you have two or more bases in play, draw two cards. War should always be a last resort, it's bad for the bottom line.", 3, "Trade Federation");
	
	public static Cards federationShuttle = new Ship("Federation Shuttle", "Fast? This baby doesn't just haul cargo. She hauls.", 1, "Trade Federation");

	public static Cards flagship = new Ship("Flagship", "desc.", 6, "Trade Federation"); // ally add 5 authority
	
	public static Cards freighter = new Ship("Freighter","desc",4,"Trade Federation");
	
	public static Cards portOfCall = new Base(true,6,"Port Of Call", "desc",6,"Trade Federation");
	
	public static Cards tradeEscort = new Ship("Trade Escort", "desc",5,"Trade Federation");
	
	public static Cards tradingPost = new Base(true,4,"Trading Post","desc",3,"Trade Federation");
	
	
	/* UNALIGNED */
	
	public static Cards explorer = new Explorer("Explorer", "desc.", 2, "Unaligned", 0);
	
	public static Cards scout = new Ship("Scout", "desc.", 0, "Unaligned");
	
	public static Cards viper = new Ship("Viper", "desc.", 0, "Unaligned");
	
	public static void initCoreSet() {
		coreSet.put("Battle Blob",battleBlob);
		coreSet.put("Battle Pod",battlePod);
		coreSet.put("Blob Carrier",blobCarrier);
		coreSet.put("Blob Destroyer",blobDestroyer);
		coreSet.put("Blob Fighter",blobFighter);
		coreSet.put("Blob Wheel",blobWheel);
		coreSet.put("Blob World",blobWorld);
		coreSet.put("Mothership ",mothership);
		coreSet.put("Ram",ram);
		coreSet.put("The Hive",theHive);
		coreSet.put("Trade Pod",tradePod);

		coreSet.put("Battle Mech",battleMech);
		coreSet.put("Battle Station",battleStation);
		coreSet.put("Brain World",brainWorld);
		coreSet.put("Junkyard",junkyard);
		coreSet.put("Machine Base",machineBase);
		coreSet.put("Mech World",mechWorld);
		coreSet.put("Missile Bot ",missileBot);
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
		coreSet.put("Recycling Station ",recyclingStation);
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
		coreSet.put("Port of Call",portOfCall);
		coreSet.put("Trade Escort ",tradeEscort);
		coreSet.put("Trading Post",tradingPost);

		coreSet.put("Explorer",explorer);
		coreSet.put("Scout",scout);
		coreSet.put("Viper",viper);
	}
	

}
