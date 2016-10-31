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
		[by: { uname ->
			[value: { value ->
				def user = new User(uname)
				def id = user.getIdByUname()
				media.vote(id_media, id, value)
			}]
		}]
	}]
}