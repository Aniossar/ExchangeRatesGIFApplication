# ExchangeRates GIF Application
Application that compares today and yesterday RUB/USD rates and sends you suitable gif from GIPHY.COM.

Stack: Java, Spring Boot, Feign, Gradle.

To run the application:

1. Rename temp.application.properties to application.properties
2.Fill application.properties with your IDs to openexchangerates.org API and giphy.com API.
3. Type in terminal gradlew.bat bootRun
4. Go to http://localhost:9090/checkRate and enjoy.

Application provides you gif tagged «broke» in case of decreasing rate and gif tagged «rich» in case of increasing rate.
