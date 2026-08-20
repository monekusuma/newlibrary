def gitDownload(repo) {
    git "https://github.com/IntelliqDevops/${repo}.git"
}

def buildArtifact() {
    sh "mvn package"
}

def deployToTomcat(ip, context) {
    sh "scp ${WORKSPACE}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war"
}

def runSelenium() {
    sh "java -jar ${WORKSPACE}/testing.jar"
}

