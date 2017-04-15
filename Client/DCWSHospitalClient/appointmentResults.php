
<?php
include ('session.php');
?>

<html>

<head>
<link rel="stylesheet" href="css/apointmentList.css">
<title>Welcome</title>
</head>

<body>
	<div>
		<table class="datagrid">
			<tr align="right">
				<td>Welcome <?php echo $login_session; ?></td>
				<td><a href="logout.php">Sign Out</a></td>

			</tr>
		</table>
	</div>
	</br>
	</br>

</body>

</html>

<?php

$json = file_get_contents ( "http://localhost:9763/DCWSHospitalSystem/rest/hospital/getAllApointments" );
$data = json_decode ( $json );

if (count ( $data->appointmentList )) {
	// Open the table
	echo "<div class=\"datagrid\">";
	echo "<table border=1 cellspacing=0 cellpadding=2>";
	echo "<thead>
	<tr>
	<th >DOCTOR NAME</th><th>SPECIALITY</th><th>HOSPITAL NAME</th><th>APOINMENT TIME</th><th>CHARGE (RS)</th><th>PAYMENT</th>
	</tr>
	</thead>";
	
	// Iterate array list in loop
	foreach ( $data->appointmentList as $idx => $appointment ) {
		
		// Output a row
		echo "<tr>";
		echo "<td>$appointment->docName</td>";
		echo "<td>$appointment->speciality</td>";
		echo "<td>$appointment->hospitalName</td>";
		echo "<td>$appointment->apoimentTime</td>";
		echo "<td>$appointment->charge</td>";
		echo "<td><a href='paymentPage.php?apoimentId=$appointment->apoimentId&charge=$appointment->charge'>Book</a></td>";
		echo "</tr>";
	}
	
	// Close the table
	echo "</table>";
	echo "</div>";
}

?>
