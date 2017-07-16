Team WebEngPro

Mitglieder:
-Andreas Niederquell, 
-Marc Wendelborn, 
-Marco Landau, 
-Yiannis Englberger, 77664
-Michael Ehrlinger, 77474

SetUp-Guide:
Um die Webanwendung zu starten, laden Sie bitte das Repository herunter und laden Sie es in Intelij IDEA
(Alternativ kann man hier das Projekt auch über Version Control auschecken).

Zum starten des Servers führen Sie bitte die Klasse ‚ViertausendApplication‘ aus, daraufhin sollte sich die Konsole in Intelij IDEA öffnen 
und man kann das Starten des Servers beobachten, das Ende des Startvorgangs erkennt man an der 
Zeile ‚Started ViertausendApplication in _.__ seconds (JVM running for _.___)‘, nun kann Intelij IDEA gegebenfalls minimiert werden.

Öffnen Sie nun den Browser  Ihrer Wahl, zum Aufruf der Anwendung geben Sie in die Adresszeile ‚localhost:8080/index.html‘ ein, 
daraufhin wird die Anwendung geladen und ist bereit zur Verwendung.

Beim Starten der Anwendung sind keine initialen Werte vorhanden, wenn man nun solche möchte, muss man in einem neuem Browserfenster 
oder in einem neuen Tab des bereits geöffneten Fensters ‚localhost:8080/addInit‘ eintippen, darauf erscheint eine Meldung drüber, 
ob der Vorgang erfolgreich war oder nicht. Damit die Werte nun auch in der Anwendung angezeigt werden, 
muss diese aktualisiert werden(die Notwendigkeit zu aktualisieren wird auch in der Meldung erwähnt, sofern das hinzufügen der Daten 
erfolgreich war). Dieser Initialisierungsvorgang kann nur einmal, direkt nach dem Start ausgeführt werden, 
wurden bereits eigen Daten eingetragen, können die initialen Daten nicht mehr geladen werden.
Die Registrierung   eines neuen Users erfolgt über die Schaltfläche ‚Registrieren‘, daraufhin erscheinen ein Eingabefeld 
für den Benutzernamen und eins für das Passwort sowie die Schaltfläche ‚Registrieren‘. Sollte der gewählte Benutzername 
bereits vergeben sein, erscheint eine entsprechende Meldung auf dem Bildschirm. Wenn die Registrierung erfolgreich war, 
erscheint eine Meldung, man könne sich nun mit den eben angelegten Benutzerdaten einloggen, man ist also nicht automatisch eingeloggt.
