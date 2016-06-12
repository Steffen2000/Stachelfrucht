<?php
require_once('mysql_connect.php');

if(count($_POST) > 0)
{
	


$laenge = $db_link -> escape_string($_POST["laenge"]);
$breite = $db_link -> escape_string($_POST["breite"]);
$id = $db_link -> escape_string($_POST["id"]);



$sql = "INSERT INTO GpsData
	(
	Laenge, Breite, ID_User
	)
	VALUES
	(
	'$laenge', '$breite', '$id'
	);
	";
	
	$db_erg = mysqli_query($db_link, $sql);
	
}