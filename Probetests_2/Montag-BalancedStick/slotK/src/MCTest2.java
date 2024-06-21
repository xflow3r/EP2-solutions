// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?",

                        new Choice(false, "Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (1A)"),
                        new Choice(false, "Das Interface Iterator spezifiziert die Methoden next() und hasNext().             (1B)"),
                        new Choice(false, "Binärbäume sind meist einfacher iterierbar als lineare Listen.                     (1C)"),
                        new Choice(false, "Iterator-Implementierungen bestimmen die Reihenfolge der Iterationen.              (1D)"),
                        new Choice(false, "Eine Collection kann höchstens eine Iterator-Implementierung enthalten.            (1E)")
                ),

                new Question(
                        "int g=5, w=1, k=1; while (k < g) w += ++k; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "k > 1                                                                              (2A)"),
                        new Choice(false, "g == 5                                                                             (2B)"),
                        new Choice(false, "k > 0 && k < g                                                                     (2C)"),
                        new Choice(false, "k >= 1 && k <= g                                                                   (2D)"),
                        new Choice(false, "w <= g                                                                             (2E)")
                ),

                new Question(
                        "public int median(int[] i) { return i[i.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: Gibt einen Eintrag etwa in der Mitte von i zurück.                   (3A)"),
                        new Choice(false, "Vorbedingung: Lässt i unverändert.                                                 (3B)"),
                        new Choice(false, "Nachbedingung: Ergebnis hängt von einem Eintrag von i ab.                          (3C)"),
                        new Choice(false, "Nachbedingung: Gibt den Median zurück wenn i sortiert ist.                         (3D)"),
                        new Choice(false, "Vorbedingung: Wirft eine Exception wenn i.length == 0.                             (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(false, "Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (4A)"),
                        new Choice(false, "Reparaturversuche nicht plausibler Daten können gefährlich sein.                   (4B)"),
                        new Choice(false, "Von außen kommende Daten sind zu prüfen, nicht intern weitergereichte.             (4C)"),
                        new Choice(false, "Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (4D)"),
                        new Choice(false, "Wir müssen die Korrektheit prüfen, nicht nur die Plausibilität.                    (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?",

                        new Choice(false, "Die Abbruchbedingung kann nicht Teil einer Schleifeninvariante sein.               (5A)"),
                        new Choice(false, "Schleifeninvarianten müssen nur im Schleifenrumpf gelten.                          (5B)"),
                        new Choice(false, "Schleifeninvarianten helfen dabei, Programme statisch zu verstehen.                (5C)"),
                        new Choice(false, "Durch Schleifeninvarianten sind Schleifen im Debugger iterierbar.                  (5D)"),
                        new Choice(false, "Fortschritt muss unabhängig von Schleifeninvarianten geprüft werden.               (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Iteratoren über Bäumen traversieren Bäume meist rekursiv.                          (1A)\n" +
            "    XXXXXXXXX Das Interface Iterator spezifiziert die Methoden next() und hasNext().             (1B)\n" +
            "    XXXXXXXXX Binärbäume sind meist einfacher iterierbar als lineare Listen.                     (1C)\n" +
            "    XXXXXXXXX Iterator-Implementierungen bestimmen die Reihenfolge der Iterationen.              (1D)\n" +
            "    XXXXXXXXX Eine Collection kann höchstens eine Iterator-Implementierung enthalten.            (1E)\n" +
            "\n" +
            " 2. int g=5, w=1, k=1; while (k < g) w += ++k; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX k > 1                                                                              (2A)\n" +
            "    XXXXXXXXX g == 5                                                                             (2B)\n" +
            "    XXXXXXXXX k > 0 && k < g                                                                     (2C)\n" +
            "    XXXXXXXXX k >= 1 && k <= g                                                                   (2D)\n" +
            "    XXXXXXXXX w <= g                                                                             (2E)\n" +
            "\n" +
            " 3. public int median(int[] i) { return i[i.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: Gibt einen Eintrag etwa in der Mitte von i zurück.                   (3A)\n" +
            "    XXXXXXXXX Vorbedingung: Lässt i unverändert.                                                 (3B)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt von einem Eintrag von i ab.                          (3C)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt den Median zurück wenn i sortiert ist.                         (3D)\n" +
            "    XXXXXXXXX Vorbedingung: Wirft eine Exception wenn i.length == 0.                             (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (4A)\n" +
            "    XXXXXXXXX Reparaturversuche nicht plausibler Daten können gefährlich sein.                   (4B)\n" +
            "    XXXXXXXXX Von außen kommende Daten sind zu prüfen, nicht intern weitergereichte.             (4C)\n" +
            "    XXXXXXXXX Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (4D)\n" +
            "    XXXXXXXXX Wir müssen die Korrektheit prüfen, nicht nur die Plausibilität.                    (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Die Abbruchbedingung kann nicht Teil einer Schleifeninvariante sein.               (5A)\n" +
            "    XXXXXXXXX Schleifeninvarianten müssen nur im Schleifenrumpf gelten.                          (5B)\n" +
            "    XXXXXXXXX Schleifeninvarianten helfen dabei, Programme statisch zu verstehen.                (5C)\n" +
            "    XXXXXXXXX Durch Schleifeninvarianten sind Schleifen im Debugger iterierbar.                  (5D)\n" +
            "    XXXXXXXXX Fortschritt muss unabhängig von Schleifeninvarianten geprüft werden.               (5E)\n" +
            "\n";

    public static final long UID = 2023061179769388L;

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