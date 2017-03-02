package com.server.socket;

/**
 * Created by Igor on 27.02.2017.
 */

import java.util.ArrayList;
import java.util.List;


public class AbstractState implements State {
    protected final static String OK = "+OK ";

    protected final static String ERR = "-ERR ";
    protected final static String CRLF = "\r\n";

    // The valid commands in this state
    protected final List<String> validCommands = new ArrayList<String>();

    public AbstractState() {
        addValidCommand("quit");
    }

    public void addValidCommand(String command) {
        this.validCommands.add(command.toLowerCase());
    }


    @Override
    public String parseCommand(StateOption stateOption, String command) {
        return null;
    }


}
