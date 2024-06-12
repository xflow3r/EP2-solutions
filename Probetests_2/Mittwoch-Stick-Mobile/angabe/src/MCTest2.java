// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "TreeMap<K,V> ist Untertyp von SortedSet<E>.                                        (1A)"),
                        new Choice(false, "LinkedList<E> ist Untertyp von Collection<E>                                       (1B)"),
                        new Choice(false, "Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (1C)"),
                        new Choice(false, "LinkedHashSet<E> implementiert Set<E>.                                             (1D)"),
                        new Choice(false, "TreeSet<E> verbietet mehrere gleiche Einträge.                                     (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(false, "Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (2A)"),
                        new Choice(false, "Nicht validierbare Daten müssen zurückgewiesen werden.                             (2B)"),
                        new Choice(false, "Unzureichende Prüfung kann z.B. zu einer SQL-Injection führen.                     (2C)"),
                        new Choice(false, "Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (2D)"),
                        new Choice(false, "Programme müssen alle eingegebenen Daten akzeptieren.                              (2E)")
                ),

                new Question(
                        "public int sumFrom1To(int n) { return (n * (n + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: n > 0.                                                               (3A)"),
                        new Choice(false, "Nachbedingung: Halbiert (n * (n + 1)).                                             (3B)"),
                        new Choice(false, "Vorbedingung: Ergebnis hängt nur von n ab.                                         (3C)"),
                        new Choice(false, "Nachbedingung: Ergebnis ist für n <= 0 nicht die Zahlensumme.                      (3D)"),
                        new Choice(false, "Nachbedingung: Gibt (n * n + n) / 2 zurück.                                        (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Invarianten beziehen sich auf einzelne Methoden.                                   (4A)"),
                        new Choice(false, "Vorbedingungen beschreiben häufig Eigenschaften von Parametern.                    (4B)"),
                        new Choice(false, "Nachbedingungen beschreiben häufig Eigenschaften von Parametern.                   (4C)"),
                        new Choice(false, "Es gilt nur das, was explizit in Zusicherungen steht.                              (4D)"),
                        new Choice(false, "Nachbedingungen beziehen sich auf einzelne Methoden.                               (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Qualität großer Programme und\n" +
                        "das zur Erreichung der geforderten Qualität nötige Qualitätsmanagement zu?",

                        new Choice(false, "Formale Korrektheitsbeweise sind für große Programme extrem aufwendig.             (5A)"),
                        new Choice(false, "Design-by-Contract kann Missverständnisse früh erkennen lassen.                    (5B)"),
                        new Choice(false, "Konfigurierbarkeit kann die Brauchbarkeit des Programms verbessern.                (5C)"),
                        new Choice(false, "Qualitätsanforderungen sollen analysiert und dargestellt werden.                   (5D)"),
                        new Choice(false, "Zur Effekivitätssteigerung sind Team-Besprechungen zu vermeiden.                   (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX TreeMap<K,V> ist Untertyp von SortedSet<E>.                                        (1A)\n" +
            "    XXXXXXXXX LinkedList<E> ist Untertyp von Collection<E>                                       (1B)\n" +
            "    XXXXXXXXX Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (1C)\n" +
            "    XXXXXXXXX LinkedHashSet<E> implementiert Set<E>.                                             (1D)\n" +
            "    XXXXXXXXX TreeSet<E> verbietet mehrere gleiche Einträge.                                     (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (2A)\n" +
            "    XXXXXXXXX Nicht validierbare Daten müssen zurückgewiesen werden.                             (2B)\n" +
            "    XXXXXXXXX Unzureichende Prüfung kann z.B. zu einer SQL-Injection führen.                     (2C)\n" +
            "    XXXXXXXXX Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (2D)\n" +
            "    XXXXXXXXX Programme müssen alle eingegebenen Daten akzeptieren.                              (2E)\n" +
            "\n" +
            " 3. public int sumFrom1To(int n) { return (n * (n + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: n > 0.                                                               (3A)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert (n * (n + 1)).                                             (3B)\n" +
            "    XXXXXXXXX Vorbedingung: Ergebnis hängt nur von n ab.                                         (3C)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis ist für n <= 0 nicht die Zahlensumme.                      (3D)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt (n * n + n) / 2 zurück.                                        (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Invarianten beziehen sich auf einzelne Methoden.                                   (4A)\n" +
            "    XXXXXXXXX Vorbedingungen beschreiben häufig Eigenschaften von Parametern.                    (4B)\n" +
            "    XXXXXXXXX Nachbedingungen beschreiben häufig Eigenschaften von Parametern.                   (4C)\n" +
            "    XXXXXXXXX Es gilt nur das, was explizit in Zusicherungen steht.                              (4D)\n" +
            "    XXXXXXXXX Nachbedingungen beziehen sich auf einzelne Methoden.                               (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf die Qualität großer Programme und\n" +
            "    das zur Erreichung der geforderten Qualität nötige Qualitätsmanagement zu?\n" +
            "    \n" +
            "    XXXXXXXXX Formale Korrektheitsbeweise sind für große Programme extrem aufwendig.             (5A)\n" +
            "    XXXXXXXXX Design-by-Contract kann Missverständnisse früh erkennen lassen.                    (5B)\n" +
            "    XXXXXXXXX Konfigurierbarkeit kann die Brauchbarkeit des Programms verbessern.                (5C)\n" +
            "    XXXXXXXXX Qualitätsanforderungen sollen analysiert und dargestellt werden.                   (5D)\n" +
            "    XXXXXXXXX Zur Effekivitätssteigerung sind Team-Besprechungen zu vermeiden.                   (5E)\n" +
            "\n";

    public static final long UID = 2023061139308164L;

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