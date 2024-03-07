PRAGMA foreign_keys = OFF;
drop table if exists lga16;
drop table if exists Population2016;
drop table if exists SchoolCompletion2016;
drop table if exists WeeklyIncome2016;
PRAGMA foreign_keys = ON;

CREATE TABLE lga16 (
    lga_code16 INTEGER NOT NULL,
    lga_name   TEXT  NOT NULL,
    lga_type16 CHAR (2) NOT NULL,
    area_sqkm  DOUBLE NOT NULL,
    latitude   DOUBLE NOT NULL,
    longitude  DOUBLE NOT NULL,
    lga_year16 INTEGER NOT NULL
    PRIMARY KEY (lga_code16)
    PRIMARY KEY (lga_year16)
);

CREATE TABLE Population2016 (
    lgacode           INTEGER NOT NULL,
    Indigenous_status TEXT NOT NULL,
    Sex               CHAR (1) NOT NULL,
    Age               TEXT NOT NULL,
    Count             INTEGER NOT NULL,
    lga_year          INTEGER NOT NULL
    PRIMARY KEY (lgacode, Indigenous_status, Sex, Age, lga_year)
    FOREIGN KEY (lgacode) REFERENCES lga16 (lga_code16)
    FOREIGN KEY (lga_year) REFERENCES lga16 (lga_year16)
);

CREATE TABLE SchoolCompletion2016 (
    lgacode           INTEGER NOT NULL,
    Indigenous_status TEXT NOT NULL,
    Sex               CHAR (1) NOT NULL,
    SchoolYear        TEXT NOT NULL,
    Count             INTEGER NOT NULL,
    lga_year          INTEGER NOT NULL
    PRIMARY KEY (lgacode, Indigenous_status, Sex, SchoolYear, lga_year)
    FOREIGN KEY (lgacode) REFERENCES lga16 (lga_code16)
    FOREIGN KEY (lga_year) REFERENCES lga16 (lga_year16)
);

CREATE TABLE WeeklyIncome2016 (
    lgacode           INTEGER NOT NULL,
    Indigenous_status TEXT NOT NULL,
    Income_bracket    TEXT NOT NULL,
    Count             INTEGER NOT NULL,
    lga_year          INTEGER NOT NULL
    PRIMARY KEY (lgacode, Indigenous_status, Income_bracket, lga_year)
    FOREIGN KEY (lgacode) REFERENCES lga16 (lga_code16)
    FOREIGN KEY (lga_year) REFERENCES lga16 (lga_year16)
);

CREATE TABLE SchoolCompletion2016 (
    lgacode           INTEGER NOT NULL,
    Indigenous_status TEXT NOT NULL,
    Sex               CHAR (1) NOT NULL,
    Condition         TEXT NOT NULL,
    Count             INTEGER NOT NULL,
    lga_year          INTEGER NOT NULL
    PRIMARY KEY (lgacode, Indigenous_status, Sex, Condition, lga_year)
    FOREIGN KEY (lgacode) REFERENCES lga16 (lga_code16)
    FOREIGN KEY (lga_year) REFERENCES lga16 (lga_year16)
);

CREATE TABLE POPULATION (
    lga_code         INTEGER  NOT NULL,
    lga_name         TEXT     NOT NULL,
    lga_state        TEXT     NOT NULL,
    lga_type         CHAR (2) NOT NULL,
    area_sqkm        DOUBLE   NOT NULL,
    total_population INTEGER  NOT NULL,
    lga_year         INTEGER  NOT NULL
);



