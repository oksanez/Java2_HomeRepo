package main.java.lessonFour.online.server.core;

public class ChatServer {
    public ChatServer() {
    }

    public void start(int port) {
        System.out.println("Server started at port: " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    }
}
