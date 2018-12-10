package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDao;
import com.niit.model.ErrorClazz;
import com.niit.model.User;

@Controller
public class UserController {
@Autowired
private UserDao userDao;
public UserController() {
	System.out.println("UserController bean is instatiated" );
}


@RequestMapping("/")
public String welcome()
{
	return "hello hit server";
}
@RequestMapping(value="/register",method=RequestMethod.POST)
public ResponseEntity<?> regestration(@RequestBody User user){
	//check email is unique
	if(!userDao.isEmailUnique(user.getEmail())) {
		ErrorClazz errorclazz=new ErrorClazz(2,"Email already exists.....choose any other Email ID");
		return new ResponseEntity<ErrorClazz>(errorclazz,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	try {
		userDao.registerUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}catch (Exception e) {
		ErrorClazz errorClazz=new ErrorClazz(1,"Unable to regester user details"+ e.getMessage());
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}

