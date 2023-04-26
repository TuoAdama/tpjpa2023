# Configuration du back end SIR

## Configuration de la base de données

### Choix du persistence-unit
Dans le fichier [EntityManagerHelper.java](src/main/java/dao/generic/EntityManagerHelper.java), remplacez le nom du persistance-unit "mysql" par "dev".

Lancez le serveur de base de données en executant la commande suivante en fonction de vôtre système d'exploitation.

#### Linux:
```shell
./run-hsqldb-server.sh
```
#### Windows:
```shell
 ./run-hsqldb-server.bat
```

Pour avoir une interface permettant d'afficher les structures de la table en base de données, executez la commande suivante:

#### Linux:
```shell
./show-hsqldb.sh
```

#### Windows:
```shell
./show-hsqldb.bat
```

## Lancement de l'application

Une fois le repo cloné, ouvrez le dans votre IDE favoris. Et lancez l'application !

## Tests des points endpoints

A la racine du projet, vous trouverez le [postman_requests.json](postman_requests.json) qui contient une collection de requêtes prêtes à être utilisées.