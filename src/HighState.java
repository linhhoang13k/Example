package StateMachine;

/**
 * Created by tranpham on 8/9/17.
 */
public class HighState implements State {

    Fan fan;

    public HighState(Fan fan) {
        this.fan = fan;
    }

    public void pull() {
        System.out.println("Current State is Off");
        fan.setCurrentState(new OffState(fan));
    }
}
