
function validateForm() {
	//alert("Please select value"+document.getElementById("drop").value); 
	if(document.getElementById("drop").value =="selecta")
	   {
	      alert("Please select the Category"); // prompt user
	      document.getElementById("drop").focus(); //set focus back to control
	      return false;
	   }
	
	if(document.getElementById("title").value==""&&document.getElementById("isbn").value==""&&document.getElementById("volume").value=="")
	{
		 alert("please enter title/isbn/volume"); 
		 return false;
	}
}