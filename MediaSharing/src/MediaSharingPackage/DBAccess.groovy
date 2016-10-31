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
    
    def getMedia(id){
        return sql.rows("SELECT * FROM media WHERE media.id="+id)[0]
    }
    
    def listAllMedia(id_user) {
        return sql.rows("SELECT * FROM media WHERE media.id_user="+id)
    }
    
    def getUser(id) {
        return sql.rows("SELECT * FROM user WHERE user.id="+id)[0]
    }
    
    def addUser(username,password,email,name) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO user(username,password,email,name) VALUES " + "(${username},${password},${email},${name})"
	  
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
    
    def voteMedia(media,user,value) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO vote(id_media,value,id_user) VALUES " + "(${media}, ${user}, ${value})"
	  
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
    
    def addComment(media,content,user) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO comment(id_media,comment_content,id_user) VALUES " + "(${media}, ${content}, ${user})"
	  
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
    
    def getComment(media) {
        return sql.rows("SELECT * FROM comment WHERE comment.id_media="+media)
    }
}

