/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.command;

import model.Canvas;

/**
 *
 * @author nikolaykombarov
 */
public class DownCommand extends AbstractCommand {
    
    DownCommand(Canvas canvas) {
        super(canvas);
    }
    
    @Override
    public void execute() {

        for (int i = 0; i < 4; i++) {
            int[] line = canvas.getColumn(i);
            
            line = reverseLine(line);
            shift(line);
            line = reverseLine(line);
            
            canvas.setColumn(line, i);
        }
    }
    
}
