insert into customers(first_name, last_name, date_of_birth)
values ('Marek', 'Markowicz', '1991-01-30'),
       ('Damian', 'Damianowicz', '1981-07-30'),
       ('Arek', 'Kowolski', '1995-08-25'),
       ('Michał', 'Michałowski', '1971-11-15'),
       ('Irek', 'Podwalski', '1994-09-30');

insert into employees (first_name, last_name, address, telephone, note, cost_of_work_hour)
values ('Arek', 'Józwiak', 'Dworcowa 1 Wrocław', '584961785', 'mechanik', 20.70),
       ('Michał', 'Podwalski', 'Piękna 17 Wrocław', '126945367', 'elektryk', 35.5),
       ('Marek', 'Damianowicz', 'Kolejowa 10 Wrocław', '851369423', 'mechanik', 15);

insert into statuses (title)
values ('Przyjęty'),
       ('Zatwierdzone koszty naprawy'),
       ('W naprawie'),
       ('Gotowy do odbioru'),
       ('Rezygnacja');

insert into vehicles (model, brand, year_of_prod, registry, next_inspection, owner_id)
values ('VW', 'Passat', '2008', 'OP4235S', '2019-12-10', 3),
       ('VW', 'Golf', '2002', 'DW4221G', '2020-02-10', 1),
       ('Opel', 'Vectra', '2012', 'DW123GF', '2019-10-30', 5),
       ('Audi', 'A6', '2018', 'DW9999F', '2020-06-15', 4),
       ('BMW', 'M3', '2015', 'OPO256V', '2019-12-15', 3);

insert into orders (accept_repair, plan_start_repair, start_repair, employee_id, problem_description,
                    repair_description, status_id, vehicle_id, cost_of_repair, cost_of_parts, cost_of_work_hour,
                    number_work_hour)
values ('2019-10-10', '2019-10-10', '2019-10-10', 1, 'przegląd', 'wymiana oleju', 1, 1, 500, 300,
        (select employees.cost_of_work_hour from employees where employees.id = 1), 2),
       ('2019-10-10', '2019-10-11', '2019-10-11', 2, 'światła', 'wymiana żarówek', 4, 2, 200, 80,
        (select employees.cost_of_work_hour from employees where employees.id = 2), 1),
       ('2019-10-15', '2019-10-15', '2019-10-20', 3, 'opony', 'wymiana opon', 3, 5, 700, 500,
        (select employees.cost_of_work_hour from employees where employees.id = 3), 2.25);
