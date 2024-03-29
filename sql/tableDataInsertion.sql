SET FOREIGN_KEY_CHECKS = 0;

LOCK TABLES grb_user WRITE;

INSERT INTO grb_user VALUES (1,'almfamily','$2y$10$Z0k7T2ZWYJsI8z9WEzH5Bu5lOps/ph7MNNSwgeuJ8rilaTxxz6QBe','Joseph','Alexander','2764 Olin Way','','Sun Prairie','WI','53590',6087720366,'cambo7131@gmail.com','2018-12-02 20:31:10')
,(2,'jleitl','$2y$10$7YGOGnOTnf.u5E13W7IIWegcVDNGdCYGYlHv939SzmqZpMwd7ydRS', 'Jill','Leitl','2764 Olin Way','','Sun Prairie','WI','53590',6087720782,'cambo7131@gmail.com','2018-12-02 22:15:25')
;
UNLOCK TABLES;

LOCK TABLES grb_player WRITE;

INSERT INTO grb_player VALUES (1,2,'Jenkin','Alexander',1,'15u'),(2,2,'Jordan','Alexander',1,'12u');

UNLOCK TABLES;

LOCK TABLES grb_pants_styles WRITE;

INSERT INTO grb_pants_styles VALUES (1,'Traditional')
            ,(2,'Stirrup');

UNLOCK TABLES;

LOCK TABLES grb_pants_sizes WRITE;

INSERT INTO grb_pants_sizes VALUES (1,'Youth XS')
            ,(2,'Youth SM')
            ,(3,'Youth MED')
            ,(4,'Youth LG')
            ,(5,'Adult XS')
            ,(6,'Adult SM')
            ,(7,'Adult MED')
            ,(8,'Adult LG')
            ,(9,'Adult XLG');

UNLOCK TABLES;

LOCK TABLES grb_jersey_sizes WRITE;

INSERT INTO grb_jersey_sizes VALUES (1,'Youth XS')
            ,(2,'Youth SM')
            ,(3,'Youth MED')
            ,(4,'Youth LG')
            ,(5,'Adult XS')
            ,(6,'Adult SM')
            ,(7,'Adult MED')
            ,(8,'Adult LG')
            ,(9,'Adult XLG')
            ,(10,'Adult XXLG');

UNLOCK TABLES;

LOCK TABLES grb_hat_sizes WRITE;

INSERT INTO grb_hat_sizes VALUES (1,'Youth')
            ,(2,'Small')
            ,(3,'Medium')
            ,(4,'Large')
            ;

UNLOCK TABLES;

LOCK TABLES grb_shoe_sizes WRITE;

INSERT INTO grb_shoe_sizes VALUES (1,'1.0')
            ,(2,'1.5')
            ,(3,'2.0')
            ,(4,'2.5')
            ,(5,'3.0')
            ,(6,'3.5')
            ,(7,'4.0')
            ,(8,'4.5')
            ,(9,'5.0')
            ,(10,'5.5')
            ,(11,'6.0')
            ,(12,'6.5')
            ,(13,'7.0')
            ,(14,'7.5')
            ,(15,'8.0')
            ,(16,'8.5')
            ,(17,'9.0')
            ,(18,'9.5')
            ,(19,'10.0')
            ,(20,'10.5')
            ,(21,'11.0')
            ,(22,'11.5')
            ,(23,'12.0')
            ,(24,'12.5')
            ,(25,'13.0')
            ,(26,'13.5')
            ,(27,'14.0')
            ,(28,'14.5')
            ,(29,'15.0')
            ,(30,'15.5')
            ,(31,'16.0')
            ,(32,'16.5')
            ,(33,'17.0');

UNLOCK TABLES;

LOCK TABLES grb_tshirt_sizes WRITE;

INSERT INTO grb_tshirt_sizes VALUES (1,'Youth XS')
            ,(2,'Youth SM')
            ,(3,'Youth MED')
            ,(4,'Youth LG')
            ,(5,'Adult XS')
            ,(6,'Adult SM')
            ,(7,'Adult MED')
            ,(8,'Adult LG')
            ,(9,'Adult XLG')
            ,(10,'Adult XXLG');

UNLOCK TABLES;

LOCK TABLES grb_shorts_sizes WRITE;

INSERT INTO grb_shorts_sizes VALUES (1,'Youth XS')
            ,(2,'Youth SM')
            ,(3,'Youth MED')
            ,(4,'Youth LG')
            ,(5,'Adult XS')
            ,(6,'Adult SM')
            ,(7,'Adult MED')
            ,(8,'Adult LG')
            ,(9,'Adult XLG')
            ,(10,'Adult XXLG');

UNLOCK TABLES;

LOCK TABLES grb_seasons WRITE;

INSERT INTO grb_seasons VALUES (1,'Spring')
            ,(2,'Summer')
            ,(3,'Fall')
            ;

UNLOCK TABLES;

LOCK TABLES grb_locations WRITE;

INSERT INTO grb_locations VALUES (1,'Madison')
            ,(2,'Milwaukee')
            ,(3,'Eau Claire')
            ;

UNLOCK TABLES;

LOCK TABLES grb_age_groups WRITE;

INSERT INTO grb_age_groups VALUES (1,'9U')
                               ,(2,'10U')
                               ,(3,'11U')
                               ,(4,'12U')
                               ,(5,'13U')
                               ,(6,'14U')
                               ,(7,'15U')
                               ,(8,'16U')
                               ,(9,'17U')
;

UNLOCK TABLES;

LOCK TABLES grb_uniform_order WRITE;

INSERT INTO grb_uniform_order VALUES (1,1,7,NULL,6,2,3,13,9,9,2,'2018-12-10 15:54:39')
            ,(2,2,3,34,3,1,1,6,NULL,NULL,3,'2018-12-10 15:56:04');

UNLOCK TABLES;

LOCK TABLES grb_user_roles WRITE;

INSERT INTO grb_user_roles VALUES (1,'almfamily','admin')
            ,(2,'jleitl','user');

UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 1;