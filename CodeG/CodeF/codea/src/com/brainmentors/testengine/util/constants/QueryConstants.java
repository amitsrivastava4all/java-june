package com.brainmentors.testengine.util.constants;

public interface QueryConstants {
	String LOGIN_SQL = "select userid, password from users where userid=? and password=?";
	String REGISTER_SQL = "insert into users (userid, password) values(?,?)";
	String QUESTION_UPLOAD_SQL = "insert into question (qid, name,ans1,ans2,ans3,ans4,rans,score) values(?,?,?,?,?,?,?,?)";
}
