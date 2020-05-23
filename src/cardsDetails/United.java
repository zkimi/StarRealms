package cardsDetails;

import java.util.HashMap;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Hero;
import cardInfo.Mission;
import cardInfo.Ship;

public class United {
	
	private static HashMap<String, Cards> united = new HashMap<String, Cards>();
	
	/* ASSAULT */
	
	private static Cards allianceTransport = new Ship("Alliance Transport", "Gain 2 trade.", 2, "Star Empire/Trade Federation");

	private static Cards blobBot = new Ship("Blob Bot", "Gain 5 Combat, Gain 2 trade.", 3, "Blob/Machine Cult");

	private static Cards coalitionMessenger = new Ship("Coalition Messenger", "desc.", 3, "Machine Cult/Trade Federation");

	private static Cards embassyBase = new Base(false, 6, "Embassy Base", "desc", 8, "Star Empire/Trade Federation");

	private static Cards exchangePoint = new Base(false, 7, "Exchange Point", "desc", 6, "Blob/Machine Cult");

	private static Cards lookoutPost = new Base(true, 6, "Lookout Post", "desc", 7, "Machine Cult/Trade Federation");
	
	private static Cards tradeStar = new Ship("Trade Star", "desc.", 1, "Blob/Star Empire");

	private static Cards unionStronghold = new Base(false, 5, "Union Stronghold", "desc", 5, "Blob/Star Empire");
	
	
	/* COMMAND */
	
	private static Cards allianceFrigate = new Ship("Alliance Frigate", "desc.", 3, "Star Empire/Trade Federation");

	private static Cards allianceLanding = new Base(true, 5, "Alliance Landing", "desc", 5, "Star Empire/Trade Federation");
	
	private static Cards assaultPod = new Ship("Assault Pod", "desc.", 2, "Blob/Star Empire");
	
	private static Cards coalitionFortress = new Base(true, 6, "Coalition Fortress", "desc", 6, "Trade Federation/Machine Cult");
	
	private static Cards coalitionFreighter = new Ship("Coalition Freighter", "desc.", 4, "Trade Federation/Machine Cult");
	
	private static Cards unionCluster = new Base(false, 8, "Union Cluster", "desc", 8, "Blob/Star Empire");
	
	private static Cards unityFighter = new Ship("Unity Fighter", "desc.", 1, "Blob/Machine Cult");
	
	private static Cards unityStation = new Base(true, 6, "Unity Station", "desc", 7, "Blob/Machine Cult");
	
	
	/* HEROES */
	
	private static Cards ceoShaner = new Hero("CEO Shaner", "desc.", 5, "Unaligned");
	
	private static Cards chairmanHaygan = new Hero("Chairman Haygan", "desc.", 3, "Unaligned");
	
	private static Cards chancellorHartman = new Hero("Chancellor Hartman", "desc.", 4, "Unaligned");
	
	private static Cards commanderKlik = new Hero("Commander Klik", "desc.", 4, "Unaligned");
	
	private static Cards commodoreZhang = new Hero("Commodore Zhang", "desc.", 5, "Unaligned");
	
	private static Cards confessorMorris = new Hero("Confessor Morris", "desc.", 5, "Unaligned");
	
	private static Cards hiveLord = new Hero("Hive Lord", "desc.", 5, "Unaligned");
	
	private static Cards screecher = new Hero("Screecher", "desc.", 3, "Unaligned");
	
	
	/* MISSIONS */
	
	private static Cards ally = new Mission("Ally", "desc.", 0, "Unaligned");
	
	private static Cards armada = new Mission("Armada", "desc.", 0, "Unaligned");
	
	private static Cards colonize = new Mission("Colonize", "desc.", 0, "Unaligned");
	
	private static Cards convert = new Mission("Convert", "desc.", 0, "Unaligned");
	
	private static Cards defend = new Mission("Defend", "desc.", 0, "Unaligned");
	
	private static Cards diversify = new Mission("Diversify", "desc.", 0, "Unaligned");
	
	private static Cards dominate = new Mission("Dominate", "desc.", 0, "Unaligned");
	
	private static Cards exterminate = new Mission("Exterminate", "desc.", 0, "Unaligned");
	
	private static Cards influence = new Mission("Influence", "desc.", 0, "Unaligned");
	
	private static Cards monopolize = new Mission("Monopolize", "desc.", 0, "Unaligned");
	
	private static Cards rule = new Mission("Rule", "desc.", 0, "Unaligned");
	
	private static Cards unite = new Mission("Unite", "desc.", 0, "Unaligned");
	
	public static HashMap<String,Cards> initUnited() {
		
		//on initialise les capacités
		initAlly();
		initScrap();
		initCap();
		
		united.put("Alliance Transport", allianceTransport);
		united.put("Blob Bot",blobBot);
	  	united.put("Coalition Messenger",coalitionMessenger);
		united.put("Embassy Base",embassyBase);
		united.put("Exchange Point",exchangePoint);
		united.put("Lookout Post",lookoutPost);
		united.put("Trade Star",tradeStar);
		united.put("Union Stronghold",unionStronghold);

		united.put("Alliance Frigate",allianceFrigate);
		united.put("Alliance Landing",allianceLanding);
		united.put("Assault Pod",assaultPod);
		united.put("Coalition Fortress",coalitionFortress);
		united.put("Coalition Freighter",coalitionFreighter);
		united.put("Union Cluster",unionCluster);
		united.put("Unity Fighter",unityFighter);
		united.put("Unity Station",unityStation);

		united.put("CEO Shaner",ceoShaner);
		united.put("Chairman Haygan",chairmanHaygan);
		united.put("Chancellor Hartman",chancellorHartman);
		united.put("Commander Klik",commanderKlik);
		united.put("Commodore Zhang",commodoreZhang);
		united.put("Confessor Morris",confessorMorris);
		united.put("Hive Lord",hiveLord);
		united.put("Screecher",screecher);

		united.put("Ally",ally);
		united.put("Armada",armada);
		united.put("Colonize",colonize);
		united.put("Convert",convert);
		united.put("Defend",defend);
		united.put("Diversify",diversify);
		united.put("Dominate",dominate);
		united.put("Exterminate",exterminate);
		united.put("Influence",influence);
		united.put("Monopolize",monopolize);
		united.put("Rule",rule);
		united.put("Unite",unite);
		
		
		return united;
	}
	
	private static void initCap() {
		/* PACK UNITED */
		allianceTransport.addCapacity("TradePoint", 2);
		blobBot.addCapacity("AttackPoint", 5);
		coalitionMessenger.addCapacity("TradePoint", 2);
		/* Embassy BASE cap spé a faire */
		exchangePoint.addCapacity("AttackPoint", 2);
		lookoutPost.addCapacity("Draw", 1);
		tradeStar.addCapacity("TradePoint", 2);
		unionStronghold.addCapacity("AttackPoint", 3);
		allianceFrigate.addCapacity("AttackPoint", 4);
		allianceLanding.addCapacity("TradePoint", 2);
		assaultPod.addCapacity("AttackPoint", 3);
		coalitionFortress.addCapacity("TradePoint", 2);
		coalitionFreighter.addCapacity("TradePoint", 3);
		unionCluster.addCapacity("AttackPoint", 4);
		unityFighter.addCapacity("AttackPoint", 3);
		/* unity Station cap spé a faire */
	}
	
	private static void initAlly() {
		allianceTransport.addAlly("Authority", 4);
		blobBot.addAlly("TradePoint", 5); // seulement pour fac blob ?! comment faire
	}
	
	private static void initScrap() {
		/* PACK UNITED */
		tradeStar.addScrap("AttackPoint", 2);
	}

}
