import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Scanner scan;
    Table table;
    Gamer gamer1;
    Gamer gamer2;
    public Input(Gamer gamer1, Gamer gamer2, Table table) {
        scan = new Scanner(System.in);
        this.table = table;
        this.gamer1 = new Gamer("GamerOne", 'X');
        this.gamer2 = new Gamer("GamerTwo", 'O');
    }

    public void makeMove(Gamer gamer) {
        table.printTable();
        int a = 0;
        int b = 0;
        System.out.println("Ход игрока " + gamer.getName());
        System.out.print("Укажите номер строки: ");
        if (scan.hasNextInt()) {
            a = scan.nextInt();
        } else {
            throw new InputMismatchException("Не корректный ввод");
        }
        System.out.print("Укажите номер столбца: ");
        if (scan.hasNextInt()) {
            b = scan.nextInt();
        } else {
            throw new InputMismatchException("Не корректный ввод");
        }
        if (a > 0 && a < 4 && b > 0 && b < 4) {
            if (table.getGameTable()[a - 1][b - 1] == ' '){
                table.getGameTable()[a - 1][b - 1] = gamer.getSymbol();
            } else {
                System.out.println("<<< Поле занято >>>");
                makeMove(gamer);
            }
        } else {
            makeMove(gamer);
        }
    }
    public boolean checkWin(Gamer gamer){
        boolean win = false;
        if (table.getGameTable()[0][0] == gamer.getSymbol() &&
                table.getGameTable()[0][1] == gamer.getSymbol() &&
                table.getGameTable()[0][2] == gamer.getSymbol()) {
            win = true;
        }if (table.getGameTable()[1][0] == gamer.getSymbol() &&
                table.getGameTable()[1][1] == gamer.getSymbol() &&
                table.getGameTable()[1][2] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[2][0] == gamer.getSymbol() &&
                table.getGameTable()[2][1] == gamer.getSymbol() &&
                table.getGameTable()[2][2] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][0] == gamer.getSymbol() &&
                table.getGameTable()[1][0] == gamer.getSymbol() &&
                table.getGameTable()[2][0] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][1] == gamer.getSymbol() &&
                table.getGameTable()[1][1] == gamer.getSymbol() &&
                table.getGameTable()[2][1] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][2] == gamer.getSymbol() &&
                table.getGameTable()[1][2] == gamer.getSymbol() &&
                table.getGameTable()[2][2] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[0][0] == gamer.getSymbol() &&
                table.getGameTable()[1][1] == gamer.getSymbol() &&
                table.getGameTable()[2][2] == gamer.getSymbol()) {
            win = true;
        }
        if (table.getGameTable()[2][0] == gamer.getSymbol() &&
                table.getGameTable()[1][1] == gamer.getSymbol() &&
                table.getGameTable()[0][2] == gamer.getSymbol()) {
            win = true;
        }
        if (win == true) {
            System.out.println("!!! Победил игрок " + gamer.getName() + " !!!");
            return true;
        } else if (checkDraw(table)) {
            System.out.println("!!! Ничья !!!");
            return true;
        } else {
            return false;
        }
    }
    public boolean checkDraw(Table table) {
        for (int i = 0; i < table.getGameTable().length; i++) {
            for (int j = 0; j < table.getGameTable()[i].length; j++) {
                if (table.getGameTable()[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}