# Aufgabenblatt 3

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 15.4. 11h durch `git commit` und `push`
abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert:
[Simulation](../src/AB3/Simulation.java)
, [BodySinglyLinkedList](../src/AB3/BodySinglyLinkedList.java),
[BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java)
, [BodyQueue](../src/AB3/BodyQueue.java)
und [Test](../src/AB3/Test.java).
Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind.
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen eingefügt werden. Definieren Sie 
keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die in einer anderen
Klasse, einem Objekt oder einer Methode stehen. Wenn Sie zusätzlich zu den gefragten
Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassen im
Unterverzeichnis [AB3](../src/AB3) erstellt werden und als erste Zeile die Deklaration
`package AB3;` enthalten, um Konflikte mit späteren Aufgabenblättern zu vermeiden.
Implementieren Sie keine unnötigen Getter-/Setter-Methoden.

## Ziel

Ziel der Aufgabe ist die Implementierung einer Liste für eine lineare und eines Baums für eine
assoziative Datenstruktur (siehe Skriptum Seiten 60-69).

## Beschreibung der gegebenen Dateien

- [BodySinglyLinkedList](../src/AB3/BodySinglyLinkedList.java) ist das Gerüst für eine
  Implementierung einer linearen Datenstruktur zur Verwaltung von Objekten des Typs `Body`.
- [BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java) ist das Gerüst für eine
  Implementierung einer assoziativen Datenstruktur, die einen Himmelskörper mit einem 
  Beschleunigungsvektor assoziiert.
- [BodyQueue](../src/AB3/BodyQueue.java) ist die vollständig vorgegebene Defintion einer linearen
  Datenstruktur zur Verwaltung von Objekten des Typs [Body](../src/AB1/Body.java). Diese Klasse
  ist eine Wrapper-Klasse: Ihre Methoden deligieren die Aufgaben an
  [BodySinglyLinkedList](../src/AB3/BodySinglyLinkedList.java).
- [Test](../src/AB3/Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
  Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der  
  Ausführung dieser Klasse keine Ausnahmen (Exception) ausgelöst werden und alle Tests als
  erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können
  aber eigene Testfälle hinzufügen.
- [Simulation](../src/AB3/Simulation.java) ist ein Gerüst für die ausführbare Klasse. Auch diese
  soll modifiziert werden (siehe unten).

## Aufgaben

Ihre Aufgaben sind folgende:

1. Vervollständigen Sie die Klassendefinitionen
   in [BodySinglyLinkedList](../src/AB3/BodySinglyLinkedList.java)
   gemäß der Kommentare in den Dateien. Die Implementierung soll mit Hilfe einer einfach
   verketteten Liste erfolgen. Benutzen Sie keine Arrays oder vorgefertigten Klassen aus dem
   Java-Collection-Framework!
2. Vervollständigen Sie die Klassendefinition in
   [BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java).
   Die Implementierung soll mit Hilfe eines binären Suchbaums erfolgen, in dem die Himmelskörper
   nach deren Masse sortiert sind. Die eigentlichen Schlüssel sind Objekte vom Typ `Body`,
   die interne Ordnung im Suchbaum erfolgt durch deren Masse. Benutzen Sie keine Arrays oder
   vorgefertigten Klassen aus dem Java-Collection-Framework!
3. Vervollständigen Sie die gegebene Klasse [Simulation](../src/AB3/Simulation.java) unter 
   Verwendung der Klassen [BodyQueue](../src/AB3/BodyQueue.java) und
   [BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java), sodass sich die Klasse 
   bei Ausführung wie die bereits bestehende Klasse [AB1/Simulation](../src/AB1/Simulation.java) 
   verhält. 
   Sie können auch den Code von [AB2/Simulation](../src/AB2/Simulation.java) als 
   Basis verwenden. Kollisionen sollen in AB3 aber wieder berücksichtigt werden. Die Zugriffe auf 
   die Himmelskörper der Simulation sollen über Methoden von [BodyQueue](../src/AB3/BodyQueue.java) 
   erfolgen. Die Klasse [BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java) soll 
   zur Verwaltung der Beschleunigungsvektoren benutzt werden.

Allgemeiner Hinweis: bei einigen Methoden sind Vorbedingungen bei den Beschreibungen der
Parameter angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden,
sondern stellen Zusicherungen dar, auf die die Methode sich verlassen kann. Diese Regel gilt
allgemein auch für zukünftige Aufgabenblätter.

### Denkanstöße (ohne Bewertung)

1. Haben Sie bei der Implementierung darauf geachtet, dass die Zugriffe möglichst effizient
   erfolgen können (Z.B. ohne die Liste beim Zugriff wiederholt durchlaufen zu müssen)? Was ist in
   dem Zusammenhang der Vorteil der verketteten Liste?
2. Wofür eignen sich eher die Methoden `addFirst`, `addLast`, `pollFirst` bzw.
   `pollLast` und wofür eher die `get`-Methoden?
3. Was würde sich beim Verhalten der Simulation ändern, wenn in 
   [BodyQueue](../src/AB3/BodyQueue.java) die Implementierung der Methoden `add` und `poll` 
   wie folgt geändert würde:
   ```
   public Body poll() {
        return list.pollLast(); //anstelle return list.pollFirst();
   }
   public void add(Body b) {
        list.addFirst(b); //anstelle list.addLast();
   }
   ```
4. In [BodyAccelerationTreeMap](../src/AB3/BodyAccelerationTreeMap.java) gibt es keine `remove`
   Methode. Was bedeutet das für die Simulation im Hinblick darauf, dass durch die Kollisionen 
   ständig neue Himmelskörper in den Baum eingefügt werden? Wirkt sich das auf die 
   Geschwindigkeit der Simulation aus?

#### _Punkteaufteilung_

- Implementierung von `BodySinglyLinkedList`: 3 Punkte
- Implementierung von `BodyAccelerationTreeMap`: 3 Punkte
- Implementierung von `Simulation`: 3 Punkte
- Gesamt: 9 Punkte

