import java.util.Scanner;

public class Main {
    private static String message;
    private static int moveCellY;
    private static String moveCellX;
    private static int moveY;
    private static String moveX;
    private static String move;
    private static int figureID;

    public static void main(String[] args) {
        GameField gameField = new GameField();
        Scanner scanner = new Scanner(System.in);
        System.out.println("write: \"help\"");
        while (scanner.hasNextLine()) {
            message = scanner.nextLine();
            if (message.equals("help")) {
                System.out.println("commands: ");
                System.out.println("\"field\" - To show the playing field");
                System.out.println("\"move\" - To move a figure");
                System.out.println("\"info\" - To show the info field");
            } else if (message.equals("move")) {
                System.out.println("Enter coordinates for movement example > (13 B 4)");

                move = scanner.nextLine();
                String[] words = move.split(" ");
                figureID = Integer.parseInt(words[0]);
                moveX = words[1];
                moveY = Integer.parseInt(words[2]);

                System.out.println(figureID + " go to " + moveX + " " + moveY);
                gameField.move(figureID, moveX, moveY);
                System.out.println("moving figure " + gameField.getFigureNum());
            } else if (message.equals("field")) {
                gameField.getField();
                System.out.println("\n");
            }else if(message.equals("info")){
                gameField.info();
            } else {
                System.out.println("This not command");
            }
        }
    }
}