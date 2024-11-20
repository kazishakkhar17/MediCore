create database medicore;
use medicore;

CREATE TABLE login (
    login_id INT AUTO_INCREMENT PRIMARY KEY, -- Numeric primary key
    id VARCHAR(20) NOT NULL UNIQUE, -- Username or login ID
    password VARCHAR(20) NOT NULL -- Password field
);

INSERT INTO login (id, password) VALUES ('kazi', '123456');
select* from login;

create table patient_info(ID varchar(20),Number varchar(40), Name varchar(20), Gender varchar(20), Patient_Disease varchar(20), Room_Number varchar(20),Time varchar(100),Deposite varchar(20),Edu_Department_Name varchar(5));
select * from patient_info;
DELETE FROM patient_info;


create table Room(room_no varchar(20),Availability varchar(20), Price varchar(20),Room_Type varchar(100));
select * from Room;

INSERT INTO Room VALUES("100", "Available", "500", "G Bed 1");
INSERT INTO Room VALUES("101", "Available", "500", "G Bed 2");
INSERT INTO Room VALUES("102", "Available", "500", "G Bed 3");
INSERT INTO Room VALUES("103", "Available", "500", "G Bed 4");
INSERT INTO Room VALUES("200", "Available", "1500", "Private Room");
INSERT INTO Room VALUES("201", "Available", "1500", "Private Room");
INSERT INTO Room VALUES("202", "Available", "1500", "Private Room");
INSERT INTO Room VALUES("203", "Available", "1500", "Private Room");
INSERT INTO Room VALUES("300", "Available", "3500", "ICU Bed 1");
INSERT INTO Room VALUES("301", "Available", "3500", "ICU Bed 2");
INSERT INTO Room VALUES("302", "Available", "3500", "ICU Bed 3");
INSERT INTO Room VALUES("303", "Available", "3500", "ICU Bed 4");
INSERT INTO Room VALUES("304", "Available", "3500", "ICU Bed 5");
INSERT INTO Room VALUES("305", "Available", "3500", "ICU Bed 6");

DELETE from room;

UPDATE Room
SET Availability = 'Available'
WHERE Availability = 'Occupied';


CREATE TABLE Educational_Department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL UNIQUE,
    department_head VARCHAR(50)
);
ALTER TABLE Department RENAME TO Educational_Department;
ALTER TABLE patient_info
ADD COLUMN Medical_Department_Name varchar(50);


INSERT INTO Educational_Department (department_name, department_head)
VALUES
    ('MPE', 'Mr. X'),
    ('EEE', 'Ms. Y'),
    ('CEE', 'Dr. Z'),
    ('CSE', 'Prof. A'),
    ('BTM', 'Mr. B'),
    ('TVE', 'Ms. C');

select * from Educational_Department;

CREATE TABLE Medical_department (
    medical_department_id INT PRIMARY KEY AUTO_INCREMENT,
    medi_dept_name VARCHAR(100),
    phone_no VARCHAR(20)
);
CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_name VARCHAR(100),
    medical_department_id INT,
    specialization VARCHAR(100),
    phone VARCHAR(20),
    FOREIGN KEY (medical_department_id) REFERENCES Medical_department(medical_department_id)
);




INSERT INTO Medical_department (medi_dept_name, phone_no) VALUES
    ('General Medicine', '111-222-3333'),
    ('Surgery', '222-333-4444'),
    ('Pediatrics & Obstetrics', '333-444-5555'),
    ('Emergency & Critical Care', '444-555-6666'),
    ('Mental Health', '555-666-7777');

INSERT INTO Doctor (doctor_name, medical_department_id, specialization, phone) VALUES
    ('Dr. John Doe', 1, 'Internal Medicine', '111-222-3333'),        -- General Medicine
    ('Dr. Mark Taylor', 2, 'General Surgeon', '222-333-4444'),       -- Surgery
    ('Dr. Emma Brown', 3, 'Pediatrician', '333-444-5555'),           -- Pediatrics & Obstetrics
    ('Dr. Liam Black', 4, 'Trauma Surgeon', '444-555-6666'),         -- Emergency & Critical Care
    ('Dr. Noah Blue', 5, 'Psychiatrist', '555-666-7777');


 DROP TABLE IF EXISTS department;

CREATE TABLE EMP_INFO (
    Employee_id INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Phone_Number VARCHAR(15),
    Salary DECIMAL(10, 2),
    Gmail VARCHAR(100)
);


INSERT INTO EMP_INFO (Employee_id, Name, Age, Phone_Number, Salary, Gmail)
VALUES
    (101, 'John Doe', 30, '1234567890', 50000.00, 'john.doe@gmail.com'),
    (102, 'Jane Smith', 28, '0987654321', 60000.00, 'jane.smith@gmail.com');

select * from EMP_INFO;

CREATE TABLE appointment (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,  -- Unique identifier for each appointment
    patient_id VARCHAR(20),                         -- References patient_info.ID
    patient_name VARCHAR(100),                      -- Name of the patient
    patient_disease VARCHAR(100),                   -- Patient's disease
    department_name VARCHAR(100),                   -- References medical_department.medi_dept_name
    doctor_name VARCHAR(100),                       -- References doctor.doctor_name
    doctor_specialization VARCHAR(100),             -- Doctor's specialization
    doctor_phone VARCHAR(20),                       -- Doctor's phone number
    appointment_time DATETIME                       -- Time of the appointment
);

select * from appointment;


Create table ambulence

SELECT
    p.ID, p.Name, p.Patient_Disease, md.medi_dept_name,
    d.doctor_name, d.specialization, d.phone, NOW()appointmentTimeappointment_time
FROM
    patient_info p
JOIN
    medical_department md ON p.Medical_Department_Name = md.medi_dept_name
JOIN
    doctor d ON md.medical_department_id = d.medical_department_id;

SELECT * FROM papatient_infotient_info;
SELECT * FROM medical_department;
SELECT * FROM doctor;
select * from appointment;
DELETE FROM appointment;
ALTER TABLE appointment
MODIFY COLUMN appointment_time VARCHAR(100);
ALTER TABLE appointment ADD UNIQUE (patient_id);
SHOW INDEX FROM appointment;
ALTER TABLE appointment DROP INDEX patient_id;
ALTER TABLE appointment MODIFY COLUMN patient_id VARCHAR(20);
ALTER TABLE patient_info ADD UNIQUE (Number);


Create table Ambulance(
ambulance_id INT PRIMARY KEY AUTO_INCREMENT,
Name varchar(20),
Gender varchar(20),
Car_name varchar(20),
Available varchar(20),
Location varchar(20)
);

insert into Ambulance values("1","Driver1","Male","Zen","Available","area 16");
SELECT * FROM Ambulance;









