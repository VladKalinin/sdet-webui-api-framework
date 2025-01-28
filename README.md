# SDET automation framework

## Please note:
- This project is demonstration of skills
- UI part relates to [APPLE](https://www.apple.com)
- API part relates ... __TBD__
- Project was done in test/portfolio purposes

### Run test locally via IDEA (JUnit configuration):
````
-ea
-Dcountry=us
-Ddevice=mobile
-Dcucumber.filter.tags=@{your tag}
-Dspring.profiles.active=mobile,us
-Dsuite=regression
-Dselenide.headless=false
````

### Run test via console/remotely
````
./gradlew clean remote -Dcountry=us -Ddevice=mobile -Dspring.profiles.active=mobile,us -Dsuite=regression -Dthreads=3
````