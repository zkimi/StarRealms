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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import cardInfo.Capacity;
import cardInfo.Cards;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import gameComponent.Market;
import gameComponent.Player;
import gameComponent.TeamTwo;

public class GraphHydraTwo {
private static int show = 0;
	
	public static void controller(Player p,TeamTwo t1, TeamTwo t2, ArrayList<Player> playerList, ApplicationContext context) {
		showNext(playerList, playerList.indexOf(p));//pour eviter que au début du tour le joueur tombe sur lui même

		for(;;) {
			draw(context, p,  playerList, t1 , t2); 
	        Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        Action action = event.getAction();
	        
	        
	        
	        //ON GERE LES CLICS
	        if (action == Action.POINTER_DOWN) {
				click(event, context, p,  playerList, t1 , t2);
				
			}else if (action == Action.KEY_PRESSED && event.getKey().toString() == "SPACE") {//passe le tour
				
				return;
				
			}else  if ((action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) && event.getKey().toString() != "SPACE") {//arrete
	        	System.out.println(event.getKey().toString());
	        	context.exit(0);
	        	return;
        
	        	
	        }
		}
	}
	
	public static void message(ApplicationContext context, String type, int nb) {
		for(;;) {

			drawMessage(context, type, nb);
			
			Event event = context.pollOrWaitEvent(10);
	        if (event == null) {  // no event
	        	continue;
	        }
	        try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        break;
		}
	}
	
	public static void drawMessage(ApplicationContext context, String type, int nbDiscard) {
    	context.renderFrame(graphics -> {
    		ScreenInfo screenInfo = context.getScreenInfo();
            float width = screenInfo.getWidth();
            float height = screenInfo.getHeight(); 
            
	    	graphics.setColor(Color.WHITE);
	    	graphics.setFont(new Font("Comic Sans MS", Font.ITALIC, 30)); 
	    	if (type == "OpponentDiscard") {
	    		graphics.setColor(Color.BLACK);
	    		graphics.drawString("Vous venez de jouer une carte qui oblige le joueur adverse à défausser "+nbDiscard+ " carte(s) au prochain tour.", width/4-150 , (height/2+150)+2);
	    		graphics.setColor(Color.WHITE);
	    		graphics.drawString("Vous venez de jouer une carte qui oblige le joueur adverse à défausser "+nbDiscard+ " carte(s) au prochain tour.", width/4-150 , height/2+150);
    		}
	    	if (type == "DestroyBaseNotEnoughAttackPoints") {
	    		graphics.setColor(Color.BLACK);
	    		graphics.drawString("Vous avez tenté d'attaquer la base adverse, pas assez de points d'attaque, vous les avez perdu.", width/4-250 , Math.round(height/5+50)+Math.round(height/5+50)-25+2);
	    		graphics.setColor(Color.WHITE);
	    		graphics.drawString("Vous avez tenté d'attaquer la base adverse, pas assez de points d'attaque, vous les avez perdu.", width/4-250 , Math.round(height/5+50)+Math.round(height/5+50)-25);
	    	}
	    	if (type == "OpponentGotOutpost") {
	    		graphics.setColor(Color.BLACK);
	    		graphics.drawString("L'adversaire possède un avant-poste, détruisez-le d'abord.", width/4-150 , Math.round(height/5+50)+Math.round(height/5+50)-25+2);
	    		graphics.setColor(Color.WHITE);
	    		graphics.drawString("L'adversaire possède un avant-poste, détruisez-le d'abord.", width/4-150 , Math.round(height/5+50)+Math.round(height/5+50)-25);
	    		
	    	}
	    	if (type == "FriendlyFire") {
	    		graphics.setColor(Color.BLACK);
	    		graphics.drawString("Vous tentez d'attaquer votre allié, c'est interdit.", width/4-150 , Math.round(height/5+50)+Math.round(height/5+50)-25+2);
	    		graphics.setColor(Color.WHITE);
	    		graphics.drawString("Vous tentez d'attaquer votre allié, c'est interdit.", width/4-150 , Math.round(height/5+50)+Math.round(height/5+50)-25);
	    		
	    	}
    	});
    }
	
	private static void draw(ApplicationContext context, Player p1, ArrayList<Player> playerList, TeamTwo t1, TeamTwo t2) {
	      context.renderFrame(graphics -> {
	    	  
	    	
	    	  
	    	ScreenInfo screenInfo = context.getScreenInfo();
	        float width = screenInfo.getWidth();
	        float height = screenInfo.getHeight(); 
	        
	        
	        /* BACK GROUND */
	        Path path_background = Paths.get("res/misc/bg.jpg");
	        try (InputStream in = Files.newInputStream(path_background)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, null, 0, 0);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing background.png ");
	        }
	      
	        
	        //On affiche les info des joueurs
	        graphics.setColor(Color.WHITE);
	        graphics.drawString("Main actuelle : "+p1.getName(), width-150, 20);
	        
	        
	        graphics.setFont(new Font("Tahoma", Font.BOLD, 20)); 
	        
	        Path path_influence = Paths.get("res/elements/influence.png");
	        try (InputStream in = Files.newInputStream(path_influence)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 10, 10, 80, 46, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing influence.png (adverse) ");
	        }
	        if (t1.contains(playerList.get(show))) {
	        	graphics.drawString(""+t1.getLife(), 36, 37);
			}else {
				graphics.drawString(""+t2.getLife(), 36, 37);
			}
	        
	        Path path_commerce = Paths.get("res/elements/argent.png");
	        try (InputStream in = Files.newInputStream(path_commerce)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 100, 10, 50, 52, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing argent.png ");
	        }
	        graphics.setColor(Color.BLACK);
	        graphics.drawString(""+playerList.get(show).getTradePoints(), 117, 43);
	        
	        Path path_attaque = Paths.get("res/elements/attaque.png");
	        try (InputStream in = Files.newInputStream(path_attaque)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img,155,5, 64, 64, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing attaque.png ");
	        }
	        graphics.setColor(Color.WHITE);
	        graphics.drawString(""+playerList.get(show).getFightPoints(), 178, 45);
	        
	        
	        graphics.setFont(new Font("Verdana", Font.PLAIN, 11));
	        graphics.drawString("Nb cartes défausse adverse : "+playerList.get(show).showDiscarding().size(), 10, 80);
	        
	        try (InputStream in = Files.newInputStream(path_influence)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 10, Math.round(height-70), 110, 64, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing influence.png ");
	        }
	        graphics.setFont(new Font("Tahoma", Font.BOLD, 25)); 
	        graphics.drawString(""+t1.getLife(), 47, height-35);
	        
	        try (InputStream in = Files.newInputStream(path_commerce)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 120, Math.round(height-70), 62, 64, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing argent.png ");
	        }
	        graphics.setColor(Color.BLACK);
	        graphics.drawString(""+p1.getTradePoints(), 143, height-30);
	        
	        try (InputStream in = Files.newInputStream(path_attaque)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 190, Math.round(height-85), 84, 84, null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing attaque.png ");
	        }
	        graphics.setColor(Color.WHITE);
	        graphics.drawString(""+p1.getFightPoints(), 223, height-33);
	        
	        
	        graphics.setFont(new Font("Verdana", Font.PLAIN, 11));
	        graphics.drawString("Cartes dans la défausse : "+p1.showDiscarding().size(), 10, height-100);
	        
	        
	        graphics.setFont(new Font("Verdana", Font.PLAIN, 11));
	        
	        //Ici on affiche les cartes de l'adversaire en jeu
	        for (int i = 2; i < 8; i++) {
	            if (playerList.get(show).getNavigTable()*(i-2) < playerList.get(show).showTable().size()) {
	            	
	            	
	            	if (playerList.get(show).showTable().get(playerList.get(show).getNavigTable()*(i-2)).getType() == "Base") {
	                	Path path_trade = Paths.get("res/cards/"+playerList.get(show).showTable().get(playerList.get(show).getNavigTable()*(i-2)).getTitle()+".png");
	                    try (InputStream in = Files.newInputStream(path_trade)) {
	                        BufferedImage img = ImageIO.read(in);
	                        
	                        BufferedImage imgrotate = rotate(img);
	                        
	                        graphics.drawImage(imgrotate, Math.round((i*width+10)/10), 10, Math.round(width/11), Math.round(height/5), null);
	                    } catch (IOException e) {
	                        throw new RuntimeException("problem while drawing " + playerList.get(show).showTable().get(playerList.get(show).getNavigTable()*(i-2)).getTitle() + ".png");
	                    }
	                    
	                    
	                } else {
	                Path path_trade = Paths.get("res/cards/"+playerList.get(show).showTable().get(playerList.get(show).getNavigTable()*(i-2)).getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_trade)) {
	                    BufferedImage img = ImageIO.read(in);
	                    graphics.drawImage(img, Math.round((i*width+10)/10), 10, Math.round(width/11), Math.round(height/5), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing " + playerList.get(show).showTable().get(playerList.get(show).getNavigTable()*(i-2)).getTitle() + ".png");
	                	}
	                }
	            	
				}
			}     	
	        
	        Path viewCardsOpponent = Paths.get("res/buttons/viewCards.png");
            try (InputStream in = Files.newInputStream(viewCardsOpponent)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width-(width/11)-10), 50, 160, 75, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing viewCards.png");
            }
	        
	        
	        //NOUVEAUTE 
	        graphics.setColor(Color.YELLOW);
	        graphics.fill(new Rectangle2D.Float(width-(width/11)-10,100 + height/12,  width/11, height/12));
	        graphics.setColor(Color.BLACK);
	        graphics.drawString(playerList.get(show).getName(), width - (width/11) , height/12 +125);
	        
	        if (t2.contains(playerList.get(show))) {//On indique à l'utilisateur si c'est sa sible
					graphics.setColor(Color.BLACK);
			        graphics.drawString("Equipe adverse", width - (width/11) , height/12 +135);
			}
	        else if (t1.contains(playerList.get(show))) {
				graphics.setColor(Color.BLACK);
		        graphics.drawString("Votre allié", width - (width/11) , height/12 +135);
			}
	        
	        

	        
	        
	        //Ici on fait l'arrichage des cartes de commerce explorer et achat:
	        
	        ArrayList<Cards> market = Market.initializeTradeCards();
	        if (market.size() > 0) {
	        for (int i = 3; i < market.size()+3; i++) {
	            
	           if (market.get(i-3).getType() == "Base") {
	            	Path path_trade = Paths.get("res/cards/"+market.get(i-3).getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_trade)) {
	                    BufferedImage img = ImageIO.read(in);
	                    
	                    BufferedImage imgrotate = rotate(img);
	                    
	                    graphics.drawImage(imgrotate, Math.round((i*width+10)/10), Math.round(height/5+50), Math.round(width/11), Math.round(height/5), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing " + market.get(i-3).getTitle() + ".png");
	                }
	                
	                
	            } else {
	            Path path_trade = Paths.get("res/cards/"+market.get(i-3).getTitle()+".png");
	            try (InputStream in = Files.newInputStream(path_trade)) {
	                BufferedImage img = ImageIO.read(in);
	                graphics.drawImage(img, Math.round((i*width+10)/10), Math.round(height/5+50), Math.round(width/11), Math.round(height/5), null);
	            } catch (IOException e) {
	                throw new RuntimeException("problem while drawing " + market.get(i-3).getTitle() + ".png");
	            }
	            }
			}
	        }
	        
	        
	        /* position image */

	        Path path_explorer = Paths.get("res/cards/Explorer.png");
	           try (InputStream in = Files.newInputStream(path_explorer)) {
	               BufferedImage img = ImageIO.read(in);
	               graphics.drawImage(img, 10, Math.round(height/5+50), Math.round(width/11), Math.round(height/5), null);
	           } catch (IOException e) {
	               throw new RuntimeException("problem while drawing explorer.png ");
	           }
	        graphics.setColor(Color.WHITE);
	        graphics.drawString(Integer.toString(Market.getExplorers().size()) + " explorer(s) restant(s)", 32, Math.round(height/5+50)+Math.round(height/5+50)-25); // debug text

	           
	           
	        
	      //Ici on affiche les cartes du joueur en jeu ainsi que la pioche
	        for (int i = 2; i < 8; i++) {
	            if (p1.getNavigTable()*(i-2) < p1.showTable().size()) {
	                
	                
	                if (p1.showTable().get(p1.getNavigTable()*(i-2)).getType() == "Base") {
	                	Path path_trade = Paths.get("res/cards/"+p1.showTable().get(p1.getNavigTable()*(i-2)).getTitle()+".png");
	                    try (InputStream in = Files.newInputStream(path_trade)) {
	                        BufferedImage img = ImageIO.read(in);
	                        
	                        BufferedImage imgrotate = rotate(img);
	                        
	                        graphics.drawImage(imgrotate, Math.round((i*width+10)/10), Math.round((2*height)/5+100), Math.round(width/11), Math.round(height/5), null);
	                    } catch (IOException e) {
	                        throw new RuntimeException("problem while drawing " + p1.showTable().get(p1.getNavigTable()*(i-2)).getTitle() + ".png");
	                    }
	                    
	                    
	                } else {
	                Path path_trade = Paths.get("res/cards/"+p1.showTable().get(p1.getNavigTable()*(i-2)).getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_trade)) {
	                    BufferedImage img = ImageIO.read(in);
	                    graphics.drawImage(img, Math.round((i*width+10)/10), Math.round((2*height)/5+100), Math.round(width/11), Math.round(height/5), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing " + p1.showTable().get(p1.getNavigTable()*(i-2)).getTitle() + ".png");
	                }
	                }
	                
	                
				}
			}     	
	        
	        
	        Path viewCardsTable = Paths.get("res/buttons/viewCards.png");
            try (InputStream in = Files.newInputStream(viewCardsTable)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width-(width/11)-10), Math.round((2*height)/5+150), 160, 75, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing viewCards.png");
            }
	        
	        
	        
	        graphics.setColor(Color.GRAY);
	        graphics.fill(new Rectangle2D.Float(10, (2*height)/5+100, width/11, height/5));// la pioche
	        
	        Path path_drawer = Paths.get("res/cards/Draw.png");
	        try (InputStream in = Files.newInputStream(path_drawer)) {
	            BufferedImage img = ImageIO.read(in);
	            graphics.drawImage(img, 10, Math.round((2*height)/5+100), Math.round(width/11), Math.round(height/5), null);
	        } catch (IOException e) {
	            throw new RuntimeException("problem while drawing test.png ");
	        }
	        
	        graphics.setColor(Color.WHITE);
	        graphics.drawString(Integer.toString(Market.getDrawer().size()) + " carte(s) restante(s)", 32, Math.round((2*height)/5+340)); // debug text
	        
	        

	        
	        
	      //Ici on affiche la main du joueur
	        for (int i = 2; i < 8; i++) {
	            if (p1.getNavigHand()*(i-2) < p1.showHand().size()) {
	                
	                if (p1.showHand().get(p1.getNavigHand()*(i-2)).getType() == "Base") {
	                	Path path_trade = Paths.get("res/cards/"+p1.showHand().get(p1.getNavigHand()*(i-2)).getTitle()+".png");
	                    try (InputStream in = Files.newInputStream(path_trade)) {
	                        BufferedImage img = ImageIO.read(in);
	                        
	                        BufferedImage imgrotate = rotate(img);
	                        
	                        graphics.drawImage(imgrotate, Math.round(((i*width+10)/10)), Math.round((3*height)/5+150), Math.round(width/11), Math.round(height/5), null);
	                    } catch (IOException e) {
	                        throw new RuntimeException("problem while drawing " + p1.showHand().get(p1.getNavigHand()*(i-2)).getTitle() + ".png");
	                    }
	                    
	                    
	                } else {
	                Path path_trade = Paths.get("res/cards/"+p1.showHand().get(p1.getNavigHand()*(i-2)).getTitle()+".png");
	                try (InputStream in = Files.newInputStream(path_trade)) {
	                    BufferedImage img = ImageIO.read(in);
	                    graphics.drawImage(img, Math.round(((i*width+10)/10)), Math.round((3*height)/5+150), Math.round(width/11), Math.round(height/5), null);
	                } catch (IOException e) {
	                    throw new RuntimeException("problem while drawing " + p1.showHand().get(p1.getNavigHand()*(i-2)).getTitle() + ".png");
	                }
	                }
				}
	            
			}     	
	        
	        Path viewCards = Paths.get("res/buttons/viewCards.png");
            try (InputStream in = Files.newInputStream(viewCards)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width-(width/11)-10), Math.round((3*height)/5+175), 160, 75, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing viewCards.png");
            }
	        
	        //Bouton tout jouer
	        Path path_playAll = Paths.get("res/buttons/playAll.png");
            try (InputStream in = Files.newInputStream(path_playAll)) {
                BufferedImage img = ImageIO.read(in);
                graphics.drawImage(img, Math.round(width-(width/11)-10), Math.round((2*height)/5+225), 160, 75, null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing playAll.png");
            }
	        
	     // eventuels messages
	        if (p1.getPenalityDiscard() > 0) {
	        	graphics.setColor(Color.WHITE);
		    	graphics.setFont(new Font("Comic Sans MS", Font.ITALIC, 30)); 
	        	graphics.drawString("Le joueur adverse a joué une carte qui vous oblige à défausser "+p1.getPenalityDiscard()+ " carte(s), cliquez dessus.", width/4-150 , height/2);
			}
	      });
	      
	    }
	
	
	
	
	private static void click(Event event, ApplicationContext context, Player p1, ArrayList<Player> playerList, TeamTwo t1, TeamTwo t2) {
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
					
					if ((i-2) >= 0 && (i-2)*playerList.get(show).getNavigTable() < playerList.get(show).showTable().size()) { // si la carte existe (avoid OutOfBounds Exception)
						
						
						System.out.println(playerList.get(show).showTable().get((i-2)*playerList.get(show).getNavigTable()));
						
						if (playerList.get(show).showTable().get((i-2)*playerList.get(show).getNavigTable()).getType() == "Base") {
							
							System.out.println("C'est une base, tentative de destruction");
							
							if (t2.contains(playerList.get(show))) {
								if (p1.getFightPoints() < playerList.get(show).showTable().get((i-2)*playerList.get(show).getNavigTable()).getDefense()) {
									message(context, "DestroyBaseNotEnoughAttackPoints", 0); // on affiche un msg
									System.out.println("Destruction échouée, perte des points de l'attaquant");
								}
								
								p1.destroyBase(playerList.get(show), playerList.get(show).showTable().get((i-2)*playerList.get(show).getNavigTable()));
							}else {
								message(context, "FriendlyFire", 0); // on affiche un msg
								System.out.println("Vous ne pouvez pas attaquer un allié !");
							}	
							
						
							
						} else {
							System.out.println("Ce n'est pas une base");
						}
					}
					
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
							
						if (Capacity.isChoiceCard(p1.showHand().get((i-2)*p1.getNavigHand()))) { // si la carte possède un choix
							Capacity.choice(p1.showHand().get((i-2)*p1.getNavigHand()).getCapacity(), p1.showHand().get((i-2)*p1.getNavigHand()), p1, context);
						} // sinon
							System.out.println("Je place la carte : " + p1.showHand().get((i-2)*p1.getNavigHand()) + " qui se trouvait dans ma main.");
							p1.playCard(p1.showHand().get((i-2)*p1.getNavigHand())); 
						
						}	
					}
				}
			}
			
		
		//Attaquer adversaire
		if (20 < cooY && cooY < 60 && 10 < cooX && cooX < 120 ) {//Il faut bien vérifier que l'utilisateur attaque sa cible
			if (t2.contains(playerList.get(show))) {
				t1.attack(t2, p1);
			}else {
				message(context, "FriendlyFire", 0); // on affiche un msg
				System.out.println("Vous ne pouvez pas attaquer un allié !");
			}			
		}
		
		//Carte suivante 
		if ( width-(width/11)-10 < cooX && cooX < width-10 ) {
			if (50 < cooY && cooY < height/12+50) {
				System.out.println("Je clique sur les cartes suivantes de l'adversaire");
				playerList.get(show).navigH();
				
			}else if ((2*height)/5+150< cooY && cooY < 2*height/5+ 150 +  height/12) {
				System.out.println("Je clique sur les cartes suivantes");
				p1.navigT();
				
			}else if ((3*height)/5+175< cooY && cooY < (3*height)/5+175 +  height/12) {
				System.out.println("Je clique sur les cartes suivantes");
				p1.navigH();
			} else if ((2*height)/5+225<cooY && cooY<(2*height)/5+225 + height/12) {//Bouton tout jouer
				
				
				while (p1.getHand().size() > 0) {
					p1.playCard(p1.showHand().get(0));
				}
				
				System.out.println("Je joue toutes mes cartes");
			}
			//nouveaute DEATHMATCH
			if (100 + height/12 < cooY && cooY < 100 + 2*height/12) {
				System.out.println("Je veux voir le joueur suivant");
				showNext(playerList, playerList.indexOf(p1));
			}
		}
	}
	
	private static void showNext(ArrayList<Player> playerList, int turn) {
		if (show == playerList.size()-1) {
			show = 0;
		}else {
			show ++;
		}
		if (show == turn && playerList.size()>1) {
			showNext(playerList, turn);
		}
	}
	
	private static BufferedImage rotate(BufferedImage buffered) {
	      BufferedImage buffered2 = new BufferedImage(buffered.getHeight(),buffered.getWidth(),BufferedImage.TYPE_INT_RGB);
	      for(int x = 0;x < buffered.getWidth();x++) {
	          for(int y = 0;y < buffered.getHeight();y++) {
	                  buffered2.setRGB(buffered.getHeight()-y-1, x, buffered.getRGB(x, y));
	          }
	      }
	      return buffered2;
	  }	
}
