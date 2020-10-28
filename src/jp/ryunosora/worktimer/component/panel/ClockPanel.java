package jp.ryunosora.worktimer.component.panel;

import jp.ryunosora.worktimer.component.label.ClockLabel;
import jp.ryunosora.worktimer.system.TimerController;
import jp.ryunosora.worktimer.system.module.TimerModule;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockPanel extends JPanel implements ActionListener {

    private ClockLabel clockLabel;

    private Timer timer = new Timer(1000, this);

    private TimerController timerController;


    public ClockPanel(TimerController timerController){
        this.timerController = timerController;
        this.setSize(400,90);
        this.clockLabel = new ClockLabel();
        this.add(this.clockLabel);
        this.updateComponent();
        //this.timer.start();
    }

    private void updateComponent(){
        this.clockLabel.updateText(this.timerController.getNowTime().getNowHour(),this.timerController.getNowTime().getNowMinute(),this.timerController.getNowTime().getNowSecond());
    }

    public Timer getTimer(){
        return this.timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.updateComponent();
    }
}
