#Objectif

Une très célèbre firme internationale de fabrication de pâtisseries industrielles a décidé d'organiser un jeu concours. Le ticket gagnant est glissé à l'intérieur d'un sachet plastique de chocolatines. Les chocolatines sont horodatées. Chaque paquet indique sa date précise de péremption à l'aide d'un nombre représentant le nombre de microsecondes qui se sont écoulées depuis le 1er Janvier 1900 (c'est précis, on ne rigole pas avec les chocolatines). Vous avez vos informations, et vous savez de manière sûre que le ticket se trouve dans un paquet dont la somme des chiffres itérée de l'horodatage est égal à 42.

Pour obtenir la somme des chiffres itérée d'un entier strictement supérieur à 99, par exemple 10412412, on somme ses chiffres: 1+0+4+1+2+4+1+2 = 15, puis on reprend la somme de ses chiffres et ainsi de suite jusqu'à qu'on ait un nombre d'au maximum deux chiffres, en l'occurrence: 15 n'a que deux chiffres, donc la somme des chiffres itérée de 10412412 est 15. Si l'entier est inférieur ou égal à 99, la somme itérée est égale à l'entier.

Un stage de 3 semaines dans l'entreprise, renouvelable, sera offert à l'heureux gagnant, vous décidez donc de mettre toutes les chances de votre côté en achetant tous les sachets respectant cette contrainte !

Données

Entrée

Ligne 1 : un entier N compris entre 1 et 1000 représentant le nombre de sachets achetés.
Lignes 2 à N+1 : le timestamp de la date de péremption tel qu'écrit sur l'emballage d'un sachet, sous forme d'un entier inférieur ou égal à 2^32

Sortie

Le nombre de sachets qui ont une chance de contenir le ticket gagnant.

Exemple

Entrée

6
1571220869
1571320869
1570424270
1570220869
1570420870
1570420869

Sortie

2

Entrée

1
42

Sortie

1
