package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape{


    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);

    }


    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }


    // EFFECTS: draws this Shape on the SimpleDrawingPlayer, if the shape is selected, Shape is filled in
    //          else, Shape is unfilled (white)
    @Override
    public void draw(Graphics g) {
        Color save = g.getColor();
        if (selected) {
            g.setColor(PLAYING_COLOR);
        } else {
            g.setColor(Color.white);
        }
        fillGraphics(g);
        g.setColor(save);
        drawGraphics(g);

        if (playLineCoord > 0 && playLineCoord < width) {
            g.setColor(Color.red);
            g.drawLine(x + playLineCoord, y, x + playLineCoord, y + height);
            g.setColor(save);
        }
    }



    private void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }


    private void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}
