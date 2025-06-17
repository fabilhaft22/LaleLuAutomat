import Utils.List;

public class Scanner {
    private boolean fehler;
    private String eingabe;

    private List<Token> tokenliste;

    public Scanner(String pEingabe, List<Token> pTokenliste){
        this.fehler = false;
        this.eingabe = pEingabe;
        this.tokenliste = pTokenliste;
    }

    public void scanne(){

    }
    public void ausgabe(boolean pFehler){
        if(pFehler) System.out.println("Lexikalische Analyse Fehlerhaft!");
        else System.out.println("Lexikalische Analyse Erfolgreich!");
    }
}
