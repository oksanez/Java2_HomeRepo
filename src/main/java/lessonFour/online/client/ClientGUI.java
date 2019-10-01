package main.java.lessonFour.online.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private static final int WIN_WIDTH = 400;
    private static final int WIN_HEIGHT = 300;
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
        this.cbAlwaysOnTop = new JCheckBox("Always on top");
        this.tfLogin = new JTextField("ivan");
        this.tfPassword = new JPasswordField("123");
        this.btnLogin = new JButton("Login");
        this.panelBottom = new JPanel(new BorderLayout());
        this.btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
        this.tfMessage = new JTextField();
        this.btnSend = new JButton("Send");
        this.userList = new JList();
        this.setDefaultCloseOperation(3);
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.setLocationRelativeTo((Component)null);
        this.setSize(400, 300);
        this.setTitle("Chat client");
        this.setAlwaysOnTop(false);
        JScrollPane scrollLog = new JScrollPane(this.log);
        JScrollPane scrollUsers = new JScrollPane(this.userList);
        this.log.setEditable(false);
        String[] users = new String[]{"user01", "user02", "user03", "user04", "user05", "user06", "user07", "user_with_a_very_long_name_in_the_chat"};
        this.userList.setListData(users);
        this.userList.setPreferredSize(new Dimension(100, 0));
        this.cbAlwaysOnTop.addActionListener(this);
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
        this.add(this.panelBottom, "South");
        this.add(scrollLog, "Center");
        this.add(scrollUsers, "East");
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == this.cbAlwaysOnTop) {
            this.setAlwaysOnTop(this.cbAlwaysOnTop.isSelected());
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] ste = e.getStackTrace();
        String msg = String.format("Exception in thread %s: %s: %s\n\t at %s", t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog((Component)null, msg, "Exception", 0);
    }
}

