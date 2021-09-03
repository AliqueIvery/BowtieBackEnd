create table Role(id int AUTO_INCREMENT not null, name varchar(30) not null);
create table User(id int AUTO_INCREMENT not null, pword varchar(30) not null, roleId int, username varchar(30) not null, primary key (id), foreign key (roleId) references role(id));
insert into role  values (1,'admin'), (2,'user'), (3,'staff');
insert into user values (1,'test',1,'aivery'),(2,'test',2,'guest'), (3,'test',3,'employee');