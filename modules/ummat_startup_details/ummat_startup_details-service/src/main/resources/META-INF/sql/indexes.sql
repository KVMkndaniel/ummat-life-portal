create index IX_E8B88DD8 on TNUMMAT_MatriUser (area[$COLUMN_LENGTH:75$]);
create index IX_768ABEC5 on TNUMMAT_MatriUser (districtName[$COLUMN_LENGTH:75$], area[$COLUMN_LENGTH:75$]);
create index IX_CC61B077 on TNUMMAT_MatriUser (userId, companyId);
create index IX_55AEDBFD on TNUMMAT_MatriUser (uuid_[$COLUMN_LENGTH:75$]);