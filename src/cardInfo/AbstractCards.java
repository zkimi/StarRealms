package cardInfo;

import java.util.HashMap;
import java.util.Objects;

public abstract class AbstractCards implements Cards{
	private final String title;
	private final String description;
	private final int cost;
	private final String faction;
	private final HashMap<String, Integer> capacity = new HashMap<String, Integer>();
	private final HashMap<String, Integer> scrap = new HashMap<String, Integer>();
	private HashMap<String, Integer> ally = new HashMap<String, Integer>();

	public AbstractCards(String title, String description, int cost, String faction) {
		this.title = Objects.requireNonNull(title);
		this.description = Objects.requireNonNull(description);
		this.cost = Objects.requireNonNull(cost);
		this.faction = Objects.requireNonNull(faction);
	}
	
	public String getTitle() {
		return title;
	}

	public int getCost() { // getter pour la fonction buyCards
		return cost;
	}
	
	
	public HashMap<String, Integer> getScrap() { // getter pour la valeur Scrap.
		return scrap;
	}
	
	public HashMap<String, Integer> getAlly() { // getter pour la valeur Scrap.
		return ally;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title, description, cost, faction, scrap, ally);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof AbstractCards)) {
			return false;
		}
		AbstractCards c = (AbstractCards) obj;		
		return title.equals(c.title) && description.equals(c.description) && cost == c.cost && faction.equals(c.faction) && capacity == c.capacity && scrap ==c.scrap && ally == c.ally && super.equals(obj);
	}

	@Override
	public String toString() {
		return "\"" + title + "\" / Cout : " + cost + "pts (" + faction + ")";
	}
	
	public void addCapacity(String key, Integer intensity) {//Methode permettant d'ajouter des capacité à la carte
		capacity.put(key, intensity);
	}
	
	public void addScrap(String key, Integer intensity) {//Methode permettant d'ajouter des capacité scrap à la carte
		scrap.put(key, intensity);
	}
	
	public void addAlly(String key, Integer intensity) {//Methode permettant d'ajouter des capacité ally à la carte
		ally.put(key, intensity);
	}
	
	public HashMap<String, Integer> getCapacity(){
		return capacity;
	}
	
	public String getFaction() {
		return faction;
	}

}