import Utils.List;

public class Parser {

    private List<Token> tokenliste;
    private boolean fehler;

    private Token aktuellesToken;

    public Parser(List<Token> pTokenliste){
        this.tokenliste = pTokenliste;
        this.tokenliste.toFirst();
        this.fehler = false;
        this.aktuellesToken = null;
    }

    @SuppressWarnings("ReassignedVariable")
    public Token nextToken(){
        Token aktToken = tokenliste.getContent();
        Token nextToken = null;
        tokenliste.next();
        if(tokenliste.hasAccess()) nextToken = tokenliste.getContent();
        tokenliste.toFirst();
        while(tokenliste.getContent() != aktToken) tokenliste.next();

        return nextToken;
    }

    public boolean parse() {
        this.tokenliste.toFirst();

        this.aktuellesToken = this.tokenliste.getContent();
        if(pruefeS()) tokenliste.remove();
        else return (this.fehler = true);

        this.aktuellesToken = this.tokenliste.getContent();
        if(pruefeA()) tokenliste.remove();
        else return (this.fehler = true);

        this.aktuellesToken = this.tokenliste.getContent();
        if(pruefeB()) tokenliste.remove();
        else return (this.fehler = true);

        return !tokenliste.isEmpty();
    }

    public boolean pruefeS(){
        String tokenWert = this.aktuellesToken.getWert();

        if(tokenWert.equals("la"))return true;
        if(tokenWert.equals("le"))return true;
        if(tokenWert.equals("lu"))return true;

        return false;
    }
    public boolean pruefeA(){
        return pruefeS();
    }
    public boolean pruefeB(){
        String tokenWert = this.aktuellesToken.getWert();
        if(tokenWert.equals("lu"))return true;

        return false;
    }
}
