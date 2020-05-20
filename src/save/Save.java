package save;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import fr.umlv.zen5.ApplicationContext;
import gameComponent.Player;
import graphic.graphicSave;

public class Save {
	public static void gameVsPlayerSave(ApplicationContext  context, Player p1, Player p2) throws IOException {
		String name = graphicSave.controller(context);
		if (name.length()==0) {
			context.exit(0);
		}else {

			Path p = Path.of("save/"+name+".sav");
			Charset charset = StandardCharsets.UTF_8;
			try(BufferedWriter writer = Files.newBufferedWriter(p, charset)){				
				StringBuilder s = new StringBuilder();
				
				if (p1.getType() == "Bot" || p2.getType() == "Bot") {//On regarde si on est en pvp ou pvbot
					s.append("Mode: PlayerVsBot \n");
				}else{
					s.append("Mode: PlayerVsPlayer \n");
				}
				
				//on écrit ensuite les utilisateurs
				s.append(p1.getType()+" "+p1.getName()+"\n");
				s.append("Id: "+p1.getId()+"\n");
				s.append("Life: "+p1.getDefensePoints()+"\n");
				s.append("Money: "+p1.getTradePoints()+"\n");
				s.append("Damage: "+p1.getTradePoints()+"\n");
				s.append("Cards: "+p1.cardsToString()+"\n");
				s.append("Table: "+p1.tableToString()+"\n");
				s.append("Hand: "+p1.handToString()+"\n");
				s.append("Discarding: "+p1.discardToString()+"\n");
				
				s.append(p2.getType()+" "+p2.getName()+"\n");
				s.append("Id: "+p2.getId()+"\n");
				s.append("Life: "+p2.getDefensePoints()+"\n");
				s.append("Money: "+p2.getTradePoints()+"\n");
				s.append("Damage: "+p2.getTradePoints()+"\n");
				s.append("Cards: "+p2.cardsToString()+"\n");
				s.append("Table: "+p2.tableToString()+"\n");
				s.append("Hand: "+p2.handToString()+"\n");
				s.append("Discarding: "+p2.discardToString()+"\n");
				
				writer.write(s.toString());
				writer.flush();
			}
		}
	}
}
