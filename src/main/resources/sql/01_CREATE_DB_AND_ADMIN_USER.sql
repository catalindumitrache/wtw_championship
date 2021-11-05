create database wtw_championship; -- Creates the new database
create user 'admin' identified by 'I41_+wqt)$33'; -- Creates the user
grant all on wtw_championship.* to 'admin'; -- Gives all privileges to the new user on the newly created database;

COMMIT;