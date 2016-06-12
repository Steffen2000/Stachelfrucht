<?php

require_once('mysql_connect.php');

if($_GET["id"] != "")
{	

$id = $db_link -> escape_string($_GET["id"]);


$sql = "SELECT Status FROM User WHERE ID = '$id' LIMIT 1";
	
	$db_erg = mysqli_query($db_link, $sql);
	
	if($db_erg -> num_rows)
	{
		$status = $db_erg -> fetch_assoc();
		if($status["Status"] == "0")
		{
			echo "false";
		}
		else
		{
			echo "true";
		}
	}

}	
?>