package graphic;


import cardInfo.Cards;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import gameDeroulement.Market;
import gameDeroulement.Players;

public class GameController {
	
	public static void window(Players p1, Players p2, ApplicationContext context) {
			for(;;) {
				
				GameView area = new GameView();
			    area.draw(context, p1, p2);
		        Event event = context.pollOrWaitEvent(10);
		        if (event == null) {  // no event
		        	continue;
		        }
		        Action action = event.getAction();
		        
		        
		        
		        //ON GERE LES CLICS
		        if (action == Action.POINTER_DOWN) {
					EventClick.getClickEvent(event, context, p1, p2);
					if (p2.getLife() <= 0) {//Si l'utilisateur a battu l'adversaire, il est inutile de continuer le tour
						return;
					}
					
				}else if (action == Action.KEY_PRESSED && event.getKey().toString() == "SPACE") {//passe le tour
					
					
					return;
					
				}else  if ((action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) && event.getKey().toString() != "SPACE") {//arrete
		        	System.out.println(event.getKey().toString());
		        	context.exit(0);
		        	return;
	        
		        	
		        }
			}
	}
	
	public static int windowEnd(ApplicationContext context, Players winner) {//cette méthode appelle l'écran de fin de jeu
		for(;;) {
			GameView area = new GameView();
			area.drawEnd(context, winner);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	        //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
	        	return EventClick.getClickEventEnd(event, context);

			}
		}
	}
	
	public static int menu(ApplicationContext context) {
		for(;;) {
			GameView area = new GameView();
			area.drawMenu(context);
			
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	      //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
	        	return EventClick.menu(event, context);

			} else  if ((action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) && event.getKey().toString() != "SPACE") {//arrete
	        	System.out.println(event.getKey().toString());
	        	context.exit(0);
	        	return 0;
        
	        	
	        }
		}
	}
	
	
	public static int choice(ApplicationContext context, Cards c) {
		for(;;) {
			GameView area = new GameView();
			area.drawChoice(context, c);
			
			Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        if (action == Action.POINTER_DOWN) {
	        	return 1;

			}
			return 1;
		}
	}
	

}
