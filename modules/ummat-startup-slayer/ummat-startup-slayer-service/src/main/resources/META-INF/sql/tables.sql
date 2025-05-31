create table District (
	uuid_ VARCHAR(75) null,
	districtId LONG not null primary key,
	regionId LONG,
	name VARCHAR(75) null,
	active_ BOOLEAN,
	regionCode VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table Locality (
	uuid_ VARCHAR(75) null,
	localityId LONG not null primary key,
	regionId LONG,
	districtId LONG,
	name VARCHAR(75) null,
	active_ BOOLEAN,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table MatriImages (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dlEntryId LONG
);