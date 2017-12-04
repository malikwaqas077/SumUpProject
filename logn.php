<?php

  define('DB_USERNAME', 'root');
    define('DB_PASSWORD', '');
    define('DB_HOST', 'localhost');
    define('DB_NAME', 'android_test_db');
	 $conn = mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die('Unable to Connect');

  $password=$_POST["pPassword"];
   $email=$_POST["pEmail"]; 
//    if (!empty($_POST)) { if (empty($_POST['pEmail']) || empty($_POST['pPassword'])) {
// // Create some data that will be the JSON response
//  $response["error"] = true;
//   $response["message"] = "One or both of the fields are empty ."; //die is used to kill the page, will not let the code below to be executed. It will also //display the parameter, that is the json data which our android application will parse to be //shown to the users
//   die(json_encode($response));
//    } 



  $query = " SELECT * FROM tbl_prsn_dtail 

  WHERE p_Name = '$email'and p_Email='$password'";
   
   
   
   $Sql_Query = "select * from tbl_prsn_dtail where p_Name = '$email' and p_Email = '$password' ";

$check = mysqli_fetch_array(mysqli_query($conn,$Sql_Query));


   if(isset($check)){

		echo "Data Matched";
		}
		else{
		echo "Invalid Username or Password Please Try Again !";
		}
		
		mysqli_close($conn);
    
	?>
