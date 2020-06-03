package cardInfo;

public class Scenario extends AbstractCards{

	public Scenario(String title, String description, int cost, String faction) {
		super(title, description, cost, faction);
	}


	public String getType(){
		return "Scenario";
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
		if (! (obj instanceof Scenario)) {
			return false;
		}
		Scenario c = (Scenario) obj;		
		return  super.equals(obj);
	}
}
