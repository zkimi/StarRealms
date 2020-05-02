package graphic;


import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import cardInfo.Cards;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import gameComponent.Market;
import gameComponent.Player;

public class ChoiceCap {
	
	/* Variables pour ecran de choix */
	private static String choice_sentence = "unknown";
	private static Color color1 = Color.WHITE;
	private static String choix1 = "unknown";
	private static Color color2 = Color.WHITE;
	private static String choix2 = "unknown";

	public static int controller(ApplicationContext context, Cards c, String choice, String possibility1, String possibility2) {
		for(;;) {
			draw(context, c, choice, possibility1, possibility2);
			
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
		
        if ( 2*height/3<cooY && cooY< (2*height/3) + height/10) {
        	if (width/4<cooX && cooX<width/4+(width/8)) { // si bouton choix 1
        		System.out.println("Le joueur choisi la première capacité");
        		
				return 1;
			}else if(3*width/4-width/8<cooX && cooX< (3*width/4-width/8)+width/8){ // sinon si bouton choix 2
				System.out.println("Le joueur choisi la deuxième capacité");
				return 2;	
			}
		}
        return 0;
	}
	
	private static void draw(ApplicationContext context, Cards c, String choice, String possibility1, String possibility2) {
    	
	   	
    	/* Interpretation du choix */    	
    	switch(choice) {
    	case "AorT":
    		choice_sentence = "Points d'influence ou Points de commerce";
    		color1 = Color.GREEN;
    		choix1 = possibility1.substring(1,possibility1.length())+" points d'influence";
    		color2 = Color.YELLOW;
    		choix2 = possibility2.substring(1,possibility2.length())+" points de commerce";
    		break;
    	case "TorC":
    		choice_sentence = "Points de commerce ou Points de combat";
    		color1 = Color.YELLOW;
    		choix1 = possibility1.substring(1,possibility1.length())+" points de commerce";
    		color2 = Color.RED;
    		choix2 = possibility2.substring(1,possibility2.length())+" points d'attaque";
    		break;
    	case "CorS":
    		choice_sentence = "Points d'attaque ou Capacité spéciale";
    		color1 = Color.RED;
    		choix1 = possibility1.substring(1,possibility1.length())+" points d'attaque";
    		color2 = Color.MAGENTA;
    		choix2 = "Capacité spéciale";
    		break;
    	case "AorC":
    		choice_sentence = "Points d'influence ou Points d'attaque";
    		color1 = Color.GREEN;
    		choix1 = possibility1.substring(1,possibility1.length())+" points d'influence";
    		color2 = Color.RED;
    		choix2 = possibility2.substring(1,possibility2.length())+" points d'attaque";
    		break;
    	default:
    		break;		
    	}
    	
    	
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
            	
            
            	if (c.getType() == "Base") { // si c'est une base
	                Path path_card = Paths.get("res/cards/"+c.getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_card)) {
	                    BufferedImage img = ImageIO.read(in);
	                    graphics.drawImage(img, Math.round(width/3), Math.round(height/3-50), Math.round(width/3), Math.round(height/3), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing"+ c.getTitle() +".png ");
	                }
            	} else if (c.getType() == "Ship") { // sinon si c'est un vaisseau
            		Path path_card = Paths.get("res/cards/"+c.getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_card)) {
	                    BufferedImage img = ImageIO.read(in);
	                    graphics.drawImage(img, Math.round(width/3+75), Math.round(height/6-50), Math.round(width/4), Math.round(height/2), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing"+ c.getTitle() +".png ");
	                }
            	}
                
                
                graphics.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
                graphics.setColor(Color.WHITE);
                graphics.drawString("Vous avez le choix entre : "+choice_sentence, width/3 , height/3+255);
                
                
                graphics.setColor(Color.GRAY);
                graphics.fill(new Rectangle2D.Float(width/4, 2*height/3, width/8, height/10));
                graphics.setColor(color1);
                graphics.drawString(choix1, width/4+25 , 2*height/3+50);
            
                graphics.setColor(Color.GRAY);
                graphics.fill(new Rectangle2D.Float(3*width/4-width/8, 2*height/3, width/8, height/10));
                graphics.setColor(color2);
                graphics.drawString(choix2, 3*width/4-width/8+25 , 2*height/3+50);
                
                
                
        		
           
    		
    	});
	}

}
