
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

function validateId()
{
	var title=document.getElementById("id").value;
	if(title=="")
	{
		document.getElementById('idSpan').innerHTML="* Enter the id";
		return false;
	}
	else
	{
		document.getElementById('idSpan').innerHTML="";
		return true;
	}
}
function Validatemember() {
	
	var title=document.getElementById("memberId").value;
	 if(isNaN("memberid")) {
		 document.getElementById('memberSpan').innerHTML="* Enter the title";
			return false;
		
	}
	 else
		{
			document.getElementById('memberSpan').innerHTML="";
			return true;
		}
	}
function validatememberId()
{
	var title=document.getElementById("memberId").value;
	if(title=="")
	{
		document.getElementById('midSpan').innerHTML="* Enter the member id";
		return false;
	}
	else
	{
		document.getElementById('midSpan').innerHTML="";
		return true;
	}
}
function validatevolno()
{
	var title=document.getElementById("volno").value;
	if(title=="")
	{
		document.getElementById('volnoSpan').innerHTML="* Enter the volume number";
		return false;
	}
	else
	{
		document.getElementById('volnoSpan').innerHTML="";
		return true;
	}
}

function validateUserID()
{
	var userID=document.getElementById("userID").value;
	
	if(userID=="")
	{
		document.getElementById('userIDSpan').innerHTML="* Enter the UserID";
		return false;
	}
	else if(isNaN(userID)) {
   	 document.getElementById('userIDSpan').innerHTML="* UserID must contain only numbers";
   	 return false;
	}
	else
	{
		document.getElementById('userIDSpan').innerHTML="";
		return true;
	}
}

function validatePassword()
{
	var password=document.getElementById("password").value;
	 var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if(password=="")
	{
		document.getElementById('passwordSpan').innerHTML="* Enter the password";
		return false;
	}
	
	 else if(!re.test(password))
	 {
     	 document.getElementById('passwordSpan').innerHTML="* Invalid password format";
     
      return false;
	 }
	else
	{
		document.getElementById('passwordSpan').innerHTML="";
		return true;
	}
}



function validateTitle()
{
	var title=document.getElementById("title").value;
	if(title=="")
	{
		document.getElementById('titleSpan').innerHTML="* Enter the title";
		return false;
	}
	else if (!title.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('titleSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('titleSpan').innerHTML="";
		return true;
	}
}
function validateRefID()
{
	System.out.println("ih");
	var refID=document.getElementById("refID").value;
	
	if(refID=="")
	{
		
		document.getElementById('refIDSpan').innerHTML="* Enter the reference ID";
		return false;
	}
	else
	{
		document.getElementById('refIDSpan').innerHTML="";
		return true;
	}
}

function validateRefIdBTM()
{
	System.out.println("ih");
	var refID=document.getElementById("refid").value;
	
	if(refID=="")
	{
		
		document.getElementById('refIDSpan').innerHTML="* Enter the reference ID";
		return false;
	}
	else
	{
		document.getElementById('refIDSpan').innerHTML="";
		return true;
	}
}
function validateIsbn()
{
	var isbn=document.getElementById("isbn").value;
	if(isbn=="")
	{
		document.getElementById('isbnSpan').innerHTML="* Enter the ISBN number";
		return false;
	}
	else if(isbn.length!=13)
	{
		document.getElementById('isbnSpan').innerHTML="* Enter a valid ISBN";
		return false;
	}
	else if(isNaN(isbn))
	{
		document.getElementById('isbnSpan').innerHTML="* Enter a valid ISBN(only numbers)";
		return false;
	}
	else
	{
		var str = document.getElementById("isbn").value;
		var res="";
		var sum=0;
		for(var i=0;i<str.length-1;i++)
		{
		    res=res+str[i];
		if(i%2==0)
		{
		   sum=sum+(parseInt(str[i])*1);
		}
		else
		{
		   sum=sum+(parseInt(str[i])*3);
		}
		}
		sum=sum%10;
		sum=10-sum;
		if(sum==str[12])
		{
			document.getElementById('isbnSpan').innerHTML="";
			return true;
		}
		else
		{
			document.getElementById('isbnSpan').innerHTML="* Enter a valid isbn number";
			return false;
		}
	}
}

function validateSubject()
{
	var subject=document.getElementById("subject").value;
	if(subject=="")
	{
		document.getElementById('subjectSpan').innerHTML="* Enter the subject";
		return false;
	}
	else if (!subject.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('subjectSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('subjectSpan').innerHTML="";
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

function validateEdition()
{
	var edition=document.getElementById("edition").value;
	if(edition=="")
	{
		document.getElementById('editionSpan').innerHTML="* Enter the edition";
		return false;
	}
	else if(isNaN(edition))
	{
		document.getElementById('editionSpan').innerHTML="* Enter a valid edition(only numbers)";
		return false;
	}
	else
	{
		document.getElementById('editionSpan').innerHTML="";
		return true;
	}
}
function validateAuthor()
{
	var author=document.getElementById("author").value;
	if(author=="")
	{
		document.getElementById('authorSpan').innerHTML="* Enter the author";
		return false;
	}
	else if (!author.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('authorSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('authorSpan').innerHTML="";
		return true;
	}
}
function validateEditor()
{
	var editor=document.getElementById("editor").value;
	if(editor=="")
	{
		document.getElementById('editorSpan').innerHTML="* Enter the editor";
		return false;
	}
	else if (!editor.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('editorSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('editorSpan').innerHTML="";
		return true;
	}
}

function validatePublisher()
{
	var publisher=document.getElementById("publisher").value;
	if(publisher=="")
	{
		document.getElementById('publisherSpan').innerHTML="* Enter the publisher";
		return false;
	}
	else if (!publisher.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('publisherSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('publisherSpan').innerHTML="";
		return true;
	}
}

function validatePlaceOfPublication()
{
	var placeOfPublication=document.getElementById("placeOfPublication").value;
	if(placeOfPublication=="")
	{
		document.getElementById('placeOfPublicationSpan').innerHTML="* Enter the place of publication";
		return false;
	}
	else if (!placeOfPublication.match(/^[a-zA-Z '.-]+$/))
	{
	document.getElementById('placeOfPublicationSpan').innerHTML="* Only alphabets are allowed";
	return false;
	}
	else
	{
		document.getElementById('placeOfPublicationSpan').innerHTML="";
		return true;
	}
}

function validateYearOfPublication()
{
	var yearOfPublication=document.getElementById("yearOfPublication").value;
	if(yearOfPublication=="")
	{
		document.getElementById('yearOfPublicationSpan').innerHTML="* Enter the year of publication";
		return false;
	}
	else if(isNaN(yearOfPublication))
	{
		document.getElementById('yearOfPublicationSpan').innerHTML="* Enter a valid year of publication(only numbers)";
		return false;
	}
	else if(yearOfPublication.length!==4)
		{
		document.getElementById('yearOfPublicationSpan').innerHTML="* Enter a 4 digit number only";
		return false;
		}
	else
	{
		document.getElementById('yearOfPublicationSpan').innerHTML="";
		return true;
	}
}

function validateCost()
{
	var cost=document.getElementById("cost").value;
	if(cost=="")
	{
		document.getElementById('costSpan').innerHTML="* Enter the cost";
		return false;
	}
	else if(isNaN(cost))
	{
		document.getElementById('costSpan').innerHTML="* Enter a valid cost(only numbers)";
		return false;
	}
	else
	{
		document.getElementById('costSpan').innerHTML="";
		return true;
	}
}

function validateReceivedDate()
{
	var yearOfPublication=document.getElementById("yearOfPublication").value;
	if(yearOfPublication=="")
	{
		document.getElementById('receivedDateSpan').innerHTML="* Enter the year of publication first";
		return false;
	}
	else if(isNaN(yearOfPublication))
	{
		document.getElementById('receivedDateSpan').innerHTML="* Enter a valid year of publication(only numbers)first";
		return false;
	}
	else if(yearOfPublication.length!=4)
	{
		document.getElementById('receivedDateSpan').innerHTML="* Enter a valid year of publication(4-digit number)first";
		return false;
	}
	else
	{
		var receivedDate=document.getElementById("receivedDate").value;
		if(receivedDate=="")
		{
			document.getElementById('receivedDateSpan').innerHTML="* Enter the received date";
			return false;
		}
		else
		{
			var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
			if (!validformat.test(receivedDate))
			{
				document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date format(mm/dd/yyyy)";
				return false;
			}
			else	
			{ //Detailed check for valid date ranges
				var monthfield=receivedDate.split("/")[0];
				var dayfield=receivedDate.split("/")[1];
				var yearfield=receivedDate.split("/")[2];
				var dayobj = new Date(yearfield, monthfield-1, dayfield);
				if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
				{
					document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date, month, or year range";
					return false;
				}
				else
				{
					if(yearfield>=yearOfPublication){
						document.getElementById('receivedDateSpan').innerHTML="";
						return true;
					}
					else{
						document.getElementById('receivedDateSpan').innerHTML="* Received date should be greater than or equal to year of publication";
						return false;
					}
				}
			}
		}
	}
}
function validateReceivedDateMagazine()
{	
	var dateOfMagazine=document.getElementById("dateOfMagazine").value;
	if(dateOfMagazine=="")
	{
		document.getElementById('receivedDateSpan').innerHTML="* Enter the date of the magazine first";
		return false;
	}
	else
	{
		var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
		if (!validformat.test(dateOfMagazine))
		{
			document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date format first for date of the magazine(mm/dd/yyyy)";
			return false;
		}
		else
		{ //Detailed check for valid date ranges
			var monthfield=dateOfMagazine.split("/")[0];
			var dayfield=dateOfMagazine.split("/")[1];
			var yearfield=dateOfMagazine.split("/")[2];
			var dayobj = new Date(yearfield, monthfield-1, dayfield);
			if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
			{
				document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date, month, or year range for date of the magazine";
				return false;
			}
			else
			{
				var receivedDate=document.getElementById("receivedDate").value;
				if(receivedDate=="")
				{
					document.getElementById('receivedDateSpan').innerHTML="* Enter the received date";
					return false;
				}
				else
				{
					var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
					if (!validformat.test(receivedDate))
					{
						document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date format for received date(mm/dd/yyyy)";
						return false;
					}
					else
					{ //Detailed check for valid date ranges
						var monthfield1=receivedDate.split("/")[0];
						var dayfield1=receivedDate.split("/")[1];
						var yearfield1=receivedDate.split("/")[2];
						var dayobj1 = new Date(yearfield1, monthfield1-1, dayfield1);
						if ((dayobj1.getMonth()+1!=monthfield1)||(dayobj1.getDate()!=dayfield1)||(dayobj1.getFullYear()!=yearfield1))
						{
							document.getElementById('receivedDateSpan').innerHTML="* Enter a valid date, month, or year range for received date";
							return false;
						}
						else
						{
							if(yearfield1>yearfield)
							{
								document.getElementById('receivedDateSpan').innerHTML="";
								return true;
							}
							else if(yearfield1==yearfield)
							{
								if(monthfield1>monthfield)
								{
									document.getElementById('receivedDateSpan').innerHTML="";
									return true;
								}
								else if(monthfield1==monthfield)
								{
									if(dayfield1>=dayfield)
									{
										document.getElementById('receivedDateSpan').innerHTML="";
										return true;
									}
									else
									{
										document.getElementById('receivedDateSpan').innerHTML="* Received date should be greater than or equal to date of publication";
										return false;
									}
								}
								else
								{
									document.getElementById('receivedDateSpan').innerHTML="* Received date should be greater than or equal to date of publication";
									return false;
								}
							}
							else
							{
								document.getElementById('receivedDateSpan').innerHTML="* Received date should be greater than or equal to date of publication";
								return false;
							}
								
						}
					
					}
				}
			}
		}
	}
}
function validateQuantity()
{
	var quantity=document.getElementById("quantity").value;
	if(quantity=="")
	{
		document.getElementById('quantitySpan').innerHTML="* Enter the quantity";
		return false;
	}
	else if(isNaN(quantity))
	{
		document.getElementById('quantitySpan').innerHTML="* Enter a valid quantity(only numbers)";
		return false;
	}
	else if(quantity!=1)
	{
		document.getElementById('quantitySpan').innerHTML="* You can add only one item at a time(Assumption)";
		return false;
	}
	else
	{
		document.getElementById('quantitySpan').innerHTML="";
		return true;
	}
}

function validateVolumeNo()
{
	var volumeNo=document.getElementById("volumeNo").value;
	if(volumeNo=="")
	{
		document.getElementById('volumeNoSpan').innerHTML="* Enter the volume no of the magazine";
		return false;
	}
	else if(isNaN(volumeNo))
	{
		document.getElementById('volumeNoSpan').innerHTML="* Enter a valid volume no(only numbers)";
		return false;
	}
	else
	{
		document.getElementById('volumeNoSpan').innerHTML="";
		return true;
	}
}

function validateIssueNo()
{
	var issueNo=document.getElementById("issueNo").value;
	if(issueNo=="")
	{
		document.getElementById('issueNoSpan').innerHTML="* Enter the issue no of the magazine";
		return false;
	}
	else if(isNaN(issueNo))
	{
		document.getElementById('issueNoSpan').innerHTML="* Enter a valid issue no(only numbers)";
		return false;
	}
	else
	{
		document.getElementById('issueNoSpan').innerHTML="";
		return true;
	}
}

function validateDateOfMagazine()
{
	var dateOfMagazine=document.getElementById("dateOfMagazine").value;
	if(dateOfMagazine=="")
	{
		document.getElementById('dateOfMagazineSpan').innerHTML="* Enter the date of the magazine";
		return false;
	}
	else
	{
		var validformat=/^\d{2}\/\d{2}\/\d{4}$/; //Basic check for format validity
		if (!validformat.test(dateOfMagazine))
		{
			document.getElementById('dateOfMagazineSpan').innerHTML="* Enter a valid date format(mm/dd/yyyy)";
			return false;
		}
		else
		{ //Detailed check for valid date ranges
			var monthfield=dateOfMagazine.split("/")[0];
			var dayfield=dateOfMagazine.split("/")[1];
			var yearfield=dateOfMagazine.split("/")[2];
			var dayobj = new Date(yearfield, monthfield-1, dayfield);
			if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
			{
				document.getElementById('dateOfMagazineSpan').innerHTML="* Enter a valid date, month, or year range";
				return false;
			}
			else
			{
				document.getElementById('dateOfMagazineSpan').innerHTML="";
				return true;
			}
		}
	}
}

function validateSubscriptionType()
{
if(document.getElementById("subscription").selectedIndex == 0)
{
	document.getElementById("subscriptionSpan").innerHTML="* Select a subscription type";
	return false;
}
else
{
	document.getElementById("subscriptionSpan").innerHTML="";
	return true;
}
}

function validateUser()
{
	var count=0;
	if(validateUserID())
		{
		
		}
	else 
		count++;
	if(validatePassword())
		{
		
		}
	else
		count++;
}
function validateCd()
{
	var count=0;
	//alert(validateTitle());
	if(validateTitle())
		
	{
		
	}
	else
		count++;
if(validateId())
		
	{
		
	}
	else
		count++;
if(validatememberId())
	
{
	
}
else
	count++;
	//alert(validateIsbn());
	
	//alert(validateSubject());
	
	//alert(validateCategory());
	
	//alert(validateEdition());
	
	//alert(validateAuthor());
	
	//alert(validateEditor());
	
	//alert(validatePublisher());
	
	//alert(validatePlaceOfPublication());
	
	//alert(validateYearOfPublication());
	
	//alert(validateCost());
	
	//alert(validateReceivedDate());
	
	//alert(validateQuantity());
	
	//alert(count);
	if(count>0)
		return false;
	else
		return true;
}
function validateMagazin()
{
	var count=0;
	//alert(validateTitle());
	if(validateTitle())
		
	{
		
	}
	else
		count++;
  if(validateId())
		
	{
		
	}
	else
		count++;
if(validatememberId())
	
{
	
}

else
	count++;
if(validatevolno())
	
{
	
}

else
	count++;

	if(count>0)
		return false;
	else
		return true;
}

function validateBook()
{
	var count=0;
	//alert(validateTitle());
	if(validateTitle())
		
	{
		
	}
	else
		count++;
	//alert(validateIsbn());
	if(validateIsbn())
	{
		
	}
	else
		count++;
	//alert(validateSubject());
	if(validateSubject())
	{
		
	}
	else
		count++;
	//alert(validateCategory());
	if(validateCategory())
	{
		
	}
	else
		count++;
	//alert(validateEdition());
	if(validateEdition())
	{
		
	}
	else
		count++;
	//alert(validateAuthor());
	if(validateAuthor())
	{
		
	}
	else
		count++;
	//alert(validateEditor());
	if(validateEditor())
	{
		
	}
	else
		count++;
	//alert(validatePublisher());
	if(validatePublisher())
	{
		
	}
	else
		count++;
	//alert(validatePlaceOfPublication());
	if(validatePlaceOfPublication())
	{
		
	}
	else
		count++;
	//alert(validateYearOfPublication());
	if(validateYearOfPublication())
	{
		
	}
	else
		count++;
	//alert(validateCost());
	if(validateCost())
	{
		
	}
	else
		count++;
	//alert(validateReceivedDate());
	if(validateReceivedDate())
	{
		
	}
	else
		count++;
	//alert(validateQuantity());
	if(validateQuantity())
	{
		
	}
	else
		count++;
	//alert(count);
	if(count>0)
		return false;
	else
		return true;
}

function resetBookSpan()
{
	document.getElementById("isbnSpan").innerHTML="";
	document.getElementById("titleSpan").innerHTML="";
	document.getElementById("subjectSpan").innerHTML="";
	document.getElementById("categorySpan").innerHTML="";
	document.getElementById("editionSpan").innerHTML="";
	document.getElementById("authorSpan").innerHTML="";
	document.getElementById("editorSpan").innerHTML="";
	document.getElementById("publisherSpan").innerHTML="";
	document.getElementById("placeOfPublicationSpan").innerHTML="";
	document.getElementById("yearOfPublicationSpan").innerHTML="";
	document.getElementById("costSpan").innerHTML="";
	document.getElementById("receivedDateSpan").innerHTML="";
	document.getElementById("quantitySpan").innerHTML="";
}


function validateCD()
{
	var count=0;
	if(validateTitle())
	{
		
	}
	else
		count++;
	if(validateSubject())
	{
		
	}
	else
		count++;
	if(validatePublisher())
	{
		
	}
	else
		count++;
	if(validatePlaceOfPublication())
	{
		
	}
	else
		count++;
	if(validateYearOfPublication())
	{
		
	}
	else
		count++;
	if(validateCost())
	{
		
	}
	else
		count++;
	if(validateReceivedDate())
	{
		
	}
	else
		count++;
	if(validateQuantity())
	{
		
	}
	else
		count++;
	
	if(count>0)
		return false;
	else
		return true;
}

function resetCDSpan()
{
	document.getElementById("titleSpan").innerHTML="";
	document.getElementById("subjectSpan").innerHTML="";
	document.getElementById("publisherSpan").innerHTML="";
	document.getElementById("placeOfPublicationSpan").innerHTML="";
	document.getElementById("yearOfPublicationSpan").innerHTML="";
	document.getElementById("costSpan").innerHTML="";
	document.getElementById("receivedDateSpan").innerHTML="";
	document.getElementById("quantitySpan").innerHTML="";
}


function validateMagazine()
{
	var count=0;
	if(validateTitle())
	{
		
	}
	else
		count++;
	if(validateVolumeNo())
	{
		
	}
	else
		count++;
	if(validateIssueNo())
	{
		
	}
	else
		count++;
	if(validateIsbn())
	{
		
	}
	else
		count++;
	if(validateCost())
	{
		
	}
	else
		count++;
	if(validateDateOfMagazine())
	{
		
	}
	else
		count++;
	if(validateReceivedDateMagazine())
	{
		
	}
	else
		count++;
	if(validateSubscriptionType())
	{
		
	}
	else
		count++;
	if(validateQuantity())
	{
		
	}
	else
		count++;
	
	if(count>0)
		return false;
	else
		return true;
}

function resetMagazineSpan()
{
	document.getElementById("titleSpan").innerHTML="";
	document.getElementById("volumeNoSpan").innerHTML="";
	document.getElementById("issueNoSpan").innerHTML="";
	document.getElementById("isbnSpan").innerHTML="";
	document.getElementById("costSpan").innerHTML="";
	document.getElementById("dateOfMagazineSpan").innerHTML="";	
	document.getElementById("receivedDateSpan").innerHTML="";
	document.getElementById("subscriptionSpan").innerHTML="";
	document.getElementById("quantitySpan").innerHTML="";
}

function validateIssueBook()
{
	var count=0;
	if(validateId())
	{
		
	}
	else
		count++;
	if(validateTitle())
	{
		
	}
	else
		count++;
	if(validateIsbn())
	{
		
	}
	else
		count++;
	if(validatememberId())
	{
		
	}
	else
		count++;
	if(count>0)
		return false;
	else
		return true;
} 
function validateReneww()
{
	var count=0;
	if(validatememberId())
	{
		
	}
	else
		count++;
	if(count>0)
		return false;
	else
		return true;
}
