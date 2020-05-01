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
					getClickEvent(event, context, p1, p2);
					if (p2.getLife() <= 0) {//Si l'utilisateur a battu l'adversaire, il est inutile de continuer le tour
						return;
					}
					
				}else if (action == Action.KEY_PRESSED && event.getKey().toString() == "SPACE") {//passe le tour
					
					p1.remShip(); //a la fin du tour les ships en jeux partent
					p1.pickCardsInHand(5); // le joueur venant de terminer pioche 5 cartes pour son prochain tour
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
	        	return getClickEventEnd(event, context);

			}
		}
	}
	
	public static int windowMenu(ApplicationContext context) {//cette méthode appelle l'écran du menu
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
	        	return getClickEventMenu(event, context);

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
	
	public static int getClickEventChoice(Event event, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();
		
		return 1;
	}
	
	static void getClickEvent(Event event, ApplicationContext context, Players p1, Players p2) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();        
				
		//Main adverse
		if (10 < cooY && cooY < (height/5)) {
			for (int i = 2; i < 8; i++) {
				if ((i*width+10)/10 < cooX && cooX < ((i*width+10)/10)+(width+10)/11) {
					System.out.println("Je clique sur la carte de la main adverse : " + (i-1));
					
				}
			}
			
		}
		
		//Ligne achat
		if ( height/5+50 < cooY && cooY < height*2/5+50) {
			if (10 < cooX && cooX < width/11+10) {
				System.out.println("J'achète une carte explorer.");
				p1.buyExplorer();
				
			}else {
				//Achat carte
				for (int i = 3; i < 8; i++) {
					if ((i*width+10)/10 < cooX && cooX < ((i*width+10)/10)+(width+10)/11) {
						
						System.out.println("J'achète la carte : " + Market.getShownMarket().get((i-3)) + "dans le marché." );
						p1.buyCard(Market.getShownMarket().get((i-3)));

						
						
					}
				}
			}
		}
		//CARTES POSEES PAR LE JOUEUR
		if (((2*height)/5)+100 < cooY && cooY < ((height*3)/5)+100) {
			//Pioche
			if (10 < cooX && cooX < width/11+10) {
				System.out.println("Je pioche une carte dans le paquet.");
				
				
			}else {
				//Carte posées
				for (int i = 2; i < 8; i++) {
					if ((i*width+10)/10 < cooX && cooX < ((i*width+10)/10)+(width+10)/11) {
						if ((i-2)*p1.getNavigTable()< p1.getTable().size()) {
							if (p1.showTable().get((i-2)*p1.getNavigTable()).getScrap().keySet().size() >0) {//On regarde si il a des capacité scrap
								p1.useScrap(p1.showTable().get((i-2)*p1.getNavigTable()));			
							}
							
							if ((p1.showTable().get((i-2)*p1.getNavigTable())).getType().equals("Explorer")) {//Si c'est un explorer il retourne dans la pile Explorer
								Market.addExplorer(p1.showTable().get((i-2)*p1.getNavigTable()));
							}
							p1.delCard(p1.showTable().get((i-2)*p1.getNavigTable()));
						}
					}
				}
			}
		}
		//MAIN DU JOUEUR
		if (((3*height)/5)+150 < cooY && cooY < ((height*4)/5)+150) { // si on se trouve sur le bon axe Y
			
			for (int i = 2; i < 8; i++) { // boucle 6 cartes
				
				if ((i*width+10)/10 < cooX && cooX < ((i*width+10)/10)+(width+10)/11) { // si le clic se trouve sur la carte 
					
					if ((i-2) >= 0 && (i-2)*p1.getNavigHand() < p1.showHand().size()) { // si la carte existe (avoid OutOfBounds Exception)
							System.out.println("Je place la carte : " + p1.showHand().get((i-2)*p1.getNavigHand()) + " qui se trouvait dans ma main.");
							p1.playCard(p1.showHand().get((i-2)*p1.getNavigHand())); 
						}	
					}
				}
			}
			
		
		//Attaquer adversaire
		if (20 < cooY && cooY < 60 && 10 < cooX && cooX < 120 ) {
			System.out.println("J'attaque l'adversaire");
			p1.attackPlayer(p2);
		}
		
		//Carte suivante 
		if ( width-(width/11)-10 < cooX && cooX < width-10 ) {
			if (50 < cooY && cooY < height/12+50) {
				System.out.println("Je clique sur les cartes suivantes de l'adversaire");
				p2.navigH();
				
			}else if ((2*height)/5+150< cooY && cooY < 2*height/5+ 150 +  height/12) {
				System.out.println("Je clique sur les cartes suivantes");
				p1.navigT();
				
			}else if ((3*height)/5+175< cooY && cooY < (3*height)/5+175 +  height/12) {
				System.out.println("Je clique sur les cartes suivantes");
				p1.navigH();
			}
		}
	}	
	
	static int getClickEventEnd(Event event, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();
        
        if (2*height/3<cooY && cooY< 2*height/3 + 105/2) {
        	if (width/4<cooX && cooX<width/4+480/2) {
				return 1;
			}else if(3*width/4-width/8<cooX && cooX< 3*width/4){
				return 2;
				
			}
		}
        
		return 0;
	}
	static int getClickEventMenu(Event event, ApplicationContext context) {
		ScreenInfo screenInfo = context.getScreenInfo();
        float width = screenInfo.getWidth();
        float height = screenInfo.getHeight(); 
        double cooX = event.getLocation().getX();
        double cooY = event.getLocation().getY();
        
        if ( 2*height/3<cooY && cooY< (2*height/3) + height/10) {
        	if (width/4<cooX && cooX<width/4+(width/8)) {
				return 2;
			}else if(3*width/4-width/8<cooX && cooX< (3*width/4-width/8)+width/8){
				return 1;
				
			}
		}
        
		return 0;
	}
}
