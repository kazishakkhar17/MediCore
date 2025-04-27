create database medicore;
use medicore;

CREATE TABLE login (
    login_id INT AUTO_INCREMENT PRIMARY KEY, -- Numeric primary key
    id VARCHAR(20) NOT NULL UNIQUE, -- Username or login ID
    password VARCHAR(20) NOT NULL -- Password field
);
ALTER TABLE login MODIFY password VARCHAR(255);

INSERT INTO login (id, password) VALUES ('kazi', '123456');
select* from login;

create table patient_info(ID varchar(20),Number varchar(40), Name varchar(20), Gender varchar(20), Patient_Disease varchar(20), Room_Number varchar(20),Time varchar(100),Deposite varchar(20),Edu_Department_Name varchar(5));
select * from patient_info;
ALTER TABLE patient_info DROP COLUMN Status;
describe patient_info;
ALTER TABLE Patient_Info
MODIFY COLUMN Number VARCHAR(255) NOT NULL;







SET SQL_SAFE_UPDATES = 0;

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




UPDATE Room
SET Availability = 'Available'
WHERE Availability = 'Occupied';

DROP TABLE IF EXISTS Educational_Department;

CREATE TABLE Educational_Department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL UNIQUE,
    department_head VARCHAR(50),
    department_email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO Educational_Department (department_name, department_head, department_email)
VALUES
    ('MPE', 'Mr. X', 'mpe@iut-dhaka.edu'),
    ('EEE', 'Ms. Y', 'eee@iut-dhaka.edu'),
    ('CEE', 'Dr. Z', 'cee@iut-dhaka.edu'),
    ('CSE', 'Prof. A', 'cse@iut-dhaka.edu'),
    ('BTM', 'Mr. B', 'btm@iut-dhaka.edu'),
    ('TVE', 'Ms. C', 'tve@iut-dhaka.edu');



ALTER TABLE Department RENAME TO Educational_Department;
ALTER TABLE patient_info
ADD COLUMN Medical_Department_Name varchar(50);




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

DELETE FROM appointment
WHERE appointment_time IN (
    SELECT appointment_time FROM (
        SELECT appointment_time FROM appointment ORDER BY appointment_time DESC LIMIT 2
    ) AS temp
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

DROP TABLE IF EXISTS Notification;



CREATE TABLE Notification (
    notification_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(100),
    educational_department_name VARCHAR(100),
    department_head_name VARCHAR(100),
    department_email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);





--Trigger--
DELIMITER $$

CREATE TRIGGER notify_on_patient_insert
AFTER INSERT ON patient_info
FOR EACH ROW
BEGIN
    DECLARE dept_name VARCHAR(100);
    DECLARE dept_head_name VARCHAR(100);
    DECLARE dept_email VARCHAR(100);

    -- Get department head info based on Educational_Department
    SELECT department_name, department_head, department_email
    INTO dept_name, dept_head_name, dept_email
    FROM Educational_Department
    WHERE department_name = NEW.Edu_Department_Name
    LIMIT 1;

    -- Insert notification
    INSERT INTO Notification (
        patient_name,
        educational_department_name,
        department_head_name,
        department_email
    )
    VALUES (
        NEW.Name,
        dept_name,
        dept_head_name,
        dept_email
    );
END$$

DELIMITER ;

delete from discharge_info;
CREATE TABLE discharge_info (
    Discharge_ID INT AUTO_INCREMENT PRIMARY KEY,
    ID VARCHAR(20),
    Number VARCHAR(40),
    Name VARCHAR(20),
    Gender VARCHAR(20),
    Patient_Disease VARCHAR(20),
    Room_Number VARCHAR(20),
    Time VARCHAR(100),
    Deposite VARCHAR(20),
    Edu_Department_Name VARCHAR(5),
    Medical_Department_Name VARCHAR(50),
    Discharge_Time DATETIME
);
select* from dischlogindischarge_infodischarge_infodischarge_infodischarge_infodischarge_infodischarge_infoarge_info;
DELIMITER //

CREATE TRIGGER after_patient_delete
AFTER DELETE ON patient_info
FOR EACH ROW
BEGIN
    INSERT INTO discharge_info (
        ID,
        Number,
        Name,
        Gender,
        Patient_Disease,
        Room_Number,
        Time,
        Deposite,
        Edu_Department_Name,
        Medical_Department_Name,
        Discharge_Time
    )
    VALUES (
        OLD.ID,
        OLD.Number,
        OLD.Name,
        OLD.Gender,
        OLD.Patient_Disease,
        OLD.Room_Number,
        OLD.Time,
        OLD.Deposite,
        OLD.Edu_Department_Name,
        OLD.Medical_Department_Name,
        NOW()
    );
END;
//

DELIMITER ;
DROP PROCEDURE IF EXISTS generate_discharge_reports;

---cursor---
DELIMITER //

CREATE PROCEDURE generate_discharge_reports()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE patient_id INT;
    DECLARE patient_name VARCHAR(100);
    DECLARE disease VARCHAR(100);
    DECLARE room_number VARCHAR(100);
    DECLARE discharge_time DATETIME;

    -- Declare cursor
    DECLARE patient_cursor CURSOR FOR
        SELECT ID, Name, Patient_Disease, Room_Number, Discharge_Time
        FROM discharge_info;

    -- Declare continue handler
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Open the cursor
    OPEN patient_cursor;

    -- Loop through the rows
    read_loop: LOOP
        FETCH patient_cursor INTO patient_id, patient_name, disease, room_number, discharge_time;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Process the patient data

        SELECT CONCAT('Patient ID: ', patient_id, ', Name: ', patient_name, ', Disease: ', disease,
                       ', Room: ', room_number, ', Discharge Time: ', discharge_time);
    END LOOP;

    -- Close the cursor
    CLOSE patient_cursor;
END //

DELIMITER ;

















