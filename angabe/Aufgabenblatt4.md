# Aufgabenblatt 4

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 29.4. 11h durch `git commit` und `push`
abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert:
[IntConst](../src/AB4/IntConst.java), [IntVar](../src/AB4/IntVar.java),
[IntVarDoublyLinkedList](../src/AB4/IntVarDoublyLinkedList.java),
[IntVarConstTreeMap](../src/AB4/IntVarConstTreeMap.java), 
[LinearExpression](../src/AB4/LinearExpression.java)
und [Test](../src/AB4/Test.java).
Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind.
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen eingefügt werden. Definieren Sie 
keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die in einer anderen
Klasse, einem Objekt oder einer Methode stehen. Wenn Sie zusätzlich zu den gefragten
Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassen im
Unterverzeichnis [AB4](../src/AB4) erstellt werden und als erste Zeile die Deklaration
`package AB4;` enthalten, um Konflikte mit späteren Aufgabenblättern zu vermeiden.
Implementieren Sie keine unnötigen Getter-/Setter-Methoden.

## Ziel

Ziel der Aufgabe ist die Implementierung einer doppelt verketteten Liste für eine lineare
Datenstruktur und einer Variante eines binären Suchbaums mit zusätzlichen Methoden (siehe
Skriptum Seiten 60-73).

## Beschreibung der gegebenen Dateien

- [IntConst](../src/AB4/IntConst.java) ist die vollständig vorgegebene Implementierung einer
  Klasse, die ganzzahlige Konstanten repräsentiert.
- [IntVar](../src/AB4/IntVar.java) ist die vollständig vorgegebene Implementierung einer
  Klasse, die (mathematische, freie) Variablen repräsentiert, deren Domäne ganze Zahlen sind.
- [LinearExpression](../src/AB4/LinearExpression.java) ist das Gerüst für eine
  Implementierung einer Klasse, die (mathematische) lineare Ausdrücke repräsentiert. Ein 
  linearer Ausdruck ist z.B. 3x-2y+2, wobei x und y freie Variablen in diesem Ausdruck sind.
  Weist man einer Variable in diesem Ausdruck einen fixen Wert zu, entsteht ein anderer Ausdruck.
  Weist man in diesem Beispiel der Variable x den Wert 3 zu, entsteht der neue Ausdruck -2y+11.
- [IntVarDoublyLinkedList](../src/AB4/IntVarDoublyLinkedList.java) ist das Gerüst für eine
  Implementierung einer doppelt verketteten Liste mit Elementen vom Typ `IntVar`.
- [IntVarConstTreeMap](../src/AB4/IntVarConstTreeMap.java) ist das Gerüst für eine
  Implementierung einer assoziativen Datenstruktur, die Schlüssel vom Typ `IntVar` mit Werten vom 
  Typ `IntConst` assoziiert.
- [Test](../src/AB4/Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
  Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der  
  Ausführung dieser Klasse keine Ausnahmen (Exception) ausgelöst werden und alle Tests als
  erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können
  aber eigene Testfälle hinzufügen.

## Aufgaben

Ihre Aufgaben sind folgende:

1. Vervollständigen Sie die Klassendefinitionen
   in [IntVarDoublyLinkedList](../src/AB4/IntVarDoublyLinkedList.java)
   gemäß der Kommentare in der Datei. Die Implementierung soll mit Hilfe einer doppelt
   verketteten Liste erfolgen. 
2. Vervollständigen Sie die Klassendefinition in 
   [IntVarConstTreeMap](../src/AB4/IntVarConstTreeMap.java) gemäß der Kommentare in der Datei.
   Die Implementierung soll mit Hilfe eines binären Suchbaums erfolgen, in dem Schlüssel nach deren
   Namen sortiert sind. Die eigentlichen Schlüssel sind Objekte vom Typ `IntVar`,
   die interne Ordnung im Suchbaum erfolgt durch deren Namen. 
3. Vervollständigen Sie die gegebene Klasse [LinearExpression](../src/AB4/LinearExpression.java) 
   gemäß der Kommentare in der Datei. Hinweis: Ein linearer Ausdruck (z.B. 2x-3y+5) kann durch 
   mehrere Schlüssel-Wert-Paare (z.B. x ➔ 2, y ➔ -3) dargestellt werden, wobei jedes 
   Schlüssel-Wert-Paar einem Term im Ausdruck entspricht. Der Schlüssel ist die Variable und der 
   Wert ist der Koeffizient des Terms. Die Konstante des Ausdrucks (z.B. 5) muss dann separat 
   gespeichert werden. 

Benutzen Sie keine Arrays oder vorgefertigten Klassen aus dem Java-Collection-Framework!

### Denkanstöße (ohne Bewertung)

1. Welche Alternativen gibt es für die Implementierung von `LinearExpression` wenn Sie die Terme 
   nicht mit der Klasse [IntVarConstTreeMap](../src/AB4/IntVarConstTreeMap.java) verwalten wollen?

#### _Punkteaufteilung_

- Implementierung von `IntVarDoublyLinkedList`: 1 Punkt
- Implementierung von `IntVarConstTreeMap`: 1 Punkt
- Implementierung von `LinearExpression`: 2 Punkte
- Gesamt: 4 Punkte

