 # Aufgabenblatt 2

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 8.4. 11h durch `git commit` und `push`
abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert: `Body.java`, `BodyQueue.java`, 
`BodyAccelerationMap.java`, `Simulation.java` und `Test.java`.

Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind.
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen aber eingefügt werden.
Implementieren Sie keine unnötigen Getter-/Setter-Methoden. Wenn Sie zusätzlich zu den gefragten
Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassen im
Unterverzeichnis [AB2](../src/AB2) erstellt werden und als erste Zeile die Deklaration
`package AB2;` enthalten, um Konflikte mit späteren Aufgabenblättern zu vermeiden.

## Ziel

Ziel der Aufgabe ist die Implementierung einer linearen und einer assoziativen Datenstruktur (siehe
Skriptum Seiten 50-59).

## Beschreibung der gegebenen Dateien

- [Body](../src/AB2/Body.java) ist das Gerüst für eine Klasse, die einen Himmelskörper
  repräsentiert.
- [Simulation](../src/AB2/Simulation.java) ist die ausführbare Klasse. Auch diese soll
  modifiziert werden (siehe unten).
- [BodyQueue](../src/AB2/BodyQueue.java) ist das Gerüst für eine Implementierung einer linearen
  Datenstruktur zur Verwaltung von Objekten des Typs [Body](../src/AB1/Body.java).
- [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java) ist das Gerüst für eine Implementierung
  einer assoziativen Datenstruktur, die einen Himmelskörper mit einem Beschleunigungsvektor 
  assoziiert.
- [Test](../src/AB1/Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
  Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der  
  Ausführung dieser Klasse keine Ausnahmen (Exception) ausgelöst werden und alle Tests als 
  erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können 
  aber eigene Testfälle hinzufügen.

## Aufgaben

Ihre Aufgaben sind folgende:

1. Kopieren Sie den Code-Block mit der Klassendefinition von
   [Body](../src/AB1/Body.java) aus AB1 in die Datei `AB2/Body.java`, das
   betrifft alle Programmzeilen nach `public class Body {`. Fügen Sie in der neuen Klasse 
   [Body](../src/AB2/Body.java) eine öffentliche Objektmethode `getMass()` hinzu, die die Masse des 
   Himmelkörpers zurückliefert.
2. Vervollständigen Sie die Klassendefinitionen in [BodyQueue](../src/AB2/BodyQueue.java) gemäß der 
   Kommentare in den Dateien. Die Implementierung soll mit Hilfe eines Arrays erfolgen. Bei der 
   Erzeugung soll das Array genau die Länge haben, die im Konstruktor angegeben wird. Diese wird 
   verdoppelt sobald alle Plätze belegt sind. Benutzen Sie keine vorgefertigten Klassen aus dem 
   Java-Collection-Framework!
3. Vervollständigen Sie die Klassendefinition in 
   [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java). Die Implementierung soll mit
   Hilfe eines Arrays erfolgen. Benutzen Sie keine vorgefertigten Klassen aus dem
   Java-Collection-Framework! Implementieren Sie diese Klasse so, dass die Einträge im Array nach
   der Masse der Himmelskörper absteigend sortiert sind. Das erhöht zwar den Aufwand beim
   erstmaligen Eintragen eines Schlüssel-Wert-Paars (Methode `put`), da alle Positionen ab der
   Einfügeposition verschoben werden müssen, es ermöglicht aber eine schnellere Suche nach dem
   Schlüssel (Methode `get`) mittels binärer Suche. Folgendes Beispiel zeigt die binäre Suche nach
   der Einfügeposition in einem absteigend sortierten Array. Da zwei Himmelskörper die gleiche 
   Masse haben können, muss mit einer entsprechenden zusätzlichen Überprüfung der Himmelskörper 
   identifiziert werden (z.B. `if (keys[middle] == toFind)` ...). Geordnet sind die Einträge nach 
   der Masse, der Schlüssel ist aber der Himmelskörper.
    ```
     Body[] keys; // assume descending order according to mass
     Body toInsert;
     ...
     
     int left = 0;
     int right = size - 1;
     
     while (left <= right) {
         int middle = left + ((right - left) / 2);
         if (keys[middle].mass() < toInsert.mass()) {
             right = middle - 1;
         } else {
             left = middle + 1;
         }
     }
     
     // index where to insert: right + 1
   ```
4. Kopieren Sie den Code-Block mit der Klassendefinition von 
   [Simulation](../src/AB1/Simulation.java) aus AB1 in die Datei `AB2/Simulation.java`, das 
   betrifft alle Programmzeilen nach `public class Simulation {`. (Ändern Sie nichts an den `import`
   Anweisungen.) Ändern Sie die Klassendefinition so, dass keine Kollisionen von Himmelskörpern 
   mehr berücksichtigt werden. Die Anzahl der Himmelskörper ändert sich im Laufe der Simulation 
   somit nicht. Testen Sie die Simulation von AB2.
5. Ändern Sie nun die neue Klasse [Simulation](../src/AB2/Simulation.java) so, dass zur Verwaltung 
   der Himmelskörper anstelle des Arrays Objekte der Klassen [BodyQueue](../src/AB2/BodyQueue.java)
   und [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java) verwendet werden. Das heißt, 
   dass die Zugriffe auf die Himmelskörper der Simulation über Methoden von 
   [BodyQueue](../src/AB2/BodyQueue.java) erfolgen müssen. Anstelle des Arrays `accelerationOfBody` 
   soll ein Objekt des Typs [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java) benutzt 
   werden.
6. Testen Sie die Simulation wieder. Das Verhalten der Simulation sollte unverändert sein. Je nach
   Implementierung der Klassen [BodyQueue](../src/AB2/BodyQueue.java) und 
   [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java) ist es möglich, dass die Simulation
   jetzt langsamer läuft als unmittelbar nach dem Umbau in Schritt 4. Das ist kein Problem.
7. (Freiwillige Zusatzaufgabe ohne Bewertung:) Testen Sie die Simulation mit den folgenden vier
   Himmelskörpern:

```
   Body sun = new Body(1.989e30,new Vector3(0,0,0),new Vector3(0,0,0));
   Body earth = new Body(5.972e24,new Vector3(-1.394555e11,5.103346e10,0),new Vector3
   (-10308.53,-28169.38,0));
   Body mercury = new Body(3.301e23,new Vector3(-5.439054e10,9.394878e9,0),new Vector3
   (-17117.83,-46297.48,-1925.57));
   Body venus = new Body(4.86747e24,new Vector3(-1.707667e10,1.066132e11,2.450232e9),new 
   Vector3(-34446.02,-5567.47,2181.10));
```

### Denkanstöße (ohne Bewertung)

Folgende Fragen sind als Denkanstöße gedacht und bilden die Grundlage für eine Diskussion in der
Übungseinheit zu diesem Aufgabenblatt.

1. Überlegen Sie sich, welche Änderungen in [Simulation](../src/AB2/Simulation.java) notwendig
   wären, wenn Kollisionen von Himmelskörpern berücksichtigt werden sollen. Wie gut 
   eignen sich die vorhandenen Datenstrukturen dafür?

#### _Punkteaufteilung_

- Implementierung von [BodyQueue](../src/AB2/BodyQueue.java): 3 Punkte
- Implementierung von [BodyAccelerationMap](../src/AB2/BodyAccelerationMap.java): 3 Punkte
- Anpassung von [Simulation](../src/AB2/Simulation.java): 2 Punkte
- Gesamt: 8 Punkte 


