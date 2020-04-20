-- user
insert into user_account (username, email, password)
    values ('user','user@appinfo.com','{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW');
insert  into user_account_authorities (user_account_username, authorities)
    values('user', 'USER');

-- admin
insert into user_account (username, email, password)
    values ('admin','admin@appinfo.com','{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW');
insert  into user_account_authorities (user_account_username, authorities)
    values('admin', 'ADMIN');
insert  into user_account_authorities (user_account_username, authorities)
    values('admin', 'USER');