INSERT INTO rec.user
(adhar, created_at, dob, email, first_name, last_name, status, updated_at)
VALUES('444444', CURRENT_TIMESTAMP, '1999-02-02', 'shiv@email.com', 'shiv', 'munda', 'Active', CURRENT_TIMESTAMP);

INSERT INTO rec.user(adhar, created_at, dob, email, first_name, last_name, status, updated_at)
	VALUES ('333333', CURRENT_TIMESTAMP, '1999-02-02', 'viswa@email.com', 'viswa', 'chand', 'Active', CURRENT_TIMESTAMP);

INSERT INTO rec.user
(adhar, created_at, dob, email, first_name, last_name, status, updated_at)
VALUES('555555', CURRENT_TIMESTAMP, '1999-02-02', 'umesh@email.com', 'umesh', 'katkum', 'Active', CURRENT_TIMESTAMP);

INSERT INTO rec.user
(adhar, created_at, dob, email, first_name, last_name, status, updated_at)
VALUES('666666', CURRENT_TIMESTAMP, '1999-02-02', 'swagata@email.com', 'swagata', 'mandal', 'Active', CURRENT_TIMESTAMP);

INSERT INTO rec.user
(adhar, created_at, dob, email, first_name, last_name, status, updated_at)
VALUES('888888', CURRENT_TIMESTAMP, '1999-02-02', 'madhu@email.com', 'madhusudan', 'gt', 'Active', CURRENT_TIMESTAMP);



 INSERT INTO rec.contact_model
(id, address_line1, address_line2, country, phone_no1, phone_no2, pincode, state, status)
VALUES( 1,'nakrekal', 'nakrekal', 'india', '99999999999', '888888888', 508211, 'TS', 'Active');

INSERT INTO rec.contact_model
(id,address_line1, address_line2, country, phone_no1, phone_no2, pincode, state, status)
VALUES(2,'kornul', 'kurnol', 'india', '999999999', '9999999999', 508222, 'AP', 'Selected');

INSERT INTO rec.contact_model
(id,address_line1, address_line2, country, phone_no1, phone_no2, pincode, state, status)
VALUES(3,'maharasta', 'maharasta', 'india', '999999999', '9999990000', '505050','Mharastra', 'Selected');

INSERT INTO rec.contact_model
(id,address_line1, address_line2, country, phone_no1, phone_no2, pincode, state, status)
VALUES(4,'Mumbai', 'mumbau', 'india', '8888888', '88888', 509211, 'Maharastra', 'Selected');

INSERT INTO rec.contact_model
(id,address_line1, address_line2, country, phone_no1, phone_no2, pincode, state, status)
VALUES(5,'Bengalore', 'Bengalore', 'india', '44444444', '4444444', 564000, 'Karnataka', 'Selected');

INSERT INTO rec.role(created_at, description, title, updated_at)
VALUES (CURRENT_TIMESTAMP, 'manager','role1', CURRENT_TIMESTAMP);

INSERT INTO rec.role(created_at, description, title, updated_at)
VALUES (CURRENT_TIMESTAMP, 'HR','role2', CURRENT_TIMESTAMP);
    
INSERT INTO rec.role(created_at, description, title, updated_at)
VALUES (CURRENT_TIMESTAMP, 'user','role3', CURRENT_TIMESTAMP);    

INSERT INTO rec.user_roles(
	users_id, roles_id)
	VALUES (1, 1);
 INSERT INTO rec.user_roles(
	users_id, roles_id)
	VALUES (2, 2);   
    INSERT INTO rec.user_roles(
	users_id, roles_id)
	VALUES (3, 3);