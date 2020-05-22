package save;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import gameComponent.Market;
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
					s.append("Mode: PlayerVsBot\n");
				}else{
					s.append("Mode: PlayerVsPlayer\n");
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
				
				//On finit par le market
				s.append("Explorer: "+Market.explorerToString()+"\n");
				s.append("Market: "+Market.marketToString()+"\n");
				s.append("Shown: "+Market.showMarketToString()+"\n");
				
				writer.write(s.toString());
				writer.flush();
			}
		}
	}
	
	public static void manHuntSave(ApplicationContext  context, ArrayList<Player> playerList, int turn) throws IOException{
		String name = graphicSave.controller(context);
		if (name.length()==0) {
			context.exit(0);
		}else {

			Path p = Path.of("save/"+name+".sav");
			Charset charset = StandardCharsets.UTF_8;
			try(BufferedWriter writer = Files.newBufferedWriter(p, charset)){				
				StringBuilder s = new StringBuilder();
				
				s.append("Mode: ManHunt\n");
				s.append("Turn: "+Integer.toString(turn)+"\n");
				
				for (Player player : playerList) {
					s.append(player.getType()+" "+player.getName()+"\n");
					s.append("Id: "+player.getId()+"\n");
					s.append("Life: "+player.getDefensePoints()+"\n");
					s.append("Money: "+player.getTradePoints()+"\n");
					s.append("Damage: "+player.getTradePoints()+"\n");
					s.append("Cards: "+player.cardsToString()+"\n");
					s.append("Table: "+player.tableToString()+"\n");
					s.append("Hand: "+player.handToString()+"\n");
					s.append("Discarding: "+player.discardToString()+"\n");
				}

				
				
				
				//On finit par le market
				s.append("Explorer: "+Market.explorerToString()+"\n");
				s.append("Market: "+Market.marketToString()+"\n");
				s.append("Shown: "+Market.showMarketToString()+"\n");
				
				writer.write(s.toString());
				writer.flush();
			}
		}
	}
	
	public static void manDeathMatch(ApplicationContext  context, ArrayList<Player> playerList, int turn) throws IOException{
		String name = graphicSave.controller(context);
		if (name.length()==0) {
			context.exit(0);
		}else {

			Path p = Path.of("save/"+name+".sav");
			Charset charset = StandardCharsets.UTF_8;
			try(BufferedWriter writer = Files.newBufferedWriter(p, charset)){				
				StringBuilder s = new StringBuilder();
				
				s.append("Mode: DeathMatch\n");
				s.append("Turn: "+Integer.toString(turn)+"\n");
				
				for (Player player : playerList) {
					s.append(player.getType()+" "+player.getName()+"\n");
					s.append("Id: "+player.getId()+"\n");
					s.append("Life: "+player.getDefensePoints()+"\n");
					s.append("Money: "+player.getTradePoints()+"\n");
					s.append("Damage: "+player.getTradePoints()+"\n");
					s.append("Cards: "+player.cardsToString()+"\n");
					s.append("Table: "+player.tableToString()+"\n");
					s.append("Hand: "+player.handToString()+"\n");
					s.append("Discarding: "+player.discardToString()+"\n");
				}

				
				
				
				//On finit par le market
				s.append("Explorer: "+Market.explorerToString()+"\n");
				s.append("Market: "+Market.marketToString()+"\n");
				s.append("Shown: "+Market.showMarketToString()+"\n");
				
				writer.write(s.toString());
				writer.flush();
			}
		}
	}
	
}
