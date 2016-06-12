<?php
/** Stachelfrucht Konfiguration
* Server Verbindungseinstellungen
* Lokale Datenbank
* Zugang zur Datenbank
*/

// Damit alle Fehler angezeigt werden
error_reporting(E_ALL);
 
// Zum Aufbau die Verbindung zur Datenbank
define ( 'MYSQL_HOST',      '127.0.0.1' );
define ( 'MYSQL_BENUTZER',  'root' );
define ( 'MYSQL_KENNWORT',  '' );
define ( 'MYSQL_DATENBANK', 'fahrrad' );
?>