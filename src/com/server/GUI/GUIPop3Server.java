package com.server.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Igor on 23.02.2017.
 */
public class GUIPop3Server {
    private JFrame mainFrame;
    private TextArea textArea;
    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }



    public GUIPop3Server(){
        mainFrame = new JFrame("POP3Server");
        mainFrame.setSize(new Dimension(500,300));
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        textArea = new TextArea();
        textArea.setSize(new Dimension(200,200));
        mainFrame.getContentPane().add(textArea);
    }

}
