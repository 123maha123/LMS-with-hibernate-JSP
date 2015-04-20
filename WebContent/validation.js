function validateFor() {

    var x = document.forms["return"]["id"].value;
    if (!(/^[1|2|3|4|5|6|7|8|9]\d{5}$/).test(x)) {
        alert("Enter valid MemberId");
        return false;
    }
}
function validateRenew(){
	   
	var y = document.forms["renew"]["mid"].value;
	    if (!(/^[1|2|3|4|5|6|7|8|9]\d{5}$/).test(y)) {
	        alert("Enter valid MemberId");
	        return false;
	    }
}
    
    
    function checkBox(){

    	var flag=0;
    for(var i=0;i<document.getElementsByName("1").length;i++)
    {
      if(document.getElementsByName("1")[i].checked==true)
      {
       flag+=1;
      }
     
    }
  
    if(flag<1){
    alert("Select one option from the list");
    return false;
    }
}


