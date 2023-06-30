
/*
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created timestamp NULL,
   updated timestamp NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   age INT NULL,
   number_of_accounts INT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

insert into users values (1, '2023-01-01', '2023-01-01', 'Richard', 'Hendricks', 27, 2);
insert into users values (2, '2023-01-01', '2023-01-01', 'Erlich', 'Bachman', 36, 2);
insert into users values (3, '2023-01-01', '2023-01-01', 'Jared', 'Dunn', 32, 1);
insert into users values (4, '2023-01-01', '2023-01-01', 'Dinesh', 'Chugtai', 31, 3);
insert into users values (5, '2023-01-01', '2023-01-01', 'Bertram', 'Gilfoyle', 29, 3);
insert into users values (6, '2023-01-01', '2023-01-01', 'Monica', 'Hall', 32, 2);
insert into users values (7, '2023-01-01', '2023-01-01', 'Gavin', 'Belson', 56, 5);
insert into users values (8, '2023-01-01', '2023-01-01', 'Laurie', 'Bream', 54, 3);
insert into users values (9, '2023-01-01', '2023-01-01', 'Nelson', 'Bighetti', 26, 1);
insert into users values (10, '2023-01-01', '2023-01-01', 'Russ', 'Hanneman', 43, 5);
insert into users values (11, '2023-01-01', '2023-01-01', 'Jian', 'Yang', 23, 3);
insert into users values (12, '2023-01-01', '2023-01-01', 'Jack', 'Barker', 61, 3);

CREATE TABLE accounts (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created timestamp NULL,
   updated timestamp NULL,
   account_number VARCHAR(255) NOT NULL,
   balance DECIMAL(12, 2) NULL,   !!!
   user_id BIGINT NULL,
   active_status BIT(1) NULL,
   CONSTRAINT pk_accounts PRIMARY KEY (id)
);

insert into accounts values (1, '2023-01-01', '2023-01-01', 'CY00000000000000000000000001', 10000.00, 1, true);
insert into accounts values (2, '2023-01-02', '2023-01-02', 'CY00000000000000000000000002', 500.00, 1, true);
insert into accounts values (3, '2023-01-05', '2023-01-05', 'CY00000000000000000000000003', 150.00, 2, true);
insert into accounts values (4, '2023-01-01', '2023-01-01', 'CY00000000000000000000000004', 999.00, 2, true);
insert into accounts values (5, '2023-01-01', '2023-01-01', 'CY00000000000000000000000005', 30000.00, 3, true);
insert into accounts values (6, '2023-01-05', '2023-01-05', 'CY00000000000000000000000006', 12000.00, 4, true);
insert into accounts values (7, '2023-01-01', '2023-01-01', 'CY00000000000000000000000007', 15000.00, 4, true);
insert into accounts values (8, '2023-01-10', '2023-01-10', 'CY00000000000000000000000008', 16000.00, 4, true);
insert into accounts values (9, '2023-01-10', '2023-01-10', 'CY00000000000000000000000009', 25000.00, 5, true);
insert into accounts values (10, '2023-01-02', '2023-01-02', 'CY00000000000000000000000010', 35000.00, 5, true);
insert into accounts values (11, '2023-01-05', '2023-01-05', 'CY00000000000000000000000011', 20000.00, 5, true);
insert into accounts values (12, '2023-01-01', '2023-01-01', 'CY00000000000000000000000012', 30000.00, 6, true);
insert into accounts values (13, '2023-01-01', '2023-01-01', 'CY00000000000000000000000013', 25000.00, 6, true);
insert into accounts values (14, '2023-01-05', '2023-01-05', 'CY00000000000000000000000014', 23400.00, 7, true);
insert into accounts values (15, '2023-01-01', '2023-01-01', 'CY00000000000000000000000015', 32200.00, 7, true);
insert into accounts values (16, '2023-01-10', '2023-01-10', 'CY00000000000000000000000016', 50000.00, 7, true);
insert into accounts values (17, '2023-01-10', '2023-01-10', 'CY00000000000000000000000017', 30000.00, 7, true);
insert into accounts values (18, '2023-01-10', '2023-01-10', 'CY00000000000000000000000018', 57000.00, 7, true);
insert into accounts values (19, '2023-01-10', '2023-01-10', 'CY00000000000000000000000019', 50000.00, 8, true);
insert into accounts values (20, '2023-01-10', '2023-01-10', 'CY00000000000000000000000020', 20000.00, 8, true);
insert into accounts values (21, '2023-01-10', '2023-01-10', 'CY00000000000000000000000021', 50000.00, 8, true);
insert into accounts values (22, '2023-01-10', '2023-01-10', 'CY00000000000000000000000022', 20000.00, 9, true);
insert into accounts values (23, '2023-01-10', '2023-01-10', 'CY00000000000000000000000023', 10000.00, 10, true);
insert into accounts values (24, '2023-01-10', '2023-01-10', 'CY00000000000000000000000024', 10000.00, 10, true);
insert into accounts values (25, '2023-01-10', '2023-01-10', 'CY00000000000000000000000025', 10000.00, 10, true);
insert into accounts values (26, '2023-01-10', '2023-01-10', 'CY00000000000000000000000026', 555.00, 10, true);
insert into accounts values (27, '2023-01-10', '2023-01-10', 'CY00000000000000000000000027', 90000.00, 10, true);
insert into accounts values (28, '2023-01-10', '2023-01-10', 'CY00000000000000000000000028', 7.00, 11, true);
insert into accounts values (29, '2023-01-10', '2023-01-10', 'CY00000000000000000000000029', 10.00, 11, true);
insert into accounts values (30, '2023-01-10', '2023-01-10', 'CY00000000000000000000000030', 10000.00, 11, true);
insert into accounts values (31, '2023-01-10', '2023-01-10', 'CY00000000000000000000000031', 10000.00, 12, true);
insert into accounts values (32, '2023-01-10', '2023-01-10', 'CY00000000000000000000000032', 50000.00, 12, true);
insert into accounts values (33, '2023-01-10', '2023-01-10', 'CY00000000000000000000000033', 80000.00, 12, true);



ALTER TABLE accounts ADD CONSTRAINT uc_accounts_account_number UNIQUE (account_number);

ALTER TABLE accounts ADD CONSTRAINT FK_ACCOUNTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE users_accounts (
   user_id BIGINT NOT NULL,
   accounts_id BIGINT NOT NULL,
   CONSTRAINT pk_users_accounts PRIMARY KEY (user_id, accounts_id)
);

ALTER TABLE users_accounts ADD CONSTRAINT uc_users_accounts_accounts UNIQUE (accounts_id);

ALTER TABLE users_accounts ADD CONSTRAINT fk_useacc_on_account FOREIGN KEY (accounts_id) REFERENCES accounts(id);

ALTER TABLE users_accounts ADD CONSTRAINT fk_useacc_on_user FOREIGN KEY (user_id) REFERENCES users(id);
insert into users_accounts values (1, 1);
insert into users_accounts values (1, 2);
insert into users_accounts values (2, 3);
insert into users_accounts values (2, 4);
insert into users_accounts values (3, 5);
insert into users_accounts values (4, 6);
insert into users_accounts values (4, 7);
insert into users_accounts values (4, 8);
insert into users_accounts values (5, 9);
insert into users_accounts values (5, 10);
insert into users_accounts values (5, 11);
insert into users_accounts values (6, 12);
insert into users_accounts values (6, 13);
insert into users_accounts values (7, 14);
insert into users_accounts values (7, 15);
insert into users_accounts values (7, 16);
insert into users_accounts values (7, 17);
insert into users_accounts values (7, 18);
insert into users_accounts values (8, 19);
insert into users_accounts values (8, 20);
insert into users_accounts values (8, 21);
insert into users_accounts values (9, 22);
insert into users_accounts values (10, 23);
insert into users_accounts values (10, 24);
insert into users_accounts values (10, 25);
insert into users_accounts values (10, 26);
insert into users_accounts values (10, 27);
insert into users_accounts values (11, 28);
insert into users_accounts values (11, 29);
insert into users_accounts values (11, 30);
insert into users_accounts values (12, 31);
insert into users_accounts values (12, 32);
insert into users_accounts values (12, 33);

CREATE TABLE transaction_categories (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created timestamp NULL,
   updated timestamp NULL,
   category VARCHAR(255) NOT NULL,
   income BIT(1) NOT NULL,
   CONSTRAINT pk_transaction_categories PRIMARY KEY (id)
);

insert into transaction_categories values (1, '2023-01-01', '2023-01-01', 'MONEY_TRANSFER', true);
insert into transaction_categories values (2, '2023-01-01', '2023-01-01', 'ACCOUNT_REPLENISHMENT', false);

CREATE TABLE transactions (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created timestamp NULL,
   updated timestamp NULL,
   sum DECIMAL(7, 2) NULL,
   from_account_id BIGINT NULL,
   to_account_id BIGINT NULL,
   CONSTRAINT pk_transactions PRIMARY KEY (id)
);

insert into transactions values (1, '2023-01-11', '2023-01-11', 100.00, 1, 4);
insert into transactions values (2, '2023-01-15', '2023-01-15', 234.00, 9, 3);
insert into transactions values (3, '2023-01-20', '2023-01-20', 15.00, 4, 5);
insert into transactions values (4, '2023-01-25', '2023-01-25', 315.00, 8, 2);
insert into transactions values (5, '2023-01-30', '2023-01-30', 44.00, 6, 1);
insert into transactions values (6, '2023-02-05', '2023-02-05', 10.00, 5, 9);
insert into transactions values (7, '2023-02-10', '2023-02-10', 191.00, 4, 1);
insert into transactions values (8, '2023-02-15', '2023-02-15', 95.00, 6, 8);
insert into transactions values (9, '2023-02-20', '2023-02-20', 500.00, 5, 2);
insert into transactions values (10, '2023-02-25', '2023-02-25', 211.00, 1, 7);
insert into transactions values (11, '2023-03-10', '2023-03-10', 77.00, 1, 6);
insert into transactions values (12, '2023-03-20', '2023-03-20', 116.00, 7, 2);
insert into transactions values (13, '2023-03-30', '2023-03-30', 443.00, 2, 4);
insert into transactions values (14, '2023-04-05', '2023-04-05', 94.00, 4, 5);
insert into transactions values (15, '2023-04-10', '2023-04-10', 111.00, 7, 3);
ALTER TABLE transactions ADD CONSTRAINT FK_TRANSACTIONS_ON_FROMACCOUNT FOREIGN KEY (from_account_id) REFERENCES accounts (id);

ALTER TABLE transactions ADD CONSTRAINT FK_TRANSACTIONS_ON_TOACCOUNT FOREIGN KEY (to_account_id) REFERENCES accounts (id);

CREATE TABLE transactions_list (
  id BIGINT AUTO_INCREMENT NOT NULL,
   created timestamp NULL,
   updated timestamp NULL,
   transaction_id BIGINT NULL,
   transaction_category_id BIGINT NULL,
   user_id BIGINT NULL,
   CONSTRAINT pk_transactions_list PRIMARY KEY (id)
);

insert into transactions_list values(1, '2023-01-11', '2023-01-11', 1, 2, 1);
insert into transactions_list values(2, '2023-01-11', '2023-01-11', 1, 1, 2);
insert into transactions_list values(3, '2023-01-15', '2023-01-15', 2, 2, 4);
insert into transactions_list values(4, '2023-01-15', '2023-01-15', 2, 1, 1);
insert into transactions_list values(5, '2023-01-20', '2023-01-20', 3, 2, 2);
insert into transactions_list values(6, '2023-01-20', '2023-01-20', 3, 1, 3);
insert into transactions_list values(7, '2023-01-25', '2023-01-25', 4, 2, 4);
insert into transactions_list values(8, '2023-01-25', '2023-01-25', 4, 1, 1);
insert into transactions_list values(9, '2023-01-30', '2023-01-30', 5, 2, 3);
insert into transactions_list values(10, '2023-01-30', '2023-01-30', 5, 1, 1);
insert into transactions_list values(11, '2023-02-05', '2023-02-05', 6, 2, 3);
insert into transactions_list values(12, '2023-02-05', '2023-02-05', 6, 1, 4);
insert into transactions_list values(13, '2023-02-10', '2023-02-10', 7, 2, 2);
insert into transactions_list values(14, '2023-02-10', '2023-02-10', 7, 1, 1);
insert into transactions_list values(15, '2023-02-15', '2023-02-15', 8, 2, 3);
insert into transactions_list values(16, '2023-02-15', '2023-02-15', 8, 1, 4);
insert into transactions_list values(17, '2023-02-20', '2023-02-20', 9, 2, 3);
insert into transactions_list values(18, '2023-02-20', '2023-02-20', 9, 1, 1);
insert into transactions_list values(19, '2023-02-25', '2023-02-25', 10, 2, 1);
insert into transactions_list values(20, '2023-02-25', '2023-02-25', 10, 1, 4);
insert into transactions_list values(21, '2023-03-10', '2023-03-10', 11, 2, 1);
insert into transactions_list values(22, '2023-03-10', '2023-03-10', 11, 1, 3);
insert into transactions_list values(23, '2023-03-20', '2023-03-20', 12, 2, 4);
insert into transactions_list values(24, '2023-03-20', '2023-03-20', 12, 1, 1);
insert into transactions_list values(25, '2023-03-30', '2023-03-30', 13, 2, 1);
insert into transactions_list values(26, '2023-03-30', '2023-03-30', 13, 1, 2);
insert into transactions_list values(27, '2023-04-05', '2023-04-05', 14, 2, 2);
insert into transactions_list values(28, '2023-04-05', '2023-04-05', 14, 1, 3);
insert into transactions_list values(29, '2023-04-10', '2023-04-10', 15, 2, 4);
insert into transactions_list values(30, '2023-04-10', '2023-04-10', 15, 1, 1);

ALTER TABLE transactions_list ADD CONSTRAINT FK_TRANSACTIONS_REGISTER_ON_TRANSACTION FOREIGN KEY (transaction_id) REFERENCES transactions (id);



ALTER TABLE transactions_list ADD CONSTRAINT FK_TRANSACTIONS_REGISTER_ON_TRANSACTION_CATEGORY FOREIGN KEY (transaction_category_id) REFERENCES transaction_categories (id);

ALTER TABLE transactions_list ADD CONSTRAINT FK_TRANSACTIONS_REGISTER_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

*/





