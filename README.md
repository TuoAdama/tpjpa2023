# Configuration du back end SIR

## Configuration de la base de données

### Choix du persistence-unit
Dans le fichier src/main/java/dao/generic/EntityManagerHelper.java, remplacez le nom du persistance-unit "mysql" par "dev".

Lancez le serveur de base de données en executant la commande suivante en fonction de vôtre système d'exploitation.

#### Linux:
```
~ ./run-hsqldb-server.sh
```
#### Windows:
```
~ ./run-hsqldb-server.bat
```