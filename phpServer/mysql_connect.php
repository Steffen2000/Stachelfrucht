<?php
require_once('config.php');
$db_link = new mysqli(
					MYSQL_HOST,
					MYSQL_BENUTZER,
					MYSQL_KENNWORT,
					MYSQL_DATENBANK		
				);
?>