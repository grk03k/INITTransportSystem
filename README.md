InitTransportService

## Deployment Process:

1. Login to AWS Console
2. Set up MySQL Database in AWS cloud using AWS RDS
3. Connect to MYSQL Database with MySQL workbench to verify the connectivity
4. Execute the below script for creating tables in the database 
5. Clone Spring boot applicaiton source code from GitHub
6. Update applicaiton .properties file to change DAtabase MySQL URL proprty
7. Package spring boot applicaiton as JAR file
8. Deploye Spring boot JAR file on AWS using Elastic benastalk service
9. Test REST APIs using Postman client

## Execute the below script for creating tables in the database

CREATE TABLE transportDB.drivers (
  driver_id int(11) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (driver_id)
);

CREATE TABLE transportDB.vehicles (
  vehicle_id int(11) NOT NULL,
  driver_id int(11) NOT NULL,
  PRIMARY KEY (vehicle_id),
  KEY VEHICLE_DRIVER_FK (driver_id),
  CONSTRAINT VEHICLE_DRIVER_FK FOREIGN KEY (driver_id) REFERENCES drivers (driver_id)
);

CREATE TABLE transportDB.routes (
  id int(11) NOT NULL AUTO_INCREMENT,
  end_time datetime DEFAULT NULL,
  route_id int(11) DEFAULT NULL,
  start_time datetime DEFAULT NULL,
  vehicle_id int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY ROUTE_VEHICLE_FK (vehicle_id),
  CONSTRAINT ROUTE_VEHICLE_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id)
) ;

CREATE TABLE transportDB.hibernate_sequence (
  next_val bigint(20) DEFAULT NULL
) ;


## Test Data
insert into Drivers(driver_id,first_name,last_name) values(1,'test1','test2'); 
insert into Drivers(driver_id,first_name,last_name) values(2,'test2','test2'); 
insert into Drivers(driver_id,first_name,last_name) values(3,'test3','test2'); 
insert into Drivers(driver_id,first_name,last_name) values(4,'test4','test2'); 
insert into vehicles(vehicle_id,driver_id) values(1,1);
insert into vehicles(vehicle_id,driver_id) values(2,2);
insert into vehicles(vehicle_id,driver_id) values(3,3);
insert into vehicles(vehicle_id,driver_id) values(4,4);
insert into vehicles(vehicle_id,driver_id) values(5,1);
insert into vehicles(vehicle_id,driver_id) values(6,1);
insert into routes(id,route_id,vehicle_id,start_time,end_time) values(1,1,1,'2022-03-01 00:00:01','2022-03-01 00:10:01');
insert into routes(id,route_id,vehicle_id,start_time,end_time) values(2,1,2,'2022-03-01 00:00:01','2022-03-01 00:10:02');
insert into routes(id,route_id,vehicle_id,start_time,end_time) values(3,1,3,'2022-03-01 00:00:01','2022-03-01 00:10:03');
insert into routes(id,route_id,vehicle_id,start_time,end_time) values(4,1,1,'2022-04-01 00:00:01','2022-04-01 00:10:01');
insert into routes(id,route_id,vehicle_id,start_time,end_time) values(5,1,4,'2022-05-01 00:00:01',null);

##Sample test
http://localhost:8080/api/routes/1/DriverDetails?time=01-MAY-2022 00:08:01