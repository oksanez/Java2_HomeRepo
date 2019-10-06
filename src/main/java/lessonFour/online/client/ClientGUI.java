package main.java.lessonFour.online.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.lang.Thread.UncaughtExceptionHandler;
import javax.swing.*;

public class ClientGUI extends JFrame implements ActionListener, UncaughtExceptionHandler {

    private static final int WIN_WIDTH = 400;
    private static final int WIN_HEIGHT = 300;

    //Элементы (кнопки, чекбоксы, поля ввода и тд), которые есть на форме
    private final JTextArea log; //блок с отпарвленными сообщениями
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
        //заполняем дефолтными значениями форму
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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // полное закрытие приложения по нажатию на крестик
        Thread.setDefaultUncaughtExceptionHandler(this); // обработка runtime исключений
        this.setLocationRelativeTo((Component)null); //помещение фрейма в центр экрана (null)
        this.setSize(400, 300);
        this.setTitle("Chat client");
        this.setAlwaysOnTop(false); // если true то приложение всегда будет поверх любых окон
        JScrollPane scrollLog = new JScrollPane(this.log);
        JScrollPane scrollUsers = new JScrollPane(this.userList);
        this.log.setEditable(false); //поле log не редактируемое
        String[] users = new String[]{"user01", "user02", "user03", "user04", "user05", "user06", "user07", "user_with_a_very_long_name_in_the_chat"};
        this.userList.setListData(users);
        this.userList.setPreferredSize(new Dimension(100, 0));
        this.cbAlwaysOnTop.addActionListener(this);

        // Расположение элементов на форму в нужном блоке
        // Последовательность строк имеет значение
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

        // отправка сообщения по кнопке Send
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfMessage.getText().trim().isEmpty()){
                    addMsg();
                    tfMessage.grabFocus(); //после отправки сообщения оставляем курсор в поле
                    //записываем в файл весь лог
                    saveToFile(log);
                }
            }
        });

        // отправка сообщения по enter
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    addMsg();
                    tfMessage.setText("");
                    tfMessage.grabFocus(); //оставляем курсор в поле
                    //записываем в файл весь лог
                    saveToFile(log);
                }
            }
        });



        //очищаем поле ввода после отправки сообщения
        tfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfMessage.setText("");
            }
        });
    }

    public void actionPerformed(ActionEvent e) { //метод вызывается когда происходит действие
        Object src = e.getSource();
        if (src == this.cbAlwaysOnTop) {
            this.setAlwaysOnTop(this.cbAlwaysOnTop.isSelected());
        } else {
            throw new RuntimeException("Unknown source: " + src);
        }
    }

    public void uncaughtException(Thread t, Throwable e) { // Метод вызывается, когда данный поток завершается из-за данного необработанного исключения
        e.printStackTrace();
        StackTraceElement[] ste = e.getStackTrace();
        String msg = String.format("Exception in thread %s: %s: %s\n\t at %s", t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog((Component)null, msg, "Exception", 0);
    }

    // Метод отправки сообщения в log
    public void addMsg(){
        String msg = tfMessage.getText();
        log.append(msg);
        log.append("\n");
    }

    // Записываем в файл лог
    static void saveToFile(JTextArea log) {
        try (BufferedWriter fileOut = new BufferedWriter(new FileWriter("log.txt"))) {
            log.write(fileOut);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}

