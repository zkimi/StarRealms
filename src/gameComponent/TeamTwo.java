package gameComponent;
import java.util.ArrayList;
import java.util.Objects;

public class TeamTwo extends ArrayList<Player>{
	private final String name;
	private int life = 75;
	private int id;

	public TeamTwo(Player p1, Player p2, int id, String name) {
		super();
		this.name = Objects.requireNonNull(name);
		this.add(Objects.requireNonNull(p1));
		this.add(Objects.requireNonNull(p2));
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
	
	public void attack(TeamTwo target, Player p) {
		target.life -= p.getFightPoints();
		p.addFightPoint(-1*p.getFightPoints());
	}

}
