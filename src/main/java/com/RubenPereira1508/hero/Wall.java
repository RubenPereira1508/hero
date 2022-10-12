package com.RubenPereira1508.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    //Position position;

    public Wall (int x, int y){
        super(x,y);
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){this.position=position;}



    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }


}
