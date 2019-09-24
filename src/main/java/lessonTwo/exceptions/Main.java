package main.java.lessonTwo.exceptions;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public Main() {
    }

    private static float methodA(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("This if an error on our terms");
        } else {
            return (float)(a / b);
        }
    }

    private static void methodIOE() {
        try {
            throw new IOException("Evil Exception");
        } catch (IOException var1) {
            System.out.println(var1.getMessage());
        }
    }

    private static void methodB() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        try {
            Main.TestStream in = new Main.TestStream();
            Throwable var2 = null;

            try {
                in.open();
                in.read();
            } catch (Throwable var13) {
                var2 = var13;
                throw var13;
            } finally {
                if (in != null) {
                    if (var2 != null) {
                        try {
                            in.close();
                        } catch (Throwable var12) {
                            var2.addSuppressed(var12);
                        }
                    } else {
                        in.close();
                    }
                }

            }

        } catch (FileNotFoundException | ClassNotFoundException var15) {
            throw new RuntimeException("Cannot instantiate a stream");
        } catch (IOException var16) {
            throw new RuntimeException("ReadExc");
        }
    }

    static class TestStream implements Closeable {
        TestStream() throws ClassNotFoundException {
            System.out.println("Init myself");
        }

        void open() throws FileNotFoundException {
            System.out.println("I open a file");
        }

        void read() throws IOException {
            throw new IOException("read");
        }

        public void close() throws IOException {
            throw new IOException("Close exception");
        }
    }
}
