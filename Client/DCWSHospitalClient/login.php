<?php
include ("config.php");
session_start ();
$error = "";
if ($_SERVER ["REQUEST_METHOD"] == "POST") {
	
	$myusername = mysqli_real_escape_string ( $db, $_POST ['username'] );
	$mypassword = mysqli_real_escape_string ( $db, $_POST ['password'] );
	
	$sql = "SELECT userid FROM hospitaluser WHERE username = '$myusername' and password = '$mypassword'";
	$result = mysqli_query ( $db, $sql );
	$row = mysqli_fetch_array ( $result, MYSQLI_ASSOC );
	
	$count = mysqli_num_rows ( $result );
	
	if ($count == 1) {
		$_SESSION ['login_user'] = $myusername;
		
		header ( "location: appointmentResults.php" );
	} else {
		$error = "Your Login Name or Password is invalid";
	}
}
?>
<html>

<head>
<link rel="stylesheet" href="css/loginstyles.css">
<title>Login Page</title>

<style type="text/css">

</style>

</head>

<body >


<form action="" method="post" class="elegant-aero">
    <h1>Login 
    </h1>
    <label>
        <span>UserName :</span>
        <input id="username" type="text" name="username" placeholder="User Name" />
    </label>
    
    <label>
        <span>Password :</span>
        <input id="password" type="password" name="password" placeholder="Password" />
    </label>
    
      
     <label>
        <span>&nbsp;</span> 
        <input type="submit" class="button" value="Login" /> 
    </label>    
</form>


</body>
</html>