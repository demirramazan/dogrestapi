create table DOG
(
    ID INT auto_increment,
    NAME VARCHAR2(50),
    BREED VARCHAR2(50),
    ORIGIN VARCHAR2(100),
    constraint DOG_PK
        primary key (ID)
);
