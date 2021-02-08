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
    
   --  INSERT INTO rec.jobs
-- (date_published, description, email, ending_date, name, phoneno, starting_date, vacancy, job_platform_id, job_position_id, organization_id)
-- VALUES('2021-01-13', 'job deatils description', 'email1@email.com', '2021-01-23', 'manager', '7894561235', '2021-01-13', '1', 1, 1, 1);

--     INSERT INTO rec.jobs
-- (date_published, description, email, ending_date, name, phoneno, starting_date, vacancy, job_platform_id, job_position_id, organization_id)
-- VALUES('2021-01-13', 'job deatils description', 'email2@email.com', '2021-01-23', 'hr', '7894561235', '2021-01-13', '1', 1, 2, 1);
--     INSERT INTO rec.jobs
-- (date_published, description, email, ending_date, name, phoneno, starting_date, vacancy, job_platform_id, job_position_id, organization_id)
-- VALUES('2021-01-13', 'job deatils description', 'email3@email.com', '2021-01-23', 'team lead', '7894561235', '2021-01-13', '1', 1, 3, 1);
--     INSERT INTO rec.jobs
-- (date_published, description, email, ending_date, name, phoneno, starting_date, vacancy, job_platform_id, job_position_id, organization_id)
-- VALUES('2021-01-13', 'job deatils description', 'email4@email.com', '2021-01-23', 'scrum master', '7894561235', '2021-01-13', '1', 1, 4, 1);

-- INSERT INTO rec.job_position
-- (job_category, description, name)
-- VALUES('manager', 'this is description', 'manager');

-- INSERT INTO rec.job_position
-- (job_category, description, name)
-- VALUES('hr', 'this is description', 'hr');
-- INSERT INTO rec.job_position
-- (job_category, description, name)
-- VALUES('teamlead', 'this is description', 'teamlead');

-- INSERT INTO rec.job_position
-- (job_category, description, name)
-- VALUES('scrummaster', 'this is description', 'scrummaster');

-- INSERT INTO rec.job_platform
-- (platform_description, platform_name)
-- VALUES('facebook', 'this is platform');

-- INSERT INTO rec.organization
-- (org_description, org_name)
-- VALUES('this is org description', 'ODIGOTECH');

-- INSERT INTO rec.document
-- (document, last_update, name, url)
-- VALUES('doc1', '2021-01-01', 'New Document', 'http://localhost:8080/doc1');

-- INSERT INTO rec.document
-- (document, last_update, name, url)
-- VALUES('doc2', '2020-01-01', 'New Document', 'http://localhost:8080/doc2');

-- INSERT INTO rec.document
-- (document, last_update, name, url)
-- VALUES('doc3', '2020-03-03', 'New Document', 'http://localhost:8080/doc3');

-- INSERT INTO rec.document
-- (document, last_update, name, url)
-- VALUES('doc4', '2021-03-03', 'New Document', 'http://localhost:8080/doc4');

-- INSERT INTO rec.document
-- (document, last_update, name, url)
-- VALUES('doc5', '2020-05-05', 'New Document', 'http://localhost:8080/doc5');

-- INSERT INTO rec.application
-- (applied_date, education, experience, other_info, applicant_id, jobs_id)
-- VALUES('2020-02-02', 'B.Tech', '2', 'B.Tech Student', 1, 1);

-- INSERT INTO rec.application
-- (applied_date, education, experience, other_info, applicant_id, jobs_id)
-- VALUES('1999-04-06', 'M.Tech', '1', 'M.Tech Student', 2, 2);

-- INSERT INTO rec.application
-- (applied_date, education, experience, other_info, applicant_id, jobs_id)
-- VALUES('1998-01-03', 'Phd', '2', 'PHD Student', 3, 3);

-- INSERT INTO rec.application
-- (applied_date, education, experience, other_info, applicant_id, jobs_id)
-- VALUES('1997-05-07', 'Bsc', '3', 'Bsc Student', 4, 4);

-- INSERT INTO rec.application
-- (applied_date, education, experience, other_info, applicant_id, jobs_id)
-- VALUES('2021-01-01', 'MCA', '0', 'MCA Student', 5, 5);

