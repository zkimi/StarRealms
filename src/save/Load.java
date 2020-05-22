package save;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import fr.umlv.zen5.ApplicationContext;
import graphic.GraphicLoad;

public class Load {
	public static void load(ApplicationContext context) {
		String name = GraphicLoad.controller(context);
		Path p = Path.of("save/"+name+".sav");
		
		List<String> lines;
		try {
			lines = Files.readAllLines(p, StandardCharsets.UTF_8);
			System.out.println(lines.get(0));
			
			String gameMode = lines.get(0).split(": ")[1];
			System.out.println(gameMode);
			
			if (gameMode.equals("PlayerVsPlayer")) {
				System.out.println("Sauvegarde PlayerVsPlayer");
				context.exit(0);
				
			}else if(gameMode.equals("PlayerBot")) {
				System.out.println("Sauvegarde PlayerVsBot");
				context.exit(0);
				
			}else if(gameMode.equals("ManHunt")) {
				System.out.println("Sauvegarde ManHunt");
				context.exit(0);
				
			}else if(gameMode.equals("DeathMatch")) {
				System.out.println("Sauvegarde DeathMatch");
				context.exit(0);
			}else{
				System.out.println("Sauvegarde corrompue");
				context.exit(0);
			}
				
			
		} catch (IOException e) {	
			e.printStackTrace();
		}

	}
}
