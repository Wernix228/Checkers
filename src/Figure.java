public class Figure {

    private final int num;
    private final String FigureColor;
    private boolean Queen;

    public Figure(int num, String figureColor) {
        this.num = num;
        FigureColor = figureColor;
    }

    public int getFigureNum() {
        return num;
    }

    public String getFigureColor() {
        return FigureColor;
    }

    public boolean isQueen() {
        return Queen;
    }

    public void setQueen(boolean queen) {
        Queen = queen;
    }
}
