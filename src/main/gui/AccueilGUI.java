package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import config.GameConfiguration;
import cpt.CompteurBorne;

public class AccueilGUI {
	private JFrame jfAccueil;
	private boolean estActive=true;
	private int nbBot;
	private String mode2jeu = GameConfiguration.CARTE_CACHEE; //Default = classique
	
	public AccueilGUI() {

	}
	
    public boolean isActive() {
        return estActive;
    }

    public void ferme_accueil() {
		jfAccueil.setVisible(false);
        estActive = false;
    }
	
	public void app_run(){
		
		//Frame d'accueil
        jfAccueil = new JFrame();
        jfAccueil.setResizable(false);
        jfAccueil.getContentPane().setBackground(Color.DARK_GRAY);
        jfAccueil.setTitle("Cartes");
        jfAccueil.getContentPane().setLayout(new BorderLayout(GameConfiguration.WINDOW_WIDTH,GameConfiguration.WINDOW_HEIGHT));
        jfAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfAccueil.setBounds(0, 0, 750, 666);
		
		//Panel du titre
		JPanel jpTitreMenu = new JPanel();
		jpTitreMenu.setForeground(Color.DARK_GRAY);
		jpTitreMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
		jpTitreMenu.setBackground(Color.DARK_GRAY);
		jfAccueil.getContentPane().add(jpTitreMenu,BorderLayout.NORTH);
		
		//Label du titre
		JLabel jlJeuDeCartes = new JLabel("Cartes");
		jlJeuDeCartes.setForeground(Color.ORANGE);
		jlJeuDeCartes.setFont(new Font("Downtempo", Font.BOLD, 50));
		jpTitreMenu.add(jlJeuDeCartes);
		
		//Panel du menu
		JPanel jpBoutonsMenu = new JPanel();
		jpBoutonsMenu.setBackground(Color.DARK_GRAY);
		jpBoutonsMenu.setLayout(null);
		jfAccueil.getContentPane().add(jpBoutonsMenu,BorderLayout.CENTER);
		
		//Nouvelle Partie
		
		//Panel Titre de Nouvelle Partie
        JPanel jpTitreNouvellePartie = new JPanel();
        jpTitreNouvellePartie.setForeground(Color.DARK_GRAY);
        jpTitreNouvellePartie.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        jpTitreNouvellePartie.setBackground(Color.DARK_GRAY);
        
        //Label Titre Réglages de la partie
        JLabel jlRéglagesDeLaPartie = new JLabel("Nouvelle partie");
        jlRéglagesDeLaPartie.setForeground(Color.ORANGE);
        jlRéglagesDeLaPartie.setFont(new Font("Downtempo", Font.BOLD, 50));
        jpTitreNouvellePartie.add(jlRéglagesDeLaPartie);
        
        //Panel Options
        JPanel jpOptions = new JPanel();
        jpOptions.setBackground(Color.DARK_GRAY);
        jpOptions.setLayout(null);

        //Mode de jeu
        //carte_cachée => Mode Classique avec face cachée
        //carte_visible => Mode Débutant avec face visible
        String[] mode2jeux = {GameConfiguration.CARTE_CACHEE,GameConfiguration.CARTE_VISIBLE};    
        //Label Mode de jeu
        JLabel jlModeDeJeu = new JLabel("Mode de jeu");
        jlModeDeJeu.setForeground(Color.ORANGE);
        jlModeDeJeu.setBounds(158, 120, 174, 37);
        jlModeDeJeu.setFont(new Font("Eurostile", Font.PLAIN, 25));
        jpOptions.add(jlModeDeJeu);
        
        //Liste déroulante Mode de jeu
        JComboBox<String> jcbModeDeJeu = new JComboBox<String>(mode2jeux);
        jcbModeDeJeu.setForeground(Color.ORANGE);
        jcbModeDeJeu.setFont(new Font("Eurostile", Font.PLAIN, 20));
        jcbModeDeJeu.setBounds(152, 172, 158, 27);
        jcbModeDeJeu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mode2jeu = (String) jcbModeDeJeu.getSelectedItem();
            }
        });
        jpOptions.add(jcbModeDeJeu);
        
        //Compteur pour le nombre de bots
      	CompteurBorne cpt = new CompteurBorne(1,4,1);
      	
      	//Label Nombre de bots
        JLabel jlNombre = new JLabel("Nombre d'ordinateurs");
        jlNombre.setForeground(Color.ORANGE);
        jlNombre.setBounds(333, 120, 293, 37);
        jlNombre.setFont(new Font("Eurostile", Font.PLAIN, 25));
        jpOptions.add(jlNombre);
        
        //Label Compteur
        JLabel jlcpt = new JLabel("" + cpt.getVal());
        jlcpt.setForeground(Color.ORANGE);
        jlcpt.setBounds(454, 162, 21, 45);
        jlcpt.setFont(new Font("Eurostile", Font.PLAIN, 20));
        jpOptions.add(jlcpt);
        
        //Bouton Moins
        JButton jbMoins= new JButton("-");
        jbMoins.setForeground(Color.ORANGE);
        jbMoins.setBounds(382, 170, 50, 30);
        jbMoins.setFocusable(false);
        jbMoins.setFont(new Font("Eurostile", Font.PLAIN, 20));
        jbMoins.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cpt.decrementer();
        		jlcpt.setText("" + cpt.getVal());
        	}
        });
        jpOptions.add(jbMoins);
        
        //Bouton Plus
        JButton jbPlus = new JButton("+");
        jbPlus.setForeground(Color.ORANGE);
        jbPlus.setBounds(490, 170, 50, 30);
        jbPlus.setFocusable(false);
        jbPlus.setFont(new Font("Eurostile", Font.PLAIN, 20));
        jbPlus.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cpt.incrementer();
        		jlcpt.setText("" + cpt.getVal());
        	}
        });
        jpOptions.add(jbPlus);
        
        //Bouton Jouer
        JButton jbJouer = new JButton("Jouer");
        jbJouer.setBounds(227, 390, 140, 45);
        jbJouer.setForeground(Color.ORANGE);
        jbJouer.setFocusable(false);
        jbJouer.setFont(new Font("Eurostile", Font.PLAIN, 30));
        jbJouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	jfAccueil.setVisible(false);
            	estActive = false;
            	nbBot= cpt.getVal();
            	//lance la partie la
            }
        });
        jpOptions.add(jbJouer);
        
        //Bouton Retour en arrière de Nouvelle Partie
        JButton jbRetourNouvellePartie = new JButton("Retour");
        jbRetourNouvellePartie.setBounds(381, 390, 140, 45);
        jbRetourNouvellePartie.setForeground(Color.ORANGE);
        jbRetourNouvellePartie.setFocusable(false);
        jbRetourNouvellePartie.setFont(new Font("Eurostile", Font.PLAIN, 30));
        jbRetourNouvellePartie.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jfAccueil.getContentPane().removeAll();
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
        		jfAccueil.getContentPane().add(jpTitreMenu,BorderLayout.NORTH);
        		jfAccueil.getContentPane().add(jpBoutonsMenu,BorderLayout.CENTER);
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
        	}
        });
        jpOptions.add(jbRetourNouvellePartie);
        
        
        //Règles
        
        //Panel Titre de Règles
        JPanel jpTitreRègles = new JPanel();
        JPanel jpRègles = new JPanel();
        jpTitreRègles.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
        jpTitreRègles.setBackground(Color.DARK_GRAY);
        jpRègles.setBackground(Color.DARK_GRAY);

        //Label Règles du jeu
        JLabel jlTitreRègles = new JLabel("Règles du jeu");
        jlTitreRègles.setForeground(Color.ORANGE);
        jlTitreRègles.setFont(new Font("Downtempo", Font.BOLD, 50));
        jpTitreRègles.add(jlTitreRègles);
        jpRègles.setLayout(null);

        //Bouton Retour de Règles
        JButton jbRetourRègles = new JButton("Retour");
        jbRetourRègles.setForeground(Color.ORANGE);
        jbRetourRègles.setBounds(311, 391, 135, 43);
        jbRetourRègles.setFocusable(false); //enleve le carré en pointiller dégeulasse
        jbRetourRègles.setFont(new Font("Eurostile", Font.PLAIN, 30));
        jbRetourRègles.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jfAccueil.getContentPane().removeAll();
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
        		jfAccueil.getContentPane().add(jpTitreMenu,BorderLayout.NORTH);
        		jfAccueil.getContentPane().add(jpBoutonsMenu,BorderLayout.CENTER);
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
        	}
        });
        jpRègles.add(jbRetourRègles);

        //Champs de texte Règles
        JTextArea jtaTexteRègles = new JTextArea();
        jtaTexteRègles.setBackground(Color.DARK_GRAY);
        jtaTexteRègles.setForeground(Color.ORANGE);
        jtaTexteRègles.setFont(new Font("Eurostile", Font.PLAIN, 15));
        jtaTexteRègles.setEditable(false);
        String texte = "Les joueurs doivent poser une carte/combinaison de cartes de valeur supérieure d'uniquement de 1\n"
        		+ "par rapport à la dernière carte posée/combinaison de cartes posée dans l'ordre suivant :\n"    
        		+ "- 3-4-5-6-7-8-9-10-Valet-Dame-Roi-As.\n"
        		+ "Le premier joueur d'un tour impose le rythme du jeu. "
        		+ "En plus des simples, les combinaisons pour\nrendre le jeu stimulant sont :\n"
        		+ "- Les cartes 2 : Des cartes qui permettent de rejouer.\n"
        		+ "- Les séries : Des cartes qui se suivent par valeur. La série suivante doit avoir le même nombre de\n    cartes et commencer par la valeur supérieur d'uniquement de 1 de la première carte de la série.\n"
        		+ "- Les doubles : Deux cartes de la même valeur.\n"
        		+ "- Les doubles séries : Même chose que les séries mais chaque carte de la série est en double.\n"
        		+ "- Les bombes à 3 : Trois cartes de la même valeur, elles brisent le rythme imposé par les simples, \n     les séries, les doubles, et les doubles séries.\n"
        		+ "- Les bombes à 4 : Quatres cartes de la même valeur, elles brisent le rythme imposé par les simples\n     , les séries, les doubles, les doubles séries, et les bombes à 3.\n";
        		
        jtaTexteRègles.setText(texte);
        jtaTexteRègles.setBounds(17, 32, 716, 321);
        jpRègles.add(jtaTexteRègles);
        
        //Crédits
        
        //Panel Titre de Crédits
        JPanel jpZoneTitreCrédits = new JPanel();
		jpZoneTitreCrédits.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 50));
		jpZoneTitreCrédits.setBackground(Color.DARK_GRAY);
		
		//Panel Informations de Crédits
		JPanel jpInfoCrédits = new JPanel();
		jpInfoCrédits.setBackground(Color.DARK_GRAY);
		jpInfoCrédits.setLayout(null);
		
		//Label Titre Crédits
		JLabel jlCrédits = new JLabel("Crédits");
		jlCrédits.setForeground(Color.ORANGE);
		jlCrédits.setFont(new Font("Downtempo", Font.BOLD, 50));
		jpZoneTitreCrédits.add(jlCrédits);
		
		//Bouton Retour de Crédits
		JButton jbRetourCrédits = new JButton("Retour");
		jbRetourCrédits.setForeground(Color.ORANGE);
		jbRetourCrédits.setBounds(307, 392, 135, 43);
		jpInfoCrédits.add(jbRetourCrédits);
		jbRetourCrédits.setFocusable(false); //enleve le carré en pointiller dégeulasse
		jbRetourCrédits.setFont(new Font("Eurostile", Font.PLAIN, 30));
		jbRetourCrédits.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            jfAccueil.getContentPane().removeAll();
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
        		jfAccueil.getContentPane().add(jpTitreMenu,BorderLayout.NORTH);
        		jfAccueil.getContentPane().add(jpBoutonsMenu,BorderLayout.CENTER);
        		jfAccueil.revalidate();
        		jfAccueil.repaint();
	        }
    	});
		
		//Texte pané de Crédits
		JTextPane jtpTexteCrédits = new JTextPane();
		jtpTexteCrédits.setEditable(false);
		jtpTexteCrédits.setForeground(Color.ORANGE);
		jtpTexteCrédits.setBackground(Color.DARK_GRAY);
		jtpTexteCrédits.setFont(new Font("Eurostile", Font.PLAIN, 15));
		jtpTexteCrédits.setText(
				"Cartes\n"
				+ "Version 1.1\n\n"
				+ "agent1999\n"
				+ "Goboun\n"
				+ "Stefx300");
		jtpTexteCrédits.setBounds(20, 105, 711, 200);
		//Pour que le texte soit aligné au milieu
		StyledDocument doc = jtpTexteCrédits.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		jpInfoCrédits.add(jtpTexteCrédits);
        
        
		//Menu Principal
		
		//Bouton Nouvelle Partie
		JButton jbNouvellePartie = new JButton("Nouvelle partie");
		jbNouvellePartie.setForeground(Color.ORANGE);
		jbNouvellePartie.setBounds(250, 99, 248, 43);
		jbNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbNouvellePartie.setFocusable(false);
		jbNouvellePartie.setFont(new Font("Eurostile", Font.PLAIN, 30));
		jbNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfAccueil.getContentPane().removeAll();//enleve le contenue de frame1
				jfAccueil.revalidate();//valide les elements supprimer de frame1
				jfAccueil.repaint();//affiche frame1 avec rien
				jfAccueil.getContentPane().add(jpTitreNouvellePartie, BorderLayout.NORTH);
				jfAccueil.getContentPane().add(jpOptions, BorderLayout.CENTER);
				jfAccueil.revalidate();
				jfAccueil.repaint();
			}
		});
		jpBoutonsMenu.add(jbNouvellePartie);
		
		//Bouton Règles
		JButton jbRègles = new JButton("Règles du jeu");
		jbRègles.setForeground(Color.ORANGE);
		jbRègles.setBounds(250, 154, 248, 43);
		jbRègles.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbRègles.setFocusable(false); //enleve le carré en pointiller dégeulasse
		jbRègles.setFont(new Font("Eurostile", Font.PLAIN, 30));
		jbRègles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfAccueil.getContentPane().removeAll();                
				jfAccueil.revalidate();
				jfAccueil.repaint(); 
				jfAccueil.getContentPane().add(jpTitreRègles, BorderLayout.NORTH);
				jfAccueil.getContentPane().add(jpRègles, BorderLayout.CENTER);
				jfAccueil.revalidate();
				jfAccueil.repaint(); 
			}
		});
		jpBoutonsMenu.add(jbRègles);
		
		//Bouton Crédits
		JButton jbCrédits = new JButton("Crédits");
		jbCrédits.setForeground(Color.ORANGE);
		jbCrédits.setBounds(250, 209, 248, 43);
		jbCrédits.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbCrédits.setFocusable(false); //enleve le carré en pointiller dégeulasse
		jbCrédits.setFont(new Font("Eurostile", Font.PLAIN, 30));
		jbCrédits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfAccueil.getContentPane().removeAll();
				jfAccueil.revalidate();
				jfAccueil.repaint();
				jfAccueil.getContentPane().add(jpZoneTitreCrédits, BorderLayout.NORTH);
				jfAccueil.getContentPane().add(jpInfoCrédits, BorderLayout.CENTER);
				jfAccueil.revalidate();
				jfAccueil.repaint();
			}
		});
		jpBoutonsMenu.add(jbCrédits);
		
		//Bouton Quitter
		JButton jbQuitter = new JButton("Quitter");
		jbQuitter.setForeground(Color.ORANGE);
		jbQuitter.setFont(new Font("Eurostile", Font.PLAIN, 30));
		jbQuitter.setFocusable(false);
		jbQuitter.setAlignmentX(0.5f);
		jbQuitter.setBounds(250, 264, 248, 43);
		jbQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfAccueil.dispose();
				System.exit(0);
			}
		});
		jpBoutonsMenu.add(jbQuitter);
		
		jfAccueil.setVisible(true);
	}
	
	public boolean frame_menu() {
		return estActive;
	}
	
	public int nbBot() {
		return this.nbBot;
	}
	
	public String getMode2jeu() {
		return this.mode2jeu;
	}
}
