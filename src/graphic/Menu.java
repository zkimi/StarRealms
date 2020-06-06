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
        	if (width/4<cooX && cooX<width/4+(360)) {
				return 2;
			}else if(3*width/4-360<cooX && cooX< (3*width/4-360)+360){
				return 1;
				
			}
		}else if (( 3*height/4<cooY && cooY< (3*height/4) + height/10)) {
			if (width/4<cooX && cooX<width/4+(360)) {
				return 3;
			}else if(3*width/4-360<cooX && cooX< (3*width/4-360)+360){
				return 4;
				
			}
		}
        
        if (0< cooY && cooY<110) {
			if (0<cooX && cooX <360) {
				return 5;
			}
			else if(width - 360 < cooX && cooX < width) {
				return 6;
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
            Path oneVsBOT = Paths.get("res/buttons/1vsBOT.png");
            try (InputStream in = Files.newInputStream(oneVsBOT)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width/4), Math.round(2*height/4), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing 1vsBOT.png ");
            }

            Path oneVsOne = Paths.get("res/buttons/1v1.png");
            try (InputStream in = Files.newInputStream(oneVsOne)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(3*width/4-360), Math.round(2*height/4), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing 1v1.png ");
            }
            
            Path deathMatch = Paths.get("res/buttons/deathMatch.png");
            try (InputStream in = Files.newInputStream(deathMatch)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width/4), Math.round(3*height/4), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing deathMatch.png ");
            }
            
            Path manHunt = Paths.get("res/buttons/manHunt.png");
            try (InputStream in = Files.newInputStream(manHunt)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(3*width/4-360), Math.round(3*height/4), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing manHunt.png ");
            }
            
            Path save = Paths.get("res/buttons/chargeSave.png");
            try (InputStream in = Files.newInputStream(save)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(0), Math.round(0), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing chargeSave.png ");
            }
            
            Path hydre = Paths.get("res/buttons/hydre.png");
            try (InputStream in = Files.newInputStream(hydre)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width-360), Math.round(0), 360, 110, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing hydre.png ");
            }
            
    		
    	});
	}
}
