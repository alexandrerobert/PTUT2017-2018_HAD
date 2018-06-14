# Télécharge l'image docker d'Ubuntu
FROM ubuntu:latest

# Met à jour la liste des packages et installe l'openJDK, le JRE et wget
RUN apt-get update && apt-get install git openjdk-8-jre openjdk-8-jdk zip wget -y

# Télécharge Glassfish et l'installe
RUN wget http://download.java.net/glassfish/4.1.1/release/glassfish-4.1.1.zip
RUN apt-get install -y && unzip glassfish-4.1.1.zip

######### RUN cd /usr/local/glassfish/domains/domain1/autodeploy/


#/glassfish4/glassfish/domains/domain1
#Log File: /glassfish4/glassfish/domains/domain1/logs/server.log
ADD MavenWebHADBPMN-1.0-SNAPSHOT.war /usr/local/glassfish/domains/domain1/autodeploy/
# COPY ./Maven/MavenWebAppHADBPM-1.0-SNAPSHOT.war /usr/local/glassfish/domains/domain1/autodeploy/


#RUN cd /home/app
#ADD ./Docker/HCO.owl

# Permet de bridger les port http, https et d'administration glassfish
EXPOSE 8080 443 4848

# Lance le serveur glassfish
#ENTRYPOINT ["glassfish4/bin/asadmin","start-domain", "&&", "top","-B"]
#RUN glassfish4/bin/asadmin start-domain

# Permet de faire fonctionner le conteneur en 
ENTRYPOINT glassfish4/bin/asadmin start-domain && glassfish4/bin/asadmin set --user admin server.jms-service.jms-host.default_JMS_host.admin-password=admin && exec top -b
