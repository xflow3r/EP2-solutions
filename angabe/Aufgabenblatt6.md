# Aufgabenblatt 6

## Allgemeine Anmerkungen

Ihre Lösung für dieses Aufgabenblatt ist bis Montag, 27.5. 11h durch `git commit` und `push`
abzugeben. Mit der Angabe werden folgende Dateien mitgeliefert:
[IntConst](../src/AB6/IntConst.java), [IntVar](../src/AB6/IntVar.java),
[IntVarConstMap](../src/AB6/IntVarConstMap.java),
[IntVarConstHashMap](../src/AB6/IntVarConstHashMap.java),
[IntVarConstTreeMap](../src/AB6/IntVarConstHashMap.java),
[IntVarIterable](../src/AB6/IntVarIterable.java),
[IntVarIterator](../src/AB6/IntVarIterator.java),
[IntVarSet](../src/AB6/IntVarSet.java),
[LinearExpression](../src/AB6/LinearExpression.java),
[IntVarTerm](../src/AB6/IntVarTerm.java),
[ConstVarProduct](../src/AB6/ConstVarProduct.java),
[SumOfTerms](../src/AB6/SumOfTerms.java),
[Condition](../src/AB6/Condition.java), [AllDifferent](../src/AB6/AllDifferent.java),
[IsEqual](../src/AB6/IsEqual.java), [AND](../src/AB6/AND.java), [OR](../src/AB6/OR.java),
[NOT](../src/AB6/NOT.java),
[Solver](../src/AB6/Solver.java)
und [Test](../src/AB6/Test.java).
Vorgegebene Programmteile dürfen nur an den Stellen verändert werden, die mit TODO markiert sind.
Zusätzliche Klassen, Interfaces, Methoden und Variablen dürfen eingefügt werden. Definieren Sie 
keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die in einer anderen
Klasse, einem Objekt oder einer Methode stehen. Wenn Sie zusätzlich zu den gefragten
Klassen weitere Klassen definieren, achten Sie darauf, dass die Klassen im
Unterverzeichnis [AB6](../src/AB6) erstellt werden und als erste Zeile die Deklaration
`package AB6;` enthalten, um Konflikte mit späteren Aufgabenblättern zu vermeiden.
Implementieren Sie keine unnötigen Getter-/Setter-Methoden.

## Ziel

Ziel der Aufgabe ist die Anwendung der Konzepte: Interfaces, dynamisches Binden, iterierbare 
Abstraktionen, Sichtweise vs. Kopie, Sortieren (siehe Skriptum Seite 91-105).

## Beschreibung der gegebenen Dateien

- Die Bedeutung der Klassen [LinearExpression](../src/AB6/LinearExpression.java), 
  [IntConst](../src/AB6/IntConst.java), [IntVar](../src/AB6/IntVar.java), 
  [IntVarIterable](../src/AB6/IntVarIterable.java),
  [IntVarIterator](../src/AB6/IntVarIterator.java), [IntVarTerm](../src/AB6/IntVarTerm.java),
  [ConstVarProduct](../src/AB6/ConstVarProduct.java) kennen Sie bereits aus AB5. Die 
  Klassengerüste können Sie mit den entsprechenden Kopien Ihrer Lösung aus AB5 ersetzen.
- [IntVarConstMap](../src/AB6/IntVarConstMap.java) ist ein vollständig gegebenes Interfaces
  für assoziative Datenstrukturen, die Schlüssel vom Typ `IntVar` mit Werten vom Typ `IntConst` 
  assoziieren. Dieses unterscheidet sich von [AB5.IntVarConstMap](../src/AB5/IntVarConstMap.java)
  dadurch, dass anstelle der Methode `keyQueue()` jetzt die Methode `keySet()` zur Verfügung 
  gestellt wird.
- [IntVarSet](../src/AB6/IntVarSet.java) ist das Interface für Objekte, die von `keySet()`
  geliefert werden. 
- [IntVarConstHashMap](../src/AB6/IntVarConstHashMap.java) und
- [IntVarConstTreeMap](../src/AB6/IntVarConstTreeMap.java) sind Gerüste für zwei unterschiedliche
  Implementierungen von [IntVarConstMap](../src/AB6/IntVarConstMap.java).
- [Condition](../src/AB6/Condition.java) ist ein vorgegebenes Interface, das Boolean-Ausdrücke
  repräsentiert. 
- [AND](../src/AB6/AND.java), [OR](../src/AB6/OR.java), [NOT](../src/AB6/NOT.java) sind Gerüste
  von Klassen, die [Condition](../src/AB6/Condition.java) implementieren und Bool'sche 
  Verknüpfungen erlauben.
- [AllDifferent](../src/AB6/AllDifferent.java) und [IsEqual](../src/AB6/IsEqual.java) sind
  Gerüste für Klassen, die spezielle Bedingungen (Un-/Gleichungen) darstellen und ebenfalls 
  [Condition](../src/AB6/Condition.java) implementieren. Diese können mit obigen Klassen 
  [AND](../src/AB6/AND.java), [OR](../src/AB6/OR.java), [NOT](../src/AB6/NOT.java) verknüpft 
  werden.
- [Solver](../src/AB6/Solver.java) ist eine Klasse, die Objekte von 
  [Condition](../src/AB6/Condition.java) nutzt und Lösungen für bestimmte Logikrätsel berechnet,
  die sich mit den vorhandenen Klassen beschreiben lassen. Als Beispiel wird das Rätsel
  [SEND+MORE=MONEY](https://de.wikipedia.org/wiki/Kryptogramm) gelöst.
- [Test](../src/AB6/Test.java) ist eine vorgegebene Klasse, die Sie zum Testen Ihrer
  Implementierung verwenden sollten. Bei einer fehlerfreien Implementierung sollten bei der 
  Ausführung dieser Klasse keine Ausnahmen (Exception) ausgelöst werden und alle Tests als
  erfolgreich ("successful") ausgegeben werden. Sie müssen diese Klasse nicht verändern, können
  aber eigene Testfälle hinzufügen.

## Aufgaben
Ihre Aufgaben sind folgende:
1. Kopieren Sie die entsprechenden Klassendefinitionen aus AB5 in die entsprechenden Dateien
   von AB6. Achten Sie jedoch darauf, dass bei der Implementierung keine Definitionen aus AB5 
   benutzt werden, sondern nur Klassen aus AB6. Passen Sie die `package` Deklarationen an.
2. Durch das geänderte Interface [AB6.IntVarConstMap](../src/AB6/IntVarConstMap.java) ändert 
   sich in AB6 auch die Implementierung der Klasse
   [IntVarConstHashMap](../src/AB6/IntVarConstHashMap.java), die wieder als Gerüst vorgegeben 
   und zu vervollständigen ist. Sie können aber die gültigen Teile der Klassendefinition aus AB5 
   kopieren und anpassen. [IntVarConstTreeMap](../src/AB6/IntVarConstTreeMap.java) soll ebenfalls
   [IntVarConstMap](../src/AB6/IntVarConstMap.java) implementieren. Hier können Sie Teile aus
   AB4 kopieren. Kopieren Sie auch die entsprechende Klassendefinition aus AB5 nach
   [SumOfTerms](../src/AB6/SumOfTerms.java) und passen Sie sie so an, dass Sie mit den Klassen
   aus AB6 funktioniert.
3. Aktivieren Sie die default-Implementierungen der gegebenen Methoden in 
   [Condition](../src/AB6/Condition.java) und vervollständigen Sie alle Klassen, die 
   dieses Interface implementieren, gemäß der Kommentare in den gegebenen Dateien.
4. Testen Sie mit der Klasse [Test](../src/AB6/Test.java). Aktivieren Sie den auskommentierten 
   Programmcode in [Solver](../src/AB6/Solver.java) und führen Sie auch diese Klasse aus, 
   um Ihre Lösung zusätzlich zu testen. 

Schreiben Sie, wo notwendig, weitere Klassen für die Implementierung der gegebenen 
Interfaces, insbesondere [IntVarSet](../src/AB6/IntVarSet.java). 
Benutzen Sie keine vorgefertigten Klassen aus dem Java-Collection-Framework!

### Denkanstöße (ohne Bewertung)
1. Die Methode `keySet()` von [IntVarConstMap](../src/AB6/IntVarConstMap.java) liefert 
   eine Sichtweise auf die Map. Gibt es abgesehen von diesen Objekten weitere Sichtweisen in 
   Ihrer Lösung? Was tut die Methode `getVarSet()` von [Condition](../src/AB6/Condition.java)?
2. Wie funktioniert die gegebene Methode `solve()` in der Klasse [Solver](../src/AB6/Solver.java)? 
   Wie können Sie die vorhandenen Klassen für die Implementierung eines
   [Sudoku](https://de.wikipedia.org/wiki/Sudoku)-Spiels nutzen?
3. Wie könnte man den Iterator der Klasse 
   [IntVarConstHashMap](../src/AB6/IntVarConstHashMap.java) so implementieren, dass die Elemente
   in alphabetischer Reihenfolge (nach Namen) geliefert werden?


#### _Punkteaufteilung_
- Vervollständigen von [IntVarConstHashMap](../src/AB6/IntVarConstHashMap.java): 2 Punkte
- Vervollständigen von [IntVarConstTreeMap](../src/AB6/IntVarConstTreeMap.java): 2 Punkte
- Anpassen von Klassen, die [LinearExpression](../src/AB6/LinearExpression.java) implementieren: 
  1 Punkt
- Vervollständigen der Klassen, die [Condition](../src/AB6/Condition.java) implementieren: 4 Punkte
- Gesamt: 9 Punkte

