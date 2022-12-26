import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField();
        Scanner scanner = new Scanner(System.in);
        System.out.println("write: \"help\"");
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            switch (message) {
                case "help":
                    System.out.println("commands: ");
                    System.out.println("\"field\" - To show the playing field");
                    System.out.println("\"move\" - To move a figure");
                    System.out.println("\"info\" - To show the info field");
                    break;
                case "move":
                    System.out.println("Enter coordinates for movement example > (13 B 5)");

                    String move = scanner.nextLine();
                    String[] words = move.split(" ");
                    int figureID = Integer.parseInt(words[0]);
                    String moveX = words[1];
                    int moveY = Integer.parseInt(words[2]);

                    gameField.move(figureID, moveX, moveY);
                    if (gameField.isCanMoveX()) {
                        System.out.println(figureID + " go to " + moveX + " " + moveY);
                        System.out.println("moving figure " + gameField.getFigureNum());
                    } else System.out.println("Figure not move: \n" + gameField.getComment());
                    break;
                case "field":

                    gameField.getField();
                    System.out.println("\n");
                    break;
                case "info":
                    gameField.info();
                    break;
                default:
                    System.out.println("This not command");
                    break;
            }
        }
    }
}