CREATE TABLE `video` (
  `vid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `likeCount` int NOT NULL DEFAULT '0',
  `dislikeCount` int NOT NULL DEFAULT '0',
  `fileName` varchar(200) NOT NULL,
  `youtubeName` varchar(100) NOT NULL,
  PRIMARY KEY (`vid`)
)

CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL DEFAULT 'username',
  `email` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL DEFAULT 'password',
  `twoFACode` varchar(45) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
)

CREATE TABLE `VideoUser` (
  `uid` int NOT NULL,
  `vid` int NOT NULL,
  KEY `uid` (`uid`),
  KEY `vid` (`vid`),
  CONSTRAINT `videouser_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `videouser_ibfk_2` FOREIGN KEY (`vid`) REFERENCES `video` (`vid`)
)