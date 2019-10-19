#Objectif

C'est toujours difficile de se motiver pour aller à la salle de sport mais depuis quelques mois, vous avez trouvé une formule gagnante. Vous y allez après le boulot avec un collègue hyper motivé et qui vous pousse à ne rater aucune séance.

Manque de chance, ce soir il est malade. Vous pensiez avoir une bonne excuse pour esquiver, mais c'est raté. Votre collègue vous supplie de vous y rendre car il a oublié son porte-monnaie dans son casier la veille.

Les casiers sont protégés par un mot de passe numérique. Votre collègue, un peu parano, ne veut pas vous écrire le mot de passe par message mais il vous donne deux indications :
*- Un intervalle [A,B] et un nombre D
*- Il vous garantit que le mot de passe est le premier nombre divisible par D dans cet intervalle

L'intervalle est inclusif ce qui signifie que le mot de passe peut être la borne inférieure ou la borne supérieure.

Vous devez déterminer le mot de passe du casier.

##Format des données

###Entrée

Ligne 1 : un entier A compris entre 10 et 10 000 représentant la borne inférieure de l'intervalle.
Ligne 2 : un entier compris entre A+1 et 10 001 représentant la borne supérieure de l'intervalle.
Ligne 3 : un entier D compris entre 1 et 1 000 représentant un diviseur du mot de passe.

###Sortie

Un entier correspondant au mot de passe du casier.