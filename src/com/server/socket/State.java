package com.server.socket;



/**
 * Created by Igor on 23.02.2017.
 */
public interface State {
    public String parseCommand(StateOption stateOption, String command);

}
