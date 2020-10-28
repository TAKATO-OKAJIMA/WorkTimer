package jp.ryunosora.worktimer.component.label;

import javax.swing.*;
import java.awt.*;

public class StateLabel extends JLabel {

    public StateLabel(){
        this.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    public void updateLabel(boolean onWork,int seconds){
        String state = null;

        if(onWork){
            state = "Working";
        }
        else {
            state = "Breaking";
        }

        for(int i = 0; i < 3 - seconds % 4; i++){
            state = state + ".";
        }

        this.setText(state);
    }
}
