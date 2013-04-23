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
    static String[] i18n = new String[15];

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
    }
    
    private static void setFR() {
        language = "fr";
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
