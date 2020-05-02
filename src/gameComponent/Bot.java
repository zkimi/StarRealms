package gameComponent;

import cardInfo.Capacity;
import cardInfo.Cards;

public class Bot extends Player {

	public Bot(String name) {
		super(name);
	}
	
	public void turn(Player p1) {
		tryPlay();
		tryBuy();
		attackPlayer(p1);
	}
	
	private void tryBuy() {//dans cette méthode le bot achète en priorité des cartes du marché ou alors des explorer si il peut
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
		String number = String.valueOf(c.getCapacity().get("Choice")); // on prend la valeur de la clé Choice
		String[] valeurs = number.split(""); // on split chaque numéro dans un tableau
		int[] integers = new int[valeurs.length];  // on créé tableau de int de la longueur du tableau de str
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
		else if (integers[0] == 3) { // si premier digit = 3 alors pts Attaque OU cap spé
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
				// reconnaitre la capacité spé appel à une autre func.
			}
		}
		
	}
}
