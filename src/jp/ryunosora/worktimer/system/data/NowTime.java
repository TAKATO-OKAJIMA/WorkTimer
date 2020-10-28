package jp.ryunosora.worktimer.system.data;

public class NowTime {

    private int nowHour = 0;
    private int nowMinute = 0;
    private int nowSecond = 0;

    private boolean onZero = true;

    private WorkTime workTime;
    private BreakTime breakTime;

    public NowTime(){

    }

    public NowTime(WorkTime workTime,BreakTime breakTime){
        this.workTime = workTime;
        this.breakTime = breakTime;
    }

    public void setNextTime(boolean onWork){
        this.toggleOnZero();
        if(onWork){
            this.setNextWorkTime();
        }
        else {
            this.setNextBreakTime();
        }
    }

    private void setNextWorkTime(){
        this.nowHour = this.workTime.getWorkHour();
        this.nowMinute = this.workTime.getWorkMinute();
        this.nowSecond = this.workTime.getWorkSecond();
    }

    private void setNextBreakTime(){
        this.nowHour = this.breakTime.getBreakHour();
        this.nowMinute = this.breakTime.getBreakMinute();
        this.nowSecond = this.breakTime.getBreakSecond();
    }

    public void countNowTime(){
        this.countSecond();
    }

    private void countSecond(){
        if(this.nowSecond == 0) {
            if (this.nowMinute > 0 || this.nowHour > 0) {
                this.nowSecond = 59;
                this.countMinute();
            }
            /*
            else if (this.nowMinute < 1 && this.nowHour < 1){
                this.toggleOnZero();
                /*
                this.toggleOnWork();
                this.setNextTime();
                */
        }
        else{
            this.nowSecond--;

            if(this.nowSecond == 0 && this.nowMinute == 0 && this.nowHour == 0){
                this.toggleOnZero();
            }
        }
    }

    private void countMinute(){
        if(this.nowMinute == 0){
            if(this.nowHour > 0) {
                this.nowMinute = 59;
                this.countHour();
            }
        }
        else {
            this.nowMinute--;
        }
    }

    private void countHour(){
        if(this.nowHour > 0) {
            this.nowHour--;
        }
    }

    public void toggleOnZero(){
        if(this.onZero){
            this.onZero = false;
        }
        else {
            this.onZero = true;
        }
    }

    public int getNowHour() {
        return this.nowHour;
    }

    public int getNowMinute(){
        return this.nowMinute;
    }

    public int getNowSecond(){
        return this.nowSecond;
    }

    public boolean isOnZero() {
        return this.onZero;
    }
}
