package main.java.lessonFive.chat.server.core;

import main.java.lessonFive.chat.network.ServerSocketThread;

public class ChatServer {
    private ServerSocketThread server;

    public ChatServer() {
    }

    public void start(int port) {
        if (this.server != null && this.server.isAlive()) {
            System.out.println("Server is already running");
        } else {
            this.server = new ServerSocketThread("Server", port);
            System.out.println("Server thread started at port: " + port);
        }

    }

    public void stop() {
        if (this.server != null && this.server.isAlive()) {
            this.server.interrupt();
            System.out.println("Server interrupted");
        } else {
            System.out.println("Server is not running!");
        }

    }
}

