PRAGMA foreign_keys = OFF;
drop table if exists Member;
/* Data Definition */

CREATE TABLE Outcomes (
    OutcomeName     TEXT,
    OutcomeDescription      TEXT      NOT NULL,
    PRIMARY KEY (OutcomeName)
    );

