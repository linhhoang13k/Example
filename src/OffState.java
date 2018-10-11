package StateMachine;

/**
 * Created by tranpham on 8/9/17.
 */
public class OffState implements State{

    Fan fan;

    public OffState(Fan fan) {
        this.fan = fan;
    }

    public OffState() {
    }

    public void pull() {
        fan.setCurrentState(new LowState(fan));
        System.out.println("Current State is Low");
    }

    public void pull2(Fan fan2) {
        fan2.setCurrentState(new LowState());
        System.out.println("Current State is Low");
    }
}
