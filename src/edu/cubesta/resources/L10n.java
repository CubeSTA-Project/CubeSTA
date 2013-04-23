/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.resources;

/**
 *
 * @author julien
 */
public class L10n {
    
    static String language;
    static String[] i18n = new String[17];
    static String[] i18nHelp = new String[22];

    public L10n() {
        setEN();
        language = System.getProperty("user.language");
        setLanguage(language);
    }

    public static void setLanguage(String language) {
        switch(language){
            case "fr" : setFR(); break;
            case "en" : setEN(); break;
            case "pl" : setPL(); break;
            case "de" : setDE(); break;
            default : setEN(); break;
        }
    }
    
    public static String[] listLanguage(){
        String[] s = {"en", "de", "fr"};
        return s;
    }
    
    public static String getLanguage(int opt){
        return i18n[opt];
    }
    
    public static String getLanguageHelp(int opt){
        return i18nHelp[opt];
    }
    
    public static String getOrdinal(int number){
        String retour;
        if("fr".equals(language)){//French
            switch(number){
                case 1 : retour = "er"; break;
                case 2 : retour = "nd"; break;
                default : retour = "ème"; break;
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
        i18n[7] = "Enter the number of movement for the scramble !";
        i18n[8] = "Enter the number of time for the average !";
        i18n[9] = "The number is too small (It should be greater than 3)";
        i18n[10] = "Choose your language !";
        i18n[11] = "seconds";
        i18n[12] = "This is not a number";
        i18n[13] = "Error";
        i18n[14] = "Inspection";
        i18n[15] = "KeyBoard Help";
        i18n[16] = "Scramble Help";
        //HELP I18N
        i18nHelp[0] = "Escape : Quit the program";
        i18nHelp[1] = "Espace : Start the timer";
        i18nHelp[2] = "Shift : Start the inspection timer";
        i18nHelp[3] = "Enter : Add a penality of 2 seconds";
        i18nHelp[4] = "D : Set the previous time as DNF";
        i18nHelp[5] = "S : Set the next time as DNS";
        i18nHelp[6] = "R : Reset all times";
        i18nHelp[7] = "F1 : Display the keyboard help";
        i18nHelp[8] = "F2 : Display the synthax movement help";
        i18nHelp[9] = "F3 : Set the language of the program";
        i18nHelp[10] = "F10 : Set the number of movement for the scramble";
        i18nHelp[11] = "F11 : Set the number of times to calculate the average";
        i18nHelp[12] = "F12 : Regen a new scramble";
        i18nHelp[13] = "F : Front side";
        i18nHelp[14] = "B : Back side";
        i18nHelp[15] = "U : Up side";
        i18nHelp[16] = "D : Down side";
        i18nHelp[17] = "R : Right side";
        i18nHelp[18] = "L : Left side";
        i18nHelp[19] = "  : Clockwise";
        i18nHelp[20] = "' : Anticlockwise";
        i18nHelp[21] = "² : Twice";
    }
    
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
        i18n[7] = "Entrer le nombre de mouvement pour le m\u00e9lange !";
        i18n[8] = "Entrer le nombre de temps pour la moyenne !";
        i18n[9] = "Le nombre est trop petit (Il doit \u00eatre sup\u00e9rieur \u00e0 3)";
        i18n[10] = "Choisissez votre langue !";
        i18n[11] = "secondes";
        i18n[12] = "Ce n'est pas un nombre";
        i18n[13] = "Erreur";
        i18n[14] = "Inspection";
        i18n[15] = "Aide Clavier";
        i18n[16] = "Aide Mélange";
        //HELP I18N
        i18nHelp[0] = "Echape : Quiter le programme";
        i18nHelp[1] = "Espace : Démarre le chronomètre";
        i18nHelp[2] = "Majuscule : Démarre le temps d'inspection";
        i18nHelp[3] = "Entrer : Ajoute une pénaliter de 2 secondes";
        i18nHelp[4] = "D : Définie le temps précédent comme DNF";
        i18nHelp[5] = "S : Définie le temps suivant comme DNS";
        i18nHelp[6] = "R : Remet à zéro tous les temps";
        i18nHelp[7] = "F1 : Afficher l'aide clavier";
        i18nHelp[8] = "F2 : Afficher l'aide de la synthaxe des mouvements";
        i18nHelp[9] = "F3 : Définie la langue du programme";
        i18nHelp[10] = "F10 : Définie le nombre de mouvement du mélange";
        i18nHelp[11] = "F11 : Définie le nombre de temps pour le calcul de la moyenne";
        i18nHelp[12] = "F12 : Permet de régénérer un mélange";
        i18nHelp[13] = "F : Face avant";
        i18nHelp[14] = "B : Face arrière";
        i18nHelp[15] = "U : Face du haut";
        i18nHelp[16] = "D : Face du bas";
        i18nHelp[17] = "R : Face de droite";
        i18nHelp[18] = "L : Face de gauche";
        i18nHelp[19] = "  : Dans le sens horaire";
        i18nHelp[20] = "' : Dans le sens antihoraire";
        i18nHelp[21] = "² : Deux fois";
    }
    
    private static void setDE() {
        language = "de";
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
        i18n[11] = "Sekunden";
        i18n[12] = "Das ist nicht eine Nummer";
        i18n[13] = "Fehler";
        i18n[14] = "Pr\u00fcfung";
    }
    
    private static void setPL() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
