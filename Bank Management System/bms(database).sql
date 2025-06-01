CREATE DATABASE bank_management_system2;
USE bank_management_system2;

CREATE TABLE MainTable (
    cardno VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    fName VARCHAR(100),
    dob DATE,
    state VARCHAR(50),
    city VARCHAR(50),
    address VARCHAR(255),
    email VARCHAR(100),
    gender VARCHAR(10),
    marital VARCHAR(15),
    pin VARCHAR(10),
    bal DECIMAL(10,2)
);

select * from MainTable;

CREATE TABLE PersonalLoan (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no VARCHAR(20) NOT NULL,
    loan_amount DECIMAL(12, 2) NOT NULL,
    installment DECIMAL(10, 2) NOT NULL,
    repay_months INT NOT NULL,
    timestamp DATETIME NOT NULL
);

select * from PersonalLoan;

CREATE TABLE ConsumerLoan (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no VARCHAR(20) NOT NULL,
    loan_amount DECIMAL(12,2) NOT NULL,
    installment DECIMAL(10,2) NOT NULL,
    product VARCHAR(50) NOT NULL,
    repay_months INT NOT NULL,
    timestamp DATETIME NOT NULL
);

select * from ConsumerLoan;

CREATE TABLE BusinessLoan (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no VARCHAR(20) NOT NULL,
    loan_amount DECIMAL(12,2) NOT NULL,
    installment DECIMAL(10,2) NOT NULL,
    repay_months INT NOT NULL,
    timestamp DATETIME NOT NULL
);

select * from BusinessLoan;

CREATE TABLE creditcard (
    accno VARCHAR(20) PRIMARY KEY,           -- Account/Card number (unique)
    jobtitle VARCHAR(100),                   -- Job Title or Business
    emptype VARCHAR(50),                     -- Employment type (e.g., Salaried, Businessman)
    income DECIMAL(15,2),                    -- Monthly Net Income
    selectcredit VARCHAR (100) ,            -- Credit Limit (amount)
    fine VARCHAR(100),                       -- Fine description (e.g., "Rs. 2000 over one month")
    cardname VARCHAR(50)                     -- Card type (e.g., Gold, Platinum)
);
select * from creditcard;
drop table creditcard;

CREATE TABLE SavingPlan (
    acc_no VARCHAR(20) NOT NULL,
    total_saving DOUBLE NOT NULL,
    monthly_installment DOUBLE NOT NULL,
    plan_duration VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (acc_no) REFERENCES MainTable(cardno)
);

drop table SavingPlan;

select * from SavingPlan;

CREATE TABLE transfer_details (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) NOT NULL,        -- Sender card number
    account_name VARCHAR(100) NOT NULL,         -- Sender name
    recipient_number VARCHAR(20) NOT NULL,      -- Receiver card number
    recipient_name VARCHAR(100) NOT NULL,       -- Receiver name
    transfer_amount DECIMAL(12, 2) NOT NULL,    -- Transferred amount
    date_time DATETIME DEFAULT CURRENT_TIMESTAMP,  -- Timestamp of transaction
    
    FOREIGN KEY (account_number) REFERENCES MainTable(cardno),
    FOREIGN KEY (recipient_number) REFERENCES MainTable(cardno)
);

select * from transfer_details;