CREATE TABLE `system_user` (
  `userID` integer UNIQUE PRIMARY KEY NOT NULL,
  `eEmail` varchar(62) NOT NULL,
  `ePassword` varchar(256) NOT NULL,
  `eFirstName` varchar(50) NOT NULL,
  `eLastName` varchar(50) NOT NULL,
  `role` shortInt(1) NOT NULL
);

CREATE TABLE `workplace` (
  `workplaceID` integer PRIMARY KEY NOT NULL,
  `e_workplace_nickname` varchar(255),
  `e_store_number` integer,
  `e_phone_number` integer(10) NOT NULL,
  `e_addressLineOne` varchar(255) NOT NULL,
  `e_addressLineTwo` varchar(255),
  `e_city` varchar(255) NOT NULL,
  `e_state` varchar(15) NOT NULL,
  `e_zipCode` int(5) NOT NULL
);

CREATE TABLE `user_workplace` (
  `userID` integer UNIQUE NOT NULL,
  `workplaceID` integer NOT NULL,
  PRIMARY KEY (`userID`, `workplaceID`)
);

CREATE TABLE `union_card` (
  `workerID` integer NOT NULL,
  `workplaceID` integer NOT NULL,
  `e_signDate` integer(8) NOT NULL,
  `e_union_card_document` varbinary NOT NULL,
  PRIMARY KEY (`workerID`, `workplaceID`)
);

CREATE TABLE `worker` (
  `workerID` integer PRIMARY KEY NOT NULL,
  `e_address` varchar(255),
  `e_shiftWorked` varbyte(1),
  `ocManaging` integer,
  `isCurrentEmployee` shortInt(1),
  `notes` varchar(255)
);

CREATE TABLE `admin_staffWorkers` (
  `adminID` integer PRIMARY KEY NOT NULL,
  `staffID` integer NOT NULL
);

CREATE TABLE `staff_workspaces` (
  `staffID` integer PRIMARY KEY NOT NULL,
  `workplaceID` integer NOT NULL
);

CREATE TABLE `ipLoginAttempts` (
  `e_ip6Address` integer PRIMARY KEY NOT NULL,
  `loginAttempts` shortInt(1)
);

ALTER TABLE `user_workplace` ADD FOREIGN KEY (`workplaceID`) REFERENCES `workplace` (`workplaceID`);

ALTER TABLE `union_card` ADD FOREIGN KEY (`workplaceID`) REFERENCES `workplace` (`workplaceID`);

ALTER TABLE `union_card` ADD FOREIGN KEY (`workerID`) REFERENCES `system_user` (`userID`);

ALTER TABLE `worker` ADD FOREIGN KEY (`workerID`) REFERENCES `system_user` (`userID`);

ALTER TABLE `worker` ADD FOREIGN KEY (`ocManaging`) REFERENCES `system_user` (`userID`);

ALTER TABLE `admin_staffWorkers` ADD FOREIGN KEY (`adminID`) REFERENCES `system_user` (`userID`);

ALTER TABLE `admin_staffWorkers` ADD FOREIGN KEY (`staffID`) REFERENCES `system_user` (`userID`);

ALTER TABLE `staff_workspaces` ADD FOREIGN KEY (`staffID`) REFERENCES `system_user` (`userID`);

ALTER TABLE `staff_workspaces` ADD FOREIGN KEY (`workplaceID`) REFERENCES `workplace` (`workplaceID`);

ALTER TABLE `user_workplace` ADD FOREIGN KEY (`userID`) REFERENCES `system_user` (`userID`);
