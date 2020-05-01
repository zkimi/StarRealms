package cardInfo;

import java.util.HashMap;

public interface Cards{
	public String getTitle();
	public String getType();
	public int getCost();
	public int getDefense();
	public HashMap<String, Integer> getScrap();
	public HashMap<String, Integer> getAlly();
	public boolean isOutpost();
	public HashMap<String, Integer> getCapacity();
	public void addCapacity(String key, Integer intensity);
	public void addScrap(String key, Integer intensity);
	public void addAlly(String key, Integer intensity);
	public String getFaction();
}