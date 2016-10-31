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
class Media {
    def id
    def title
    def num_views
    def user
    def num_votes
    def rating
    def file_size
    def url
    def access_type
    def category
    
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mediasharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def getMedia(id){
        return sql.rows("SELECT * FROM media WHERE media.id="+id)[0]
    }
    
    def addComment(media,content,user) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO comment(id_media,comment_content,id_user) VALUES " + "(${media}, ${string(content)}, ${user})"
	  
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
        def sqlstr = "INSERT INTO vote(id_media,value,id_user) VALUES " + "(${media}, ${string(value)}, ${user})"
	  
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
    
    def upload(title,user,filesize,url,accesstype,category,album) {
        sql.connection.autoCommit = false
        def sqlstr = "INSERT INTO media(title,id_user,file_size,url,id_accesstype,id_category,id_album) VALUES " + "(${string(title)}, ${user}, ${filesize}, ${string(url)}, ${accesstype}, ${category}, ${album})"
	  
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

