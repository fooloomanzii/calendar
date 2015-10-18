# Source-Folder

---

## Produktfunktionen

    */F010/ Kalanderansicht mit Hilfe einer GUI. Dabei werden Termine grafisch hervorgehoben, sowie und der Titel mit Uhrzeit angezeigt, sofern die aktuelle Ansicht letzteres zulässt.
      ** /F011/ Monatsansicht
      ** /F012/ Wochenansicht
      ** /F013/ Tagesansicht
      ** /F014/ Jahresansicht

    */F020/ Der Anwender kann Termine auf zweierlei Arten erstellen:
      ** /F021/ Durch Mausklick auf einen Tag/Stunde
      ** /F022/ Durch Auswahl „Termin hinzufügen“ in einer Menüleiste.

    */F030/ Die Interaktion in der Kalenderansicht kann sowohl mit dem Mausrad, als auch durch die Cursortasten der Tastatur geschehen.

    */F040/ Am oberen Rand der Benutzungsoberfläche soll eine Menüleiste verfügbar sein, die neben den Kalenderverwaltungsfunktionen die Einstellungen beinhaltet.

    */F110/ Termine kann man für das angemeldete Konto:
      ** /F111/ anlegen
      ** /F112/ löschen
      ** /F113/ ändern

    */F210/ Der Benutzer kann seinen Kalender optional mit einem Onlinekalender synchronisieren, manuell oder automatisch.
    */F220/ Der Anwender kann Benutzer anlegen, die aus Benutzernamen und Kennwort bestehen. Es soll folgende Möglichkeiten geben:
      ** /F221/ Benutzer wechseln
      ** /F222/ Benutzer löschen
      ** /F223/ \textit{Passwort-vergessen}-Funktion
    */F230/* Ein Benutzer kann festlegen, ob und in welchem Intervall sein Kalender einem lokalen Backup abgelegt wird.
    */F240/* Sicheres Beenden des Programms: Schreiboperationen werden dabei zu Ende geführt, und eine notwendige Online-Synchronisierung durchgeführt.
    */F310/* Optional: Durch die Konsole lassen sich wichtigen Funktionen ausführen, ohne dass die GUI geladen wird. Dazu gehören:
      ** /F311/ Termine anlegen, ändern, löschen
      ** /F312/ Benutzer erstellen
      ** /F313/ Synchronisation erzwingen
      ** /F314/ Backup erstellen


##Produktdaten
Es sollen folgende Daten persistent gespeichert werden:
  ####Termine
  Termine bestehen aus folgenden Daten (Titel, Daum, Besitzer sind Pflichtangabe beim Erstellen von Terminen):

        */D01/ Titel
        */D02/ Datum, Uhrzeit, Zeitspanne
        */D03/ Ort
        */D04/ Besitzer, Auswahl aus einer Liste vorhandener Benutzer mit der Möglichkeit einen neuen Benutzer anzulegen
        */D05/ Einzeltermin (Standard) oder Serientyp mit Zyklusangabe
        */D06/ Beschreibung
        */D07/ Sichtbarkeit: Privat (Standard) oder Öffentlich

  ####Benutzerkonto
    Zu einem Benutzer gehörigen Informationen:

        */D11/ Benutzername
        */D12/ Passwort (verschlüsselt)
        */D13/ Hinzugefügte Online-Kalender und zugehörige Adressen und Passwörter (verschlüsselt)
        */D14/ Backup- und Synchronisationseinstellungen
          ** /D21/ Speicherort/-adresse
          ** /D22/ Zeitintervall

##Produktleistungen

     */L010/ Terminänderungen muss in allen synchronisierten Kalendern übernommen werden. Dies ist abhängig von den Möglichkeiten der Onlinekalender.
     */L020/ Bei fehlerhaften Eingaben und Daten, darf das Programm nicht abstürzen und es muss dem Benutzer die Möglichkeit zur Änderung der Daten gegeben werden.
     */L030/ Der Benutzer erhält eine Auflistung aller eingegebenen Fehler.
     */L040/ Die Datensicherheit wird gewährleistet.

##Bedienoberfläche

    */B010/ Dem Benutzer wird mittels einer GUI ein Kalender angezeigt, welcher
    folgende Ansichten unterstützt. Dabei werden Termine grafisch hervorgehoben, sowie und der Titel mit Uhrzeit angezeigt, sofern die aktuelle Ansicht es zulässt.
      ** /B011/ Monatsansicht
      ** /B012/ Wochenansicht
      ** /B013/ Tagesansicht
      ** /B014/ Jahresansicht
    */B020/ Es wird ein grafisches Dialogfeld dargestellt, indem alle Termineinstellungen getroffen werden. Der Anwender kann Termine auf zweierlei Arten erstellen:
      ** /B021/ Durch Mausklick auf einen Tag/Stunde
      ** /B022/ Durch Auswahl „Termin hinzufügen“ in einer Menüleiste
    */B030/ Die Interaktion in der Kalenderansicht kann sowohl mit dem Mausrad,
    als auch durch die Cursortasten der Tastatur geschehen.
    */B040/ Am oberen Rand der Benutzungsoberfläche soll eine Toolbar
    verfügbar sein, die neben den Kalenderverwaltungsfunktionen auch die
    Einstellungen darstellt.
    */B050/ Benutzer dürfen nur ihre eigenen privaten Termine und die von ihnen erstellten öffentlichen Termine bearbeiten
    */B050/ Benutzer dürfen öffentliche Termine nur sehen
