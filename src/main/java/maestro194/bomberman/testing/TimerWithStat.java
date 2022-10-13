package maestro194.bomberman.testing;

import javafx.animation.AnimationTimer;

public abstract class TimerWithStat extends AnimationTimer {
    public enum Stat {
        RUNNING, PAUSED, STOPPED,
    }

    private Stat stat = Stat.STOPPED;

    @Override
    public void start() {
        super.start();
        stat = Stat.RUNNING;
    }

    @Override
    public void stop() {
        super.stop();
        stat = Stat.STOPPED;
    }

    public Stat getStat() {
        return stat;
    }
}