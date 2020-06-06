package gameComponent;
import java.util.ArrayList;

public class TeamTwo extends ArrayList<Player>{
	private final String name;
	private int life = 75;
	private int id;

	public TeamTwo(Player p1, Player p2, int id, String name) {
		super();
		this.name = name;
		this.add(p1);
		this.add(p2);
		this.id = id;
	}
	
	public void pickCardsInHand(int n) {
		for (Player p : this) {
			p.pickCardsInHand(n);
		}
	}
	
	public boolean isFirst() {
		return id == 1;
	}
	
	public void setId(int i) {
		id = i;
	}
	public int getLife() {
		return life;
	}
	
	public String getName() {
		return name;
	}
	

}
