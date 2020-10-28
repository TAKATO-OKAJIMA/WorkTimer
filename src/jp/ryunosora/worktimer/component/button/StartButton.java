package jp.ryunosora.worktimer.component.button;

import jp.ryunosora.worktimer.system.TimerController;

import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {

    private TimerController timerController;

    public StartButton(TimerController timerController){
        this.timerController = timerController;
        this.addActionListener(this);
        this.setText("Start");
        this.setSize(30,10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timerController.allTimerStart();
    }
}
