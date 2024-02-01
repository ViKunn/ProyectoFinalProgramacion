package FisicaYMates;

public class Vector2D {
    private double posiciónX, posiciónY ;

    public Vector2D(double  posiciónX, double posiciónY) {
        this.posiciónX = posiciónX;
        this.posiciónY = posiciónY;

    }

    public  Vector2D() {
        this.posiciónX = 0;
        this.posiciónY = 0;
    }

    public double getPosiciónX() {
        return posiciónX;
    }
    public double getPosiciónY() {
        return posiciónY;
    }

    public void setPosiciónX(double posiciónX) {
        this.posiciónX = posiciónX;
    }

    public void setPosiciónY(double posiciónY) {
        this.posiciónY = posiciónY;
    }
}
