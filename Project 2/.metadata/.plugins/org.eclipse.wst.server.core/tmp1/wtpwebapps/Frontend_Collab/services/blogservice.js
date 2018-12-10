/**
 * BlogService
 */
app.factory('BlogService',function($http){
	var blogService={}
	
	blogService.addBlog=function(blog){
		return $http.post("http://localhost:9090/middleware_Collab/addblogpost",blog)
	}
	blogService.getBlogsWaitingForApproval=function(){
		return $http.get("http://localhost:9090/middleware_Collab/blogswaitingforapproval")
	}
	
	blogService.getBlogsApproved=function(){
		return $http.get("http://localhost:9090/middleware_Collab/blogsapproved")
	}
	
	blogService.getBlog=function(blogPostId){
		return $http.get("http://localhost:9090/middleware_Collab/getBlog/"+blogPostId)
	}
	blogService.approve=function(blogPost){
    	return $http.put("http://localhost:9090/middleware_Collab/approve",blogPost)
    }	
	
	blogService.reject=function(blogPost,rejectionReason){
		return $http.put("http://localhost:9090/middleware_Collab/reject/"+rejectionReason,blogPost)
	}
	
	blogService.hasUserLikedBlogPost=function(blogPostId){
		return $http.get("http://localhost:9090/middleware_Collab/hasUserLikedBlogPost/"+blogPostId);
	}
	
	blogService.updateLikes=function(blogPostId){
		return $http.put("http://localhost:9090/middleware_Collab/updatelikes/"+blogPostId);
	}
	
	blogService.addBlogComment=function(blogComment){
		//newly created blogcomment object with the values for two properties - blogPost, commentTxt
		//blogComment {'blogPost':{},'commentTxt':'Thanks'}
		return $http.post("http://localhost:9090/middleware_Collab/addblogcomment",blogComment)
	}
	
	blogService.getAllBlogComments=function(blogPostId){
	return $http.get("http://localhost:9090/middleware_Collab/getblogcomments/"+blogPostId)	
	}
	return blogService;
})
