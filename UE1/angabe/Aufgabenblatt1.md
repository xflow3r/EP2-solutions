# Aufgabenblatt 1

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 18.3.2024 11:00 Uhr durch `git commit`
und `push` abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert, die sie gemäß der Angabe
verändern müssen: `Simulation.java`, `Vector3.java`, `Body.java` und zum Testen `Test.java`.
Die zusätzliche Datei `SpaceDraw.java` enthält Methoden, die in der Simulation
benötigt werden. Diese Methoden können Sie auch in Ihrer Lösung aufrufen. Die zusätzliche
Datei `CodeDraw.jar` (im Verzeichnis `lib`) wird nur zum Zeichnen verwendet und sollte nicht 
entfernt oder verändert werden.

Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind.
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen aber eingefügt werden.
Implementieren Sie keine unnötigen Getter-/Setter-Methoden. Wenn Sie zusätzlich zu den gefragten
Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassen im
Unterverzeichnis [AB1](../src/AB1) erstellt werden und als erste Zeile die Deklaration
`package AB1;` enthalten, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Verwendung in IntelliJ

Diese Aufgabenstellung ist ein vollständiges IntelliJ-Projekt, das Sie bereits in IntelliJ öffnen
können. Sie müssen daher kein eigenes Projekt anlegen. Öffnen Sie nach dem Klonen des Repos in
IntelliJ einfach den entsprechenden Ordner. Gegebenenfalls muss noch folgender Schritt ausgeführt
werden:

- Einstellen des _Project SDK_: Öffnen Sie dazu in IntelliJ die Projekteinstellungen
  (_File_ -> _Project Structure..._) und wählen Sie ein JDK unter _Project | Project SDK_ aus.

## Beschreibung der gegebenen Klassen

- [Vector3](../src/AB1/Vector3.java) ein Gerüst für eine Klasse, die 3D-Vektoren repräsentiert.
- [Body](../src/AB1/Body.java) ist das Gerüst für eine Klasse, die einen Himmelskörper
  repräsentiert.
- [Simulation](../src/AB1/Simulation.java) ist die ausführbare Klasse. Auch diese soll
  modifiziert werden (siehe unten).
- [Test](../src/AB1/Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
  Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der  
  Ausführung dieser Klasse keine Exceptions geworfen werden und alle Tests als erfolgreich
  ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können aber eigene
  Testfälle hinzufügen.
- [SpaceDraw](../src/AB1/SpaceDraw.java) ist eine vorgegebene Klasse mit statischen Hilfsmethoden.

## Thema

Das Thema dieses Aufgabenblatts ist eine vereinfachte Simulation des Weltraums mit den darin
geltenden klassischen physikalischen Gesetzen für Himmelskörper. Kenntnisse der Physik werden nicht 
vorausgesetzt. Sie müssen gegebenen Code umbauen.

## Ziel

Ziel der Aufgabe ist die Anwendung der Konzepte: Objekt- vs. Klassenmethode, Datensatz, Data Hiding,
Konstruktoren (siehe Skriptum Seiten 31-50).

## Aufgaben

1. Lesen Sie sich die Kommentare in den Dateien durch und führen Sie die
   Klasse [Simulation](../src/AB1/Simulation.java) aus.
2. Data hiding:
    1. Machen Sie in den Klassen [Vector3](../src/AB1/Vector3.java) und [Body](../src/AB1/Body.java)
       alle Objektvariablen `private`.
    2. Definieren Sie entsprechende Konstruktoren, um die Objektvariablen zu initialisieren. 
       [Simulation](../src/AB1/Simulation.java) soll nur noch diese nutzen und nicht mehr direkt 
       auf Objektvariablen klassenfremder Objekte zugreifen dürfen. Testen Sie zunächst die 
       vervollständigten Klassen [Vector3](../src/AB1/Vector3.java) und 
       [Body](../src/AB1/Body.java) mit der Klasse [Test](../src/AB1/Test.java). Entfernen Sie
       dazu die Kommentarzeichen in der Klassendefinition.
3. Datenkapselung: Anstelle der gegebenen statischen Methoden in der Datei `Simulation.java` sollen
   nur noch entsprechende Objektmethoden der Klassen [Body](../src/AB1/Body.java)
   und [Vector3](../src/AB1/Vector3.java) benutzt werden. (Ausnahme ist die Methode `main`. Die  
   statischen Methoden der Klasse `SpaceDraw` müssen auch nicht verändert werden.) Implementieren 
   Sie dazu die spezifizierten Methoden und bauen Sie [Simulation](../src/AB1/Simulation.java) so 
   um, dass anstelle der Aufrufe statischer Methoden Objektmethoden genutzt werden. Sie sollen
   alle in [Body](../src/AB1/Body.java) und [Vector3](../src/AB1/Vector3.java) spezifizierten
   Methoden implementieren, auch wenn nicht alle von [Simulation](../src/AB1/Simulation.java) 
   genutzt werden. Die in `Simulation.java` gegebenen statischen Methoden können dann entfernt
   werden (natürlich bis auf die erwähnten Ausnahmen). Nutzen Sie die implementierten Methoden 
   auch in `Simulation.java`, um die Himmelskörper zu bewegen und zu zeichnen.

## Zusatzfragen

Beantworten Sie folgende Zusatzfragen als Kommentar in `Simulation.java`:

1. Was versteht man unter _Datenkapselung_? Geben Sie ein Beispiel, wo dieses Konzept in dieser
   Aufgabenstellung angewendet wird.
2. Was versteht man unter _Data Hiding_? Geben Sie ein Beispiel, wo dieses Konzept in dieser
   Aufgabenstellung angewendet wird.
3. Was steht bei einem Methodenaufruf links vom `.` (z.B. bei `SpaceDraw.massToColor(1e30)` oder
   `body.radius()`)? Woran erkennt man dabei Objektmethoden?

### Denkanstöße (ohne Bewertung)

Folgende Fragen sind als Denkanstöße gedacht und bilden die Grundlage für eine Diskussion in der
Übungseinheit zu diesem Aufgabenblatt.

1. Welche anderen oder weiteren Objektmethoden hätten Sie zur Verfügung gestellt, wenn es keine
   Vorgaben gegeben hätte?
2. Wann wäre es sinnvoll, die Klasse `SpaceDraw` so zu ändern, dass diese ebenfalls Objektmethoden
   zur Verfügung stellt?

#### _Punkteaufteilung_

- Korrekte Sichtbarkeit von Objektvariablen in [Vector3](../src/AB1/Vector3.java)
  und [Body](../src/AB1/Body.java) und Initialisierung mittels
  Konstruktoren: 1 Punkt
- Korrekte Objektmethoden in [Vector3](../src/AB1/Vector3.java) und
  [Body](../src/AB1/Body.java): 2.5 Punkt
- Korrekte Verwendung der Objektmethoden in [Simulation](../src/AB1/Simulation.java): 1 Punkt
- Korrekte Beantwortung der Zusatzfragen: 0.5 Punkte
- Gesamt: 5 Punkte


