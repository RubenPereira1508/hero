package com.RubenPereira1508.hero;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Screen screen;
    //Position position=new Position(10,10);
    //Hero hero;
    Arena arena;

    Game(int width, int height) {
        //hero = new Hero(position);
        arena=new Arena(width,height);
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            //TerminalSize terminalSize=new TerminalSize(40,20);
            //DefaultTerminalFactory terminalFactory=new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            //Terminal terminal1 =terminalFactory.createTerminal();

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        arena.draw1(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType()== KeyType.Character && key.getCharacter()=='q') {screen.close();}
            if (key.getKeyType()==KeyType.EOF){ break;}
        }
    }
   /* public static void main(String[] args) throws IOException {
     Game game=new Game();
     game.run();
    }*/

    private void processKey (com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        arena.processKey(key);
    }

    /*private void moveHero(Position position) {
        hero.setPosition(position);
    }
*/
   /* private void processKey (com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        //System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default: break;
        }
    }*/


}
