package com.server.socket;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Igor on 22.02.2017.
 */
public class StateAuthorization extends AbstractState implements State {
    private String userName = null;
    private String password = null;


    // Since we are allowed to hardcode password, doing this initially
    // TODO implement a better password checking routine
    private final Map<String, String> validUsers = new HashMap<String, String>();

    // Set flag to hold decision about user validity
    private Boolean validUser = false;

    // The total and max number of times user attempted to login
    private int attempts = 0;
    private final int maxAttempts = 3;

    public StateAuthorization() {
        addValidCommand("auth");
        addValidCommand("user");
        addValidCommand("pass");


        this.validUsers.put("ihar.yermachonak@gmail.com", "5win3se7enrus2");
        this.validUsers.put("igor@mail.local", "199661");

    }


    @Override
    public String parseCommand(StateOption stateContext, String command) {
        // delims are the fields delimeters used in parsing commands
        final String delims = "[ ]+";
        String response = "";
        String[] tokens = null;

        // Ignore commands that contain nothing
        if (!command.isEmpty()) {
            tokens = command.split(delims);
        }

        if (tokens.length > 0) {
            if (validCommands.contains(tokens[0].toLowerCase())) {
                String s = tokens[0].toLowerCase();
                if (s.equals("user")) {
                    setUsername(tokens);
                    if (this.userName.isEmpty()) {
                        response = ERR + "Username was not sent" + CRLF;
                    } else {
                        response = OK + this.userName + CRLF;
                    }
                } else if (s.equals("pass")) {
                    setPassword(tokens);
                    if (!this.password.isEmpty()) {
                        setValidUser();
                        if (this.validUser) {
                            response = OK + "Welcome " + this.userName + CRLF;
                        } else {
                            attempts++;
                            response = ERR + "Invalid username/password combination " + Integer.toString(maxAttempts - attempts) + " attempts left" + CRLF;
                        }
                    } else {
                        response = ERR + "Must send password" + CRLF;
                    }
                } else if (s.equals("quit")) {
                    response = OK + "Server closing connection" + CRLF;
                    endAuthorization(stateContext);
                } else {
                    response = ERR + "Unknown command" + CRLF;
                }
            }
        }
        return response;
    }


    private void setUsername(String[] tokens) {
        if (tokens.length >= 2) {
            this.userName = tokens[1];
        }
    }

    private void setPassword(String[] tokens) {
        this.password = "";
        if (tokens.length >= 2) {
            for (int i = 1; i < tokens.length; i++) {
                this.password += tokens[i];
            }
        }
    }

    private void setValidUser() {
        if (validUsers.containsKey(this.userName)) {
            if (validUsers.get(this.userName).equals(this.password)) {
                this.validUser = true;
            }
        }
    }

    private void endAuthorization(StateOption stateOption) {
        stateOption.setRunnable(false);
    }
}
