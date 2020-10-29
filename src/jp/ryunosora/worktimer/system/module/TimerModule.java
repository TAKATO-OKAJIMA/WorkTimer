package jp.ryunosora.worktimer.system.module;


import jp.ryunosora.worktimer.system.models.NowTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerModule implements ActionListener {

    private boolean onWork = true;

    private Timer timer = new Timer(1000, this);

    private AlarmModule alarmModule;
    private NowTime nowTime;

    public TimerModule(NowTime nowTime, AlarmModule alarmModule){
        this.nowTime = nowTime;
        this.alarmModule = alarmModule;
        this.nowTime.setNextTime(this.onWork);
    }

    private void toggleOnWork(){
        if(this.onWork){
            this.onWork = false;
            //this.alarmModule.playBreakAlarm();
        }
        else{
            this.onWork = true;
            //this.alarmModule.playWorkAlarm();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!nowTime.isOnZero()){
            this.nowTime.countNowTime();
        }
        else {
            this.alarmModule.playWorkAlarm(this.onWork);
            this.toggleOnWork();
            this.nowTime.setNextTime(this.onWork);
        }
        //this.countSeconds();
        //System.out.println(this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds());
        //System.out.println(this.isOnWork());
    }

    public boolean isOnWork(){
        return this.onWork;
    }

    public Timer getTimer() {
        return this.timer;
    }
}
