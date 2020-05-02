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
import gameComponent.Player;

public class EndGame {
	public static int controller(ApplicationContext context, Player winner) {//cette méthode appelle l'écran de fin de jeu
		for(;;) {
			draw(context, winner);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	        //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
	        	return click(event, context);

			}
		}
	}
	
	private static int click(Event event, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();
        
        if (2*height/3<cooY && cooY< 2*height/3 + 105/2) {
        	if (width/4<cooX && cooX<width/4+480/2) {
        		System.out.println("Le joueur souhaite relancer une nouvelle partie");
				return 1;
			}else if(3*width/4-width/8<cooX && cooX< 3*width/4){
				System.out.println("Le joueur souhaite quitter le jeu");
				return 2;
				
			}
		}
        
		return 0;
	}
	
	private static void draw(ApplicationContext context, Player winner) {//On affiche ici le gagnant, et demande si l'utilisateur veut rejouer
    	context.renderFrame(graphics -> {
    		ScreenInfo screenInfo = context.getScreenInfo();
            float width = screenInfo.getWidth();
            float height = screenInfo.getHeight(); 
            
            // Le background
            Path path_background = Paths.get("res/misc/bg.jpg");
            try (InputStream in = Files.newInputStream(path_background)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, null, 0, 0);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing background.png ");
            }
            
    		
            //on affiche d'abord le gagnant
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/3, height/3-50, width/3, height/4));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Le gagnant est: "+winner.getName()+" voulez vous rejouer?" , width/3+100 , height/3+50);
            
            //Puis les 2 choix possible
            Path play_again = Paths.get("res/buttons/play_again.png");
            try (InputStream in = Files.newInputStream(play_again)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width/4), Math.round(2*height/3), Math.round(480/2), Math.round(105/2), null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing play_again.png ");
            }
            
            Path quit = Paths.get("res/buttons/quit.png");
            try (InputStream in = Files.newInputStream(quit)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(3*width/4-width/8), Math.round(2*height/3), Math.round(480/2), Math.round(105/2), null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing play_again.png ");
            }
            
    		
    	});    
    }
}
