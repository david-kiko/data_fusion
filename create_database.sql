-- Create database if it doesn't exist
CREATE DATABASE api WITH ENCODING 'UTF8';

-- Connect to the api database
\c api;

-- Create table in public schema
CREATE TABLE public.input (
    CID bigint PRIMARY KEY,
    CNAME varchar(255),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP
); 


CREATE TABLE public.output_get (
    CID bigint PRIMARY KEY,
    CNAME varchar(255),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP
); 

CREATE TABLE public.output_post (
    CID bigint PRIMARY KEY,
    CNAME varchar(255),
    create_time timestamp DEFAULT CURRENT_TIMESTAMP
); 