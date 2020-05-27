#This command will remove old logs
echo "Removing old Logs"
rm -r logs/*

echo "Downloading dependancies before running test"
#This command will download all the required maven dependancy and runs your project.
docker run -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8 mvn clean verify