
create table SYSTEM_USER (
	email varchar(62) NOT NULL,
    ePassword varchar(256) NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    workplaceID varchar(50) NOT NULL,
    isWorker boolean NOT NULL,
    isOrganizer boolean NOT NULL,
    isStaff boolean NOT NULL);
