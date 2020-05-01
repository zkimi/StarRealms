package gameDeroulement;

import cardInfo.Cards;

public class Bot extends Players {

	public Bot(String name) {
		super(name);
	}
	
	public void turn(Players p1) {
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
			this.playCard(this.showHand().get(i));
		}
	}
}
