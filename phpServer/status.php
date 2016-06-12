<?php
/** Statusabfrage durch den Fahrrad-Computer
* Bei GET Anfrage wird die User_ID uebermittelt
* Mit Daten aus der Datenbank vergleichen
*/

// Übernimmt die Daten aus der mysql_connect.php
require_once('mysql_connect.php');

// Wenn id nicht leer ist...
if($_GET["id"] != "")
	{

	// ...dann wird in der Datenbank...
	$id = $db_link -> escape_string($_GET["id"]);
	
	// ...Status aus der Tabelle User ausgewaehlt und... 
	$sql = "SELECT Status FROM User WHERE ID = '$id' LIMIT 1";
	
	$db_erg = mysqli_query($db_link, $sql);
	
	// ...es wird geprüft ob der Wert 1 oder 0 ist...
	if($db_erg -> num_rows)
		{
		$status = $db_erg -> fetch_assoc();
		// ...und wenn der Wert 0 ist, dann...
		if($status["Status"] == "0")
			{
				// ...wird false als String ausgegeben aber wenn es 1 ist dann...
				echo "false";
			}
		else
			{
				// ...wird true als String ausgegeben
				echo "true";
			}
		}
}	
?>