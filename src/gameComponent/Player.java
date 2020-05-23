package gameComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import cardInfo.Capacity;
import cardInfo.Cards;
import cardsDetails.CoreSet;

public class Player {
	private String name;
	private int id;
	private int navigHand = 1;
	private int navigTable = 1;
	private int defensePoints = 50; // pts d'influence
	private int tradePoints = 0; // pts d'argent
	private int fightPoints = 0; // pts d'attaque
	private ArrayList<Cards> cards; // deck de d�part 8 scout, 2 viper (pioche)
	private ArrayList<Cards> table; // jeu pos� sur la table
	private ArrayList<Cards> hand; // main du joueur
	private ArrayList<Cards> discarding; // d�fausse du joueur
	private int penalityDiscard = 0; // penalit� d�fausse de carte

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
	
	public void navigH() {//cette methode sert � naviguer plus loin dans la main ou remettre � 1 si on atteind le bout
		if (navigHand*5 >= hand.size()) {
			navigHand =1;
		}else {
			navigHand++;
		}
	}
	
	public void navigT() {//cette methode sert � naviguer plus loin dans la table ou remettre � 1 si on atteind le bout
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
	
	
	public void distributeCards(int number, Cards c) { // fonction qui permet de donner le deck de d�part 8 scout 2 viper
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
	
	
	// Pour cette fonction d'apr�s les r�gles :
	// "La carte achet�e est directement plac�e sur la d�fausse du joueur" 
	public void buyCard(Cards c) {
		if (this.tradePoints >= c.getCost() && Market.getShownMarket().contains(c)) {
			this.tradePoints -= c.getCost(); // on retire le nombre de pi�ces au joueur afin de valider la transaction.
			discarding.add(c);
			Market.getShownMarket().remove(c); // on supprime la carte du milieu
			Market.initializeTradeCards(); // on raffraichit le commerce
		}
	}
	
	public void buyExplorer() {
		if (Market.getExplorers().size() > 0) {
			if (this.tradePoints >= 2) {
				this.tradePoints -= CoreSet.explorer.getCost(); // on retire le nombre de pi�ces au joueur afin de valider la transaction.
				discarding.add(CoreSet.explorer);
				Market.getExplorers().remove(0);
			} else {
				System.out.println("Vous n'avez pas assez de points d'argent"); // print �a en popup
			}
		} else {
			System.out.println("Il n'y a plus d'explorers en stock"); // print �a en popup
		}
	}
	
	public void endTurn() {//pour supprimer les ship en jeu � la fin du tour
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
				checkCardPowerUps(c); // si carte poss�de effets sp�ciaux
			}
			//return "Carte jou�e : OK.";
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
		
	
	
	public void shuffleCards() { // fonction qui m�lange les cartes du joueur.
		Collections.shuffle(showCards());
	}
	
	public ArrayList<Cards> pickCardsInHand(int number){
		
		int difference = cards.size() - number; // on regarde deja si on peut contenir la somme demand�e dans le deck du joueur.
		int difference_deck_defausse = cards.size()+discarding.size() - number;
		
		if (difference >= 0) { // si la diff est sup�rieur ou �gale � z�ro C OK.
			for (int i = 0; i < number; i++) {
				addCard(cards.get(0), hand);
				removeCard(cards.get(0), cards);
			}
		} else if (difference_deck_defausse >= 0) { // si la diff entre le nombre demand� et le DECK + la d�fausse est sup�rieur � z�ro 
			
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
		for (int i = 0; i < target.hand.size(); i++) {
			if (target.hand.get(i).isOutpost()) { // si le joueur poss�de un avant poste
				System.out.println("WTF");
				if(fightPoints > target.hand.get(i).getDefense()) { // si le joueur � plus de pts d'attaque que l'avant poste peut absorber
					removeCard(target.hand.get(i), target.hand); // on supprime la carte de la main du joueur puisqu'elle est morte
					fightPoints -= target.hand.get(i).getDefense(); // on enleve le nombre de points d'attaque d�bit�
				} else {
					fightPoints -= target.hand.get(i).getDefense(); // on enleve le nombre de points d'attaque � l'avant poste
				}
			}
		}// si il a pas d'avant poste, ses points d'influence sont directement touch�s.
		
		target.defensePoints -= fightPoints;
		fightPoints = 0;
		
	}
	
	public void replaceCards() {//cette m�thode remplace la pile par la defausse et m�lange la pilet
		
		for (int i = 0; i < discarding.size(); i++) {
			addCard(discarding.get(i), cards);
			removeCard(discarding.get(i), discarding);
		}
		Collections.shuffle(cards);
		
	}
	
	

	@Override
	public String toString() {
		return "Player n�" + id;
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
	
	public void addFightPoint(int x) {//Cette m�thode ajoute des points d'attaque � l'user
		fightPoints += x;
	}
	
	public void addTradePoint(int x) {//Cette m�thode ajoute des points de commerce � l'user
		tradePoints += x; 
	}
	
	public void addAuthority(int x) {//Cette m�thode ajoute des points d'authority
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
	
	public void setAuthority(int nb) {
		defensePoints = nb;
	}
	
	public void setTradePoints(int nb) {
		tradePoints = nb;
	}
	
	public void setAttackPoints(int nb) {
		fightPoints = nb;
	}
}



