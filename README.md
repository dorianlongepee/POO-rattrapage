> Code de base fourni par **David Guillin** que je remercie !

Repository dans le but de comparer mes changements par rapport au code de David, et voici un bref résumé de mon travail :

## Todo pour rattrapage

- [x] Jouer au jeu de Memory avec un jeu de tarot en mode console
- [ ] Jouer au jeu du Memory avec un jeu de tarot sous JavaFX
- [x] Jouer au jeu du Plus ou Moins avec un jeu de tarot sous JavaFX

## Problèmes encontrés

+ Le jeu de Memory fourni par David (sous JFX) est compliqué à comprendre car beaucoup de valeurs en dur (+ cartes pas mélangées), je n'ai pas eu le temps de refactoriser ça pour l'adapter aux cartes du tarot

### Caveats

Pour lancer le programme, il faut exécuter la méthode main de la classe GameController située à l'adresse suivante
(comportement à refactoriser dans l'idéal) :
```
games/Memory/controller/GameController.java
```

/!\ J'ai travaillé sous IntelliJ, j'ai fait un export pour eclipse mais si vous avez des problèmes pour importer le projet, ça peut être ça.