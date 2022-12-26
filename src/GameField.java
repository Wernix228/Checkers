public class GameField {

    private final Cell[][] field = new Cell[8][8];
    private String comment = "";
    private int moveFigureNum;
    private Cell fID;
    private boolean canMoveX = false;

    public GameField() {
        int fNum = 1;

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {

                if ((x % 2 == 0 && y % 2 == 1) || (x % 2 != 0 && y % 2 == 0)) {


                    if (x <= 2) {
                        field[x][y] = new Cell(y, x, "black", new Figure(fNum, "black"));
                        ++fNum;
                    } else if (x >= 5) {
                        field[x][y] = new Cell(y, x, "black", new Figure(fNum, "white"));
                        ++fNum;
                    } else {
                        field[x][y] = new Cell(y, x, "black", null);
                    }

                } else {
                    field[x][y] = new Cell(y, x, "white");
                }
            }
        }
    }

    public void info() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("CellX = " + field[i][j].getCellX() + " ");
                System.out.print("CellY = " + field[i][j].getCellY() + " ");
                System.out.print("CellColor = " + field[i][j].getCellColor() + " ");
                if (field[i][j].getFigure() != null) {
                    System.out.print("          FigureNum = " + field[i][j].getFigure().getFigureNum() + " ");
                    System.out.println("FigureColor = " + field[i][j].getFigure().getFigureColor());
                } else
                    System.out.println("          " + field[i][j].getFigure());
            }
        }
    }

    public void move(int figureID, String cellSX, int cellY) {
        int cellX;
        switch (cellSX) {
            case "A":
                cellX = 0;
                canMoveX = true;
                break;
            case "B":
                cellX = 1;
                canMoveX = true;
                break;
            case "C":
                cellX = 2;
                canMoveX = true;
                break;
            case "D":
                cellX = 3;
                canMoveX = true;
                break;
            case "E":
                cellX = 4;
                canMoveX = true;
                break;
            case "F":
                cellX = 5;
                canMoveX = true;
                break;
            case "G":
                cellX = 6;
                canMoveX = true;
                break;
            case "H":
                cellX = 7;
                canMoveX = true;
                break;
            default:
                comment = "Lol";
                findByID(figureID);
                cellX = fID.getCellX();
                canMoveX = false;
                break;
        }
        findByID(figureID);
        figureMove(fID.getCellY(), fID.getCellX(), cellY, cellX, fID);
        fID = null;
        System.out.println(getComment());
    }

    public String getComment() {
        return comment;
    }

    private void figureMove(int selectCellX, int selectCellY, int cellY, int cellX, Cell fMove) {
        if (field[selectCellX][selectCellY].getFigure() != null) {
            Figure figure = field[selectCellX][selectCellY].getFigure();
            moveFigureNum = field[selectCellX][selectCellY].getFigure().getFigureNum();
            if (canMove(fMove)) {
                field[selectCellX][selectCellY].setFigure(null);
                field[--cellY][cellX].setFigure(figure);
                figure = null;
            } else comment = "?";
        } else comment = "Figure not found";
        System.out.println(comment);
    }

    private void findByID(int ID) {
        for (int x = 0; x < field.length - 1; x++) {
            for (int y = 0; y < field[x].length - 1; y++) {
                if (field[x][y].getFigure() != null) {
                    if (field[x][y].getFigure().getFigureNum() == ID) {
                        fID = field[x][y];
                    }
                }
            }
        }
    }

    public int getFigureNum() {
        return moveFigureNum;
    }

    public void getField() {
        String figureColor = "";
        String line = "";
        String color = "";
        String figureID = "00";
        int lineNum = 1;
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {
                if (field[x][y].getCellColor().equals("white")) {
                    color = "w";
                } else color = "b";
                if (field[x][y].getFigure() != null) {

                    if (field[x][y].getFigure().getFigureNum() <= 9) {
                        figureID = "0" + field[x][y].getFigure().getFigureNum();
                    } else figureID = Integer.toString(field[x][y].getFigure().getFigureNum());

                    if (field[x][y].getFigure().getFigureColor().equals("white")) {
                        figureColor = "W";
                    } else figureColor = "B";
                } else figureColor = "N";

                line += color + "" + figureColor + figureID + "|";
                figureID = "00";
            }
            System.out.println(lineNum + "|" + line);
            line = "";
            lineNum++;
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }
        System.out.println("   A    B    C    D    E    F    G    H");
    }

    private boolean canMove(Cell cID) {
        if ((cID.getCellX() < 7 && cID.getCellX() >= 0) && canMoveX) {
            if(cID.getFigure().isQueen()){
                return true;
            }else if (cID.getCellY() >= 0 && cID.getCellY() < 7){
                return true;
            }else return false;
        } else return false;
    }

    public boolean isCanMoveX() {
        return canMoveX;
    }
}
