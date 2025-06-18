import Utils.List;

public class Scanner {
    private boolean fehler;
    private String eingabe;

    private List<Token> tokenliste;

    private Token aktuellesToken;

    public Scanner(String pEingabe, List<Token> pTokenliste){
        this.fehler = false;
        this.eingabe = pEingabe;
        if(pTokenliste == null) this.tokenliste = new List<Token>();
        else this.tokenliste = pTokenliste;
        this.aktuellesToken = null;
    }

    public void scanne(){
        String[] eA  = { //eA = eingabeAlphabet
                "la", "le", "lu"
        };
        for(int i = 0; i < this.eingabe.length(); i = i + 2){
            aktuellesToken = new Token(""+this.eingabe.charAt(i) + this.eingabe.charAt(i+1), "keyword");

            if(aktuellesToken.getWert().equals(eA[0])) this.tokenliste.append(aktuellesToken);

            else if(aktuellesToken.getWert().equals(eA[1])) this.tokenliste.append(aktuellesToken);

            else if(aktuellesToken.getWert().equals(eA[2])) this.tokenliste.append(aktuellesToken);

            else {
                this.fehler = true;
                tokenliste = null;
                break; // die for schleife abbrechen sollte ein fehlerhafter token vorkommen
            }
        }
        this.ausgabe(this.fehler);

    }
    public void ausgabe(boolean pFehler){
        if(pFehler) System.out.println("Lexikalische Analyse Fehlerhaft!");
        else System.out.println("Lexikalische Analyse Erfolgreich!");
    }

    public List<Token> getTokenliste(){
        return this.tokenliste;
    }
}
