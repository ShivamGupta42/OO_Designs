package trafficLight;

public class TrafficSignal {
    State state;

    TrafficSignal(){
        initTrafficSignal();
    }

    private void initTrafficSignal() {
        State Red = new State(Color.RED,100);
        State Green = new State(Color.GREEN,100);
        State Yellow = new State(Color.YELLOW,20);

        Red.nextState=Green;
        Green.nextState=Yellow;
        Yellow.nextState=Red;

        this.state = Red;
    }

    public State getNextState(){
        return this.state.nextState;
    }

    public void SetNextState(){
        this.state = state.nextState;
    }
}
