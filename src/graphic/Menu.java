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

public class Menu {
	public static int controller(ApplicationContext context) {
		for(;;) {
			draw(context);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	      //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
	        	return click(event, context);

			} else  if ((action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) && event.getKey().toString() != "SPACE") {//arrete
	        	System.out.println(event.getKey().toString());
	        	context.exit(0);
	        	return 0;
        
	        	
	        }
		}
	}
	
	
	private static int click(Event event, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();
        
        if ( 2*height/4<cooY && cooY< (2*height/4) + height/10) {
        	if (width/4<cooX && cooX<width/4+(width/8)) {
				return 2;
			}else if(3*width/4-width/8<cooX && cooX< (3*width/4-width/8)+width/8){
				return 1;
				
			}
		}else if (( 3*height/4<cooY && cooY< (3*height/4) + height/10)) {
			if (width/4<cooX && cooX<width/4+(width/8)) {
				return 3;
			}else if(3*width/4-width/8<cooX && cooX< (3*width/4-width/8)+width/8){
				return 4;
				
			}
		}
		return 0;
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
               
            
            Path logo = Paths.get("res/misc/logo.png");
            try (InputStream in = Files.newInputStream(logo)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width/3), Math.round(height/4-50), Math.round(width/3), Math.round(height/4), null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing logo.png ");
            }
            
            //On affiche les choix possibles
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, 2*height/4, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("2 joueurs avec IA" , width/4+50 , 2*height/4+50);
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(3*width/4-width/8, 2*height/4, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("2 joueurs sans IA" , 3*width/4-width/8+50 , 2*height/4+50);
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, 3*height/4, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Combat à mort" , width/4+50 , 3*height/4+50);
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(3*width/4-width/8, 3*height/4, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Chasse à l'homme" , 3*width/4-width/8+50 , 3*height/4+50);
            
           
    		
    	});
	}
}
