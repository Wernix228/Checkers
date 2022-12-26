public class Figure {
    private final String color;

    private final int num;
    private boolean queen;

    public Figure(int num, String color) {
        this.num = num;
        this.color = color;
    }

    public int getFigureNum() {
        return num;
    }

    public String getColor() {
        return color;
    }

    public boolean isQueen() {
        return queen;
    }

    public void setQueen() {
        this.queen = true;
    }
}
