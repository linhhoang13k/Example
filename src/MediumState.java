package StateMachine;

/**
 * Created by tranpham on 8/9/17.
 */
public class MediumState implements State {

    Fan fan;

    public MediumState(Fan fan) {
        this.fan = fan;
    }

    public void pull() {
        System.out.println("Current State is High");
        fan.setCurrentState(new HighState(fan));
    }
}
