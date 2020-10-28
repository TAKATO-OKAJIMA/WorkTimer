package jp.ryunosora.worktimer.component.panel;

import jp.ryunosora.worktimer.component.label.StateLabel;
import jp.ryunosora.worktimer.component.label.StateLogo;
import jp.ryunosora.worktimer.system.TimerController;
import jp.ryunosora.worktimer.system.module.TimerModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatePanel extends JPanel implements ActionListener {

     private Timer timer = new Timer(1000, this);
     private StateLabel stateLabel = new StateLabel();
     private StateLogo stateLogo = new StateLogo();

     private TimerController timerController;

     public StatePanel(TimerController timerController){
         this.timerController = timerController;
         //this.setSize(400, 40);
         this.setLayout(new FlowLayout(FlowLayout.LEFT));

         this.add(Box.createRigidArea(new Dimension(2,1)));
         this.add(stateLogo);
         this.add(this.stateLabel);

         this.updateComponent();
         this.timer.start();
     }

     private void updateComponent(){
         this.stateLabel.updateLabel(this.timerController.getTimerModule().isOnWork(),this.timerController.getNowTime().getNowSecond());
         this.stateLogo.updateIcon(this.timerController.getTimerModule().isOnWork());
     }

    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.updateComponent();
     }
}
