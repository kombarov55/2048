package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyEventSender extends KeyAdapter {
    List<Controller> clients = new ArrayList<>();

    public KeyEventSender(Controller... controllers) {
        clients.addAll(Arrays.asList(controllers));
    }

    @Override public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_UP || code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_DOWN) {
            for (Controller x : clients) {
                x.sendCommand(code);
            }
        }
    }


}
