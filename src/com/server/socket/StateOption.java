package com.server.socket;

/**
 * Created by Igor on 23.02.2017.
 */
public class StateOption  {


    private State currentState;
    boolean runnable = true;
    public StateOption() {
        setState(new StateAuthorization());
    }

    public void setState(State newState) {
        this.currentState = newState;
    }


    public String parseCommand(String command) {
        return this.currentState.parseCommand(this, command);
    }

    public Boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(Boolean bool) {
        runnable = bool;
    }


}
