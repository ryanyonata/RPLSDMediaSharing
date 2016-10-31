/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MediaSharingPackage

import java.sql.*; 
import groovy.sql.Sql

/**
 *
 * @author ryanyonata
 */
class User {
    def id
    def username
    def email
    def password
    def name
    
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mediasharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def getUser(id) {
        return sql.rows("SELECT * FROM user WHERE user.id="+id)[0]
    }
    
    def string(str) {
        return "\"" + str + "\"";
    }
    
    def login(username, password){
        def response = "SELECT password FROM user WHERE username="+string(username)
        sql.eachRow(response) { row ->
            response = string(row.password)
        }
        if (string(response).equals("")) {
            return "Username Invalid";
        } else if (response.equals(string(password))){
            return "Login Success"
        } else {
            return "Password Invalid"
        }
    }
    
    def addUser(username,password,email,name) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO user(username,password,email,name) VALUES " + "(${string(username)},${string(password)},${string(email)},${string(name)})"
	    
        try {
            sql.execute(sqlstr);
            sql.commit()
            println("Successfully committed")
        }catch(Exception ex) {
            sql.rollback() 
            println("Transaction rollback")
        }	
        sql.close()
    }
    
    def getIdByUname(username) {
        return sql.rows("SELECT id FROM user WHERE username="+string(username))[0].'id'
    }
}