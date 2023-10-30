import java.util.Scanner;
public class View {
    private static final Scanner scan = new Scanner(System.in);
    Table table = new Table();
    Gamer gamerOne = new Gamer("G1", 'X');
    Gamer gamerTwo = new Gamer("G2", 'O');
    Input input = new Input(gamerOne, gamerTwo, table);
    public void game() {
        System.out.print("Введите имя первого игрока: ");
        gamerOne.setName(scan.nextLine());
        System.out.print("Введите имя второго игрока: ");
        gamerTwo.setName(scan.nextLine());
        while (true) {
            input.makeMove(gamerOne);
            if (input.checkWin(gamerOne)) {
                table.printTable();
                return;
            }
            input.makeMove(gamerTwo);
            if (input.checkWin(gamerTwo)) {
                table.printTable();
                return;
            }
        }
    }
}