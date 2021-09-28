create database social_network;
create schema social_network.network;
create table network.posts
(
    id       serial
        constraint posts_pk
            primary key,
    postname varchar not null,
    postinfo varchar not null,
    owner    varchar not null
);

create table network.user_messages
(
	id serial,
	message varchar not null,
	sender varchar not null,
	receiver varchar not null
);