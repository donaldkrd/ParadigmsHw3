public class Gamer {
    private String name;
    private char symbol;

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gamer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}