-- Database: stu_db

-- DROP DATABASE stu_db;

CREATE DATABASE stu_db
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
    id integer NOT NULL,
    age integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    stuid character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.student
    OWNER to postgres;