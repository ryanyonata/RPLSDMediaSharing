/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MediaSharingPackage

import java.sql.*; 
import groovy.sql.Sql

def name='ryanyonata'

println "Hello $name!"

// Connect database
def dbConn = new DBAccess()
def user = new User();
def media = new Media();

def username = 'test'
def email = 'test@email.com'
def password = 'password2'
def name2 = 'Ryan2'


login user username 'ryanyonata' password 'password'
getID user username 'ryanyonata'
register user username 'adarwawan' password 'adalah123' email 'adarwawan@gmail.com' name 'Ahmad Darmawan'
vote media id 1 by_user 1 value -1
comment media id 1 content 'sia maneh' by_user 2


// DSL 1 : Login
def login(user) {
	[username: { uname ->
		[password: { pass ->
			def idx = user.login(uname, pass)
			println idx
		}]
	}]
}

// DSL 2 : Register
def register(user) {
    [username: { uname ->
    	[password: { pass ->
    		[email: { email ->
    			[name: { name -> 
    				user.addUser(uname, pass, email, name)
    			}]
    		}]
    	}]
    }]
}

// DSL 3 : Vote media
def vote(media) {
	[id: { id_media ->
		[by_user: { id_user ->
			[value: { value ->
				media.voteMedia(id_media, id_user, value)
			}]
		}]
	}]
}

// DSL 4 : Comment
def comment(media) {
	[id: { id_media ->
		[content: { content ->
			[by_user: { id_user ->
				media.addComment(id_media, content, id_user)
			}]
		}]
	}]
}

// DSL 5 : Get User ID
def getID(user) {
    [username: { uname ->
        def idx = user.getIdByUname(uname)
        println idx
        return idx
    }]
}