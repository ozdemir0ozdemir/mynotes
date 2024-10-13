-- categories Table
create sequence categories_id_seq start with 1 increment by 1;

create table categories
(
    category_id   bigint not null default nextval('categories_id_seq'),
    category_name text   not null unique,
    primary key (category_id)
);

-- blog_posts table
create sequence blog_posts_id_seq start with 1 increment by 1;

create table blog_posts
(
    blog_post_id bigint not null default nextval('blog_posts_id_seq'),
    title        text   not null,
    article      text   not null,
    category_id  bigint not null references categories (category_id),
    created_at   timestamp,
    updated_at   timestamp,
    primary key (blog_post_id)
);

-- Example Data - Should i use tags instead of one parent category
insert into categories(category_name)
values ('Java Core'),
       ('Spring Boot'),
       ('Thymeleaf'),
       ('Effective Java'),
       ('Clean Code'),
       ('Books');