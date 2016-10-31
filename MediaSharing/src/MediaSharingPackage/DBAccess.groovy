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
class DBAccess {
    // Connect database
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mediasharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def addUser(username,password,email,name) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO user(username,password,email,name) VALUES " + "(${string(username)},${string(password)},${string(email)},${string(name)})"
	
        //def sql = "INSERT INTO eventID VALUES (" + "\"" + i + "\"" + ");";
        
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
    
    def string(str) {
        return "\"" + str + "\"";
    }
}

