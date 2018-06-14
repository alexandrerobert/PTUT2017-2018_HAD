#!/bin/bash
# Se place au niveau du projet
cd ../MavenWebAppHADBPM/MavenWebAppHADBPM

# Créé le .war
mvn clean  install

# Déplace le .war créé dans le dossier Docker
cp $HOME/.m2/repository/com/mycompany/MavenWebAppHADBPM/1.0-SNAPSHOT/MavenWebAppHADBPM-1.0-SNAPSHOT.war ../../Docker/MavenWebHADBPMN-1.0-SNAPSHOT.war
