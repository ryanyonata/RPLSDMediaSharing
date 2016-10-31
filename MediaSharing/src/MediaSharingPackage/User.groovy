/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MediaSharingPackage

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
        String response = ""
        response = sql.rows("SELECT password FROM user WHERE username="+username)
        if (response == "") {
            return "Username Invalid";
        } else if (response == password){
            return "Login Succes"
        } else {
            return "Password Invalid"
        }
    }
}

