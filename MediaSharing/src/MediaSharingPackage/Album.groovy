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
class Album {
    def id
    def title
    def user
    
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mediasharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def listAllMedia(user,album) {
        return sql.rows("SELECT * FROM media WHERE media.id_user="+user+" AND id_album="+album)
    }
}

