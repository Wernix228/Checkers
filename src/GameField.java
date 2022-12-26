public class GameField {
    private final Cell[][] field;
    private Cell fID;

    private String comment = "";

    private int moveFigureNum;
    private boolean canMoveX;

    public GameField() {
        field = getDefaultField();
    }

    private Cell[][] getDefaultField() {
        Cell[][] field = new Cell[8][8];
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

        return field;
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append("CellX = " + field[i][j].getX() + " ");
                sb.append("CellY = " + field[i][j].getY() + " ");
                sb.append("CellColor = " + field[i][j].getColor() + " ");
                if (field[i][j].getFigure() != null) {
                    sb.append(("          FigureNum = " + field[i][j].getFigure().getFigureNum() + " "));
                    sb.append("FigureColor = " + field[i][j].getFigure().getColor()).append("\n");
                } else {
                    sb.append("          " + field[i][j].getFigure()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    public void move(int figureID, String cellSX, int cellY) {
        int cellX = lettersToNumbers(cellSX);
        findByID(figureID);
        figureMove(fID.getY(), fID.getX(), cellY, cellX, fID);
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
                if (field[x][y].getColor().equals("white")) {
                    color = "w";
                } else color = "b";
                if (field[x][y].getFigure() != null) {

                    if (field[x][y].getFigure().getFigureNum() <= 9) {
                        figureID = "0" + field[x][y].getFigure().getFigureNum();
                    } else figureID = Integer.toString(field[x][y].getFigure().getFigureNum());

                    if (field[x][y].getFigure().getColor().equals("white")) {
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

    private void findByID(int id) {
        for (int x = 0; x < field.length - 1; x++) {
            for (int y = 0; y < field[x].length - 1; y++) {
                if (field[x][y].getFigure() != null) {
                    if (field[x][y].getFigure().getFigureNum() == id) {
                        fID = field[x][y];
                    }
                }
            }
        }
    }

    private boolean canMove(Cell cID) {
        if ((cID.getX() < 7 && cID.getX() >= 0) && canMoveX) {
            if (cID.getFigure().isQueen()) {
                return true;
            } else if (cID.getY() >= 0 && cID.getY() < 7) {
                return true;
            } else return false;
        } else return false;
    }
//idk what it does pls help
    public boolean isCanMoveX() {
        return canMoveX;
    }

    private int lettersToNumbers(String symbol) {
        return symbol.charAt(0) - 100;
    }
}
