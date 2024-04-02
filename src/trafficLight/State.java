package trafficLight;

public class State {
    Color color;
    int duration;
    State nextState;

    State(Color color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public void setNextState(State state){
        this.nextState = state;
    }
}

