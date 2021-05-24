package es.florida;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class App {
    public static final int PORT = 9876;

    public static void main(String[] args) throws IOException {

        DronController controller = new DronController();
        Socket dronSocket = controller.connect();

        controller.takeOff();
        esperar(1);
        controller.land();
        esperar(1);
        controller.firePrimaryCannon();
        esperar(1);
        controller.fireSecondaryWeapon();
        controller.shutDown();

        dronSocket.close();


        //ServerSocket server = new ServerSocket(PORT);
        //Socket connection = server.accept();
        //InputStream input = connection.getInputStream();
        //OutputStream output = connection.getOutputStream();
        //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        //PrintWriter printer = new PrintWriter(new OutputStreamWriter(output));
        //controller.takeOff();
        //esperar(1);
        //controller.land();
        //esperar(1);
        //controller.firePrimaryCannon();
        //esperar(1);
        //controller.fireSecondaryWeapon();
        //controller.shutDown();
        //String line;
//
        //while ((line = reader.readLine()) != null) {
        //   System.out.println(line);
        //}
        //printer.println("Bienvenido...");
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    };
}
