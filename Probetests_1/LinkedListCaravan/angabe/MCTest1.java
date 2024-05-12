// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen müssen für jede Verwendung von\n" +
                        "'this(...)' bzw. 'this' in einem Konstruktor zutreffen?",

                        new Choice(false, "'this' ist nur in 'final' Konstruktoren verwendbar.                           (1A)"),
                        new Choice(false, "'this' darf in Konstruktoren nicht verwendet werden.                          (1B)"),
                        new Choice(false, "'this = null;' darf nur als erste Anweisung vorkommen.                        (1C)"),
                        new Choice(false, "'this' referenziert das Objekt, das gerade initialisiert wird.                (1D)"),
                        new Choice(false, "Der Wert von 'this' kann nicht 'null' sein.                                   (1E)")
                ),

                new Question(
                        "e sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree e = new STree(); e.add(0); e.add(6); e.add(5);\n" +
                        "Welche der folgenden Aussagen treffen auf e zu?",

                        new Choice(false, "Der Knoten mit Wert 6 ist die Wurzel.                                         (2A)"),
                        new Choice(false, "Der Knoten mit Wert 6 ist Elter von dem mit Wert 5.                           (2B)"),
                        new Choice(false, "Der Baum ist nicht ausbalanciert.                                             (2C)"),
                        new Choice(false, "Der Knoten mit Wert 6 hat zumindest ein Kind.                                 (2D)"),
                        new Choice(false, "Der Knoten mit Wert 0 ist ein Blattknoten.                                    (2E)")
                ),

                new Question(
                        "X, U und C seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(false, "Ist U eine Klasse, dann ist U Untertyp von java.lang.Object.                  (3A)"),
                        new Choice(false, "Aus 'C ist Klasse' und 'U ist Interface' folgt: 'U ist kein Untertyp von C'.  (3B)"),
                        new Choice(false, "Aus 'U Untertyp von C' folgt: 'Kommentare in U und C passen zusammen'.        (3C)"),
                        new Choice(false, "Ist X kein Untertyp von java.lang.Object, dann ist X ein Interface.           (3D)"),
                        new Choice(false, "Aus 'U Untertyp von C' und 'C Untertyp von X' folgt: 'U.class==X.class'.      (3E)")
                ),

                new Question(
                        "o sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'o.peek()' die Zahl 1 als Ergebnis?",

                        new Choice(false, "o.push(1); o.push(8); o.push(o.peek());                                       (4A)"),
                        new Choice(false, "o.push(6); o.push(1); o.push(8);                                              (4B)"),
                        new Choice(false, "o.push(8); o.push(o.pop()); o.push(1);                                        (4C)"),
                        new Choice(false, "o.push(6); o.push(8); o.push(1);                                              (4D)"),
                        new Choice(false, "o.push(8); o.push(1); o.push(o.peek());                                       (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?",

                        new Choice(false, "Kommentare sind in abstrakten Datentypen bedeutungslos.                       (5A)"),
                        new Choice(false, "Datenkapselung ist ein anderer Begriff für Data-Hiding.                       (5B)"),
                        new Choice(false, "Datenkapselung fügt Variablen und Methoden zu einer Einheit zusammen.         (5C)"),
                        new Choice(false, "Data-Hiding behindert die Datenabstraktion.                                   (5D)"),
                        new Choice(false, "Klassen implementieren abstrakte Datentypen.                                  (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen müssen für jede Verwendung von\n" +
            "    'this(...)' bzw. 'this' in einem Konstruktor zutreffen?\n" +
            "    \n" +
            "    XXXXXXXXX 'this' ist nur in 'final' Konstruktoren verwendbar.                           (1A)\n" +
            "    XXXXXXXXX 'this' darf in Konstruktoren nicht verwendet werden.                          (1B)\n" +
            "    XXXXXXXXX 'this = null;' darf nur als erste Anweisung vorkommen.                        (1C)\n" +
            "    XXXXXXXXX 'this' referenziert das Objekt, das gerade initialisiert wird.                (1D)\n" +
            "    XXXXXXXXX Der Wert von 'this' kann nicht 'null' sein.                                   (1E)\n" +
            "\n" +
            " 2. e sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree e = new STree(); e.add(0); e.add(6); e.add(5);\n" +
            "    Welche der folgenden Aussagen treffen auf e zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 ist die Wurzel.                                         (2A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 ist Elter von dem mit Wert 5.                           (2B)\n" +
            "    XXXXXXXXX Der Baum ist nicht ausbalanciert.                                             (2C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 hat zumindest ein Kind.                                 (2D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 0 ist ein Blattknoten.                                    (2E)\n" +
            "\n" +
            " 3. X, U und C seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ist U eine Klasse, dann ist U Untertyp von java.lang.Object.                  (3A)\n" +
            "    XXXXXXXXX Aus 'C ist Klasse' und 'U ist Interface' folgt: 'U ist kein Untertyp von C'.  (3B)\n" +
            "    XXXXXXXXX Aus 'U Untertyp von C' folgt: 'Kommentare in U und C passen zusammen'.        (3C)\n" +
            "    XXXXXXXXX Ist X kein Untertyp von java.lang.Object, dann ist X ein Interface.           (3D)\n" +
            "    XXXXXXXXX Aus 'U Untertyp von C' und 'C Untertyp von X' folgt: 'U.class==X.class'.      (3E)\n" +
            "\n" +
            " 4. o sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'o.peek()' die Zahl 1 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX o.push(1); o.push(8); o.push(o.peek());                                       (4A)\n" +
            "    XXXXXXXXX o.push(6); o.push(1); o.push(8);                                              (4B)\n" +
            "    XXXXXXXXX o.push(8); o.push(o.pop()); o.push(1);                                        (4C)\n" +
            "    XXXXXXXXX o.push(6); o.push(8); o.push(1);                                              (4D)\n" +
            "    XXXXXXXXX o.push(8); o.push(1); o.push(o.peek());                                       (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?\n" +
            "    \n" +
            "    XXXXXXXXX Kommentare sind in abstrakten Datentypen bedeutungslos.                       (5A)\n" +
            "    XXXXXXXXX Datenkapselung ist ein anderer Begriff für Data-Hiding.                       (5B)\n" +
            "    XXXXXXXXX Datenkapselung fügt Variablen und Methoden zu einer Einheit zusammen.         (5C)\n" +
            "    XXXXXXXXX Data-Hiding behindert die Datenabstraktion.                                   (5D)\n" +
            "    XXXXXXXXX Klassen implementieren abstrakte Datentypen.                                  (5E)\n" +
            "\n";

    public static final long UID = 2023050259538994L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}