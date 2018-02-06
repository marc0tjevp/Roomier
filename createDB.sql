USE roomier;

CREATE TABLE User (
	UserName varchar(255) NOT NULL,
	PasswordHash varchar(256) NOT NULL,
	Password varchar(256) NOT NULL,
	Email varchar(255) NOT NULL,
	PRIMARY KEY(UserName)
);

CREATE TABLE Task (
TaskID varchar(255) NOT NULL,
TaskName varchar(255) NOT NULL,
ClaimedBy varchar(255),
TaskCompleted bit DEFAULT 0 NOT NULL,
CreateDate Date NOT NULL,
CompletedDate Date,
PRIMARY KEY(TaskID),
FOREIGN KEY(ClaimedBy) REFERENCES User(UserName)
); 

CREATE TABLE Product (
	ProductID varchar(255) NOT NULL,
	ProductName varchar(255) NOT NULL,
	Amount int DEFAULT 0 NOT NULL,
	MinAmount int DEFAULT 0 NOT NULL,
	CreateTask bit DEFAULT 0 NOT NULL,
	PRIMARY KEY(ProductID)
);

CREATE TABLE Event (
	EventID varchar(255) NOT NULL,
	EventName varchar(255) NOT NULL,
	StartTime Time NOT NULL,
	EndTime Time NOT NULL,
	EventDate Date NOT NULL,
	ConfirmationStatus bit DEFAULT 0 NOT NULL,
	CreatedBy varchar(255) NOT NULL,
	PRIMARY KEY(EventID),
	FOREIGN KEY(CreatedBy) REFERENCES User(UserName)
);

CREATE TABLE Event_User (
	EventID varchar(255) NOT NULL,
	UserName varchar(255)roomier NOT NULL,
	Accepted bit NOT NULL,
	PRIMARY KEY(EventID, UserName),
	FOREIGN KEY(EventID) REFERENCES Event(EventID),
	FOREIGN KEY(UserName) REFERENCES User(UserName)
);
	