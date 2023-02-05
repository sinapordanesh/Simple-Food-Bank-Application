
# Simple Food Bank Application


A simple food bank application that calculates the number of calories required for a family based on the number of men, women, and children, and recommends a hamper based on the available inventory


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


## Prerequisites

What things you need to install the software and how to install them:

Java Development Kit (JDK) 8 or higher
MySQL Server 5.7 or higher
## Installation

Follow these steps to install the application on your local machine:

Clone the repository: git clone https://github.com/sinapordanesh/Simple-Food-Bank-Application
Import the database schema: Log in to the MySQL server and import the foodbank.sql file located in the db directory.

Compile and run the application: Open a terminal, navigate to the project directory, and run the following command to compile and run the application: 

 ``` shell
javac -cp .:lib/mysql-connector-java-8.0.23.jar com/foodbank/src/*.java
```

```shell
java -cp .:lib/mysql-connector-java-8.0.23.jar com.foodbank.src.FoodBankMain
```

- All .jar files should be located lib former in the working directory.

- All test files are separated from program codes and located at com/foodbank/src/TestFiles
- To compile it successfully

- FoodBankMain.java is the file that contains main()

## Built With

- Java
- MySQL
- Spring Boot (The web version is not complete yet)
## Authors

- [Saman Pordanesh](https://www.linkedin.com/in/saman-pordanesh-8592ab211/)
- Jinsu Kwak
- Noureldin Amer


## License

[MIT](https://choosealicense.com/licenses/mit/)

