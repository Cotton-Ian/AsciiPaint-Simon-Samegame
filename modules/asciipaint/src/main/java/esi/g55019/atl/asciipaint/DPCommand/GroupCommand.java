package esi.g55019.atl.asciipaint.DPCommand;

import esi.g55019.atl.asciipaint.AsciiPaint;
import esi.g55019.atl.asciipaint.DPComposite.Component;
import esi.g55019.atl.asciipaint.DPComposite.Composite;
import java.util.List;

/**
 * Command to create a group
 * @author Ian Cotton
 */
public class GroupCommand implements Command{
    private AsciiPaint paint;
    int[] commandes;

    /**
     * constructor
     * @param asciiPaint AsciiPaint
     * @param commandes int[]
     */
    public GroupCommand(AsciiPaint asciiPaint, int[] commandes) {
        this.commandes = commandes;
        paint = asciiPaint;
    }

    /**
     * create a new group
     */
    @Override
    public void execute() {
        paint.newGroup(commandes);
    }

    /**
     * ungroup the last group created
     */
    @Override
    public void unexecute() {
        int index = paint.nbForme() -1;
        Component groupe = paint.getShapeAt(index);
        List<Component> list = ((Composite) groupe).getChildren();
        for (int i = 0; i < list.size(); i++) {
            paint.addCompenent(list.get(i));
        }
        paint.removeShape(groupe);
    }

    @Override
    public boolean isReversible() {
        return true;
    }
}
