<?php
/** Laengen und Breiten Daten werden in die Datenbank übertragen
* Es wird eine MySQL Verbindung mit der Datenbank aufgebaut aus mysql_connect.php
* Und es werden die Daten Laenge, Breite, ID_User in die Datenbank geschrieben
*/

// Übernimmt die Daten aus der mysql_connect.php
require_once('mysql_connect.php');

// Wenn abfrage ob die POST Variable ein Array ist
if(count($_POST) > 0)
	{
		// Laenge Variable entspricht der laenge in der Datenbank
		$laenge = $db_link -> escape_string($_POST["laenge"]);
		// Breite Variable entspricht der breite in der Datenbank
		$breite = $db_link -> escape_string($_POST["breite"]);
		// Id Variable entspricht der id in der Datenbank
		$id = $db_link -> escape_string($_POST["id"]);
		
		// Daten werden in die Datenbank eingefügt
		$sql = "INSERT INTO GpsData
			(Laenge, Breite, ID_User)
			VALUES
			('$laenge', '$breite', '$id');";
		
		$db_erg = mysqli_query($db_link, $sql);
}