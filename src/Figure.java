public class Figure {

    private int num = 1000;
    private String FigureColor;
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

    public void setFigureColor(String figureColor) {
        FigureColor = figureColor;
    }

    public boolean isQueen() {
        return Queen;
    }

    public void setQueen(boolean queen) {
        Queen = queen;
    }
}
