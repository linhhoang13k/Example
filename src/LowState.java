package StateMachine;

/**
 * Created by tranpham on 8/9/17.
 */
public class LowState implements State {

    Fan fan;

    public LowState(Fan fan) {
        this.fan = fan;
    }


    public LowState() {
    }

    public void pull() {
        System.out.println("Current State is Medium");
        fan.setCurrentState(new MediumState(fan));
    }

    public void pull2(Fan fan) {

    }
}
