package com.server.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Igor on 23.02.2017.
 */
public class GUIPop3Server extends JFrame {

    private TextArea textArea;

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }


    public GUIPop3Server() {
        this.setTitle("POP3Server");
        this.setSize(new Dimension(500, 300));
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        textArea = new TextArea();
        textArea.setSize(new Dimension(400, 250));
        this.getContentPane().add(textArea);
    }

}
