package jp.ryunosora.worktimer.component.button;

import jp.ryunosora.worktimer.system.TimerController;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopButton extends JButton implements ActionListener {

    private TimerController timerController;

    public StopButton(TimerController timerController){
        this.timerController = timerController;
        this.addActionListener(this);
        this.setText("Stop");
        this.setSize(30, 10);
        //this.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timerController.allTimerStop();
    }
}
