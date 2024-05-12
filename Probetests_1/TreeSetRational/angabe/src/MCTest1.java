// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "L, R und M seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(false, "Aus 'R Untertyp von M' folgt: 'R ist Klasse', 'M ist Interface'.              (1A)"),
                        new Choice(false, "R ist kein Untertyp von R.                                                    (1B)"),
                        new Choice(false, "Ist L ein Interface, dann ist L Untertyp von java.lang.Object.                (1C)"),
                        new Choice(false, "'null' ist ein Objekt von jedem Referenztyp M.                                (1D)"),
                        new Choice(false, "Aus 'R Untertyp von M' folgt: 'Kommentare in R und M müssen gleich sein'.     (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
                        "linearer und assoziativer Datenstrukturen?",

                        new Choice(false, "Assoziative Datenstrukturen sind (effizient) wahlfrei zugreifbar.             (2A)"),
                        new Choice(false, "Lineare Datenstrukturen können bei Bedarf größer werden.                      (2B)"),
                        new Choice(false, "Wahlfreie Zugriffe auf lineare Datenstrukturen sind sehr effizient.           (2C)"),
                        new Choice(false, "Lineare Datenstrukturen verwenden Schlüssel zur Adressierung.                 (2D)"),
                        new Choice(false, "Stacks haben FIFO-Verhalten.                                                  (2E)")
                ),

                new Question(
                        "Y sei ein Referenztyp (Klasse oder Interface), und m sei eine durch\n" +
                        "'T m = new W();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden Y, T, W und m zu?",

                        new Choice(false, "Mit 'W ist Untertyp von Y' gilt: '((Y)m).getClass() == W.class'               (3A)"),
                        new Choice(false, "'(Y)m' liefert Laufzeitfehler wenn Y nicht Untertyp von W ist.                (3B)"),
                        new Choice(false, "'(Y)null' liefert einen Laufzeitfehler.                                       (3C)"),
                        new Choice(false, "'(Y)m' liefert einen Laufzeitfehler wenn T Untertyp von Y ist.                (3D)"),
                        new Choice(false, "T ist Obertyp von W.                                                          (3E)")
                ),

                new Question(
                        "n sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  C und K seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 'n.get(C)' den String in K als Ergebnis?",

                        new Choice(false, "n.put(C, C); n.put(K, K); n.put(n.get(K), n.get(C));                          (4A)"),
                        new Choice(false, "n.put(K, C); n.put(n.get(K), n.get(C)); n.put(C, K);                          (4B)"),
                        new Choice(false, "n.put(C, K); n.put(C, C); n.put(n.get(C), n.get(K));                          (4C)"),
                        new Choice(false, "n.put(C, K); n.put(n.get(K), n.get(C)); n.put(K, C);                          (4D)"),
                        new Choice(false, "n.put(C, K); n.put(K, C); n.put(n.get(C), n.get(K));                          (4E)")
                ),

                new Question(
                        "e sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'e.peekFirst()'\n" +
                        "die Zahl 9 als Ergebnis?",

                        new Choice(false, "e.addFirst(9); e.addFirst(6); e.pollFirst();                                  (5A)"),
                        new Choice(false, "e.addFirst(9); e.addFirst(6); e.addFirst(e.peekLast());                       (5B)"),
                        new Choice(false, "e.addFirst(9); e.addFirst(6); e.peekFirst();                                  (5C)"),
                        new Choice(false, "e.addLast(9); e.addLast(6); e.pollLast();                                     (5D)"),
                        new Choice(false, "e.addLast(9); e.addLast(6); e.addFirst(e.peekLast());                         (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. L, R und M seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aus 'R Untertyp von M' folgt: 'R ist Klasse', 'M ist Interface'.              (1A)\n" +
            "    XXXXXXXXX R ist kein Untertyp von R.                                                    (1B)\n" +
            "    XXXXXXXXX Ist L ein Interface, dann ist L Untertyp von java.lang.Object.                (1C)\n" +
            "    XXXXXXXXX 'null' ist ein Objekt von jedem Referenztyp M.                                (1D)\n" +
            "    XXXXXXXXX Aus 'R Untertyp von M' folgt: 'Kommentare in R und M müssen gleich sein'.     (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
            "    linearer und assoziativer Datenstrukturen?\n" +
            "    \n" +
            "    XXXXXXXXX Assoziative Datenstrukturen sind (effizient) wahlfrei zugreifbar.             (2A)\n" +
            "    XXXXXXXXX Lineare Datenstrukturen können bei Bedarf größer werden.                      (2B)\n" +
            "    XXXXXXXXX Wahlfreie Zugriffe auf lineare Datenstrukturen sind sehr effizient.           (2C)\n" +
            "    XXXXXXXXX Lineare Datenstrukturen verwenden Schlüssel zur Adressierung.                 (2D)\n" +
            "    XXXXXXXXX Stacks haben FIFO-Verhalten.                                                  (2E)\n" +
            "\n" +
            " 3. Y sei ein Referenztyp (Klasse oder Interface), und m sei eine durch\n" +
            "    'T m = new W();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden Y, T, W und m zu?\n" +
            "    \n" +
            "    XXXXXXXXX Mit 'W ist Untertyp von Y' gilt: '((Y)m).getClass() == W.class'               (3A)\n" +
            "    XXXXXXXXX '(Y)m' liefert Laufzeitfehler wenn Y nicht Untertyp von W ist.                (3B)\n" +
            "    XXXXXXXXX '(Y)null' liefert einen Laufzeitfehler.                                       (3C)\n" +
            "    XXXXXXXXX '(Y)m' liefert einen Laufzeitfehler wenn T Untertyp von Y ist.                (3D)\n" +
            "    XXXXXXXXX T ist Obertyp von W.                                                          (3E)\n" +
            "\n" +
            " 4. n sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  C und K seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 'n.get(C)' den String in K als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX n.put(C, C); n.put(K, K); n.put(n.get(K), n.get(C));                          (4A)\n" +
            "    XXXXXXXXX n.put(K, C); n.put(n.get(K), n.get(C)); n.put(C, K);                          (4B)\n" +
            "    XXXXXXXXX n.put(C, K); n.put(C, C); n.put(n.get(C), n.get(K));                          (4C)\n" +
            "    XXXXXXXXX n.put(C, K); n.put(n.get(K), n.get(C)); n.put(K, C);                          (4D)\n" +
            "    XXXXXXXXX n.put(C, K); n.put(K, C); n.put(n.get(C), n.get(K));                          (4E)\n" +
            "\n" +
            " 5. e sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'e.peekFirst()'\n" +
            "    die Zahl 9 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX e.addFirst(9); e.addFirst(6); e.pollFirst();                                  (5A)\n" +
            "    XXXXXXXXX e.addFirst(9); e.addFirst(6); e.addFirst(e.peekLast());                       (5B)\n" +
            "    XXXXXXXXX e.addFirst(9); e.addFirst(6); e.peekFirst();                                  (5C)\n" +
            "    XXXXXXXXX e.addLast(9); e.addLast(6); e.pollLast();                                     (5D)\n" +
            "    XXXXXXXXX e.addLast(9); e.addLast(6); e.addFirst(e.peekLast());                         (5E)\n" +
            "\n";

    public static final long UID = 2023050279769497L;

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