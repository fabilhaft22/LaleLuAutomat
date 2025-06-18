import Utils.List;

public class Analyse {
    private String eingabe;
    private List<Token> tokenliste;
    private Scanner scanner;
    private Parser parser;

    public Analyse(String pEingabe){
        this.eingabe = pEingabe.toLowerCase();
        tokenliste = null;
        scanner = null;
        parser = null;
    }

    public String getEingabe() {
        return eingabe;
    }

    public void setEingabe(String eingabe) {
        this.eingabe = eingabe;
    }

    public void analysiere(){
        scanner = new Scanner(this.eingabe, this.tokenliste);
        scanner.scanne();
        tokenliste = scanner.getTokenliste();

        if(!(tokenliste.isEmpty())){
            parser = new Parser(this.tokenliste);
            if(!parser.parse()){
                System.out.println("Das Eingabewort " + this.eingabe + " ist Teil der Grammatik und somit erlaubt.");
            }else {
                System.out.println("Das Eingabewort " + this.eingabe + " ist kein Teil der Grammatik und somit nicht erlaubt.");
            }
        }
    }
}
