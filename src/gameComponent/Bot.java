package gameComponent;

import java.util.HashMap;

import cardInfo.Capacity;
import cardInfo.Cards;
import cardsDetails.ColonyWars;
import cardsDetails.CoreSet;
import cardsDetails.United;

public class Bot extends Player {
	
	public static Bot initBotFromFile(String nameLine, String idLine, String lifeLine, String tradeLine, String fightLine,String cardLine ,String tableLine, String handLine, String discardLine, String penalityLine){
		Bot p = new Bot(nameLine.split(" ")[1]+nameLine.split(" ")[2]);
		HashMap<String, Cards> coreSet = CoreSet.getCards();
		HashMap<String, Cards> colonyWars = ColonyWars.getCards();
		HashMap<String, Cards> united = United.getCards();
		
		if (Integer.parseInt(idLine.split(": ")[1]) == 1) {
			p.first();
		}else if (Integer.parseInt(idLine.split(": ")[1]) == 2) {
			
		}
		p.addAuthority(Integer.parseInt(lifeLine.split(": ")[1]) - p.getLife());//On rajoute la vie que le bot a dans le fichier en oubliant celle par d�faut
		p.addTradePoint(Integer.parseInt(tradeLine.split(": ")[1]) - p.getTradePoints());
		p.addFightPoint(Integer.parseInt(fightLine.split(": ")[1]) - p.getFightPoints());
		
		//On g�re les cartes de l'utilisateur
		String[] cards = cardLine.split(": |, ");
		for (int i = 1; i < cards.length; i++) {
			if (coreSet.containsKey(cards[i])) {//On verifie dans quelle dico la carte se situe
				p.showCards().add(coreSet.get(cards[i]));
				
			}else if (colonyWars.containsKey(cards[i])) {
				p.showCards().add(colonyWars.get(cards[i]));
				
			}else if(united.containsKey(cards[i])) {
				p.showCards().add(united.get(cards[i]));
			}
		}
		String[] table = tableLine.split(": |, ");
		for (int i = 1; i < table.length; i++) {
			if (coreSet.containsKey(table[i])) {//On verifie dans quelle dico la carte se situe
				p.showTable().add(coreSet.get(table[i]));
				
			}else if (colonyWars.containsKey(table[i])) {
				p.showTable().add(colonyWars.get(table[i]));
				
			}else if(united.containsKey(table[i])) {
				p.showTable().add(united.get(table[i]));
			}
		}
		
		String[] hand = handLine.split(": |, ");
		for (int i = 1; i < hand.length; i++) {
			if (coreSet.containsKey(hand[i])) {
				p.showHand().add(coreSet.get(hand[i]));
				
			}else if (colonyWars.containsKey(hand[i])) {
				p.showHand().add(colonyWars.get(hand[i]));
				
			}else if(united.containsKey(hand[i])) {
				p.showHand().add(united.get(hand[i]));
			}
		}
		
		String[] discarding = discardLine.split(": |, ");
		for (int i = 1; i < discarding.length; i++) {
			System.out.println(hand.length);
			if (coreSet.containsKey(discarding[i])) {
				p.showDiscarding().add(coreSet.get(discarding[i]));
				
			}else if (colonyWars.containsKey(discarding[i])) {
				p.showDiscarding().add(colonyWars.get(discarding[i]));
				
			}else if(united.containsKey(discarding[i])) {
				p.showDiscarding().add(united.get(discarding[i]));
			}
			
			p.addPenalityDiscard(Integer.parseInt(penalityLine.split(": ")[1]) - p.getPenalityDiscard()); 
		}
		
		return p;
	}
	

	public Bot(String name) {
		super(name);
	}
	
	public void turn(Player p1) {
		tryPlay();
		tryBuy();
		attackPlayer(p1);
	}
	
	private void tryBuy() {//dans cette m�thode le bot ach�te en priorit� des cartes du march� ou alors des explorer si il peut
		for (int i = Market.getShownMarket().size()-1; i>=0; i--) {
			if (super.getTradePoints() > Market.getShownMarket().get(i).getCost()) {
				this.buyCard(Market.getShownMarket().get(i));
			}
		}
		
		//Si il ne peut pas il essaie d'acheter des explorer
		for (int i = Market.getExplorers().size()-1; i>=0; i--) {
			if (super.getTradePoints() > Market.getExplorers().get(i).getCost()) {
				this.buyCard(Market.getExplorers().get(i));
			}
		}
	}
	
	private void tryPlay() {//le bot essaie de jouer toutes les cartes qu'il a
		for (int i = this.showHand().size()-1; i >= 0; i--) {
			
			if (Capacity.isChoiceCard(this.showHand().get(i))) { // si le bot a une carte a choix
				System.out.println("Le bot effectue un choix sur sa carte");
				botChoiceCard(this.showHand().get(i)); // on prend le choix le plus avantageux
			}
			System.out.println("Le bot joue "+this.showHand().get(i));
			this.playCard(this.showHand().get(i)); // le bot joue la carte
		}
	}
	
	private void botChoiceCard(Cards c) {
		String number = String.valueOf(c.getCapacity().get("Choice")); // on prend la valeur de la cl� Choice
		String[] valeurs = number.split(""); // on split chaque num�ro dans un tableau
		int[] integers = new int[valeurs.length];  // on cr�� tableau de int de la longueur du tableau de str
		String posBot1 = "unknown";
		String posBot2 = "unknown";
		
		
		for (int i = 0; i < integers.length; i++){ // pour chaque case du tableau int
		    integers[i] = Integer.parseInt(valeurs[i]); // on y met la valeur du string converti en INT
		}
		
		if (integers[0] == 1) { // si premier digit = 1 alors pts Authority OU pts Trade
			posBot1 = "A"+integers[1];
			posBot2 = "T"+integers[2];
		}
		else if (integers[0] == 2) { // si premier digit =  2 alors pts Trade OU pts Attaque
			posBot1 = "T"+integers[1];
			posBot2 = "C"+integers[2];
		}
		else if (integers[0] == 3) { // si premier digit = 3 alors pts Attaque OU cap sp�
			posBot1 = "C"+integers[1];
			posBot2 = "S"+integers[2];
		}
		else if (integers[0] == 4) { // si premier digit = 4 alors pts Authoruty OU Attaque
			posBot1 = "A"+integers[1];
			posBot2 = "C"+integers[2];
		}
		
		
		if (integers[1] >= integers[2]) {
			if (posBot1.startsWith("T")) {
				this.addTradePoint(Integer.parseInt(posBot1.substring(1,posBot1.length())));
			} else if (posBot1.startsWith("A")) {
				this.addAuthority(Integer.parseInt(posBot1.substring(1,posBot1.length())));
			} else if (posBot1.startsWith("C")) {
				this.addFightPoint(Integer.parseInt(posBot1.substring(1,posBot1.length())));
			}
		
		} else {
			if (posBot2.startsWith("T")) {
				this.addTradePoint(Integer.parseInt(posBot2.substring(1,posBot2.length())));
			} else if (posBot2.startsWith("C")) {
				this.addFightPoint(Integer.parseInt(posBot2.substring(1,posBot2.length())));
			} else if (posBot2.startsWith("S")) {
				// reconnaitre la capacit� sp� appel � une autre func.
			}
		}
		
	}
	
	@Override
	public String getType() {
		return "Bot";
	}
}
