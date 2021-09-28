package asciipaint;

public class Point {

    private double x;
    private double y;

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point b){
        double distanceX = Math.pow(b.getX() - this.getX(),2);
        double distanceY = Math.pow(b.getY() - this.getY(),2);

        return Math.sqrt(distanceX + distanceY);
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }

}
