package jp.ryunosora.worktimer.component.panel;

import jp.ryunosora.worktimer.component.button.StartButton;
import jp.ryunosora.worktimer.component.button.StopButton;
import jp.ryunosora.worktimer.system.TimerController;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;

public class ControlPanel extends JPanel {

    public ControlPanel(TimerController timerController){
        this.setSize(400,40);
        StartButton startButton = new StartButton(timerController);
        //startButton.setAlignmentY(0.5f);
        StopButton stopButton = new StopButton(timerController);
        //stopButton.setAlignmentY(0.5f);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(startButton);
        this.add(Box.createRigidArea(new Dimension(30, 1)));
        this.add(stopButton);
    }
}
