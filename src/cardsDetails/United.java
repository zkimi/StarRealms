package cardsDetails;

import cardInfo.Base;
import cardInfo.Cards;
import cardInfo.Hero;
import cardInfo.Mission;
import cardInfo.Ship;

public class United {
	
	/* ASSAULT */
	
	public static Cards allianceTransport = new Ship("Alliance Transport", "Gain 2 trade.", 2, "Star Empire/Trade Federation");

	public static Cards blobBot = new Ship("Blob Bot", "Gain 5 Combat, Gain 2 trade.", 3, "Blob/Machine Cult");

	public static Cards coalitionMessenger = new Ship("Coalition Messenger", "desc.", 3, "Machine Cult/Trade Federation");

	public static Cards embassyBase = new Base(false, 6, "Embassy Base", "desc", 8, "Star Empire/Trade Federation");

	public static Cards exchangePoint = new Base(false, 7, "Exchange Point", "desc", 6, "Blob/Machine Cult");

	public static Cards lookoutPost = new Base(true, 6, "Lookout Post", "desc", 7, "Machine Cult/Trade Federation");
	
	public static Cards tradeStar = new Ship("Trade Star", "desc.", 1, "Blob/Star Empire");

	public static Cards unionStronghold = new Base(false, 5, "Union Stronghold", "desc", 5, "Blob/Star Empire");
	
	
	/* COMMAND */
	
	public static Cards allianceFrigate = new Ship("Alliance Frigate", "desc.", 3, "Star Empire/Trade Federation");

	public static Cards allianceLanding = new Base(true, 5, "Alliance Landing", "desc", 5, "Star Empire/Trade Federation");
	
	public static Cards assaultPod = new Ship("Assault Pod", "desc.", 2, "Blob/Star Empire");
	
	public static Cards coalitionFortress = new Base(true, 6, "Coalition Fortress", "desc", 6, "Trade Federation/Machine Cult");
	
	public static Cards coalitionFreighter = new Ship("Coalition Freighter", "desc.", 4, "Trade Federation/Machine Cult");
	
	public static Cards unionCluster = new Base(false, 8, "Union Cluster", "desc", 8, "Blob/Star Empire");
	
	public static Cards unityFighter = new Ship("Unity Fighter", "desc.", 1, "Blob/Machine Cult");
	
	public static Cards unityStation = new Base(true, 6, "Unity Station", "desc", 7, "Blob/Machine Cult");
	
	
	/* HEROES */
	
	public static Cards ceoShaner = new Hero("CEO Shaner", "desc.", 5, "Unaligned");
	
	public static Cards chairmanHaygan = new Hero("Chairman Haygan", "desc.", 3, "Unaligned");
	
	public static Cards chancellorHartman = new Hero("Chancellor Hartman", "desc.", 4, "Unaligned");
	
	public static Cards commanderKlik = new Hero("Commander Klik", "desc.", 4, "Unaligned");
	
	public static Cards commodoreZhang = new Hero("Commodore Zhang", "desc.", 5, "Unaligned");
	
	public static Cards confessorMorris = new Hero("Confessor Morris", "desc.", 5, "Unaligned");
	
	public static Cards hiveLord = new Hero("Hive Lord", "desc.", 5, "Unaligned");
	
	public static Cards screecher = new Hero("Screecher", "desc.", 3, "Unaligned");
	
	
	/* MISSIONS */
	
	public static Cards ally = new Mission("Ally", "desc.", 0, "Unaligned");
	
	public static Cards armada = new Mission("Armada", "desc.", 0, "Unaligned");
	
	public static Cards colonize = new Mission("Colonize", "desc.", 0, "Unaligned");
	
	public static Cards convert = new Mission("Convert", "desc.", 0, "Unaligned");
	
	public static Cards defend = new Mission("Defend", "desc.", 0, "Unaligned");
	
	public static Cards diversify = new Mission("Diversify", "desc.", 0, "Unaligned");
	
	public static Cards dominate = new Mission("Dominate", "desc.", 0, "Unaligned");
	
	public static Cards exterminate = new Mission("Exterminate", "desc.", 0, "Unaligned");
	
	public static Cards influence = new Mission("Influence", "desc.", 0, "Unaligned");
	
	public static Cards monopolize = new Mission("Monopolize", "desc.", 0, "Unaligned");
	
	public static Cards rule = new Mission("Rule", "desc.", 0, "Unaligned");
	
	public static Cards unite = new Mission("Unite", "desc.", 0, "Unaligned");

}