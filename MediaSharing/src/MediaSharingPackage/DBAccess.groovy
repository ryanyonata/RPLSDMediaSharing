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
    
    def voteMedia(media,user,value) {
        
    }

}

