
function Validate() 
{
    var x=document.forms["search"]["memberid"].value;
	if(x=="")
	{
		document.getElementById('idSpan').innerHTML="* Enter the MemberID";
		return false;
	}
	else if(isNaN(x)) {
   	    document.getElementById('idSpan').innerHTML="* MemberID must contain only numbers";
   	    return false;
	}
	else if(!(/^[1|2|3|4|5|6|7|8|9]\d{5}$/).test(x))
	{
		document.getElementById('idSpan').innerHTML="* MemberID must contain 6 digits only";
		return false;
	}
	else
	{
		document.getElementById('idSpan').innerHTML="";
		return true;
	}
	
}
function validateCategory()
{
    if(document.getElementById("category").selectedIndex == 0)
    {
	  document.getElementById("categorySpan").innerHTML="* Select a category";
	  return false;
    }
    else
   {
	 document.getElementById("categorySpan").innerHTML="";
	 return true;
   }
}
function fromValidate() 
{
    var date=document.getElementById('fromdate').value;
	if(date=="")
	{
		document.getElementById('fromSpan').innerHTML="* Enter the FromDate";
		return false;
	}
	
	else
	{
		var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
		if (!validformat.test(date))
		{
			document.getElementById('fromSpan').innerHTML="* Enter a valid date format(dd/mm/yyyy)";
			return false;
		}
		else	
		{ //Detailed check for valid date ranges
			var dayfield =receivedDate.split("/")[0];
			var monthfield=receivedDate.split("/")[1]; 
			var yearfield=receivedDate.split("/")[2];
			var dayobj = new Date(yearfield, monthfield-1, dayfield);
			if ((dayobj.getDate()!=dayfield)||(dayobj.getMonth()+1!=monthfield)||(dayobj.getFullYear()!=yearfield))
			{
				document.getElementById('fromSpan').innerHTML="* Enter a valid date, month, or year range";
				return false;
			}
			else
			{
				document.getElementById('fromSpan').innerHTML="";
				return true;
			}
		}
	}
}


function toValidate() 
{
	//forms["search"]["todate"]
	 var date=document.getElementById('todate').value;
	 if(date=="")
		{
			document.getElementById('toSpan').innerHTML="* Enter the ToDate";
			return false;
		}
		
		else
		{
			var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
			if (!validformat.test(date))
			{
				document.getElementById('toSpan').innerHTML="* Enter a valid date format(dd/mm/yyyy)";
				return false;
			}
			else	
			{ //Detailed check for valid date ranges
				var dayfield =receivedDate.split("/")[0];
				var monthfield=receivedDate.split("/")[1]; 
				var yearfield=receivedDate.split("/")[2];
				var dayobj = new Date(yearfield, monthfield-1, dayfield);
				if ((dayobj.getDate()!=dayfield)||(dayobj.getMonth()+1!=monthfield)||(dayobj.getFullYear()!=yearfield))
				{
					document.getElementById('toSpan').innerHTML="* Enter a valid date, month, or year range";
					return false;
				}
				else
				{
					document.getElementById('toSpan').innerHTML="";
					return true;
				}
			}
		}
}
function display_alert()
{
    var reason = document.getElementById("reason").value;
	if(reason == "" ||!isNaN(reason))
	{
	    alert("please provide a valid reason for fine cancellation");
		document.finecancellation.reason.focus();
		return false;
	}
	else
	{
	   alert("The fine has been cancelled and the status is updated");
	}
}
function display_alert1()
{
		 alert("The payment has been done and the status is updated");
}
function myfunction(s)
{
	if(s==1)
	{
      document.getElementById("dl").value="memberdetails";
	}
	else
	{
	   document.getElementById("dl").value="defaulters";
	}
}
function myfun(s)
{  
	
   if(s==1)
	{
	  
	  document.getElementById("pay").value="payment";
	}
	else
	{
	  
	  document.getElementById("pay").value="cancel";
	  
	}
	
  //return  check();
   
}
function chkForm(form) {

	var isChecked=0;
	
	for ( var i=0;i<form.elements.length;i++) {
		alert(12);
		if ( ( form.detail[i].checked == true ))
		{
			alert(12);
			isChecked++;
		}
	}	
	if (isChecked > 0) { alert('Just so you know it worked\-going to submit now.'); //form.submit(); 
	
	} 
	else { alert('You didn\'t check a box. We told you to check a box.');  } 
	}
function check()
{
	var x=document.getElementById("detail").value;
	if(!x.checked)
	{
	  alert("Please select atleast one checkbox");
	  return false;
	}	

}
function defaulter()
{
	var count=0;
	if(fromValidate())
	{
		
	}
	else
		count++;
	if(toValidate())
	{
		
	}
	else
		count++;
	
	
	if(count>0)
		return false;
	else
		return true;
	}
function validateSearch()
{
	var count=0;
	if(Validate())
	{
		
	}
	else
		count++;
	if(validateCategory())
	{
		
	}
	else
		count++;
	if(fromValidate())
	{
		
	}
	else
		count++;
	if(toValidate())
	{
		
	}
	else
		count++;
	
	
	if(count>0)
		return false;
	else
		return true;
	
}