package cardInfo;

public class Ship extends AbstractCards{

	public Ship(String title, String description, int cost, String faction) {
		super(title, description, cost, faction);
	}

	public String getType(){
		return "Ship";
	}
	
	public boolean isOutpost() {
		return false;
	}
	
	public int getDefense() {
		return 0;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Ship)) {
			return false;
		}
		return  super.equals(obj);
	}

}