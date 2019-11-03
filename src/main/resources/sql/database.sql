create table customers
(
    id            int auto_increment,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    date_of_birth date,
    primary key (id)
);

create table vehicles
(
    id              int auto_increment,
    model           varchar(50),
    brand           varchar(50),
    year_of_prod    year(4),
    registry        varchar(10),
    next_inspection date,
    owner_id        int,
    primary key (id),
    foreign key (owner_id) references customers (id) on delete cascade
);

create table employees
(
    id                int auto_increment,
    first_name        varchar(50) not null,
    last_name         varchar(50) not null,
    address           varchar(255),
    telephone         varchar(20),
    note              varchar(255),
    cost_of_work_hour decimal(7, 2),
    primary key (id)
);

create table statuses
(
    id    int auto_increment,
    title varchar(50),
    primary key (id)
);

create table orders
(
    id                  int auto_increment,
    accept_repair       date,
    plan_start_repair   date,
    start_repair        date,
    end_repair          date,
    employee_id         int,
    problem_description varchar(255),
    repair_description  varchar(255),
    status_id           int,
    vehicle_id          int,
    cost_of_repair      decimal(7, 2),
    cost_of_parts       decimal(7, 2),
    cost_of_work_hour   decimal(7, 2),
    number_work_hour    decimal(5, 2),
    primary key (id),
    foreign key (employee_id) references employees (id) on delete cascade,
    foreign key (status_id) references statuses (id) on delete cascade,
    foreign key (vehicle_id) references vehicles (id) on delete cascade
);

create table users
(
    id       int auto_increment,
    login    varchar(50)  not null unique,
    password varchar(255) not null,
    is_admin tinyint(1)   not null,
    primary key (id)
);
