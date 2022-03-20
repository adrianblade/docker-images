FROM jenkins/jenkins:lts-jdk11

RUN /usr/local/bin/install-plugins.sh git
RUN /usr/local/bin/install-plugins.sh matrix-auth 
RUN /usr/local/bin/install-plugins.sh workflow-aggregator
RUN /usr/local/bin/install-plugins.sh workflow-job
#RUN /usr/local/bin/install-plugins.sh docker-workflow
#RUN /usr/local/bin/install-plugins.sh blueocean
RUN /usr/local/bin/install-plugins.sh credentials-binding
RUN /usr/local/bin/install-plugins.sh job-dsl
#RUN /usr/local/bin/install-plugins.sh greenballs
#RUN /usr/local/bin/install-plugins.sh kubernetes

#JAVA 17 installation
COPY jdk-17_linux-x64_bin.tar.gz /tmp/jdk-17_linux-x64_bin.tar.gz
ARG JAVA_HOME_NAME=java-17-oracle

# Install Java.
#RUN \
#  mkdir -p /tmp/share/jvm/$JAVA_HOME_NAME && \
#  tar -C /tmp/share/jvm/$JAVA_HOME_NAME --strip-components=1 -xvf /tmp/jdk-17_linux-x64_bin.tar.gz

ENV JENKINS_USER admin
ENV JENKINS_PASS admin

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY create-credential.groovy /usr/share/jenkins/ref/init.groovy.d/
# COPY create-freestyle.groovy /usr/share/jenkins/ref/init.groovy.d/
# COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY jdk-install.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY configure-job-dsl-security.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY execute-dsl-from-local-script.groovy /usr/share/jenkins/ref/init.groovy.d/

VOLUME /var/jenkins_home

USER jenkins
