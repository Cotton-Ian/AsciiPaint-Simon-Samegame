package td01;

public class Rectangle {
    private Point bl; //bottom left corner
    private Point ur; //upper right corner

    public Rectangle(Point bottomLeft, Point upperRight){
        if(bottomLeft.getX() >= upperRight.getX() || bottomLeft.getY() >= upperRight.getY()){
            throw new IllegalArgumentException("bottomLeft must be below and on the left of upperRight" +", received (bottomLeft - upperRight): " +bottomLeft+"-"+upperRight);
        }
        this.bl = new Point(bottomLeft.getX(), bottomLeft.getY());
        this.ur = new Point(upperRight.getX(), upperRight.getY());
    }

    public void move(double dx, double dy){
        bl.move(dx, dy);
        ur.move(dx,dy);
    }

    public double getPerimenter(){
        return 2*((ur.getX()-bl.getX())+(ur.getY()-bl.getY()));
    }

    @Override
    public String toString(){
        return "Rectangle : ["+bl+", "+ur+"]";
    }

}

class TestRectangle{
    public static void main(String[] args) {
        Point bl = new Point(0,0);
        Point ur = new Point(5,3);
        Rectangle r = new Rectangle(bl,ur);
        bl.move(10,10);
        System.out.println(r);
        System.out.println("Périmètre : " + r.getPerimenter());
        r.move(2,5);
        System.out.println(r);
        System.out.println("Périmètre :" + r.getPerimenter());
    }
}
