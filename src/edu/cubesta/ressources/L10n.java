/**
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * © Copyright 2013, Gardet Julien, Droy Yann, Araujo Auxence.
 * 
 * The logo in edu.cubesta.ressources.favicon.png is a derivate work from
 * <http://commons.wikimedia.org/w/index.php?title=File:Rubik%27s_cube.svg&oldid=70000649>.
 * 
 * Other legal notices on <http://cubesta-project.github.io/CubeSTA/legals.html>.
 */
/* Project : CubeSTA
 * Location : edu.cubesta.ressources
 * Class : L10n.java
 */

package edu.cubesta.ressources;

/**
 * Permet de gérer l'internationalisation du programme
 * @author julien.gardet yann.droy auxence.araujo
 */
public class L10n {
    
    /**
     * Tips and tricks : 
     * Utiliser fileformat.info pour retrouver le code unicode des caractères
     * http://www.fileformat.info/info/unicode/char/search.htm?q=&preview=entity
     * Character : U+0041  ->  Java : \u0041
     */
    
    /**
     * Variable Globale
     */
    
    private static String language;
    private static String[] i18n = new String[18];
    private static String[] i18nHelp = new String[23];
    
    /**
     * Définie la langue d'affichage par défault
     */

    public L10n() {
        setEN();
        language = System.getProperty("user.language");
        setLanguage(language);
    }
    
    /**
     * Modifie la langue d'affichage
     * @param language 
     * la langue à définir
     */

    public static void setLanguage(String language) {
        switch(language){
            case "fr" : setFR(); break;
            case "en" : setEN(); break;
            case "pl" : setPL(); break;
            case "de" : setDE(); break;
            default : setEN(); break;
        }
    }
    
    /**
     * Retourne la liste des langues disponible
     * @return 
     * retourne la liste des langues
     */
    
    public static String[] listLanguage(){
        String[] s = {"en", "de", "fr"};
        return s;
    }
    
    /**
     * Retourne l'internationalisation d'un message
     * @param opt
     * Le numéro du méssage
     * @return 
     * Retourn le message traduit
     */
    
    public static String getLanguage(int opt){
        return i18n[opt];
    }
    
    /**
     * Retourne l'internationalisation d'un message d'aide
     * @param opt
     * Le numéro du méssage
     * @return 
     * Retourne le message traduit
     */
    
    public static String getLanguageHelp(int opt){
        return i18nHelp[opt];
    }
    
    /**
     * Retourne l'internationalisation des adjectifs numérals ordinaux
     * @param number
     * Le numéro
     * @return 
     * Retourne l'abreviation
     */
    
    public static String getOrdinal(int number){
        String retour;
        if("fr".equals(language)){//French
            switch(number){
                case 1 : retour = "er"; break;
                case 2 : retour = "nd"; break;
                default : retour = "\u00e8me"; break;
            }
        }else if("de".equals(language)){//Deutsch
            retour = ".";
        }else{//English and Default
            if(number <= 20){
               switch(number){
                    case 1 : retour = "st"; break;
                    case 2 : retour = "nd"; break;
                    case 3 : retour = "rd"; break;
                    default : retour = "th"; break;
                } 
            }else{
               switch(number % 10){
                    case 1 : retour = "st"; break;
                    case 2 : retour = "nd"; break;
                    case 3 : retour = "rd"; break;
                    default : retour = "th"; break;
                } 
            }
        }
        return retour;
    }
    
    /**
     * The english translation
     */

    private static void setEN() {
        language = "en";
        //MAIN I18N
        i18n[0] = "Round";
        i18n[1] = "Average";
        i18n[2] = "Best";
        i18n[3] = "Scramble";
        i18n[4] = "Timer";
        i18n[5] = "Option";
        i18n[6] = "Warning";
        i18n[7] = "Enter the number of movements for the scramble !";
        i18n[8] = "Enter the number of time for the average !";
        i18n[9] = "The number is too small (It should be greater than 3)";
        i18n[10] = "Choose your language !";
        i18n[11] = "seconds";
        i18n[12] = "This is not a number";
        i18n[13] = "Error";
        i18n[14] = "Inspection";
        i18n[15] = "Keyboard Help";
        i18n[16] = "Scramble Help";
        i18n[17] = "Enter the inspection time (in second) !";
        //HELP I18N
        i18nHelp[0] = "Escape : Quit the program";
        i18nHelp[1] = "Espace : Start the timer";
        i18nHelp[2] = "Shift : Start the inspection timer";
        i18nHelp[3] = "Enter : Add a penality of 2 seconds";
        i18nHelp[4] = "D : Set the previous time as DNF";
        i18nHelp[5] = "S : Set the next time as DNS";
        i18nHelp[6] = "R : Reset all times";
        i18nHelp[7] = "F1 : Display the keyboard help";
        i18nHelp[8] = "F2 : Display the syntax movement help";
        i18nHelp[9] = "F3 : Set the language of the program";
        i18nHelp[10] = "F9 : Set the inspection time";
        i18nHelp[11] = "F10 : Set the number of movements for the scramble";
        i18nHelp[12] = "F11 : Set the number of times to calculate the average";
        i18nHelp[13] = "F12 : Regenerate a new scramble";
        i18nHelp[14] = "F : Front side";
        i18nHelp[15] = "B : Back side";
        i18nHelp[16] = "U : Up side";
        i18nHelp[17] = "D : Down side";
        i18nHelp[18] = "R : Right side";
        i18nHelp[19] = "L : Left side";
        i18nHelp[20] = "  : Clockwise";
        i18nHelp[21] = "' : Counterclockwise";
        i18nHelp[22] = "² : Twice";
    }
    
    /**
     * La traduction française
     */
    
    private static void setFR() {
        language = "fr";
        //MAIN I18N
        i18n[0] = "Tour";
        i18n[1] = "Moyenne";
        i18n[2] = "Meilleur";
        i18n[3] = "M\u00e9lange";
        i18n[4] = "Chronom\u00e8tre";
        i18n[5] = "Option";
        i18n[6] = "Attention";
        i18n[7] = "Entrer le nombre de mouvements pour le m\u00e9lange !";
        i18n[8] = "Entrer le nombre de temps pour la moyenne !";
        i18n[9] = "Le nombre est trop petit (Il doit \u00eatre sup\u00e9rieur \u00e0 3)";
        i18n[10] = "Choisissez votre langue !";
        i18n[11] = "secondes";
        i18n[12] = "Ce n'est pas un nombre";
        i18n[13] = "Erreur";
        i18n[14] = "Inspection";
        i18n[15] = "Aide Clavier";
        i18n[16] = "Aide M\u00e9lange";
        i18n[17] = "Entrer le temps d'inspection (en secondes) !";
        //HELP I18N
        i18nHelp[0] = "Echap : Quiter le programme";
        i18nHelp[1] = "Espace : D\u00e9marre le chronom\u00e8tre";
        i18nHelp[2] = "Majuscule : D\u00e9marre le temps d'inspection";
        i18nHelp[3] = "Entrer : Ajoute une p\u00e9naliter de 2 secondes";
        i18nHelp[4] = "D : D\u00e9finie le temps pr\u00e9c\u00e9dent comme DNF";
        i18nHelp[5] = "S : D\u00e9finie le temps suivant comme DNS";
        i18nHelp[6] = "R : Remet à z\u00e9ro tous les temps";
        i18nHelp[7] = "F1 : Afficher l'aide clavier";
        i18nHelp[8] = "F2 : Afficher l'aide de la syntaxe des mouvements";
        i18nHelp[9] = "F3 : D\u00e9finit la langue du programme";
        i18nHelp[10] = "F9 : D\u00e9finit le temps d'inspection";
        i18nHelp[11] = "F10 : D\u00e9finit le nombre de mouvements du m\u00e9lange";
        i18nHelp[12] = "F11 : D\u00e9finit le nombre de temps pour le calcul de la moyenne";
        i18nHelp[13] = "F12 : Permet de r\u00e9g\u00e9n\u00e9rer un m\u00e9lange";
        i18nHelp[14] = "F : Face avant";
        i18nHelp[15] = "B : Face arri\u00e8re";
        i18nHelp[16] = "U : Face du haut";
        i18nHelp[17] = "D : Face du bas";
        i18nHelp[18] = "R : Face de droite";
        i18nHelp[19] = "L : Face de gauche";
        i18nHelp[20] = "  : Dans le sens horaire";
        i18nHelp[21] = "' : Dans le sens antihoraire";
        i18nHelp[22] = "² : Deux fois";
    }
    
    /**
     * Die deutsche Übersetzung
     */
    
    private static void setDE() {
        language = "de";
        //Main Help
        i18n[0] = "Runde";
        i18n[1] = "Mittelwert";
        i18n[2] = "Beste";
        i18n[3] = "Scramble";
        i18n[4] = "Stoppuhr";
        i18n[5] = "Wahl";
        i18n[6] = "Achtung";
        i18n[7] = "Geben Sie die Nummer der Bewegung f\u00fcr die Scramble !";
        i18n[8] = "Geben Sie die Nummer der Zeit f\u00fcr der Mittelwert !";
        i18n[9] = "Die Zahl ist zu klein (muss gr\u00f6\u00dfer als 3)";
        i18n[10] = "W\u00e4hlen Sie Ihre Sprache";
        i18n[11] = "Strafsekunden";
        i18n[12] = "Das ist nicht eine Nummer";
        i18n[13] = "Fehler";
        i18n[14] = "Pr\u00fcfung";
        i18n[15] = "Tastatur-Hilfe";
        i18n[16] = "Scramble-Hilfe";
        i18n[17] = "Geben Sie die Pr\u00fcfung Zeit (in Sekunden) !";
        //HELP I18N
         i18nHelp [0] = "Escape-Taste: Beenden das Programm";
         i18nHelp [1] = "Leertaste: Starten der Stoppuhr";
         i18nHelp [2] = "Umschalttaste: Starten der Pr\u00fcfung Stoppuhr";
         i18nHelp [3] = "Eingabetaste: F\u00fcgt 2 Strafsekunden";
         i18nHelp [4] = "D: Definiert der vorherige Zeit als DNF";
         i18nHelp [5] = "S: Definiert der n\u00e4chste Zeit als DNS";
         i18nHelp [6] = "R: Zur\u00fccksetzen aller Zeiten";
         i18nHelp [7] = "F1: Zeigt die Tastatur-Hilfe";
         i18nHelp [8] = "F2: Zeigt die Scramble-Hilfe";
         i18nHelp [9] = "F3: Definiert die Sprache des Programms";
         i18nHelp [10] = "F9: Definiert der Pr\u00fcfung Stoppuhr";
         i18nHelp [11] = "F10: Definiert die Anzahl der Bewegung f\u00fcr die Scramble";
         i18nHelp [12] = "F11: Definiert die Anzahl der f\u00fcr die Berechnung des Mittelwertes";
         i18nHelp [13] = "F12: Regeneriert eine neue Scramble";
         i18nHelp [14] = "F: Vorderseite";
         i18nHelp [15] = "B: R\u00fcckseite";
         i18nHelp [16] = "U: Obenseite";
         i18nHelp [17] = "D: Unterseite";
         i18nHelp [18] = "R: Richtigseite";
         i18nHelp [19] = "L: Linkenseite";
         i18nHelp [20] = " : Im Uhrzeigersinn";
         i18nHelp [21] = "': Gegen den Uhrzeigersinn";
         i18nHelp [22] = "²: Zweimal";
    }
    
    /**
     * Tłumaczenie na polski
     */
    
    private static void setPL() {
        language = "pl";
        //MAIN I18N
        i18n[0] = "Runda";
        i18n[1] = "Średnia";
        i18n[2] = "Najlepszy";
        i18n[3] = "Mieszanie";
        i18n[4] = "Zegar";
        i18n[5] = "Ustawienia";
        i18n[6] = "Uwaga";
        i18n[7] = "Wpisać liczbę ruchów do pomieszania kostki !";
        i18n[8] = "Wpisać liczbę czasów do średnii ";
        i18n[9] = "Liczba jest za mała (powyżej 3)";
        i18n[10] = "Wybraj język !";
        i18n[11] = "sekund";
        i18n[12] = "To nie jest numer";
        i18n[13] = "Błąd";
        i18n[14] = "Czas podglądania";
        i18n[15] = "Pomoc klawiatury";
        i18n[16] = "Pomoc mieszania";
        i18n[17] = "Wpisać czas podglądania (w sekundach)!";
        //HELP I18N
        i18nHelp[0] = "Echap : Zamknąć program";
        i18nHelp[1] = "Spacja : Startować zegar";
        i18nHelp[2] = "Shift : Startować czas podglądania";
        i18nHelp[3] = "Enter : Dodać karę 2 sekund";
        i18nHelp[4] = "D : Ustawić poprzedni czasu jako DNF";
        i18nHelp[5] = "S : Ustawić przyszłego czasu jako DNS";
        i18nHelp[6] = "R : Resetować zegara";
        i18nHelp[7] = "F1 : Wyswietlić pomoc klwiatury";
        i18nHelp[8] = "F2 : Wyswietlić pomoc ruchów kostki";
        i18nHelp[9] = "F3 : Ustawić język";
        i18nHelp[10] = "F9 : Ustawić czas podglądania";
        i18nHelp[11] = "F10 : Ustawić liczbę ruchów do pomieszania kostki";
        i18nHelp[12] = "F11 : Ustawić liczbę czasów do liczenia średnii";
        i18nHelp[13] = "F12 : Regenerować jednego mieszania ";
        i18nHelp[14] = "F : Przednia ściana";
        i18nHelp[15] = "B : Tylnia ściana";
        i18nHelp[16] = "U : Górna ściana";
        i18nHelp[17] = "D : Dolna ściana";
        i18nHelp[18] = "R : Prawa ściana";
        i18nHelp[19] = "L : Lewa ściana";
        i18nHelp[20] = "  : Kierunkiem ruchu według wskazówek zegara";
        i18nHelp[21] = "' : Kierunkiem przeciwnym według ruchu wskazówek zegara";
        i18nHelp[22] = "² : Dwa razy";
    }
}