package view.command;

import model.Canvas;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private Map<Integer, CommandI> container = new HashMap<>();
    
    public boolean wasActionPreformed = false;
    
    public CommandExecutor(Canvas canvas) {
        container.put(KeyEvent.VK_RIGHT, new RightCommand(canvas));
        container.put(KeyEvent.VK_UP, new UpCommand(canvas));
        container.put(KeyEvent.VK_LEFT, new LeftCommand(canvas));
        container.put(KeyEvent.VK_DOWN, new DownCommand(canvas));
    }
    
    public void execute(int keyEvent) {
        AbstractCommand command = (AbstractCommand) container.get(keyEvent);
        command.wasActionPreformed = false;
        container.get(keyEvent).execute();
        wasActionPreformed = command.wasActionPreformed;
    }
}
