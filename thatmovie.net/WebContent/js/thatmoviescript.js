 $(document).ready(function(){
       $('#login_frm').submit(function()
       {   
       
   
    	// $("#msgbox").removeClass().addClass('myinfo').text('Validating Your Login ').fadeIn(1000);   
    	 $("#msgbox").removeClass().text('Validating Your Login ').fadeIn(1000);   
    	 
    	 
    	 
    	 
    	 this.timer = setTimeout(function () {
    		 $.ajax({
    		 url: 'LoginServlet',
    		 data: 'us='+ $('#uName').val() +'&pw=' + $('#pswrd').val(),
    		 type: 'post',
    		 success: function(msg){
    		 if(msg != 'ERROR') // Message Sent, check and redirect
    		 {                // and direct to the success page
    		  
    		 // $("#msgbox").html('Login Verified, Logging in.....').addClass('myinfo').fadeTo(900,1,	 
    		 $("#msgbox").html('Login Verified, Logging in.....').fadeTo(900,1,
    		 function()
    		 
    		 {
    		 //redirect to secure page
    		 document.location='MovieViewServlet';
    		 });
    		  
    		 }
    		 else
    		 {
    		 $("#msgbox").fadeTo(200,0.1,function() //start fading the messagebox
    		 {
    		 //add message and change the class of the box and start fading
    		 $(this).html('Sorry, Wrong Combination Of Username And Password.').removeClass().addClass('myerror').fadeTo(900,1);
    		 });
    		  
    		 }
    		 }
    		  
    		 });
    		 }, 200);
    		 return false;
    		 });
    		  
    		 });
    	 
 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 /*
    	//  another way to do the ajax call
    	  
    	  var user=$('#uName').val();
          var pwd=$('#pswrd').val();
          $.ajax({
               type: "POST",
               url:"LoginServlet",
               data:{"userName":user,"passWord":pwd},
               success: function (data) {
                  if(data=='True'){
                    $(location).attr('href','Movies.jsp');
                  }else{
                      alert('Fail....');
                  }
               }
             });                                
           });
         });
    	 
    	 
    	 */