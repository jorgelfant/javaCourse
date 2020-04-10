package j_ligneCommande;

public class A_theorie {
    /*
    Le terminal est une des applications les plus importantes de votre ordinateur.

    En effet, le terminal vous permet d’agir sur les différents dossiers et fichiers de votre ordinateur de façon
    simple et rapide. Vous serez donc amené à l’utiliser régulièrement lors de votre carrière.

    D'une certaine façon, le terminal est l'ancêtre de programmes comme l'explorateur Windows ou Finder (sous Mac).

    Eh bien, entre autres choses, le terminal sert à :

    naviguer dans une arborescence de fichiers ;

    créer, supprimer et déplacer des dossiers et des fichiers ;

    lancer des programmes.

    « Console », « terminal », « ligne de commande », « term », tous ces mots sont des synonymes pour désigner
    la même chose. Dans la suite du cours, l'un ou l'autre de ces termes seront utilisés indifféremment.

    Si vous êtes sous Windows, accéder à un terminal sera un peu plus complexe, car celui-ci n’est pas disponible
    de base et doit être installé préalablement au cours.

    Pour ceci, je vous propose deux options :

    "Cygwin", que vous pouvez télécharger et installer en suivant les instructions du site officiel (en anglais) ;

    le shell Bash pour Windows, que vous pouvez installer en suivant les instructions officielles de Microsoft (en français).

    Windows possède deux utilitaires directement inspiré du terminal, mais qui ne sont pas des terminaux même si visuellement, ils sont très proches :

    L'invite de commande (appelée aussi fenêtre de commande DOS).

    Le powershell (présent sur les Windows les plus récents et qui accepte des commandes plus proches de ce que propose
    le terminal)

    Ces deux programmes ont le même but que le terminal et la même philosophie, mais les commandes acceptés par le terminal
    ne fonctionneront pas nécessairement avec ces deux programmes, ce pourquoi il est vivement conseillé pour ce cours
    d'installer un vrai terminal avec Cygwin ou le shell Bash pour Windows.

    Commençons avec la commande « pwd», qui signifie en réalité « Print Working Directory » (ou, en français, «
    afficher le répertoire de travail »). Avouez que « pwd » est tout de même plus rapide à écrire ! 🙂

    La commande pwd demande au terminal d’indiquer l’endroit où vous vous trouvez dans l’arborescence de fichiers.
    Dans mon cas, , « /cygdrive/c/OpenClassrooms » indique que je me trouve dans le dossier « OpenClassrooms»,
    situé dans à la racine de mon disque C.

    La plupart des instructions de la ligne de commande prennent en compte des “paramètres” (ou “arguments”) qui vont
    venir “compléter” l’instruction et modifier son comportement.

Par exemple, avec pwd. Au lieu de taper simplement l’instruction “pwd", vous allez rajouter le paramètre “--help”.
Cette commande avec l’argument --help n’affiche plus le répertoire dans lequel vous vous trouvez, mais l’aide associée
à la commande.

La commande ls (qui est le raccourci pour "list" en anglais) permet de lister le contenu d'un répertoire. Essayons-la.

Cependant, dans le terminal, vous ne voyez que les noms des éléments présents dans le dossier. Il est difficile de savoir si ce sont des dossiers ou des fichiers (les extensions comme .txt ou .png sont des indices, certes, mais il est tout à fait possible de créer des fichiers sans extensions ou des répertoires qui en possèdent une, ce n’est donc pas fiable).
De plus, il existe des fichiers et des dossiers “cachés” que vous ne voyez pas avec la commande “ls” de base.
Pour remédier à ces problèmes, vous pouvez ajouter deux paramètres à la commande ls :

-l : ce paramètre précise à la commande ls d’afficher plus d’informations sur chacun des éléments présents ;

-a : ce paramètre indique que tous les dossiers et fichiers devront apparaître, y compris les dossiers et fichiers cachés.

Il est également possible de combiner ces deux commandes. Cela s’écrira ls -l -a ou plus simplement : ls -la

drwx------ 1 root root  512 Dec  8 14:24 .
drwxr-xr-x 1 root root  512 Dec  8 14:16 ..
-rw------- 1 root root   36 Dec  8 14:23 .bash_history
-rw-r--r-- 1 root root 3106 Apr  9  2018 .bashrc
drwx------ 1 root root  512 Dec  8 14:24 .config
-rw-r--r-- 1 root root  148 Aug 17  2015 .profile

Chaque ligne possède beaucoup d’informations. Vous pouvez par exemple repérer que chaque ligne commence par un
“d” ou un “-”. Lorsque la ligne commence par un “d”, pour “directory”, cela signifie que l’élément correspondant
est un dossier. Sinon, c’est un fichier.

drwx------ 1 root root  512 Dec  8 14:24 .
drwxr-xr-x 1 root root  512 Dec  8 14:16 ..

Ces deux éléments sont en réalité des dossiers cachés, présents dans  les répertoires, et aux propriétés un peu
particulières :

“.” : ce dossier désigne toujours le répertoire dans lequel on se trouve. Autrement dit, si “pwd” vous dit que vous
êtes dans /cygdrive/c/OpenClassrooms, alors le terminal remplacera automatiquement “.” par “/cygdrive/c/OpenClassrooms” ;

“..” : ce dossier désigne toujours le répertoire parent (c’est-à-dire le dossier qui contient le dossier dans lequel
vous êtes actuellement).

Par exemple, si vous êtes dans “/cygdrive/c/OpenClassrooms”, le répertoire parent est : “/cygdrive/c”.

************************************************************************************************************************
Vous allez découvrir différentes options de la commande ls.

ls nomDuRepertoire

Commençons par ls nom du répertoire. Vous savez désormais afficher le contenu du répertoire courant, mais comment
faire pour afficher le contenu d’un autre répertoire ?  Eh bien, vous pouvez utiliser la commande ls nomdurepertoire.

Par exemple ici, si je tape ls 2019, le contenu du répertoire 2019 va s’afficher.

********************************************************************************
ls ..
Découvrons maintenant ls ..

‘..’ quant à lui est un dossier caché qui correspond toujours au répertoire parent. Donc ls .. va afficher le contenu
du répertoire parent.

Dans notre exemple, nous sommes dans le dossier OpenClassrooms du disque C. Le dossier dans lequel se trouve
"OpenClassrooms” est directement le disque C. Donc ls .. va afficher le contenu de mon disque C.

root@DESKTOP-H37IHSM:~# ls ..
bin  boot  dev  etc  home  init  lib  lib64  media  mnt  opt  proc  root  run  sbin  snap  srv  sys  tmp  usr  var

*********************************************************************************
ls - la répertoire
Et bien sûr, tous les paramètres peuvent être combinés. 😱

ls -la 2019 va afficher le contenu du répertoire “2019”, avec les dossiers et fichiers cachés (option “a”) et sous
forme de liste détaillée (option “l”).

**********************************************************************************
Si vous souhaitez lister le contenu d'un dossier dont le nom contient un espace comme « mon dossier » cela peut poser
des problèmes, car la commande « ls » croira que vous cherchez à lister le contenu deux dossiers distincts : "mon" et "dossier".

Pour afficher le contenu d’un dossier dont le nom contient un espace, vous pouvez utiliser des guillemets :

ls "2019/récit de vacances"   car non  ls 2019 récit de vacances

*********************************************************************************

Maintenant que vous savez afficher ce qui se trouve dans un répertoire donné, voyons comment vous rendre dans ce
même répertoire.

Pour cela, la commande « cd », pour « Change Directory » (« changer de répertoire », en français) vous permettra
de naviguer d'un répertoire à l'autre.

Le fonctionnement est très simple, il suffit de taper “cd” suivi du répertoire de destination.

Par exemple en tapant “cd 2019”, je vais me rendre dans mon répertoire appelé “2019”.

Il peut parfois être un peu fastidieux de retaper à la main toutes ces commandes. Mais heureusement pour vous,
il existe un certain nombre de « raccourcis » pour éviter de le faire :

la flèche haut et la flèche bas permettent de naviguer dans l'historique du terminal et de relancer des commandes
déjà tapées précédemment ;

tabpermet de faire de l'autocomplétion, c’est-à-dire compléter automatiquement une commande ou un chemin si on a
commencé à en taper le début. Si plusieurs options sont disponibles, taper une deuxième fois sur cette touche
affichera la liste des options possibles ;

ctrl + r: cette combinaison permet de faire une recherche dans l'historique des commandes. Faites d’abord ctrl+r
pour passer en mode “recherche”, puis tapez une partie de la commande que vous voulez rejouer. Lorsque votre recherche
a porté ses fruits, vous n’avez plus qu’à valider en appuyant sur Entrée;

ctrl + aet ctrl + e : ces deux combinaison permettent respectivement d'aller automatiquement au tout début ou à la
toute fin de la ligne de commande que vous êtes en train de taper, ce qui peut être pratique lorsque vous êtes en
train d'écrire une commande particulièrement longue.

*************************************************************************************

mkdir est la contraction de “make directory”, c’est-à-dire “Créer un répertoire”, en français.

a syntaxe de mkdir est simple : il suffit de taper "mkdir" suivi du nom du répertoire que l'on désire créer.
Par exemple, si je tape “mkdir test”, cela créera un répertoire appelé “test” à l’endroit où je me trouve :

Dans l’exemple ci-dessus, j’ai commencé par un ls pour voir l’ensemble des dossiers et fichiers présents, puis j’ai
créé un nouveau répertoire appelé “test” et j’ai enfin exécuté un second “ls” pour vérifier que mon nouveau répertoire
a bien été créé.
************************************************************************************

Si vous voulez créer un dossier dont le nom possède un espace, par exemple “mon dossier”, la première idée est
simplement d’écrire “mkdir mon dossier”.

Vous pouvez constater que deux dossiers ont été créés. Le premier s'appelle “dossier” et le second “mon”.

En effet, le terminal considère l’espace comme un séparateur entre deux dossiers, alors que “mon dossier”,
est en réalité le nom complet.

La façon la plus simple de faire est d’entourer le nom du dossier avec des guillemets.

mkdir "mon dossier"

L’autre manière de faire est “d’échapper” le caractère espace, c’est-à-dire d’indiquer au terminal que l’espace
en question n’est pas un séparateur mais doit se comporter comme une “lettre” normale. Le caractère d'échappement
s’appelle un “antislash” (ou backslash) : \.
mkdir "my test 3"
OU
mkdir my\ test\ 3

****************************************************************************************

Vous savez désormais créer des dossiers, mais comment créer des fichiers ? Eh bien, exactement de la même manière
que pour créer un dossier, mais avec une autre commande.

Cette fois-ci, vous allez utiliser touch, avec la même syntaxe, c'est-à-dire : touch nomDuNouveauFichier.

Par exemple, pour créer un fichier appelé fichier.txt, il suffira de taper : touch fichier.txt

touch "un fichier de texte.txt"

touch monfichier.txt

************************************************************************************************************************
                                       Manipulez des éléments sur votre ordinateur
************************************************************************************************************************

Maintenant que vous savez vous repérer avec le terminal et même créer des dossiers et fichiers, il est temps
d’apprendre à les déplacer, à les copier et à les supprimer


Déplacez du contenu avec mv
***************************

Pour déplacer un fichier, la commande à utiliser est mv pour “move”, déplacer, en français. La syntaxe sera donc :

mv elementADeplacer destination.

mv bonjour bonsoir       ### pour renommer le fichier/répertoire "bonjour" en "bonsoir"

mv bonsoir ~/Desktop  ### déplace le fichier "bonsoir" du répertoire courant vers le répertoire ~/Desktop sans le renommer

mv bonsoir ~/Desktop/bonnenuit ###déplace le fichier "bonsoir" du répertoire courant vers le répertoire ~/Desktop et le renomme en
                             bonnenuit (bien sûr bonnenuit n'existait pas dans le répertoire ~/Desktop sinon le système vous
                             demandera la confirmation pour écraser l'ancien fichier)

man mv            ### pour avoir les options de mv

**********************************************************************************************
Et si je veux faire l’opération inverse et remettre le fichier “fichier.txt” là où il était ?
**********************************************************************************************
gracias al punto le decimos que mueva el archivo al dossier en cours

jorgelu@DESKTOP-H37IHSM:~/test/aTester$ mv test/da.txt .
mv: cannot stat 'test/da.txt': No such file or directory

jorgelu@DESKTOP-H37IHSM:~/test/aTester$ mv ../test/da.txt .
mv: cannot stat '../test/da.txt': Not a directory

jorgelu@DESKTOP-H37IHSM:~/test/aTester$ mv ../da.txt .
jorgelu@DESKTOP-H37IHSM:~/test/aTester$ ls
da.txt
jorgelu@DESKTOP-H37IHSM:~/test/aTester$ cd ..
jorgelu@DESKTOP-H37IHSM:~/test$ ls
aTester  holita.txt  test  testo
jorgelu@DESKTOP-H37IHSM:~/test$


************************************************************************************************************************
                                              Découvrez les wildcards
************************************************************************************************************************

Vous savez désormais déplacer du contenu, mais comment s’y prendre si on veut déplacer beaucoup de fichiers d’un coup ?

Il est possible de retaper “mv” pour chaque fichier, mais si vous avez une centaine de fichiers à déplacer, vous risquez
de vous ennuyer assez vite :-).

C’est pour cette raison que l’on a créé des “wildcards” ou “jokers”. Ce sont des caractères qui “remplacent” une partie
du nom d’un fichier.

Il en existe plusieurs, mais le plus connu d’entre eux est probablement le caractère *. Ce caractère peut être utilisé
comme substitut pour n’importe quelle autre chaîne de caractères dans une recherche.

la c*    tous les éléments qui commence par c
la *a    tous les éléments qui se terminent par a


Dans ce nouvel exemple, je suis dans mon répertoire test, qui contient plusieurs sous-répertoires et fichiers
(dossier, fichier.txt, mon, ‘second  test’, ‘troisième test’, ‘un fichier avec espace.txt').

Parmi eux, le répertoire appelé “dossier” ne contient rien du tout.

Lorsque je fais mv * dossier, je demande au terminal de déplacer (mv) tout ce qui correspond à * (c’est-à-dire, absolument tout !)
dans le répertoire “dossier”.

Notez le message d’erreur qui apparaît, car il est impossible de déplacer un répertoire à l’intérieur de lui-même. 😃

Cependant, tous les autres éléments ont bien été copiés à l’intérieur du répertoire “dossier”. Si vous tapez la commande
ls, vous pouvez vérifier qu’il n’y a plus que le répertoire “dossier” dans le répertoire courant, et que les autres éléments ont bien été déplacés.



jorgelu@DESKTOP-H37IHSM:~/test$ ls
aTester  holita.txt  test  testo

jorgelu@DESKTOP-H37IHSM:~/test$ mv * testo
mv: cannot move 'testo' to a subdirectory of itself, 'testo/testo'

jorgelu@DESKTOP-H37IHSM:~/test$ ls
testo

jorgelu@DESKTOP-H37IHSM:~/test$ cd testo
jorgelu@DESKTOP-H37IHSM:~/test/testo$ ls

aTester  holita.txt  test  toc
jorgelu@DESKTOP-H37IHSM:~/test/testo$


************************************************************************************************************************
                                            Copiez du contenu avec cp
************************************************************************************************************************
Pour copier du contenu, nous allons procéder exactement de la même manière que ce que nous avons fait pour la commande mv,
mais avec la commande “cp”.

La syntaxe pour copier un élément est cp elementACopier destination.

Par exemple pour copier le fichier “fichier.txt” dans le répertoire “dossier” :

jorgelu@DESKTOP-H37IHSM:~/test$ cp tic.txt  ../
jorgelu@DESKTOP-H37IHSM:~/test$ ls
testo  tic.txt
jorgelu@DESKTOP-H37IHSM:~/test$ cd ..
jorgelu@DESKTOP-H37IHSM:~$ ls
 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   tic.txt
jorgelu@DESKTOP-H37IHSM:~$


Second exemple : pour copier le fichier “fichier.txt” dans le même répertoire, mais avec un nouveau nom, ici “fichier2.txt”.

cp fichier.txt fichier2.txt

************************************************************************************************************************
                                            la copie d’un répertoire
************************************************************************************************************************

Notez le message d'erreur :

cp -r not specified

Celui-ci est apparu parce que j'ai tenté de faire la copie directement, comme je l'aurais fait pour un fichier.
Cependant, le terminal a ici indiqué qu’il manquait l’option “-r”.

En effet, copier un répertoire signifie copier également les éventuels sous-répertoires et fichiers qu’il contient,
ce qui peut concerner potentiellement beaucoup de fichiers (imaginez que vous copiez le répertoire "Windows", par exemple...).

Le terminal demande donc une confirmation avec l’option -r (r pour “récursif” qui signifie au terminal qu’il va devoir
aller à l’intérieur du dossier, et des sous-dossiers, et ainsi de suite).

jorgelu@DESKTOP-H37IHSM:~$ ls
 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   tic.txt

jorgelu@DESKTOP-H37IHSM:~$ cp test test2
cp: -r not specified; omitting directory 'test'

jorgelu@DESKTOP-H37IHSM:~$ cp test/ test2
cp: -r not specified; omitting directory 'test/'

jorgelu@DESKTOP-H37IHSM:~$ cp -r test/ test2

*CA MARCHE*
jorgelu@DESKTOP-H37IHSM:~$ ls
 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   test2   tic.txt
jorgelu@DESKTOP-H37IHSM:~$

OU

jorgelu@DESKTOP-H37IHSM:~$ cp -r test test3
jorgelu@DESKTOP-H37IHSM:~$ ls
 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   test2   test3   tic.txt
jorgelu@DESKTOP-H37IHSM:~$

************************************************************************************************************************
                                        Supprimez des fichiers et des répertoires avec rm
************************************************************************************************************************
Dernier point et pas des moindres, la suppression.

La suppression se fait avec rm, remove, qui signifie tout simplement “supprimer”, en français.

Soyez vigilant avec cette commande car elle supprime du contenu ! N'hésitez pas à faire vos tests dans un répertoire
à part pour plus de sécurité.

La syntaxe de rm est très simple : rm elementASupprimer. Par exemple, pour supprimer le fichier “fichier2.txt” je n’ai
qu’à écrire rm fichier2.txt.

Et avec ls nous avons vérifié que ce fichier a bien été supprimé.

Essayons maintenant de supprimer un répertoire. Ici, je tente de supprimer le répertoire “dossierCopie”.

 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   test2   test3
jorgelu@DESKTOP-H37IHSM:~$ rm test3
rm: cannot remove 'test3': Is a directory

jorgelu@DESKTOP-H37IHSM:~$ rm -r test3
jorgelu@DESKTOP-H37IHSM:~$ ls
 Desktop  'my test'  'my test 3'   mytest2   mytest3   test   test2
jorgelu@DESKTOP-H37IHSM:~$

Comme pour ce que nous avons vu avec cp, supprimer un répertoire signifie également supprimer ses éventuels
sous-répertoires et fichiers. Par mesure de sécurité, la commande rm exige que l’on précise que l’on veut réellement
supprimer le dossier et tout ce qu’il contient.

Pour cela, c’est la même option à utiliser, -r.

Ce qui donne au final : rm -r dossierCopie.

************************************************************************************************************************
                              Allez plus loin avec de nouvelles commandes
************************************************************************************************************************

Dans ce dernier chapitre, nous allons nous éloigner de la simple manipulation de dossiers et fichiers via le terminal
pour explorer d’autres possibilités.

Affichez le manuel d’une commande avec man
...........................................

La commande “man” affiche l’aide associée à une commande. Pour cela, il suffit de taper man commande.

Par exemple pour afficher l’aide de la commande pwd, on tapera man pwd :

man pwd   esto daria    man es manual



PWD(1)                                              User Commands                                              PWD(1)

NAME
       pwd - print name of current/working directory

SYNOPSIS
       pwd [OPTION]...

DESCRIPTION
       Print the full filename of the current working directory.

       -L, --logical
              use PWD from environment, even if it contains symlinks

       -P, --physical
              avoid all symlinks

       --help display this help and exit

       --version
              output version information and exit

       If no option is specified, -P is assumed.

       NOTE: your shell may have its own version of pwd, which usually supersedes the version described here.  Please
       refer to your shell's documentation for details about the options it supports.

AUTHOR
       Written by Jim Meyering.
 Manual page pwd(1) line 1 (press h for help or q to quit)

************************************************************************************************************************

Comme vous pouvez le constater, l’écran entier a été remplacé par l’aide de la commande pwd.

Pour naviguer dans cette aide, vous pouvez utiliser flèche haut et flèche bas. Et pour sortir de cette aide, vous
pouvez taper sur la touche q (q pour pour "quitter").

En cas de doute sur le fonctionnement d’une commande, ou pour connaître l’ensemble des options disponibles, man sera
votre meilleur allié.

Si vous tapez “man ls” vous verrez qu’il existe de nombreuses autres options que nous n’avons pas explorées. Et vous
pouvez même taper “man man” pour avoir l’aide de man :-).

Pour naviguer dans cette aide, vous pouvez utiliser flèche haut et flèche bas. Et pour sortir de cette aide, vous
pouvez taper sur la touche q (q pour pour "quitter").

En cas de doute sur le fonctionnement d’une commande, ou pour connaître l’ensemble des options disponibles, man sera
votre meilleur allié.

Si vous tapez “man ls” vous verrez qu’il existe de nombreuses autres options que nous n’avons pas explorées. Et vous
pouvez même taper “man man” pour avoir l’aide de man :-).

************************************************************************************************************************
                              Utilisez cat, less et more pour connaître le contenu d’un fichier
************************************************************************************************************************

Nous savons comment connaître le contenu d’un répertoire avec ls, mais comment connaître le contenu d’un fichier ?

Pour cela il existe cat, less et more.

Ces trois commandes ont le même but, à savoir afficher le contenu d’un fichier.

Par exemple, si je veux afficher le contenu du fichier “fichier.txt”, je vais taper cat fichier.txt.

************
cat tic.txt
 hola mundo
************
Le contenu du fichier s’affiche tel quel dans le terminal.

Pour “less”, la différence, c’est que cet affichage va être “paginé”. C’est-à-dire qu’au lieu d’afficher le contenu
directement sous la commande, le terminal va utiliser le même mode de visualisation qu’avec la commande “man”.

Ainsi, si le fichier est très long, vous pourrez naviguer dedans à l’aide de flèche haut et flèche bas,
et pour quitter, là encore, il suffira de taper q.

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ less test.txt

hola viste funciona !
test.txt (END)


More est une ancienne version de “less”, avec des options navigation en moins. Je précise cependant son existence ici,
car il est encore très répandu.

************************************************************************************************************************
                                           Découvrez les redirections
************************************************************************************************************************
Ce qui suit n’est pas réellement une commande mais une “redirection”.

Il en existe plusieurs types, mais nous ne verrons ici que la plus commune : “>”.

Une redirection consiste à prendre la “sortie” d’une commande (par exemple pour “ls”, la sortie est tout simplement :
afficher la liste des répertoires à l’écran) et à la rediriger vers autre chose, ici vers un fichier.

L’intérêt est notamment de pouvoir garder une trace des commandes que l’on a pu faire, en enregistrant leur résultat
dans un fichier pour s’en resservir plus tard.

Voici un exemple simple pour mieux comprendre :


JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ ls -l >test.txt

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ cat text.txt
cat: text.txt: No such file or directory

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ cat test.txt
total 46
drwxr-xr-x 1 JORGE 197121    0 Dec  8 12:18 A SAUVER/
-rw-r--r-- 1 JORGE 197121  234 Dec  2 21:04 Assassin's Creed Odyssey.url
-rwxr-xr-x 1 JORGE 197121 2177 Dec  8 11:39 Atom.lnk*
-rw-r--r-- 1 JORGE 197121  282 Nov 30 21:14 desktop.ini
-rw-r--r-- 1 JORGE 197121  642 Dec  8 11:40 hola.java
drwxr-xr-x 1 JORGE 197121    0 Dec  8 10:26 JAVA ENTERPRISE/
drwxr-xr-x 1 JORGE 197121    0 Dec  8 11:11 javaSystem/
drwxr-xr-x 1 JORGE 197121    0 Dec  7 14:02 JSP - Proyecto de carrito de compras/
-rwxr-xr-x 1 JORGE 197121 1450 Nov 30 20:01 Microsoft Edge.lnk*
drwxr-xr-x 1 JORGE 197121    0 Dec  8 10:27 Pour Jorge2/
-rwxr-xr-x 1 JORGE 197121 2097 Nov 30 20:48 Splash.lnk*
-rw-r--r-- 1 JORGE 197121    0 Dec  8 17:28 test.txt
-rwxr-xr-x 1 JORGE 197121 1274 Nov 30 21:28 Uplay.lnk*



************************************************************************************************************************
                                          Appréhendez grep
************************************************************************************************************************

La dernière commande que nous allons voir dans ce chapitre est grep.

Grep sert à chercher des éléments à l’intérieur d’un fichier sans même avoir besoin de les ouvrir.

La syntaxe est : grep ceQueVousVoulezChercher làOùVousVoulezChercher

Par exemple, si vous voulez afficher toutes les lignes qui contiennent le mot “Cours” dans le fichier liste.txt,
il faudra taper grep Cours liste.txt

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop

$ grep hola.java test.txt
-rw-r--r-- 1 JORGE 197121  642 Dec  8 11:40 hola.java

Et vous pouvez constater que hola.java s'est affiché à l'écran.

Si nous voulons chercher par exemple “txt” dans l’intégralité des fichiers du répertoire courant, alors la commande sera grep txt *.

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ grep * test.txt

grep: JAVA ENTERPRISE: Is a directory
grep: javaSystem: Is a directory
grep: JSP - Proyecto de carrito de compras: Is a directory
grep: Pour Jorge2: Is a directory
test.txt:drwxr-xr-x 1 JORGE 197121    0 Dec  8 12:18 A SAUVER/
test.txt:drwxr-xr-x 1 JORGE 197121    0 Dec  8 12:18 A SAUVER/

Ce qui s’est passé, c’est que grep a cherché la chaîne “txt” dans tous les éléments du répertoire courant un par
un (grâce à * que nous avons vu précédemment et qui permet de cibler l’ensemble des fichiers).

Comme grep fait ses recherches dans des fichiers, lorsqu’il rencontre un élément qui est un répertoire, il affiche
un message pour préciser que cet élément est un répertoire et qu'il ne peut donc pas vérifier si la chaîne se trouve
bien à l'intérieur.

Par exemple, ici, “2019”, "Cours1", "Cours2" et "test" sont un répertoire.

Lorsque grep rencontre des fichiers, il les vérifie et soit il reste silencieux quand il n'y a rien à l'intérieur qui
corresponde à la recherche (par exemple, le fichier "lorem.txt" ne contient pas, à l'intérieur, la chaîne "txt") soit
il affiche le contenu qui correspond (par exemple “liste.txt” contient trois lignes avec “txt” dedans, et ces lignes
sont bien affichées).

JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ grep txt *

grep: A SAUVER: Is a directory
grep: JAVA ENTERPRISE: Is a directory
grep: javaSystem: Is a directory
grep: JSP - Proyecto de carrito de compras: Is a directory
grep: Pour Jorge2: Is a directory
test.txt:-rw-r--r-- 1 JORGE 197121    0 Dec  8 17:28 test.txt

En résumé
*********
Dans ce chapitre, nous avons appris :

man pour afficher le manuel ;

cat/less/more pour afficher un contenu ;

la redirection “>” pour envoyer le résultat d’une commande à l’intérieur d’un fichier ;

grep pour faire des recherches.

*******************************************************************************************************
Lista | tipo de lo que se busca | contar los elementos


JORGE@DESKTOP-H37IHSM MINGW64 ~/Desktop
$ ls -l | grep .txt | wc -l
1

ls -l | grep jpg | wc -l
510

ls -l | grep jpg | wc -l > nb_jpg.txt
… et on peut aussi envoyer le fichier nb_jpg.txt sur Internet par FTP ou à un ami par e-mail, le tout en une ligne !

*******************************************************************************************************

Pour rappel, voici toutes les commandes que nous avons vues ensemble, tout au long de ce cours :

      pwd : permet d’afficher le répertoire courant ;

      ls : permet d’afficher le contenu d’un répertoire ;

      ls -a : l’option -a affiche également les fichiers et dossiers cachés,

      ls -l : l’option -l modifie l’affichage pour rajouter de nombreuses informations ;

      cd dossier : permet de se déplacer à l’intérieur d’un répertoire ;

      mkdir dossier : permet de créer un dossier ;

      touch nomFichier : permet de créer un fichier ;

      mv source destination : permet de déplacer des éléments ;

      * : est un caractère qui peut être utilisé comme substitut pour n’importe quel caractère dans une recherche ;

      cp source destination : permet de copier des éléments ;

      cp -r : l’option -r permet de copier un répertoire ;

      rm fichiers : permet de supprimer des fichiers ;

      rm -r dossiers : l’option -r permet de supprimer des répertoires ;

      man commande : permet d’afficher le manuel d’une commande ;

      cat/less/more nomFichier : permet d’afficher le contenu d’un fichier ;

      > : permet de rediriger le résultat d’une commande vers un fichier ;

      grep motif chemin : permet de faire des recherches dans des fichiers.

    */
}
