package com.server.socket;

/**
 * Created by Igor on 22.02.2017.
 */
public class StateAuthorization implements  State {
    @Override
    public String parseCommand(StateOption stateOption, String command) {

        return command;
    }
}
