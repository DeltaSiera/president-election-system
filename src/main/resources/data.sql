-- insert into Candidates
insert into Candidates (Id, first_name, last_name, agenda)
values (1, 'Aragorn', 'The first', 'Ranger of the North. Heir of Isildur'),
       (2, 'Gandalf', 'from Gandálfr', 'Wizard and the bearer of one of the Three Rings'),
       (3, 'Saruman', 'Wizard', 'Leader of the Istari'),
       (4, 'Gimli ', 'Fearless dwarf', 'Son of Glóin, a member of Thorin''s company'),
       (5, 'Legolas', 'Elf', 'Sindar Elf of the Woodland Realm and one of the nine members of the Fellowship');

insert into Voters
VALUES
-- insert into voters (nin, region)
(57539440, 'MORDOR'),
(70192431, 'ERIADOR'),
(78452734, 'ROHAN'),
(90534476, 'GONDOR'),
(70169876, 'ROHAN'),
(91204628, 'RHUN'),
(99620783, 'MORDOR'),
(48964379, 'ROHAN'),
(54392418, 'ERIADOR'),
(49142036, 'ERIADOR'),
(47259609, 'ROHAN'),
(30168798, 'MORDOR'),
(57682372, 'RHUN'),
(57177271, 'ROHAN'),
(25269345, 'GONDOR'),
(60827484, 'RHUN'),
(50608390, 'MORDOR'),
(53055943, 'RHUN'),
(37279177, 'GONDOR'),
(79569379, 'GONDOR'),
(66752622, 'ERIADOR'),
(19718791, 'ERIADOR'),
(20359371, 'ERIADOR'),
(96965101, 'MORDOR'),
(25351866, 'ERIADOR'),
(93513613, 'ROHAN'),
(13277685, 'GONDOR'),
(24344900, 'MORDOR'),
(72158095, 'RHUN'),
(92396475, 'RHUN'),
(74630545, 'ERIADOR'),
(73961827, 'ERIADOR'),
(19023225, 'GONDOR'),
(77240249, 'GONDOR'),
(69991138, 'GONDOR'),
(66894471, 'GONDOR'),
(94975211, 'ERIADOR'),
(90878482, 'RHUN'),
(57604687, 'GONDOR'),
(62901162, 'MORDOR'),
(12897497, 'ROHAN'),
(98040135, 'ERIADOR'),
(78095670, 'ROHAN'),
(38819642, 'MORDOR'),
(29316767, 'ERIADOR'),
(91375560, 'RHUN'),
(37351158, 'ERIADOR'),
(29249713, 'ERIADOR'),
(99749433, 'ROHAN'),
(70962435, 'MORDOR'),
(57306409, 'GONDOR'),
(59975871, 'RHUN'),
(36836442, 'MORDOR'),
(43116237, 'ROHAN'),
(90604450, 'ROHAN'),
(71852338, 'ROHAN'),
(36106345, 'MORDOR'),
(66306877, 'RHUN'),
(24628207, 'ERIADOR'),
(89072758, 'ERIADOR'),
(99674411, 'ERIADOR'),
(90804246, 'ERIADOR'),
(19916863, 'GONDOR'),
(20454603, 'ROHAN'),
(33517839, 'ROHAN'),
(49171601, 'MORDOR'),
(74764191, 'ERIADOR'),
(89111714, 'GONDOR'),
(98811960, 'GONDOR'),
(17104847, 'RHUN'),
(86709027, 'RHUN'),
(99050222, 'MORDOR'),
(22494434, 'ROHAN'),
(60449254, 'GONDOR'),
(87317121, 'RHUN'),
(33296856, 'MORDOR'),
(64589155, 'ROHAN'),
(35637186, 'ERIADOR'),
(84797862, 'GONDOR'),
(84794848, 'ROHAN'),
(65479824, 'GONDOR'),
(14824935, 'RHUN'),
(42499730, 'GONDOR'),
(73404489, 'ERIADOR'),
(28507221, 'GONDOR'),
(95001911, 'RHUN'),
(83880255, 'RHUN'),
(91836461, 'MORDOR'),
(86632108, 'RHUN'),
(28563522, 'GONDOR'),
(18592670, 'ROHAN'),
(55847192, 'ERIADOR'),
(21493527, 'MORDOR'),
(47940696, 'RHUN'),
(76084819, 'ROHAN'),
(39229712, 'RHUN'),
(49659417, 'ERIADOR'),
(75119512, 'RHUN'),
(66446643, 'GONDOR');


-- INSERT INTO Votes
INSERT INTO Votes (bulletin_id, voter_id, candidate_id)
VALUES (197, 57539440, 3),
       (2472, 70192431, 5),
       (1844, 78452734, 4),
       (3420, 90534476, 1),
       (2534, 70169876, 3),
       (670, 91204628, 4),
       (1651, 99620783, 3),
       (2400, 48964379, 1),
       (2933, 54392418, 3),
       (4810, 49142036, 5),
       (390, 47259609, 2),
       (2814, 30168798, 4),
       (1481, 57682372, 3),
       (1266, 57177271, 1),
       (1192, 25269345, 5),
       (398, 60827484, 2),
       (4923, 50608390, 2),
       (438, 53055943, 4),
       (4669, 37279177, 2),
       (2541, 79569379, 5),
       (964, 66752622, 1),
       (1843, 19718791, 4),
       (4986, 20359371, 5),
       (2716, 96965101, 5),
       (4685, 25351866, 5),
       (1336, 93513613, 5),
       (2278, 13277685, 5),
       (922, 24344900, 2),
       (1752, 72158095, 4),
       (2404, 92396475, 4),
       (250, 74630545, 4),
       (2254, 73961827, 5),
       (3693, 19023225, 2),
       (16, 77240249, 5),
       (2312, 69991138, 4),
       (1960, 66894471, 4),
       (3090, 94975211, 4),
       (4097, 90878482, 3),
       (4974, 57604687, 4),
       (1973, 62901162, 4),
       (1756, 12897497, 3),
       (4802, 98040135, 5),
       (3153, 78095670, 5),
       (4920, 38819642, 4),
       (2752, 29316767, 1),
       (413, 91375560, 2),
       (2626, 37351158, 4),
       (2926, 29249713, 1),
       (4760, 99749433, 5),
       (159, 70962435, 2),
       (1559, 57306409, 5),
       (4016, 59975871, 4),
       (4108, 36836442, 2),
       (205, 43116237, 5),
       (4659, 90604450, 5),
       (2594, 71852338, 3),
       (1269, 36106345, 1),
       (1896, 66306877, 1),
       (3818, 24628207, 3),
       (3973, 89072758, 5),
       (3439, 99674411, 4),
       (8, 90804246, 3),
       (1610, 19916863, 1),
       (4942, 20454603, 5),
       (1405, 33517839, 1),
       (1866, 49171601, 1),
       (3760, 74764191, 4),
       (703, 89111714, 1),
       (4020, 98811960, 1),
       (190, 17104847, 3),
       (4405, 86709027, 4),
       (1495, 99050222, 5),
       (740, 22494434, 5),
       (4681, 60449254, 1),
       (992, 87317121, 1),
       (2882, 33296856, 5),
       (1498, 64589155, 5),
       (4336, 35637186, 1),
       (1934, 84797862, 2),
       (2171, 84794848, 4),
       (1068, 65479824, 2),
       (4558, 14824935, 2),
       (440, 42499730, 2),
       (1289, 73404489, 5),
       (3365, 28507221, 1),
       (3884, 95001911, 3),
       (1472, 83880255, 1),
       (3378, 91836461, 4),
       (1333, 86632108, 1),
       (2020, 28563522, 3);
--        (4332, 18592670, 1),
--        (3959, 55847192, 1),
--        (2679, 21493527, 4),
--        (4309, 47940696, 3),
--        (1887, 76084819, 1),
--        (2902, 39229712, 5),
--        (3434, 49659417, 5),
--        (4103, 75119512, 1);
--        (2616, 66446643, 4);