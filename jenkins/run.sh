docker build -f jenkins -t "jenkins:1" .

docker run -d -p 8080:8080 jenkins:1