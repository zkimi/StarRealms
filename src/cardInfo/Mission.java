package cardInfo;

import java.util.Objects;

public class Mission extends AbstractCards{

	public Mission(String title, String description, int cost, String faction) {
		super(title, description, cost, faction);
	}


	public String getType(){
		return "Mission";
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
		if (! (obj instanceof Mission)) {
			return false;
		}
		Mission c = (Mission) obj;		
		return  super.equals(obj);
	}

}