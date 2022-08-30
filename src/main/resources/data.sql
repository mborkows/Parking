INSERT INTO spot (id, plate, start, stop, driver_type, paid) VALUES (1, 'WOT-111', '2022-08-22T13:00:00', '2022-08-22T14:00:00','REGULAR', 0);
INSERT INTO spot (id, plate, start, driver_type, paid) VALUES (2, 'WOT-111', '2022-08-22T13:00:00','REGULAR', 0);
INSERT INTO spot (id, plate, start, stop, driver_type, paid) VALUES (3, 'WPR-111', '2022-08-22T13:00:00','2022-08-22T14:00:00','DISABLED', 0);
INSERT INTO spot (id, plate, start, driver_type, paid) VALUES (4, 'WPR-111', '2022-08-22T13:00:00','DISABLED', 0);
INSERT INTO spot (id, plate, start, stop, driver_type, paid) VALUES (5, 'KR-111', '2022-08-22T13:00:00', '2022-08-22T14:00:00','REGULAR', 0);

INSERT INTO rate (id, driver_type, first_hour, second_hour, next_hour_multiplier) VALUES (1, 'REGULAR', 1, 2, 1.5);
INSERT INTO rate (id, driver_type, first_hour, second_hour, next_hour_multiplier) VALUES (2, 'DISABLED', 0, 2, 1.2);