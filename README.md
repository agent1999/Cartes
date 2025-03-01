# Cartes

Un jeu vidéo de cartes original en Java suivant les principes du génie logiciel.

## Règles du jeu
        
Les joueurs doivent poser une carte/combinaison de cartes de valeur supérieure d'uniquement de 1 par rapport à la dernière carte posée/combinaison de cartes posée dans l'ordre suivant : 
- 3-4-5-6-7-8-9-10-Valet-Dame-Roi-As.

Le premier joueur d'un tour impose le rythme du jeu. En plus des simples, les combinaisons pour rendre le jeu stimulant sont :
- Les cartes 2 : Des cartes qui permettent de rejouer.
- Les séries : Des cartes qui se suivent par valeur. La série suivante doit avoir le même nombre de cartes et commencer par la valeur supérieur d'uniquement de 1 de la première carte de la série.
- Les doubles : Deux cartes de la même valeur.
- Les doubles séries : Même chose que les séries mais chaque carte de la série est en double.
- Les bombes à 3 : Trois cartes de la même valeur, elles brisent le rythme imposé par les simples, les séries, les doubles, et les doubles séries.
- Les bombes à 4 : Quatres cartes de la même valeur, elles brisent le rythme imposé par les simples, les séries, les doubles, les doubles séries, et les bombes à 3.

## Comment installer le jeu

- Ouvrir `Eclipse`.
- Sélectionner le dossier `Cartes` en tant que workspace et cliquer sur `Launch`
    - Si vous n'avez pas eu de fenêtre pour sélectionner le workspace, aller dans `File -> Switch Workspace -> Other`.
- Dans `Package Explorer`, cliquer sur `Create a Java project`.
- Décocher la case `Use default location` et mettre dans `Location` le chemin du dossier `src` et cliquer sur `Finish`.
- Dans `Package Explorer`, dérouler le dossier `src`, puis le dossier `main`, et enfin le dossier `test`.
- Ouvrir le fichier `TestCarteSimulation.java`.
- Appuyer sur le bouton vert avec un triangle blanc pour éxécuter le logiciel.

## Journal des modifications

### Version 1.1

- Mise à jour de l'arborescence et des chemins des fichiers.
- Mise à jour des positions des widgets.
- Suppression des effets sonores de victoire et de défaite.
- Suppression des options de stratégies.

### Version 1.0

- Sortie initiale.

## Crédits

- Merci à [Goboun](https://github.com/Goboun) et [Stefx300](https://github.com/Stefx300) pour avoir travailler avec moi.
