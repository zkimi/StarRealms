   _____ _               _____            _                      _    __      __       ______ _____ _____ _______ _____ ____  _   _ 
  / ____| |             |  __ \          | |                    | |  /\ \    / /\     |  ____|  __ |_   _|__   __|_   _/ __ \| \ | |
 | (___ | |_ __ _ _ __  | |__) |___  __ _| |_ __ ___  ___       | | /  \ \  / /  \    | |__  | |  | || |    | |    | || |  | |  \| |
  \___ \| __/ _` | '__| |  _  // _ \/ _` | | '_ ` _ \/ __|  _   | |/ /\ \ \/ / /\ \   |  __| | |  | || |    | |    | || |  | | . ` |
  ____) | || (_| | |    | | \ |  __| (_| | | | | | | \__ \ | |__| / ____ \  / ____ \  | |____| |__| _| |_   | |   _| || |__| | |\  |
 |_____/ \__\__,_|_|    |_|  \_\___|\__,_|_|_| |_| |_|___/  \____/_/    \_\/_/    \_\ |______|_____|_____|  |_|  |_____\____/|_| \_|
                                                                                                                                    
                                                                                                                                    

Phase 1 : 

- Organisation des fichiers :
.
├── src
│   ├── cardInfo
│   │    ├── AbstractCards.java
│   │    ├── Base.java
│   │    ├── Capacity.java
│   │    ├── Cards.java
│   │    ├── Explorer.java
│   │    ├── Gambit.java
│   │    ├── Hero.java
│   │    ├── Mission.java
│   │    ├── Scenario.java
│   │    └── Ship.java
│   │
│   ├── cardDetails
│   │    ├── ColonyWars.java
│   │    ├── CoreSet.java
│   │    ├── Gambits.java
│   │    ├── Scenarios.java
│   │    └── United.java
│   │
│   ├── game
│   │    └── Jeux.java
│   │
│   ├── gameComponent
│   │    ├── Bot.java
│   │    ├── Market.java
│   │    ├── Player.java
│   │    └── TeamTwo.java
│   │
│   ├── gameMode
│   │    ├── DeathMatch.java
│   │    ├── GameVsBot.java
│   │    ├── GameVsPlayer.java
│   │    ├── Hydra.java
│   │    └── ManHunt.java
│   │
│   ├── graphic
│   │    ├── ChoiceCap.java
│   │    ├── EndGame.java
│   │    ├── GraphDeathMatch.java
│   │    ├── GraphHydraTwo.java
│   │    ├── GraphLoad.java
│   │    ├── GraphMainGame.java
│   │    ├── GraphManHunt.java
│   │    ├── GraphSave.java
│   │    └── Menu.java
│   │
│   └── save
│        ├── Load.java
│        └── Save.java
│ 
├── res
│   ├── buttons
│   ├── cards
│   ├── elements
│   └── misc
│  
├─ doc
│  
│   
└── lib

- Implémentations :

Phase 2 :
○ Ajout de toutes les cartes de départ ainsi que leur capacitées respectives (pts de commerce, pts de combat, pts d'influence, scrap & ally).
○ Ajout d'un système de tour à tour entre deux joueurs.
○ Initialisation du marché, des decks de départ, ainsi que de la pioche, des défausses et de la pile explorers.
○ Gestion de l'interface graphique (placement des élements et des informations pour les joueurs).
○ Gestion des évenements vis-à-vis d'un clic utilisateur (manipulation des cartes, attaques, pioche, achat).
○ Ajout d'une aide pour visualiser le deck en son intégralité (bouton cartes restantes).
○ Ajout de l'écran de fin, ainsi que d'une possibilité de rejouer ou de quitter.

Phase 3 :
○ Ajout des extensions Colony Wars, Scenarios, Gambit
○ Ajout du système de sauvegarde (enregistrement et ouverture de sauvegarde)
○ Ajout du mode Hydre

- Répartition du travail :

○ Répartition en 50/50 : 
	• L'un gérant l'interface graphique, l'autre les fonctions pour commencer.
	• Echange des parties, puis travail coordonné.

- Choix techniques / algorithmiques :

○ L'ensemble decks/pioches/marché sont intégralement gérés avec des ArrayList.
○ Les capacités des cartes ont été implémentées dans des dictionnaires (HashMap) grâce à des valeurs permettant de faciliter grandement l'intégration d'une carte.
○ Les équipes pour le mode hydre sont des classes qui héritent des ArrayList. 

- Les éventuels problèmes rencontrés :

○ Quelques petits bugs un peu génants, perturbant le bon déroulement du jeu car entraînant des exceptions.
○ Difficulté à gérer les effets
○ Bug d'affichage graphique
○ Restauration des cartes lors de la sauvegarde (a entrainé la création de dictionnaires)

- Fonctionnement du jeu:
	Appuyer sur espace pour passer le tour, n'importe quelle autre touche pour arrêter le jeu. Pour attaquer l'adversaire cliquer sur son nom.
	Lors de l'écran de sauvegarde, appuyez sur espace pour valider le nom, si l'écran est vide, celà ne sauvegardera pas.

