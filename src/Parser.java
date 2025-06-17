import Utils.List;

public class Parser {

    private List<Token> tokenliste;

    public Parser(List<Token> pTokenliste){
        this.tokenliste = pTokenliste;
        this.tokenliste.toFirst();
    }

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
        //TODO
        return false;
    }
    public boolean pruefeS(){
        //TODO
        return true;
    }
    public boolean pruefeA(){
        //TODO
        return true;
    }
    public boolean pruefeB(){
        //TODO
        return true;
    }
}
