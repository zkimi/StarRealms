package save;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import fr.umlv.zen5.ApplicationContext;
import gameMode.DeathMatch;
import gameMode.GameVsBot;
import gameMode.GameVsPlayer;
import gameMode.ManHunt;
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
					System.out.println("Sauvegarde PlayerVsPlayer");
					GameVsPlayer.initFromFile(context, lines);
					context.exit(0);
					break;
					
				case "PlayerVsBot":
					System.out.println("Sauvegarde PlayerVsBot");
					GameVsBot.initFromFile(context, lines);
					context.exit(0);
					break;
			
				case "ManHunt":
					System.out.println("Sauvegarde ManHunt");
					ManHunt.initFromFile(context, lines);
					context.exit(0);
					break;
				
				case "DeathMatch":
					System.out.println("Sauvegarde DeathMatch");
					DeathMatch.initFromFile(context, lines);
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
}