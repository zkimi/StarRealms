package save;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import gameComponent.Player;

public class graphicLoad {
	private static String name = "";
	
	public static int controller(ApplicationContext context, String name) {
		for(;;) {
			draw(context);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	      //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
				click(event,context);
				
			}else if (action == Action.KEY_PRESSED && event.getKey().toString() == "SPACE") {//passe le tour
				boolean state_file = verifyFile();
				
				if (state_file) {
					try {
						decryptSave();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					// print msg d'erreur
				}
				
			}else  if ((action == Action.KEY_PRESSED) && event.getKey().toString() != "SPACE") {//arrete
	        	type(event);
        
	        	
	        }
		}
	}
	
	private static void click(Event event, ApplicationContext context) {
		  ScreenInfo screenInfo = context.getScreenInfo();
	      float width = screenInfo.getWidth();
	      float height = screenInfo.getHeight(); 
	      double cooX = event.getLocation().getX();
	      double cooY = event.getLocation().getY(); 
	      
	      if (2*height/3+200<cooY && cooY< (2*height/3+200) + height/10) {
	        	if (width/4<cooX && cooX<width/4+(width/2)) {
	        		name="";
					System.out.println("Je reset");
	        	}
		   }
	      
	}
	
	
	private static void type(Event event) {
		if (Character.isLetter(event.getKey().toString().charAt(0)) && event.getKey().toString().length() == 1 ) {//On test si la le charactere est une lettre
			name += event.getKey().toString().toLowerCase();
		}
	}
	
	private static boolean verifyFile() {		
		Path path = Path.of("saves/"+name+".txt");
		
		if (Files.isReadable(path)) { // si le fichier est lisible
			System.out.println("Le fichier "+name+".txt"+" existe.");
			return true;
		}
		System.out.println("Le fichier "+name+".txt"+" n'existe pas.");
		return false;
	}
	
	private static void decryptSave() throws IOException{
		Path path = Path.of("saves/"+name+".txt");

		try (BufferedReader reader = Files.newBufferedReader(path,Charset.forName("ISO-8859-1"))){
			String line;
			System.out.println("Lecture de la sauvegarde "+name);

			for (int i = 1; (line=reader.readLine()) != null; i++) {
				System.out.println(line);
			}
		}
	}
		

	
	private static void draw(ApplicationContext context) {
    	context.renderFrame(graphics -> {
    		ScreenInfo screenInfo = context.getScreenInfo();
            float width = screenInfo.getWidth();
            float height = screenInfo.getHeight(); 
            
            
            
    		Path path_background = Paths.get("res/misc/bg.jpg");
            try (InputStream in = Files.newInputStream(path_background)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, null, 0, 0);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing background.png ");
            }
            
            
               
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, height/3, width/2, height/10));
            graphics.setColor(Color.yellow);
            graphics.drawString("Entrez le nom de votre sauvegarde (seuls les minuscules sont acceptées)", width/4 , height/3+50);
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, 2*height/3, width/2, height/10));
            graphics.setColor(Color.yellow);
            graphics.drawString(name, width/2-50 , 2*height/3+50);
            
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, 2*height/3+200, width/2, height/10));
            graphics.setColor(Color.yellow);
            graphics.drawString("Effacer le nom du fichier", width/2-50 , 2*height/3+250);
           
    		
    	});
	}
}
