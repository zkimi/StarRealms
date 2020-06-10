package cardInfo;

public class Hero extends AbstractCards{

	public Hero(String title, String description, int cost, String faction) {
		super(title, description, cost, faction);
	}

	public String getType(){
		return "Hero";
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
		if (! (obj instanceof Hero)) {
			return false;
		}
		return  super.equals(obj);
	}

}