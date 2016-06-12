<?php
/** Bringt alle Informationen zur Datenbank Verbindung in eine Variable
* Daten wie MYSQL_HOST, MYSQL_BENUTZER, MYSQL_KENNWORT, MYSQL_DATENBANK werden
* alle in nur eine Variable zusammengefasst
*/

// Übernimmt die Daten aus der config.php
require_once('config.php');

// Es werden die MariaDB Informationen in eine Variable gespeichert ($db_link)
$db_link = new mysqli(
					MYSQL_HOST,
					MYSQL_BENUTZER,
					MYSQL_KENNWORT,
					MYSQL_DATENBANK		
				);
?>