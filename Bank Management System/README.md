# Bank Management System (BMS)

A comprehensive Java-based desktop application for managing banking operations, built with Swing GUI and MySQL database integration.

## Overview

The Bank Management System is a desktop application that provides a complete banking solution with features including account management, loan processing, fund transfers, bill payments, and credit card services. The system is designed with a modern GUI interface and robust database connectivity.

## Features

### Core Banking Features
- **User Authentication**: Secure login system with account number and PIN verification
- **Account Management**: Complete account creation, balance inquiry, and account details viewing
- **Fund Transfers**: Inter-account money transfers with transaction logging
- **Deposit/Withdrawal**: Account balance management operations

### Loan Services
- **Personal Loans**: Apply for personal loans with income verification and installment calculations
- **Business Loans**: Business loan applications with turnover-based approval system
- **Consumer Loans**: Product-specific loans (Home, Car, Solar Panel, Fridge) with flexible repayment options

### Credit Card Services
- **Multiple Card Types**: Platinum, Gold, Pink, and Visa credit cards
- **Credit Application**: Employment-based credit card approval system
- **Credit Management**: View credit limits, fines, and card details

### Utility Services
- **Bill Payments**: Water, electricity, gas, and internet bill payment interface
- **Mobile Packages**: Various mobile service package offerings
- **Travel Tickets**: Travel booking and ticket reservation system
- **Saving Plans**: Long-term saving plan management

### Additional Features
- **Branchless Banking**: Digital banking services
- **Advance Salary**: Salary advance application system
- **Scheduled Transfers**: Automated fund transfer scheduling
- **Currency Conversion**: International transaction support
- **Transaction History**: Complete transaction logging and viewing

## Technology Stack

- **Frontend**: Java Swing (GUI)
- **Backend**: Java (Core Java)
- **Database**: MySQL
- **Database Connectivity**: JDBC
- **IDE**: NetBeans (build configuration included)

## Database Schema

The system uses MySQL database `bank_management_system2` with the following tables:

### MainTable
- `cardno` (VARCHAR, PRIMARY KEY): Account number
- `name`: Customer name
- `fName`: Father's name
- `dob`: Date of birth
- `state`, `city`, `address`: Address information
- `email`: Email address
- `gender`: Gender (male/female/other)
- `marital`: Marital status
- `pin`: Account PIN
- `bal`: Account balance

### Loan Tables
- **PersonalLoan**: Personal loan applications and details
- **BusinessLoan**: Business loan applications and details
- **ConsumerLoan**: Consumer loan applications with product specifications

### Credit Card Table
- **creditcard**: Credit card applications and details including employment info, income, credit limits, and card types

### Transaction Tables
- **transfer_details**: Fund transfer transaction logs
- **SavingPlan**: Saving plan details and management

## Installation and Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server
- NetBeans IDE (optional, for development)

### Database Setup
1. Install MySQL Server
2. Create database using the provided SQL file:
   ```sql
   CREATE DATABASE bank_management_system2;
   USE bank_management_system2;
   ```
3. Execute the SQL script from `bms(database).sql` to create all tables

### Application Setup
1. Clone or download the project
2. Update database connection details in `DataConnection.java`:
   ```java
   c = DriverManager.getConnection("jdbc:mysql:///bank_management_system2","root","your_password");
   ```
3. Compile and run the application:
   ```bash
   javac -cp "mysql-connector-java.jar:." src/bank/management/system/*.java
   java -cp "mysql-connector-java.jar:." bank.management.system.login
   ```

## Project Structure

```
Bank Management System/
├── src/
│   ├── bank/management/system/
│   │   ├── login.java                 # Main login interface
│   │   ├── SignupOne.java            # Account registration
│   │   ├── Facilities.java           # Main dashboard
│   │   ├── AccountDetails.java       # Account details viewer
│   │   ├── WithdrawDeposit.java      # Balance operations
│   │   ├── FundsTransfer1.java       # Fund transfer system
│   │   ├── PersonalLoan.java         # Personal loan application
│   │   ├── BusinessLoan.java         # Business loan application
│   │   ├── ConsumerLoan.java         # Consumer loan application
│   │   ├── CreditCard.java           # Credit card services
│   │   ├── Bills.java                # Utility bill payments
│   │   ├── AddMoney.java             # Account funding
│   │   ├── Details.java              # Service details viewer
│   │   ├── DataConnection.java       # Database connectivity
│   │   └── [Other service modules]
│   └── icons/                        # Application icons and images
├── build/                            # Compiled classes
├── bms(database).sql                # Database schema
├── build.xml                         # Ant build configuration
└── nbproject/                        # NetBeans project configuration
```

## Usage

### Getting Started
1. Launch the application by running `login.java`
2. For new users: Click "Sign up" to create an account
3. For existing users: Enter account number and PIN to login

### Main Features Usage
- **Account Management**: Use "Account Details" to view personal information and service details
- **Fund Transfers**: Navigate to "Fund Transaction" for inter-account transfers
- **Loan Applications**: Access loan services from the main dashboard
- **Credit Cards**: Apply for credit cards through the credit card section
- **Bill Payments**: Use "Branchless Banking" for utility bill payments

## Security Features

- PIN-based authentication system
- Account number validation
- Transaction logging and audit trails
- Secure database connections
- Input validation for all forms

## Development Notes

- The application uses Swing for GUI components
- Database operations are handled through JDBC
- Exception handling is implemented throughout the application
- The system supports multiple concurrent users
- All transactions are logged for audit purposes

## Future Enhancements

- Enhanced security features (encryption, two-factor authentication)
- Mobile application development
- API integration for real-time banking services
- Advanced reporting and analytics
- Multi-language support
- Enhanced user interface with modern design patterns

## Contributing

This is a standalone banking system project. For modifications or enhancements:
1. Ensure database compatibility
2. Test all banking operations thoroughly
3. Maintain transaction integrity
4. Follow Java coding standards

## License

This project is developed for educational and demonstration purposes. Please ensure compliance with local banking regulations before using in production environments.

## Support

For technical support or questions about the system implementation, refer to the source code documentation and database schema provided in the project files.
