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
class Comment {
    def id
    def user
    def media
    def comment_content
    
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/mediasharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def getComment(media) {
        return sql.rows("SELECT * FROM comment WHERE comment.id_media="+media)
    }
}

