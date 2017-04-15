
<?php
include ('session.php');
$apoimentId = $_GET ['apoimentId'];
$charge = $_GET ['charge'];
/*
 * $docName= $_GET['docName'];
 * $speciality= $_GET['speciality'];
 * $hospitalName= $_GET['hospitalName'];
 * $apoimentTime= $_GET['apoimentTime'];
 *
 */
?>


<?php header('Access-Control-Allow-Origin: *'); ?>


<html>

<head>
<link rel="stylesheet" href="css/loginstyles.css">
<link rel="stylesheet" href="css/apointmentList.css">

<title>Payment Page</title>


<SCRIPT LANGUAGE="JavaScript">


    function showLayer(layer){
    	//alert(layer);

if(layer=="bank"){
	document.getElementById("bank").style.display ="block";
	document.getElementById("mobile").style.display ="none";
} if(layer=="mobile"){
	document.getElementById("mobile").style.display ="block";
	document.getElementById("bank").style.display ="none";
	
}
    	
      

        //return false;
    }

    function callPayment() {


    	var cvcNumber = document.getElementById('cvcNumber').value;
    	var ccNumber = document.getElementById('ccNumber').value;
    	var cardHolderName = document.getElementById('cardHolderName').value; 
		var currency="LKR";
		var language="EN";
		var paymentType="CC";
		var phonNumber="";
		var pin="";
		var responseUrl="";


    	var orderId = '<?php echo $apoimentId;?>';
    	var charge = '<?php echo $charge;?>';
		var userId='<?php echo $login_session; ?>';

		
		var restUrl="http://localhost:8080/rest/hospital/callHospitalCCPG/"+charge+"/"+ccNumber+"/"+cardHolderName+"/"+ccNumber+"/"+orderId+"/"+userId;
        var xhttp = new XMLHttpRequest();
        xhttp.open("POST", restUrl, true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        
       	xhttp.send();

       alert('ARE YOU SURE TO CONFIRM PAYMENT ? ');
       alert('TRANSACTION COMPLETED'+xhttp.responseText);

    }

     function mobilePayment() {
    		var cvcNumber = document.getElementById('cvcNumber').value;
        	var ccNumber = document.getElementById('ccNumber').value;
        	var cardHolderName = document.getElementById('cardHolderName').value; 
    		var currency="LKR";
    		var language="EN";
    		var paymentType="CC";
    		var phonNumber="";
    		var pin="";
    		var responseUrl="";


        	var orderId = '<?php echo $apoimentId;?>';
        	var charge = '<?php echo $charge;?>';
    		var userId='<?php echo $login_session; ?>';

    		
    		var restUrl="http://localhost:8080/rest/hospital/callHospitalMobilePG/"+charge+"/"+phonNumber+"/"+pin+"/"+orderId+"/"+userId;
            var xhttp = new XMLHttpRequest();
            xhttp.open("POST", restUrl, true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.setRequestHeader("Accept", "application/json");
            xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
            
           	xhttp.send();

           alert('ARE YOU SURE TO CONFIRM PAYMENT ? ');
           alert('TRANSACTION COMPLETED'+xhttp.responseText);
    } 
    
    //-->
    </SCRIPT>

</head>

<body onload="return showLayer('bank');">
	<table class="datagrid">
		<tr align="right">
			<td>Welcome <?php echo $login_session; ?></td>
			<td><a href="logout.php">Sign Out</a></td>
		</tr>
	</table>


	<div align="center">
		<table>
			<tr>
				<td><input type="radio" name="radio1" value="bank"
					onClick="return showLayer('bank');">Sampath Bank</td>
				<td><input type="radio" name="radio2" value="mobile"
					onClick="return showLayer('mobile');">Dialog Mobile</td>
				<br>
				<br>
				<br>
				<br>
			</tr>
		</table>

		<div id="bank">
			<form action="javascript:callPayment()" class="elegant-aero">

				<h1>Payment Page</h1>
				<label> <span>CVC Number:</span> <input id="cvcNumber" type="text"
					name="cvcNumber" placeholder="CVS Number" />
				</label> <label> <span>Credit Card Number:</span> <input
					id="ccNumber" type="text" name="ccNumber" placeholder="CC Number" />
				</label> <label> <span>Holder Name:</span> <input
					id="cardHolderName" type="text" name="cardHolderName"
					placeholder="Card Holder Name" />
				</label> <label> <span>&nbsp;</span> <input class="button"
					type="submit" value="Pay">
				</label>
			</form>

		</div>

		<div id="mobile">
			<form action="javascript:callPayment()" class="elegant-aero">

				<h1>Payment Page</h1>

				<label> <span>Mobile Number:</span> <input id="phonNumber"
					type="text" name="phonNumber" placeholder="Mobile Number" />
				</label> <label> <span>Pin Number:</span> <input id="pin"
					type="text" name="pin" placeholder="Pin Number" />
				</label> <label> <span>&nbsp;</span> <input class="button"
					type="submit" value="Pay">
				</label>

			</form>

		</div>



	</div>

</body>

</html>

