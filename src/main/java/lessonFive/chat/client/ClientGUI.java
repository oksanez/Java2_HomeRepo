package main.java.lessonFive.chat.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClientGUI extends JFrame implements ActionListener, UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextArea log;
    private final JPanel panelTop;
    private final JTextField tfIPAddress;
    private final JTextField tfPort;
    private final JCheckBox cbAlwaysOnTop;
    private final JTextField tfLogin;
    private final JPasswordField tfPassword;
    private final JButton btnLogin;
    private final JPanel panelBottom;
    private final JButton btnDisconnect;
    private final JTextField tfMessage;
    private final JButton btnSend;
    private final JList<String> userList;
    private boolean shownIoErrors;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI();
            }
        });
    }

    private ClientGUI() {
        this.log = new JTextArea();
        this.panelTop = new JPanel(new GridLayout(2, 3));
        this.tfIPAddress = new JTextField("127.0.0.1");
        this.tfPort = new JTextField("8189");
        this.cbAlwaysOnTop = new JCheckBox("Alwayson top");
        this.tfLogin = new JTextField("ivan");
        this.tfPassword = new JPasswordField("123");
        this.btnLogin = new JButton("Login");
        this.panelBottom = new JPanel(new BorderLayout());
        this.btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
        this.tfMessage = new JTextField();
        this.btnSend = new JButton("Send");
        this.userList = new JList();
        this.shownIoErrors = false;
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setSize(400, 300);
        this.setTitle("Chat Client");
        this.log.setEditable(false);
        this.log.setLineWrap(true);
        JScrollPane scrollLog = new JScrollPane(this.log);
        JScrollPane scrollUsers = new JScrollPane(this.userList);
        String[] users = new String[]{"user1_with_an_exceptionally_long_nickname", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9", "user10"};
        this.userList.setListData(users);
        scrollUsers.setPreferredSize(new Dimension(100, 0));
        this.cbAlwaysOnTop.addActionListener(this);
        this.btnLogin.addActionListener(this);
        this.btnSend.addActionListener(this);
        this.tfMessage.addActionListener(this);
        this.panelTop.add(this.tfIPAddress);
        this.panelTop.add(this.tfPort);
        this.panelTop.add(this.cbAlwaysOnTop);
        this.panelTop.add(this.tfLogin);
        this.panelTop.add(this.tfPassword);
        this.panelTop.add(this.btnLogin);
        this.panelBottom.add(this.btnDisconnect, "West");
        this.panelBottom.add(this.tfMessage, "Center");
        this.panelBottom.add(this.btnSend, "East");
        this.add(this.panelTop, "North");
        this.add(scrollLog, "Center");
        this.add(this.panelBottom, "South");
        this.add(scrollUsers, "East");
        this.setVisible(true);
    }

    public void uncaughtException(Thread t, Throwable e) {
        this.showException(t, e);
        System.exit(1);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == this.cbAlwaysOnTop) {
            this.setAlwaysOnTop(this.cbAlwaysOnTop.isSelected());
        } else {
            if (src != this.btnSend && src != this.tfMessage) {
                throw new RuntimeException("Unknown source: " + src);
            }

            this.sendMessage();
        }

    }

    private void sendMessage() {
        String msg = this.tfMessage.getText();
        String username = this.tfLogin.getText();
        if (!"".equals(msg)) {
            this.tfMessage.setText((String)null);
            this.tfMessage.requestFocusInWindow();
            this.putLog(String.format("%s: %s", username, msg));
            this.wrtMsgToLogFile(msg, username);
        }
    }

    private void wrtMsgToLogFile(String msg, String username) {
        try {
            FileWriter out = new FileWriter("log.txt", true);
            Throwable var4 = null;

            try {
                out.write(username + ": " + msg + "\n");
                out.flush();
            } catch (Throwable var14) {
                var4 = var14;
                throw var14;
            } finally {
                if (out != null) {
                    if (var4 != null) {
                        try {
                            out.close();
                        } catch (Throwable var13) {
                            var4.addSuppressed(var13);
                        }
                    } else {
                        out.close();
                    }
                }

            }
        } catch (IOException var16) {
            if (!this.shownIoErrors) {
                this.shownIoErrors = true;
                this.showException(Thread.currentThread(), var16);
            }
        }

    }

    private void putLog(final String msg) {
        if (!"".equals(msg)) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ClientGUI.this.log.append(msg + "\n");
                    ClientGUI.this.log.setCaretPosition(ClientGUI.this.log.getDocument().getLength());
                }
            });
        }
    }

    private void showException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] ste = e.getStackTrace();
        String msg = String.format("Exception in thread %s: %s: %s\n\t at %s", t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog((Component)null, msg, "Exception", 0);
    }
}

