package cardInfo;

public class Gambit extends AbstractCards {

	public Gambit(String title, String description, int cost, String faction) {
		super(title, description, cost, faction);
	}


	public String getType(){
		return "Gambit";
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
		if (! (obj instanceof Gambit)) {
			return false;
		}
		Gambit c = (Gambit) obj;		
		return  super.equals(obj);
	}
}
