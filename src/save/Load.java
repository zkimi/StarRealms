package save;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import fr.umlv.zen5.ApplicationContext;
import gameComponent.Player;
import graphic.GraphicLoad;

public class Load {
	public static void load(ApplicationContext context) {
		String name = GraphicLoad.controller(context);
		Path p = Path.of("save/"+name+".sav");
		
		List<String> lines;
		try {
			lines = Files.readAllLines(p, StandardCharsets.UTF_8);
			System.out.println(lines.get(0));
			
			String gameMode = lines.get(0).split(": ")[1].replaceAll("\\s+","");
			System.out.println(gameMode);
			
			switch (gameMode) {
				case "PlayerVsPlayer":
					decryptSave(lines, "PVP");
					System.out.println("Sauvegarde PlayerVsPlayer");
					context.exit(0);
					break;
					
				case "PlayerBot":
					System.out.println("Sauvegarde PlayerVsBot");
					context.exit(0);
					break;
			
				case "ManHunt":
					System.out.println("Sauvegarde ManHunt");
					context.exit(0);
					break;
				
				case "DeathMatch":
					System.out.println("Sauvegarde DeathMatch");
					context.exit(0);
					break;
					

				default:
					System.out.println("Sauvegarde corrompue");
					context.exit(0);
					break;
			}
			
			
		} catch (IOException e) {	
			e.printStackTrace();
		}

	}
	
	public static void decryptSave(List<String> lines, String mode) {
		
		// detection joueur 1
		if (lines.get(1).startsWith("Player") && mode.equals("PVP")) {
			
			Player p1 = new Player(lines.get(1).split("Player")[1]);
			p1.setAuthority(Integer.parseInt(lines.get(3).split(":")[1].trim())); // restauration de l'influence
			p1.setTradePoints(Integer.parseInt(lines.get(4).split(":")[1].trim()));
			p1.setAttackPoints(Integer.parseInt(lines.get(5).split(":")[1].trim()));
			
			/* ARRAYLIST CARDS P1 */
			
			String[] cards1 = lines.get(6).split(":")[1].split(",");
	 
	        for(int i = 0; i < cards1.length ;i++)
	        {
	        	if (!cards1[i].isBlank()) {
	        		// on ajoute la carte avec son ID au joueur dans ses cartes.
	        		System.out.println(cards1[i].trim());
	        	}
	        }
	        
	        /* ARRAYLIST TABLE P1 */
	        
	        String[] table1 = lines.get(7).split(":")[1].split(",");
	        
	        for(int i = 0; i < table1.length ;i++)
	        {
	        	if (!table1[i].isBlank()) {
	        		// on ajoute la carte avec son ID au joueur à la table.
	        		System.out.println(table1[i].trim());
	        	}
	        }
	        
	        /* ARRAYLIST HAND P1 */
	        
	        String[] hand1 = lines.get(8).split(":")[1].split(",");
	        
	        for(int i = 0; i < hand1.length ;i++)
	        {
	        	if (!hand1[i].isBlank()) {
	        		// on ajoute la carte avec son ID au joueur à la main.
	        		System.out.println(hand1[i].trim());
	        	}
	        }
	        
	        /* ARRAYLIST DISCARDING P1 */
	        
	        String[] discarding1 = lines.get(9).split(":")[1].split(",");
	        
	        for(int i = 0; i < discarding1.length ;i++)
	        {
	        	if (!discarding1[i].isBlank()) {
	        		// on ajoute la carte avec son ID au joueur à la défausse.
	        		System.out.println(discarding1[i].trim());
	        	}
	        }
	        
	        /* ON CHECK SI LA SAUVEGARDE NEST PAS CORROMPUE OU PARTIELLE */
	        
	        if (lines.get(10).startsWith("Player")) {
		        System.out.println("On s'occupe du deuxième joueur");
		        
		        Player p2 = new Player(lines.get(10).split("Player")[1]);
				p2.setAuthority(Integer.parseInt(lines.get(12).split(":")[1].trim())); // restauration de l'influence
				p2.setTradePoints(Integer.parseInt(lines.get(13).split(":")[1].trim()));
				p2.setAttackPoints(Integer.parseInt(lines.get(14).split(":")[1].trim()));
				
				/* ARRAYLIST CARDS P2 */
				
				String[] cards2 = lines.get(15).split(":")[1].split(",");
		 
		        for(int i = 0; i < cards2.length ;i++)
		        {
		        	if (!cards2[i].isBlank()) {
		        		// on ajoute la carte avec son ID au joueur dans ses cartes.
		        		System.out.println(cards2[i].trim());
		        	}
		        }
		        
		        /* ARRAYLIST TABLE P2 */
		        
		        String[] table2 = lines.get(16).split(":")[1].split(",");
		        
		        for(int i = 0; i < table2.length ;i++)
		        {
		        	if (!table2[i].isBlank()) {
		        		// on ajoute la carte avec son ID au joueur à la table.
		        		System.out.println(table2[i].trim());
		        	}
		        }
		        
		        /* ARRAYLIST HAND P2 */
		        
		        String[] hand2 = lines.get(17).split(":")[1].split(",");
		        
		        for(int i = 0; i < hand2.length ;i++)
		        {
		        	if (!hand2[i].isBlank()) {
		        		// on ajoute la carte avec son ID au joueur à la main.
		        		System.out.println(hand2[i].trim());
		        	}
		        }
		        
		        /* ARRAYLIST DISCARDING P2 */
		        
		        String[] discarding2 = lines.get(18).split(":")[1].split(",");
		        
		        for(int i = 0; i < discarding2.length ;i++)
		        {
		        	if (!discarding2[i].isBlank()) {
		        		// on ajoute la carte avec son ID au joueur à la défausse.
		        		System.out.println(discarding2[i].trim());
		        	}
		        }
		        
		        
		        /* INITIALISER EXPLORERS */ 
		        
		        String[] explorers = lines.get(19).split(":")[1].split(",");
		        for(int i = 0; i < explorers.length ;i++)
		        {
		        	if (!explorers[i].isBlank()) {
		        		// on ajoute les explorers restants a la pile
		        		System.out.println(explorers[i].trim());
		        	}
		        }
		        
		        String[] market = lines.get(20).split(":")[1].split(",");
		        for(int i = 0; i < market.length ;i++)
		        {
		        	if (!market[i].isBlank()) {
		        		// on ajoute a la pile marché
		        		System.out.println(market[i].trim());
		        	}
		        }
		        
		        String[] shown = lines.get(21).split(":")[1].split(",");
		        for(int i = 0; i < shown.length ;i++)
		        {
		        	if (!shown[i].isBlank()) {
		        		// on ajoute aux cartes commerces affichées
		        		System.out.println(shown[i].trim());
		        	}
		        }
		        
		    } 
	        
			
		}
		
		
	}
}
