package main.java.lessonFive.chat.network;

public class ServerSocketThread extends Thread {
    private final int port;

    public ServerSocketThread(String name, int port) {
        super(name);
        this.port = port;
        this.start();
    }

    public void run() {
        for(; !this.isInterrupted(); System.out.println("Server Socket Thread is working")) {
            try {
                sleep(3000L);
            } catch (InterruptedException var2) {
                this.interrupt();
                return;
            }
        }

    }
}
