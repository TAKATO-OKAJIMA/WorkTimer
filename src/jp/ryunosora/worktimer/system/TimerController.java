package jp.ryunosora.worktimer.system;

import jp.ryunosora.worktimer.system.data.BreakTime;
import jp.ryunosora.worktimer.system.data.NowTime;
import jp.ryunosora.worktimer.system.data.WorkTime;
import jp.ryunosora.worktimer.system.module.AlarmModule;
import jp.ryunosora.worktimer.system.module.TimerModule;

import javax.swing.Timer;
import java.util.ArrayList;

public class TimerController {

    private ArrayList<Timer> timerList = new ArrayList<Timer>();

    private WorkTime workTime = new WorkTime();
    private BreakTime breakTime = new BreakTime();
    private NowTime nowTime = new NowTime(workTime, breakTime);

    private AlarmModule alarmModule = new AlarmModule();
    private TimerModule timerModule = new TimerModule(this.nowTime, this.alarmModule);

    public TimerController(){
        this.addDefaultTimer();
    }

    public  TimerController(Timer timer){
        this.addDefaultTimer();
        this.addTimerList(timer);
    }

    public void addTimerList(Timer timer){
        this.timerList.add(timer);
    }

    public void allTimerStart(){
        for(Timer timer: this.timerList){
            timer.start();
        }
    }

    public void allTimerStop(){
        for(Timer timer: this.timerList){
            timer.stop();
        }
    }

    private void addDefaultTimer(){
        this.addTimerList(this.timerModule.getTimer());
    }

    public NowTime getNowTime(){
        return this.nowTime;
    }

    public TimerModule getTimerModule(){
        return this.timerModule;
    }
}
