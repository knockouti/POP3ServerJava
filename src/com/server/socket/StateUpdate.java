package com.server.socket;

import javax.swing.*;
import java.io.BufferedReader;

/**
 * Created by Igor on 22.02.2017.
 */
public class StateUpdate extends AbstractState implements State {

    public StateUpdate(){
        addValidCommand("quit");
    }
    @Override
    public String parseCommand(StateOption stateOption, String command) {

        return command;
    }

    private void endStateUpdate(StateOption stateOption) {
        stateOption.setRunnable(false);
    }
}
