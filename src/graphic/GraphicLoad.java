package graphic;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;

public class GraphicLoad {

	public static String controller(ApplicationContext context) {
		String name = "";
		for(;;) {
			draw(context, name);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	      //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
				name = click(event,context, name);
				
			}else if (action == Action.KEY_PRESSED && event.getKey().toString() == "SPACE") {//passe le tour
				boolean state_file = verifyFile(name);
				
				if (state_file) {
					return name;
				} else {
					System.out.println("Le fichier n'existe pas.");
					context.exit(0);
				}
				
			}else  if ((action == Action.KEY_PRESSED) && event.getKey().toString() != "SPACE") {//arrete
	        	name = type(event, name);
        
	        	
	        }
		}
	}
	
	private static String click(Event event, ApplicationContext context, String name) {
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
	      return name;
	      
	}
	
	
	private static String type(Event event, String name) {
		if (Character.isLetter(event.getKey().toString().charAt(0)) && event.getKey().toString().length() == 1 ) {//On test si la le charactere est une lettre
			name += event.getKey().toString().toLowerCase();
		}
		return name;
	}
	
	private static boolean verifyFile(String name) {		
		Path path = Path.of("save/"+name+".sav");
		
		if (Files.isReadable(path)) { // si le fichier est lisible
			System.out.println("Le fichier "+name+".sav"+" existe.");
			return true;
		}
		System.out.println("Le fichier "+name+".sav"+" n'existe pas.");
		return false;
	}
	

		

	
	private static void draw(ApplicationContext context, String name) {
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
