public class Cell {

    private Figure figure = null;
    private final int cellX;
    private final int cellY;
    private final String cellColor;

    public Cell(int cellX, int cellY, String cellColor, Figure figure) {
        this.cellX = cellX;
        this.cellY = cellY;
        this.cellColor = cellColor;
        this.figure = figure;
    }

    public Cell(int cellX, int cellY, String cellColor) {
        this.cellX = cellX;
        this.cellY = cellY;
        this.cellColor = cellColor;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getCellColor() {
        return cellColor;
    }

}
