package com.server.socket;

import java.io.BufferedReader;

/**
 * Created by Igor on 22.02.2017.
 */
public class StateTransaction implements State {
    @Override
    public String parseCommand(StateOption stateOption, String command) {

        return command;
    }


}
