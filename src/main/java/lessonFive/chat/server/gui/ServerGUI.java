package main.java.lessonFive.chat.server.gui;

import main.java.lessonFive.chat.server.core.ChatServer;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.UncaughtExceptionHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ServerGUI extends JFrame implements ActionListener, UncaughtExceptionHandler {
    private static final int POS_X = 1000;
    private static final int POS_Y = 550;
    private static final int HEIGHT = 100;
    private static final int WIDTH = 200;
    private final ChatServer chatServer;
    private final JButton btnStart;
    private final JButton btnStop;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ServerGUI();
            }
        });
    }

    private ServerGUI() {
        this.chatServer = new ChatServer();
        this.btnStart = new JButton("Start");
        this.btnStop = new JButton("Stop");
        this.setDefaultCloseOperation(3);
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.setBounds(1000, 550, 200, 100);
        this.setTitle("Server GUI");
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLayout(new GridLayout(1, 2));
        this.btnStop.addActionListener(this);
        this.btnStart.addActionListener(this);
        this.add(this.btnStart);
        this.add(this.btnStop);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == this.btnStart) {
            this.chatServer.start(8189);
        } else {
            if (src != this.btnStop) {
                throw new RuntimeException("Unknown source: " + src);
            }

            this.chatServer.stop();
        }

    }

    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] ste = e.getStackTrace();
        String msg = String.format("Exception in thread %s: %s: %s\n\t at %s", t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog((Component)null, msg, "Exception", 0);
    }
}
