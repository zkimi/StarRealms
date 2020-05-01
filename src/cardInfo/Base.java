package cardInfo;

import java.util.Objects;

public class Base extends AbstractCards{
	boolean outpost;
	int defense;

	public Base(boolean outpost, int defense, String title, String description, int cost, String faction){
		super(title, description, cost, faction);
		this.outpost = outpost;
		this.defense = Objects.requireNonNull(defense);
	}

	public String getType(){
		return "Base";
	}


	@Override
	public String toString() {
		return super.toString() + " " + (outpost ? "Outpost " : "") + " Defense: " + defense ;
	}

	public boolean isOutpost(){
		return outpost;
	}
	
	public int getDefense() {
		return defense;
	}

	public void getHit(int damage){//cette fonction retire le nombre de point de vie à la carte
		return;
	}


	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(outpost, defense);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Base)) {
			return false;
		}
		Base c = (Base) obj;		
		return outpost == c.outpost && defense == c.defense && super.equals(obj);
	}

}