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
            return string(row.password)
        }
//        if (string(response).equals("")) {
//            return "Username Invalid";
//        } else if (string(response).equals(string(password))){
//            return "Login Succes"
//        } else {
//            return "Password Invalid"
//        }
    }
}