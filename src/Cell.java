public class Cell {

    private Figure figure;
    private final int x;
    private final int y;
    private final String color;

    public Cell(int x, int y, String color, Figure figure) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.figure = figure;
    }

    public Cell(int x, int y, String color) {
        this(x, y, color, null);
    }

    public Figure getFigure() {
        return figure;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getColor() {
        return color;
    }

}
