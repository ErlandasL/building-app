# Building App - Internship simple Full-Stack task
## Prerequisites
1. [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
2. [Node.js](https://nodejs.org/)
3. [maven](https://maven.apache.org/install.html)

OS X
```sh
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install git npm mvn
```

Ubuntu
```sh
sudo apt-get update -y
sudo apt-get install git npm maven -y
```

## Installation
```sh
git clone https://github.com/ErlandasL/building-app.git
```
Back-end
```sh
cd building-app/building-back/
mvn spring-boot:run
```
After running back-end open new terminal window to run front-end

Front-end 
```sh
cd building-app/building-front/
npm install
npm start
```

You can access website via http://localhost:3000

Swagger is running on http://localhost:8080/swagger-ui/

Database is running on http://localhost:8080/console login to database settings in application.properties file which is in building-back/src/main/resources/
