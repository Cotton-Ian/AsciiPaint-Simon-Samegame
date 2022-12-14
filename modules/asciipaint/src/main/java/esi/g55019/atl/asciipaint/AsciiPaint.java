package esi.g55019.atl.asciipaint;

import esi.g55019.atl.asciipaint.DPComposite.Component;
import esi.g55019.atl.asciipaint.DPComposite.Composite;
import esi.g55019.atl.asciipaint.DPComposite.Leaf;
import esi.g55019.atl.asciipaint.ShapePackage.Circle;
import esi.g55019.atl.asciipaint.ShapePackage.Line;
import esi.g55019.atl.asciipaint.ShapePackage.Rectangle;
import esi.g55019.atl.asciipaint.ShapePackage.Square;

/**
 * @author Cotton Ian g55019
 * This class has the methods allowing to add shapes to the drawings
 * as well as to return the drawing as a string
 * (No test for this class bc there is nothing to test)
 */

public class AsciiPaint {

    private Drawing drawing;
    private boolean end;

    /**
     * Constructor when you choose the dimension of the drawing
     * @param drawing Drawing
     */
    public AsciiPaint(Drawing drawing) {
        this.drawing = drawing;
        this.end = false;
    }

    /**
     * default constructor, the dimension of the drawing will be 50x50
     */
    public AsciiPaint() {
        drawing = new Drawing();
    }

    /**
     * add a circle to the drawing
     * @param x      int
     * @param y      int
     * @param radius double
     * @param color  char
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Leaf(new Circle(new Point(x, y), radius, color)));
    }

    /**
     * add a rectangle to the drawing
     * @param x      int
     * @param y      int
     * @param width  double
     * @param height double
     * @param color  char
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Leaf(new Rectangle(new Point(x, y), width, height, color)));
    }

    /**
     * add a square to the drawing
     * @param x     int
     * @param y     int
     * @param side  double
     * @param color char
     */
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Leaf(new Square(new Point(x, y), side, color)));
    }

    /**
     * add a line to the drawing
     * @param x1    int
     * @param y1    int
     * @param x2    int
     * @param y2    int
     * @param color char
     */
    public void newLine(int x1, int y1, int x2, int y2, char color){
        drawing.addShape(new Leaf(new Line(new Point(x1,y1), new Point(x2,y2), color)));
    }

    /**
     * create a group to the drawing, the param has the index of each Leaf/group to add in the group
     * First each Component will be added in the created group
     * Second each Compenent will be delete from the drawing
     * Third the group will be added to the drawing
     * @param commandes int[]
     */
    public void newGroup(int[] commandes){
        Composite groupe = new Composite();
        for (int i = 0; i < commandes.length; i++) {
            if(drawing.getShapeInList(commandes[i]) instanceof Leaf){
                groupe.add(new Leaf(drawing.getShapeInList(commandes[i])));
            }
            else{
                groupe.add(new Composite(drawing.getShapeInList(commandes[i])));
            }

        }
        for (int i = commandes.length -1; i >= 0; i--) {
            drawing.removeShape(drawing.getShapeInList(commandes[i]));
        }
        drawing.addShape(groupe);
    }

    /**
     * add a Leaf or a Composite to the drawing
     * @param composant
     */
    public void addCompenent(Component composant){
        drawing.addShape(composant);
    }

    /**
     * remove a Component from the drawing
     * @param compenent Component
     */
    public void removeShape(Component compenent){
        drawing.removeShape(compenent);
    }

    /**
     * Return the drawing
     * @return String as a string.
     */
    public String asAscii() {
        String monstring = "";
        for (int i = drawing.getHeight(); i >= 0; i--) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                if (drawing.getShapeAt(new Point(j, i)) != null) {
                    monstring += (" " + (drawing.getShapeAt(new Point(j, i)).getColor()) + " ");
                } else {
                    monstring += (" . ");
                }
            }
            monstring += ("\n");
        }

        return monstring;
    }

    /**
     * called the showlist method
     */
    public void showList(){
        drawing.showList();
    }

    /**
     * called the move method
     * @param numberOfTheShape  int
     * @param dx    int
     * @param dy    int
     */
    public void move(int numberOfTheShape, int dx, int dy){
        drawing.move(numberOfTheShape, dx, dy);
    }

    /**
     * return the number of component from the drawing
     * @return
     */
    public int nbForme(){
        return drawing.getSize();
    }

    /**
     * set the attribut end of asciipaint to end
     */
    public void end(){
        this.end = true;
    }

    /**
     * return the shape at the given index
     * @param index int
     * @return Component
     */
    public Component getShapeAt(int index){
        return drawing.getShapeInList(index);
    }

    /**
     * change the color of the Component at the given position
     * @param index int
     * @param color color
     */
    public void changeColor(int index, char color){
        drawing.changeColor(index, color);
    }

    /**
     * return the value of the end attribute
     * @return boolean
     */
    public boolean getEnd(){
        return end;
    }
}

