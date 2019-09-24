SET FOREIGN_KEY_CHECKS = 0;

LOCK TABLES grb_player WRITE;

DROP TABLE IF EXISTS grb_player;
DROP TABLE IF EXISTS grb_uniform_order;
DROP TABLE IF EXISTS grb_user;
DROP TABLE IF EXISTS grb_pants_styles;
DROP TABLE IF EXISTS grb_pants_sizes;
DROP TABLE IF EXISTS grb_jersey_sizes;
DROP TABLE IF EXISTS grb_hat_sizes;
DROP TABLE IF EXISTS grb_shoe_sizes;
DROP TABLE IF EXISTS grb_tshirt_sizes;
DROP TABLE IF EXISTS grb_shorts_sizes;
DROP TABLE IF EXISTS grb_seasons;
DROP TABLE IF EXISTS grb_locations;

UNLOCK TABLES;

CREATE TABLE grb_player (
    ID int(11) NOT NULL AUTO_INCREMENT,
    USER_ID int(11) NOT NULL,
    PLAYER_FIRST_NAME varchar(20) DEFAULT NULL,
    PLAYER_LAST_NAME varchar(30) DEFAULT NULL,
    SITE_LOCATION int(11) NOT NULL,
    AGE_GROUP char(3) DEFAULT NULL,
    PRIMARY KEY (ID),
    KEY fk_grb_player_id (USER_ID),
    KEY fk_grb_player_site_location (SITE_LOCATION),
    CONSTRAINT grb_player_ibfk_1 FOREIGN KEY (USER_ID) REFERENCES grb_user (ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT grb_player_ibfk_2 FOREIGN KEY (SITE_LOCATION) REFERENCES grb_locations (LOCATION_ID)
);

CREATE TABLE grb_uniform_order (
    ORDER_ID int(11) NOT NULL AUTO_INCREMENT,
    PLAYER_ID int(11) NOT NULL,
    JERSEY_SIZE int(11) DEFAULT NULL,
    JERSEY_NUMBER int(11) DEFAULT NULL,
    PANTS_SIZE int(11) DEFAULT NULL,
    PANTS_STYLE int(11) DEFAULT NULL,
    HAT_SIZE int(11) DEFAULT NULL,
    SHOE_SIZE int(11) DEFAULT NULL,
    TSHIRT_SIZE int(11) DEFAULT NULL,
    SHORTS_SIZE int(11) DEFAULT NULL,
    SEASON int(11) DEFAULT NULL,
    DATE_CREATED timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (ORDER_ID),
    KEY fk_grb_uniform_order_player_id (PLAYER_ID),
    KEY fk_grb_uniform_order_pants_styles (PANTS_STYLE),
    KEY fk_grb_uniform_order_pants_sizes (PANTS_SIZE),
    KEY fk_grb_uniform_order_jersey_sizes (JERSEY_SIZE),
    KEY fk_grb_uniform_order_hat_sizes (HAT_SIZE),
    KEY fk_grb_uniform_order_shoe_sizes (SHOE_SIZE),
    KEY fk_grb_uniform_order_tshirt_sizes (TSHIRT_SIZE),
    KEY fk_grb_uniform_order_short_sizes (SHORTS_SIZE),
    KEY fk_grb_uniform_order_seasons (SEASON),
    CONSTRAINT grb_uniform_order_ibfk_1 FOREIGN KEY (PLAYER_ID) REFERENCES grb_player (ID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT grb_uniform_order_ibfk_2 FOREIGN KEY (PANTS_STYLE) REFERENCES grb_pants_styles (STYLE_ID),
    CONSTRAINT grb_uniform_order_ibfk_3 FOREIGN KEY (PANTS_SIZE) REFERENCES grb_pants_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_4 FOREIGN KEY (JERSEY_SIZE) REFERENCES grb_jersey_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_5 FOREIGN KEY (HAT_SIZE) REFERENCES grb_hat_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_6 FOREIGN KEY (SHOE_SIZE) REFERENCES grb_shoe_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_7 FOREIGN KEY (TSHIRT_SIZE) REFERENCES grb_tshirt_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_8 FOREIGN KEY (SHORTS_SIZE) REFERENCES grb_shorts_sizes (SIZE_ID),
    CONSTRAINT grb_uniform_order_ibfk_9 FOREIGN KEY (SEASON) REFERENCES grb_seasons (SEASON_ID)
);

CREATE TABLE grb_user (
    ID int(11) NOT NULL AUTO_INCREMENT,
    USER_NAME varchar(50) DEFAULT NULL,
    USER_PASSWORD varchar(160) DEFAULT NULL,
    USER_FIRST_NAME varchar(20) DEFAULT NULL,
    USER_LAST_NAME varchar(30) DEFAULT NULL,
    USER_ADDRESS_1 varchar(30) DEFAULT NULL,
    USER_ADDRESS_2 varchar(30) DEFAULT NULL,
    USER_CITY varchar(30) DEFAULT NULL,
    USER_STATE char(2) DEFAULT NULL,
    USER_ZIP varchar(10) DEFAULT NULL,
    USER_PHONE bigint(20) DEFAULT NULL,
    USER_EMAIL varchar(50) DEFAULT NULL,
    DATE_CREATED timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
);

CREATE TABLE grb_pants_styles (
    STYLE_ID int(11) NOT NULL AUTO_INCREMENT,
    STYLE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (STYLE_ID)
);

CREATE TABLE grb_pants_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_jersey_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_hat_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_shoe_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_tshirt_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_shorts_sizes (
    SIZE_ID int(11) NOT NULL AUTO_INCREMENT,
    SIZE_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SIZE_ID)
);

CREATE TABLE grb_seasons (
    SEASON_ID int(11) NOT NULL AUTO_INCREMENT,
    SEASON_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (SEASON_ID)
);

CREATE TABLE grb_locations (
    LOCATION_ID int(11) NOT NULL AUTO_INCREMENT,
    LOCATION_DESCRIPTION varchar(50) NOT NULL,
    PRIMARY KEY (LOCATION_ID)
);

CREATE TABLE grb_user_roles (
    ID int(11) NOT NULL AUTO_INCREMENT,
    USER_NAME varchar(50) NOT NULL,
    USER_ROLE varchar(20) NOT NULL,
    PRIMARY KEY (ID)
);

SET FOREIGN_KEY_CHECKS = 1;
