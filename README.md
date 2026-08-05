# Starbucks Selenium Automation Framework

A Java-based UI test automation framework for starbucks.com, built using Selenium WebDriver, TestNG, and the Page Object Model design pattern, with Jenkins CI/CD integration.

## 🛠️ Tech Stack
- **Language:** Java
- **Build Tool:** Maven
- **Test Framework:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** ExtentReports
- **CI/CD:** Jenkins
- **Data-Driven Testing:** Apache POI (Excel)

## 📁 Project Structure
src/
├── main/java/
│ ├── pages/ # Page Object classes
│ └── utils/ # ConfigReader, ExcelUtility, waits, etc.
├── test/java/
│ ├── tests/
│ │ ├── homepage/
│ │ ├── menu/
│ │ ├── auth/
│ │ └── ...
│ └── base/ # BaseTest (setup/teardown)
└── test/resources/
├── config.properties
└── testng.xml
