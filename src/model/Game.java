package model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import view.command.CommandExecutor;
import view.command.CommandI;

import java.util.List;
import java.util.function.Function;

/**
 *
 * @author nikolaykombarov
 * 
 * 
 */
public class Game {
    private boolean isGameOver = false;
    private Canvas canvas;
    private static boolean actionPreformed;
    private CommandExecutor executor;
    
    
    public Game() {
        canvas = new Canvas();
        executor = new CommandExecutor(canvas);
    }
    
    //TODO: при amount == 16 сделать проверку, можно ли сделать ещё один ход, вертикальную и горизонтальную 
    public boolean isGameOver() {
        if (canvas.getAmount() != 16) 
            return false;
        
        return true;
    }




    /*
        
    */
    
    public void doAction(int keyEvent) {
        executor.execute(keyEvent);

    }
    /**
    *                           
    *3 раза 
    *Итерируем вправо пока не найдём клетку не равную нулю или не выйдем за границы.
    *Если не нашли, то continue
    *суммируем
    */

    
    public Canvas getCanvas() {
        return canvas;
    }

    
    public void spawn() {
        canvas.setRandomPoint();
    }

    
    public boolean isActionPreformed() {
        return executor.wasActionPreformed;
    }
    
    
    public interface gameCallback {
        List<Cell> apply(Direction direction);
    }

}
