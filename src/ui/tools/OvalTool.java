package ui.tools;

import model.Oval;
import model.Rectangle;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool {

    private Shape shape;



    public OvalTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
        shape = null;
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    //EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "Oval";
    }

    // MODIFIES: this
    // EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
    //           added to the editor's drawing
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }




    // MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
    @Override
    public void mouseReleasedInDrawingArea(MouseEvent e) {
        shape.unselectAndStopPlaying();
        shape = null;
    }

    // MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
    @Override
    public void mouseDraggedInDrawingArea(MouseEvent e) {
        shape.setBounds(e.getPoint());
    }


    //EFFECTS: Constructs and returns the new shape
    private void makeShape(MouseEvent e) {
        shape = new Oval(e.getPoint(), editor.getMidiSynth());
    }

}
