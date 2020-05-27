#This command will remove old logs
echo "Removing old Logs"
rm -r logs/*

echo "Running test directly by using existing cached maven dependancies"
#This command will use your cached maven dependancy so that you dont have to download dependency every time you run the project.
docker run -it --rm -v "$PWD":/usr/src/mymaven -v "$HOME/.m2":/root/.m2 -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8 mvn clean verify