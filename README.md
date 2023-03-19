> Code de base fourni par **David Guillin** que je remercie !

Repository dans le but de comparer mes changements par rapport au code de David, et voici un bref résumé de mon travail :

## Todo pour rattrapage

- [x] Jouer au jeu de Memory avec un jeu de tarot en mode console
- [ ] Jouer au jeu du Memory avec un jeu de tarot sous JavaFX
- [x] Jouer au jeu du Plus ou Moins avec un jeu de tarot sous JavaFX

## Problèmes encontrés

+ Le jeu de Memory fourni par David (sous JFX) est compliqué à comprendre car beaucoup de valeurs en dur, l'image tarotcards.jpg fait office de fond et il crée des carrés noirs par dessus pour simuler les cartes retournées de ce que je comprends. J'ai essayé d'y intégrer les 2-3 lignes supplémentaires pour les cartes atouts, mais ce n'était que contourner le problème et bricoler, la refacto était complexe et confusante. J'ai donc préféré me focaliser sur le second jeu qui est le Plus ou Moins, qui lui est totalament fonctionnel.

### Caveats

Pour lancer le programme, il faut exécuter la méthode main de la classe GameController située à l'adresse suivante
(comportement à changer dans l'idéal) :
```
games/Memory/controller/GameController.java
```

/!\ J'ai travaillé sous IntelliJ, j'ai fait un export pour eclipse mais si vous avez des problèmes pour importer le projet, ça peut être ça.
