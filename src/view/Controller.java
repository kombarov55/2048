package view;

import model.Direction;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Controller {
    private Game game;
    private MainFrame mainFrame;
    private final Map<Integer, Color> COLORS = new HashMap<>();
    model.Canvas canvas;


    {
        COLORS.put(0, Color.WHITE);
        COLORS.put(2, Color.WHITE);
        COLORS.put(4, Color.GRAY);
        COLORS.put(8, Color.RED);
        COLORS.put(16, Color.ORANGE);
        COLORS.put(32, Color.GREEN);
        COLORS.put(64, Color.CYAN);
        COLORS.put(128, Color.DARK_GRAY);
        COLORS.put(256, Color.MAGENTA);
        COLORS.put(512, Color.CYAN);
        COLORS.put(1024, Color.PINK);
    }

    public void sendCommand(int keyEvent) {
        game.doAction(keyEvent);
        if (game.isActionPreformed()) game.spawn();
        refresh();
    }


    public boolean isGameOver() {
        return game.isGameOver();
    }


    public void refresh() {
        IntStream.range(0, 16).forEach(i -> {
            int code = canvas.getPoint(i % 4, i / 4);
            mainFrame.updateCell(i, COLORS.get(code), codeToString(code));
        });
    }

    private String codeToString(int code) {
        return code == 0 ? "" : String.valueOf(code);
    }


    public void setUI(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        mainFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (Direction.isValid(code))
                    sendCommand(e.getKeyCode());
            }
        });
        refresh();
    }

    private void animateButton(final JButton button) {
        new Thread() {

            public void run() {
                try {
                    button.setFont(new Font("Arial", Font.PLAIN, 16));
                    Thread.sleep(100);
                    button.setFont(new Font("Arial", Font.PLAIN, 20));
                    Thread.sleep(100);
                    button.setFont(new Font("Arial", Font.PLAIN, 18));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    button.setFont(new Font("Arial", Font.PLAIN, 18));
                }
            }
        }.start();
    }

    //Поток спит и ожидает пробуждения от нажатия кнопки. затем отправляет как результат
    //значение кнопки и будит контроллер. контроллер обрабатывает результат и создаёт новый такой поток


    Thread t = new Thread() {


        public void run() {

        }

    };

    public void setGame(Game game) {
        this.game = game;
        canvas = game.getCanvas();
    }

    public KeyAdapter getKeyAdapter() {
        return null;
    }


}
