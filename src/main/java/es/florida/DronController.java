package es.florida;


import javax.sound.sampled.Port;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.Socket;
public class DronController {

    public static final int PORT = 9876;
    private PrintWriter _printer = null;
    public Socket connect() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", PORT));

        OutputStream output = socket.getOutputStream();
        _printer = new PrintWriter(new OutputStreamWriter(output));
        return socket;
    }

    public void takeOff() {
        System.out.println("Taking off...");
        _printer.println("TAKE-OFF");
    }

    public void land() {
        System.out.println("Landing");
        _printer.println("LAND");
    }

    public void firePrimaryCannon() {
        System.out.println("Ratatatatatatata!");
        _printer.println("FIRE_P_W");
    }

    public void fireSecondaryWeapon() {
        System.out.println("Piñau! Piñau!");
        _printer.println("FIRE_S_W");
    }

    public void shutDown() {
        System.out.println("Shutting down system...");
        _printer.println("OFF");
    }

}
