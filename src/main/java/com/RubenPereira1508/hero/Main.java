package com.RubenPereira1508.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TerminalSize terminalSize=new TerminalSize(40,20);
            DefaultTerminalFactory terminalFactory=new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal1 =terminalFactory.createTerminal();

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            screen.clear();
            screen.setCharacter(10,10, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}