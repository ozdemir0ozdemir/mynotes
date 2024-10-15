-- categories Table
create sequence categories_id_seq start with 1 increment by 1;

create table categories
(
    category_id   bigint not null default nextval('categories_id_seq'),
    category_name text   not null unique,
    primary key (category_id)
);

-- blog_titles table
create sequence blog_titles_id_seq start with 1 increment by 1;

create table blog_titles
(
    blog_title_id bigint not null default nextval('blog_titles_id_seq'),
    blog_title    text   not null,
    category_id   bigint not null references categories (category_id),
    created_at    timestamp,
    updated_at    timestamp,
    primary key (blog_title_id)
);

-- blog_posts table
create sequence blog_posts_id_seq start with 1 increment by 1;

create table blog_posts
(
    blog_post_id  bigint not null default nextval('blog_posts_id_seq'),
    article       text   not null,
    blog_title_id bigint not null references blog_titles (blog_title_id),
    created_at    timestamp,
    updated_at    timestamp,
    primary key (blog_post_id)
);

-- Example Data - Should i use tags instead of one parent category
insert into categories(category_name)
values ('Java Core'),
       ('Spring Boot'),
       ('Thymeleaf');

insert into blog_titles(blog_title, category_id, created_at)
values ('Effective Java Notes', 1, NOW()),
       ('Spring Boot Data Jpa Notes', 2, NOW()),
       ('Layouts with Thymeleaf Notes', 3, NOW());

insert into blog_posts(article, blog_title_id, created_at)
values ('Prefer encapsulation over inheritance', 1, NOW()),
       ('Prefer static factory methods over constructors', 1, NOW()),
       ('Object relationship mapping causes problems', 2, NOW()),
       ('Projection classes reduces evaluation time of sql calls', 2, NOW()),
       ('There is no need to use layout plugin', 3, NOW()),
       ('Thymeleaf is amazing with iframes', 3, NOW());

