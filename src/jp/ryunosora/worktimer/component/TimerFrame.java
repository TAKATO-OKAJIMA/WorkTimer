package jp.ryunosora.worktimer.component;

import jp.ryunosora.worktimer.component.panel.ClockPanel;
import jp.ryunosora.worktimer.component.panel.ControlPanel;
import jp.ryunosora.worktimer.component.panel.StatePanel;
import jp.ryunosora.worktimer.system.TimerController;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Dimension;

public class TimerFrame extends JFrame {


    private TimerController timerController = new TimerController();

    public TimerFrame(){
        this.setFrameProperty();
        //this.setIconImage(new ClockImage().getImage());
        StatePanel statePanel = new StatePanel(this.timerController);
        this.timerController.addTimerList(statePanel.getTimer());

        ClockPanel clockPanel = new ClockPanel(this.timerController);
        this.timerController.addTimerList(clockPanel.getTimer());

        ControlPanel controlPanel = new ControlPanel(timerController);

        this.getContentPane().add(statePanel);
        this.getContentPane().add(clockPanel);
        this.getContentPane().add(Box.createRigidArea(new Dimension(1,10)));
        this.getContentPane().add(controlPanel);
        this.getContentPane().add(Box.createRigidArea(new Dimension(1,10)));

        //this.timerModule.getTimer().start();
    }

    private void setFrameProperty(){
        this.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 180);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.setTitle("WorkTimer");
        this.setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("image/HoloGlassKAMOPIS.png")).getImage());
    }

    private void setLookAndFeel(String className){
        try {
            UIManager.setLookAndFeel(className);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
