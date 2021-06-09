package es.florida;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DronController {


    static final int PORT = 9876 ;

    public Socket connect() throws IOException {

        return new Socket("localhost", PORT);
    }
    //Si quiero que un comando se encripte tengo que poner true en el encrypt:
    public void takeOff() throws IOException, InterruptedException {
        System.out.println("Taking off...");
        App.enviarComandos("TAKE-OFF", true, true);
    }

    public void land() throws IOException, InterruptedException {
        System.out.println("Landing");
        App.enviarComandos("LAND", true, true);
    }

    public void firePrimaryCannon() throws IOException, InterruptedException {
        System.out.println("Ratatatatatatata!");
        App.enviarComandos("FIRE_P_W", true, true);
    }

    public void fireSecondaryWeapon() throws IOException, InterruptedException {
        System.out.println("Piñau! Piñau!");
        App.enviarComandos("FIRE_S_W", true, true);
    }

    public void shutDown() throws IOException, InterruptedException {
        System.out.println("Shutting down system...");
        App.enviarComandos("OFF", true, true);
    }

}
