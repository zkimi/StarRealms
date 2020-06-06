package gameComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import cardInfo.Capacity;
import cardInfo.Cards;
import cardsDetails.ColonyWars;
import cardsDetails.CoreSet;
import cardsDetails.United;

public class Player {
	private String name;
	private int id;
	private int navigHand = 1;
	private int navigTable = 1;
	private int defensePoints = 50; // pts d'influence
	private int tradePoints = 0; // pts d'argent
	private int fightPoints = 0; // pts d'attaque
	private ArrayList<Cards> cards; // deck de départ 8 scout, 2 viper (pioche)
	private ArrayList<Cards> table; // jeu posé sur la table
	private ArrayList<Cards> hand; // main du joueur
	private ArrayList<Cards> discarding; // défausse du joueur
	private int penalityDiscard = 0; // penalité défausse de carte
	
	public static Player initPlayerFromFile(String nameLine, String idLine, String lifeLine, String tradeLine, String fightLine,String cardLine ,String tableLine, String handLine, String discardLine, String penalityLine) {
		Player p = new Player(nameLine.split(" ")[1]+nameLine.split(" ")[2]);
		HashMap<String, Cards> coreSet = CoreSet.getCards();
		HashMap<String, Cards> colonyWars = ColonyWars.getCards();
		HashMap<String, Cards> united = United.getCards();

		p.id = Integer.parseInt(idLine.split(": ")[1]);  
		p.defensePoints =  Integer.parseInt(lifeLine.split(": ")[1]);
		p.tradePoints = Integer.parseInt(tradeLine.split(": ")[1]);
		p.fightPoints = Integer.parseInt(fightLine.split(": ")[1]);
		
		//On gère les cartes de l'utilisateur
		String[] cards = cardLine.split(": |, ");
		for (int i = 1; i < cards.length; i++) {
			if (coreSet.containsKey(cards[i])) {//On verifie dans quelle dico la carte se situe
				p.cards.add(coreSet.get(cards[i]));
				
			}else if (colonyWars.containsKey(cards[i])) {
				p.cards.add(colonyWars.get(cards[i]));
				
			}else if(united.containsKey(cards[i])) {
				p.cards.add(united.get(cards[i]));
			}
		}
		
		String[] table = tableLine.split(": |, ");
		for (int i = 1; i < table.length; i++) {
			if (coreSet.containsKey(table[i])) {//On verifie dans quelle dico la carte se situe
				p.table.add(coreSet.get(table[i]));
				
			}else if (colonyWars.containsKey(table[i])) {
				p.table.add(colonyWars.get(table[i]));
				
			}else if(united.containsKey(table[i])) {
				p.table.add(united.get(table[i]));
			}
		}
		
		String[] hand = handLine.split(": |, ");
		for (int i = 1; i < hand.length; i++) {
			if (coreSet.containsKey(hand[i])) {
				p.hand.add(coreSet.get(hand[i]));
				
			}else if (colonyWars.containsKey(hand[i])) {
				p.hand.add(colonyWars.get(hand[i]));
				
			}else if(united.containsKey(hand[i])) {
				p.hand.add(united.get(hand[i]));
			}
		}
		
		String[] discarding = discardLine.split(": |, ");
		for (int i = 1; i < discarding.length; i++) {
			System.out.println(hand.length);
			if (coreSet.containsKey(discarding[i])) {
				p.discarding.add(coreSet.get(discarding[i]));
				
			}else if (colonyWars.containsKey(discarding[i])) {
				p.discarding.add(colonyWars.get(discarding[i]));
				
			}else if(united.containsKey(discarding[i])) {
				p.discarding.add(united.get(discarding[i]));
			}
			
			p.penalityDiscard = Integer.parseInt(penalityLine.split(": ")[1]);
		}
		
		return p;
	}

	public Player(String name) {
		this.id = 0;
		this.name = name;
		this.defensePoints = Objects.requireNonNull(defensePoints);
		this.tradePoints = Objects.requireNonNull(tradePoints);
		this.fightPoints = Objects.requireNonNull(fightPoints);
		this.cards = new ArrayList<Cards>();
		this.table = new ArrayList<Cards>();
		this.hand = new ArrayList<Cards>();
		this.discarding = new ArrayList<Cards>();
		
	}
	
	public void navigH() {//cette methode sert à naviguer plus loin dans la main ou remettre à 1 si on atteind le bout
		if (navigHand*5 >= hand.size()) {
			navigHand =1;
		}else {
			navigHand++;
		}
	}
	
	public void navigT() {//cette methode sert à naviguer plus loin dans la table ou remettre à 1 si on atteind le bout
		if (navigTable*5 >= hand.size()) {
			navigTable =1;
		}else {
			navigTable++;
		}
	}
	
	public int getNavigHand() {
		return navigHand;
	}
	
	public int getNavigTable() {
		return navigTable;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void first(){
		id = 1;
	}
	
	public void second(){
		id = 2;
	}
	
	public void third() {
		id = 3;
	}
	
	public boolean isfirst() {
		return id == 1;
	}
	
	
	public void distributeCards(int number, Cards c) { // fonction qui permet de donner le deck de départ 8 scout 2 viper
		for (int i = 0; i<number; i++) {
			cards.add(c);
		}
	}
	
	public void addCard(Cards c, ArrayList<Cards> liste) {
		liste.add(c);
	}

	public void removeCard(Cards c, ArrayList<Cards> liste) {
		liste.remove(c);
	}
	
	public ArrayList<Cards> showCards(){
		return cards;
	}
	
	public ArrayList<Cards> showHand(){
		return hand;
	}
	
	public ArrayList<Cards> showDiscarding(){
		return discarding;
	}
	
	public ArrayList<Cards> showTable(){
		return table;
	}
	
	
	// Pour cette fonction d'après les règles :
	// "La carte achetée est directement placée sur la défausse du joueur" 
	public void buyCard(Cards c) {
		if (this.tradePoints >= c.getCost() && Market.getShownMarket().contains(c)) {
			this.tradePoints -= c.getCost(); // on retire le nombre de pièces au joueur afin de valider la transaction.
			discarding.add(c);
			Market.getShownMarket().remove(c); // on supprime la carte du milieu
			Market.initializeTradeCards(); // on raffraichit le commerce
		}
	}
	
	public void buyExplorer() {
		if (Market.getExplorers().size() > 0) {
			if (this.tradePoints >= 2) {
				this.tradePoints -= CoreSet.explorer.getCost(); // on retire le nombre de pièces au joueur afin de valider la transaction.
				discarding.add(CoreSet.explorer);
				Market.getExplorers().remove(0);
			} else {
				System.out.println("Vous n'avez pas assez de points d'argent"); // print ça en popup
			}
		} else {
			System.out.println("Il n'y a plus d'explorers en stock"); // print ça en popup
		}
	}
	
	public void endTurn() {//pour supprimer les ship en jeu à la fin du tour
		if (table.size() > 0) {
			for (int i = table.size() - 1 ; i >= 0 ; i--) {
				if (table.get(i).getType() != "Base") {
					addCard(table.get(i), discarding);
					removeCard(table.get(i), table);
				}else{//sinon on joue l'effet de la base
					checkCardPowerUps(table.get(i));
				}
			}
		} 
	}
	

	
	public void playCard(Cards c) {
		if (hand.contains(c)) {
			if (penalityDiscard > 0) {
				addCard(c, discarding);
				removeCard(c, hand);
				penalityDiscard -= 1;
			} else {
				addCard(c, table); // on l'ajoute sur la table
				removeCard(c, hand); // on la retire de la main
				checkCardPowerUps(c); // si carte possède effets spéciaux
			}
			//return "Carte jouée : OK.";
		} 
	}
	
	public void checkCardPowerUps(Cards c) {
		
		Capacity.applyCap(c.getCapacity(), this, c);
		
		if (c.getAlly().keySet().size() > 0) {
			//On regarde si il y a des cartes de la meme faction
			int count = 0;
			for (Cards c2 : table) {
				if (c.getFaction().equals(c2.getFaction())) {
					count++;
				}
			}
			if (count > 1) {
				Capacity.applyCap(c.getAlly(), this, c);
			}
		}	
	}
		
	
	
	public void shuffleCards() { // fonction qui mélange les cartes du joueur.
		Collections.shuffle(showCards());
	}
	
	public ArrayList<Cards> pickCardsInHand(int number){
		
		int difference = cards.size() - number; // on regarde deja si on peut contenir la somme demandée dans le deck du joueur.
		int difference_deck_defausse = cards.size()+discarding.size() - number;
		
		if (difference >= 0) { // si la diff est supérieur ou égale à zéro C OK.
			for (int i = 0; i < number; i++) {
				addCard(cards.get(0), hand);
				removeCard(cards.get(0), cards);
			}
		} else if (difference_deck_defausse >= 0) { // si la diff entre le nombre demandé et le DECK + la défausse est supérieur à zéro 
			
			int temp = number-cards.size();
			
			for (int i = 0; i < cards.size(); i++) {
				addCard(cards.get(0), hand);
				removeCard(cards.get(0), cards);
			}
			
			for (int i = 0; i < temp; i++) {
				addCard(discarding.get(0), hand);
				removeCard(discarding.get(0), discarding);
			}
			
		} 
		
		return hand;
	}
	
	
	public ArrayList<Cards> getHand(){
		return hand;
	}

	public int getDefensePoints() {
		return defensePoints;
	}
	
	public int getTradePoints() {
		return tradePoints;
	}
	
	public int getFightPoints() {
		return fightPoints;
	}
	
	public int getPenalityDiscard() {
		return penalityDiscard;
	}
	
	
	public void attackPlayer(Player target) {		
		
		boolean gotOutpost = false;
		
		for (int i = 0; i < target.table.size(); i++) { // inspection de toutes les cartes
			if (target.table.get(i).isOutpost()) { 
				gotOutpost = true;
				if(fightPoints >= target.table.get(i).getDefense()) { // si le joueur à plus de pts d'attaque que l'avant poste peut absorber
					fightPoints -= target.table.get(i).getDefense(); // on enleve le nombre de points d'attaque débité
					removeCard(target.table.get(i), target.table); // on supprime la carte de la main du joueur puisqu'elle est morte
				} else {
					fightPoints = 0; // il a perdu ses points
				}
			}
		}
		
		if (gotOutpost == false) { // si aucun avant poste
			target.defensePoints -= fightPoints;
			fightPoints = 0;
		}
		
	}
	
	public void destroyBase(Player target, Cards base) {
		if (this.fightPoints >= base.getDefense()) {
			this.fightPoints -= base.getDefense(); // on enleve les pts utilisés
			removeCard(base, target.table); // on supprime la base qui est détruite
		} else {
			this.fightPoints = 0; // sinon il a perdu ses points LOL
		}
	}
	
	public void replaceCards() {//cette méthode remplace la pile par la defausse et mélange la pile
		
		for (int i = 0; i < discarding.size(); i++) {
			addCard(discarding.get(i), cards);
			removeCard(discarding.get(i), discarding);
		}
		Collections.shuffle(cards);
		
	}
	
	public boolean opponentGotOutpost(Player opponent) {
		for (int i = 0; i < opponent.table.size(); i++) { // inspection de toutes les cartes
			if (opponent.table.get(i).isOutpost()) { 
				return true;
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Player n°" + id;
	}
	
	public int getLife(){
		return defensePoints;
	}
	
	public int getFight(){
		return defensePoints;
	}
	
	public void delCard(Cards c) {
		table.remove(c);
	}
	
	public ArrayList<Cards> getTable() {
		return table;
	}
	
	public void useScrap(Cards c) {
		Capacity.applyCap(c.getScrap(), this, c);
	}
	
	public void addFightPoint(int x) {//Cette méthode ajoute des points d'attaque à l'user
		fightPoints += x;
	}
	
	public void addTradePoint(int x) {//Cette méthode ajoute des points de commerce à l'user
		tradePoints += x; 
	}
	
	public void addAuthority(int x) {//Cette méthode ajoute des points d'authority
		defensePoints += x;
	}
	
	public void addPenalityDiscard(int x) {
		penalityDiscard += x;
	}
	
	public String getType() {
		return "Player";
	}
	
	public int getId() {
		return id;
	}
	
	public String cardsToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : cards) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	
	public String tableToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : table) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	
	public String handToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : hand) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	
	public String discardToString() {
		StringBuilder s = new StringBuilder();
		for (Cards c : discarding) {
			s.append(c.getTitle()+", ");
		}
		return s.toString();
	}
	

}



