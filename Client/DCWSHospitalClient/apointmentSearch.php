
<?php
include ('session.php');
?>


<?php header('Access-Control-Allow-Origin: *'); ?>


<html>

<head>
<link rel="stylesheet" href="css/loginstyles.css">
<link rel="stylesheet" href="css/apointmentList.css">

<title>Payment Page</title>


<SCRIPT LANGUAGE="JavaScript">
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
	

		<div id="bank">
			<form action="appointmentResults.php" class="elegant-aero">

				<h1>Search Page</h1>
				<label> <span>Doctor Name:</span> <input id="docName" type="text"
					name="docName" placeholder="Doctor Name" />
				</label> <label> <span>Hospital Name:</span> <input
					id="hospitalName" type="text" name="hospitalName" placeholder="Hospital Name" />
				</label> <label> <span>Specialization:</span> <input
					id="specialization" type="text" name="specialization"
					placeholder="Specialization" />
					
					</label> <label> <span>Date:</span> <input
					id="date" type="date" name="date"
					placeholder="Apointment Date" />
	
				</label> <label> <span>&nbsp;</span> <input class="button"
					type="submit" value="Search">
				</label>
			</form>

		</div>




	</div>

</body>

</html>

