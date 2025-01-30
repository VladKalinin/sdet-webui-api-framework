# SDET Automation Framework

## Overview
This project is a demonstration of skills as an SDET (Software Development Engineer in Test). It showcases automation capabilities across UI and API testing, utilizing modern tools and frameworks.

### Key Features:
- **UI Testing**: Automation examples targeting the [APPLE](https://www.apple.com) website.
- **API Testing**: Examples showcasing robust API validations (details coming soon).
- **Integration with CI/CD**: GitHub Actions configured for seamless automated testing.

### Purpose:
This project is intended for portfolio and demonstration purposes only.

---

## Tech Stack
The framework is built using the following technologies:

- **Java**: Core programming language.
- **Gradle**: Build tool for dependency management and task execution.
- **Selenide**: Simplified browser automation for UI tests.
- **Spring Framework**: Dependency injection and application context management.
- **Rest Assured**: Simplified API testing.
- **JUnit**: Testing framework.
- **Cucumber**: BDD-style testing.
- **GitHub Actions**: Continuous Integration setup.

---

## How to Run Tests

### Locally via IntelliJ IDEA (JUnit Configuration):

To run tests locally using JUnit, configure the following JVM options:

```bash
-ea
-Dcountry=us
-Ddevice=mobile
-Dcucumber.filter.tags=@{your_tag}
-Dspring.profiles.active=mobile,us
-Dsuite=regression
-Dselenide.headless=false
```

### Via Console or Remotely:

To execute tests from the terminal or remotely, use the following command:

```bash
./gradlew clean remote \
  -Dcountry=us \
  -Ddevice=mobile \
  -Dspring.profiles.active=mobile,us \
  -Dsuite=regression \
  -Dthreads=3
```

---

## Future Improvements
- Add detailed examples for API testing.
- Enhance reporting mechanisms.
- Include cross-browser testing support.

---