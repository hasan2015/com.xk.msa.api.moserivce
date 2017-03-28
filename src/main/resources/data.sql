--DROP TABLE IF EXISTS `user`;
CREATE TABLE `app_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL, 
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
--DROP TABLE IF EXISTS `USER_ROLE`;
CREATE TABLE `user_role` (
  `app_user_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL 
);
insert into app_user(id, password, username) values(1, '$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G', 'yanhaixun@360ser.com');
insert into user_role(app_user_id, role) values(1, 'ADMIN');
insert into user_role(app_user_id, role) values(1, 'PREMIUM_MEMBER');

--curl -X POST -H "X-Requested-With: XMLHttpRequest" -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d "{"""username""": """svlada@gmail.com""","""password""":"""test1234"""}" "http://localhost:9966/api/auth/login"
--curl -X GET -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdmxhZGFAZ21haWwuY29tIiwic2NvcGVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1BSRU1JVU1fTUVNQkVSIl0sImlzcyI6Imh0dHA6Ly9zdmxhZGEuY29tIiwiaWF0IjoxNDg5NjY2MzE4LCJleHAiOjE0ODk2NjcyMTh9.pBltxzF1WLFtGFG8pYQgfNC2YcOKh0GsLQbf4fbqHmDsBFqEGuk8yyhkSOdJxZrKP8KriQ3Xt-anaGWSq3_Odg" -H "Cache-Control: no-cache" "http://localhost:9966/api/me"