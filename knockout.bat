@echo off

:: PATH C:\Users\subhash\software\java\jdk-16.0.1\bin

IF [%1]==[] (
     START /B java --module-path lib/ --add-modules javafx.controls,javafx.fxml  -jar knockout-1.0.2-SNAPSHOT.jar
) ELSE (
     START /B %1\bin\java.exe --module-path lib/ --add-modules javafx.controls,javafx.fxml  -jar knockout-1.0.2-SNAPSHOT.jar
)
powershell -window minimized -command ""
::timeout /t 10

exit