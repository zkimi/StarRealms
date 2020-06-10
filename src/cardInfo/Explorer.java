package cardInfo;

public class Explorer extends AbstractCards{
	
	public Explorer(String title, String description, int cost, String faction, int specialSkill) {
		super(title, description, cost, faction);
	}

	public String getType(){
		return "Explorer";
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
		if (! (obj instanceof Explorer)) {
			return false;
		}
		return super.equals(obj);
	}

	
}
