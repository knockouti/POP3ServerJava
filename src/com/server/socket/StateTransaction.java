package com.server.socket;

import java.io.BufferedReader;

/**
 * Created by Igor on 22.02.2017.
 */
public class StateTransaction extends AbstractState implements State {

    public StateTransaction(){
        addValidCommand("STAT");
        addValidCommand("LIST");
        addValidCommand("RETR");
        addValidCommand("DELE");
        addValidCommand("NOOP");
        addValidCommand("RSET");
    }

    @Override
    public String parseCommand(StateOption stateOption, String command) {

        return command;
    }

    private void endStateTransaction(StateOption stateOption) {
        stateOption.setRunnable(false);
    }

}
