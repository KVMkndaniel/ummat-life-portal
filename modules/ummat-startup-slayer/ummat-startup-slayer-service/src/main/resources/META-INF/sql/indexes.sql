create index IX_B9F7BF29 on District (regionCode[$COLUMN_LENGTH:75$]);
create index IX_39BE5557 on District (regionId);
create index IX_A84A740 on District (uuid_[$COLUMN_LENGTH:75$]);

create index IX_BCBDA086 on Locality (districtId);
create index IX_899F1D0B on Locality (uuid_[$COLUMN_LENGTH:75$]);

create index IX_EBB640F on MatriImages (userId);
create unique index IX_BB965C4B on MatriImages (uuid_[$COLUMN_LENGTH:75$], groupId);