package jp.ryunosora.worktimer.component.label;

import javax.swing.*;
import java.awt.*;

public class ClockLabel extends JLabel {

    public ClockLabel(){
        this.setSize(400, 100);
        this.setFont(new Font("Arial",Font.PLAIN,30));
    }

    public void updateText(int nowHour, int nowMinute, int nowSecond){
        this.setText(String.format("%02d",nowHour) + ":" + String.format("%02d",nowMinute) + ":" + String.format("%02d",nowSecond));
    }
}
