# Knockout
User time management app

Agile team DSM time tracker

#For Developers
###prerequisite:
You need to have java 16 version installed.

If you don't want to install java 16 then you can go for zip version.

Download the jdk 16 zip version from https://jdk.java.net/16/

Extract the files and export the below required param on the terminal which we work,
1. export the JRE params only for the terminal used for development as below,
Linux: export PATH=/c/Users/subhash/software/java/jdk-16.0.1/bin:$PATH
Windows: PATH C:\Users\subhash\software\java\jdk-16.0.1\bin
2. Also export the JAVA_HOME variable,
JAVA_HOME=jdk_home.
Ex. Linux JAVA_HOME=/c/Users/subhash/software/java/jdk-16.0.1/

###For Development
1. Navigate to project folder
2. Build the project and launch application using 'mvn clean javafx:run -Pdev' command

A
###For production build
1. Navigate to project folder
2. Build project - 'mvn clean install -Pprod'
3. The product will be created 'target/knockout-{version}.zip'

Note: launch the application using 'java --module-path lib/ --add-modules javafx.controls,javafx.fxml  -jar knockout-{version}.jar' command

   Linux: java --module-path lib/ --add-modules javafx.controls,javafx.fxml  -jar knockout-{version}.jar
   Windows: java --module-path lib/ --add-modules javafx.controls,javafx.fxml  -jar knockout-{version}.jar



#For User

###prerequisite:
1. Client machine should be installed with java 16
   
   If user don't want to install java 16 then they should download the zip version of java 16 and provide to the app during runtime as mentioned in upcoming steps.

2. Build the project using 'For production build' Steps and share the product zip file to the user.

###Steps to launch the app
1. Extract the product zip file
2. Create a short cut: Desktop --> right click --> new --> short cut
3. Brose the 'knockout.bat' from the extracted folder and at the end provide the 'java 16' folder

   {product_extracted_folder}\knockout-{version}\knockout.bat {java_16_folder}'

   Ex. 'C:\Users\subhash\knockout-{version}\knockout.bat C:\Users\subhash\Downloads\knockout-{version}\jdk-16.0.2'
4. Right click on the 'short cut' --> properties' --> Layout --> Width - 1 , Height - 1, Left - 2000, Top - 1000
5. Access the software by double clicking the shortcut.
