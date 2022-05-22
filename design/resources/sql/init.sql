create database ss;
use ss;
create table user (
	id int not null auto_increment,
	username varchar(100) not null unique,
	password_hash varchar(32) not null,
	fullname varchar(15),
	email varchar(50),
	mobile varchar(15),
	registered_at DATETIME,
	last_login DATETIME,
	avatar_url varchar(100),
	local_root_video_url varchar(100)
)

create table dictionary (
	id int not null auto_increment,
	word varchar(20) not null unique,
	phonetic varchar(20)
)

create table group_video (
	id int not null auto_increment,
	user_id int,
	name varchar(30)
)

create table user_word_known (
	id int not null auto_increment,
	word_id int not null,
	user_id int not null
)

create table ipa_symbol (
	id int not null auto_increment,
	symbol varchar(2) not null unique,
	example varchar(20),
	example_phonetic varchar(20),
	video_guide_url varchar(100),
	image_guide_url varchar(100),
	type varchar(15),
	view_count int
)

create table video (
	id int not null auto_increment,
	title varchar(100) not null,
	sub text,
	view_count int,
	group_id int not null,
	url varchar(100) not null
)
	
	
	
