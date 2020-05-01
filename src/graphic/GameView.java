package graphic;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import cardInfo.Cards;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;
import gameDeroulement.Market;
import gameDeroulement.Players;

public class GameView{
	
	public BufferedImage rotate(BufferedImage buffered) {
        BufferedImage buffered2 = new BufferedImage(buffered.getHeight(),buffered.getWidth(),BufferedImage.TYPE_INT_RGB);
        for(int x = 0;x < buffered.getWidth();x++) {
            for(int y = 0;y < buffered.getHeight();y++) {
                    buffered2.setRGB(buffered.getHeight()-y-1, x, buffered.getRGB(x, y));
            }
        }
        return buffered2;
    }
    
    void draw(ApplicationContext context, Players p1, Players p2) {
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
        
        
        graphics.drawString("Influence adverse : "+p2.getDefensePoints(), 10, 20);
        graphics.drawString("Point commerce adverse : "+p2.getTradePoints(), 10, 40);
        graphics.drawString("Point attaque adverse : "+p2.getFightPoints(), 10, 60);
        graphics.drawString("Nb cartes défausse adverse : "+p2.showDiscarding().size(), 10, 80);
        
        graphics.drawString("Influence joueur actuel : "+p1.getDefensePoints(), 10, height-70);
        graphics.drawString("Point commerce joueur actuel : "+p1.getTradePoints(), 10, height-50);
        graphics.drawString("Point attaque joueur actuel : "+p1.getFightPoints(), 10, height-30);
        graphics.drawString("Cartes dans la défausse : "+p1.showDiscarding().size(), 10, height-10);
        
        //Ici on affiche les cartes de l'adversaire en jeu
        for (int i = 2; i < 8; i++) {
            if (p2.getNavigTable()*(i-2) < p2.showTable().size()) {
            	
            	
            	if (p2.showTable().get(p2.getNavigTable()*(i-2)).getType() == "Base") {
                	Path path_trade = Paths.get("res/cards/"+p2.showTable().get(p2.getNavigTable()*(i-2)).getTitle()+".png");
                    try (InputStream in = Files.newInputStream(path_trade)) {
                        BufferedImage img = ImageIO.read(in);
                        
                        BufferedImage imgrotate = rotate(img);
                        
                        graphics.drawImage(imgrotate, Math.round((i*width+10)/10), 10, Math.round(width/11), Math.round(height/5), null);
                    } catch (IOException e) {
                        throw new RuntimeException("problem while drawing " + p2.showTable().get(p2.getNavigTable()*(i-2)).getTitle() + ".png");
                    }
                    
                    
                } else {
                Path path_trade = Paths.get("res/cards/"+p2.showTable().get(p2.getNavigTable()*(i-2)).getTitle()+".png");
                try (InputStream in = Files.newInputStream(path_trade)) {
                    BufferedImage img = ImageIO.read(in);
                    graphics.drawImage(img, Math.round((i*width+10)/10), 10, Math.round(width/11), Math.round(height/5), null);
                } catch (IOException e) {
                    throw new RuntimeException("problem while drawing " + p2.showTable().get(p2.getNavigTable()*(i-2)).getTitle() + ".png");
                }
                }
            	
            	//graphics.setColor(Color.WHITE);
            	//graphics.drawString(p2.showTable().get(p2.getNavigTable()*(i-2)).toString(), (i*width+10)/10, height/5+25);
			}
		}     	
        
        graphics.setColor(Color.YELLOW);
        graphics.fill(new Rectangle2D.Float(width-(width/11)-10, 50, width/11, height/12));
        graphics.setColor(Color.BLACK);
        graphics.drawString("Cartes suivantes", width - (width/11) + 10 , 75);
        
        
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
        
        
        graphics.setColor(Color.YELLOW);
        graphics.fill(new Rectangle2D.Float(width-(width/11)-10, (2*height)/5+150, width/11, height/12));
        graphics.setColor(Color.BLACK);
        graphics.drawString("Cartes suivantes", width - (width/11) + 10 , (2*height)/5+175);
        
        
        
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
        
        graphics.setColor(Color.YELLOW);
        graphics.fill(new Rectangle2D.Float(width-(width/11)-10, (3*height)/5+175, width/11, height/12));
        graphics.setColor(Color.BLACK);
        graphics.drawString("Cartes suivantes", width - (width/11) + 10 , (3*height)/5+200);
        
        
      });
      
    }          
    
    public void drawEnd(ApplicationContext context, Players winner) {//On affiche ici le gagnant, et demande si l'utilisateur veut rejouer
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
            graphics.drawString("Le gagnant est: "+winner+" voulez vous rejouer?" , width/3+100 , height/3+50);
            
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
    
    public void drawChoice(ApplicationContext context, Cards c) {
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
                graphics.fill(new Rectangle2D.Float(width/3, height/3-50, width/3, height/4));
                /*Path path_card = Paths.get("res/"+c.getTitle()+".jpg");
                try (InputStream in = Files.newInputStream(path_card)) {
                    BufferedImage img = ImageIO.read(in);
                    graphics.drawImage(img, null, 0, 0);
                } catch (IOException e) {
                    throw new RuntimeException("problem while drawing"+ c.getTitle() +".png ");
                }*/
                
                //Puis les 2 choix possible
                if(c.getScrap().keySet().size() > 0) {
                graphics.setColor(Color.GRAY);
                graphics.fill(new Rectangle2D.Float(width/4, 2*height/3, width/8, height/10));
                graphics.setColor(Color.YELLOW);
                graphics.drawString("SCRAP : Ajouter "+c.getScrap() , width/4+50 , 2*height/3+50);
                }
                else {                
                graphics.setColor(Color.GRAY);
                graphics.fill(new Rectangle2D.Float(3*width/4-width/8, 2*height/3, width/8, height/10));
                graphics.setColor(Color.YELLOW);
                graphics.drawString("NE PAS UTILISER SCRAP" , 3*width/4-width/8+50 , 2*height/3+50);
                }
                
                
        		
           
    		
    	});
	}
    
    
    public void drawMainGameMenu(ApplicationContext context) {
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
                graphics.drawImage(img, Math.round(width/3), Math.round(height/3-50), Math.round(width/3), Math.round(height/4), null);
            } catch (IOException e) {
                throw new RuntimeException("problem while drawing logo.png ");
            }
            
            
          //Puis les 2 choix possible
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(width/4, 2*height/3, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Avec le mode IA" , width/4+50 , 2*height/3+50);
            
            graphics.setColor(Color.GRAY);
            graphics.fill(new Rectangle2D.Float(3*width/4-width/8, 2*height/3, width/8, height/10));
            graphics.setColor(Color.YELLOW);
            graphics.drawString("Sans le mode IA" , 3*width/4-width/8+50 , 2*height/3+50);
            
           
    		
    	});
	}
    
    public void drawMenu(ApplicationContext context) {
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


