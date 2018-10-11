package StateMachine;

/**
 * Created by tranpham on 8/9/17.
 */
public class Fan {
    State currentState;

    public Fan() {
        this.currentState = new OffState(this);
    }

    public void pull(){
        currentState.pull();
    }

    public void setCurrentState(State state){
        currentState=state;
    }
}
