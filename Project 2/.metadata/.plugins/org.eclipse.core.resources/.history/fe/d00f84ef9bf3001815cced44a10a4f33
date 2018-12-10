/**
 * UserService
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.registration=function(user){//user from controller
		return $http.post("http://localhost:9090/middleware_Collab/register",user)
	}
	
	userService.login=function(user){
		return $http.put("http://localhost:9090/middleware_Collab/login",user)
	}
	
	
	userService.logout=function(){
		return $http.put("http://localhost:9090/middleware_Collab/logout")
	}
	
	return userService;
})
