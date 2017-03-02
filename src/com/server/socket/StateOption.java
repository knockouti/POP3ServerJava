package com.server.socket;

import java.io.BufferedReader;

/**
 * Created by Igor on 23.02.2017.
 */
public class StateOption {


    private State currentState;
    boolean runnable = true;

    public StateOption() {
        setState(new StateAuthorization());
    }

    public void setState(State newState) {
        this.currentState = newState;
    }


    public String parseCommand(String string) {

        return this.currentState.parseCommand(this, string);

    }

    public Boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(Boolean bool) {
        runnable = bool;
    }


}
