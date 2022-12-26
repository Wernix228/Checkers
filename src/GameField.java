public class GameField {

    private Cell[][] field = new Cell[8][8];
    private Figure figure;
    private String comment = "";
    private int cellX;
    private int fNum = 1;
    private int moveFigureNum;
    private Cell fID;

    public GameField() {

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

    public void getField() {
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
        switch (cellSX) {
            case "A":
                cellX = 0;
                break;
            case "B":
                cellX = 1;
                break;
            case "C":
                cellX = 2;
                break;
            case "D":
                cellX = 3;
                break;
            case "E":
                cellX = 4;
                break;
            case "F":
                cellX = 5;
                break;
            case "G":
                cellX = 6;
                break;
            case "H":
                cellX = 7;
                break;
        }
        findByID(figureID);
        figureMove(fID.getCellY(), fID.getCellX(), cellY, cellX);
        fID = null;
        System.out.println(getComment());
    }

    public String getComment() {
        return comment;
    }

    private void figureMove(int selectCellX, int selectCellY, int cellX, int cellY) {
        if (field[selectCellX][selectCellY].getFigure() != null) {
            figure = field[selectCellX][selectCellY].getFigure();
            moveFigureNum = field[selectCellX][selectCellY].getFigure().getFigureNum();
            field[selectCellX][selectCellY].setFigure(null);
            field[cellX][cellY].setFigure(figure);
            figure = null;
        } else System.out.println("Figure not found");
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

    public void info() {
        String figureColor = "";
        String line = "";
        String color = "";
        String figureID = "00";
        System.out.println("+----+----+----+----+----+----+----+----+");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (field[x][y].getCellColor().equals("white")) {
                    color = "w";
                }else color = "b";
                if (field[x][y].getFigure() != null) {

                    if (field[x][y].getFigure().getFigureNum() <= 9){
                        figureID = "0"+ field[x][y].getFigure().getFigureNum();
                    }else figureID = Integer.toString(field[x][y].getFigure().getFigureNum());

                    if (field[x][y].getFigure().getFigureColor().equals("white")) {
                        figureColor = "w";
                    } else figureColor = "b";
                }else figureColor = "n";

                line += color + "" + figureColor + figureID + "|";
                figureID = "00";
            }
            System.out.println("|" + line);
            line = "";
            System.out.println("+----+----+----+----+----+----+----+----+");
        }
    }
}
