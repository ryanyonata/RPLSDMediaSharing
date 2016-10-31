/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MediaSharingPackage

def name='ryanyonata'

println "Hello $name!"

// Connect database
def dbConn = new DBAccess()

def username = 'test'
def email = '"test@email.com"'
def password = 'password2'
def name2 = 'Ryan2'

def a = dbConn.addUser(username,password,email,name2)

println a
