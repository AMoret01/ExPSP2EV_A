package es.florida;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;



public class App {
    public static final int PORT = 9876;

    public static void main(String[] args) throws IOException {

        DronController controller = new DronController();

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(PORT));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        controller.takeOff();
        esperar(1);
        controller.land();
        esperar(1);
        controller.firePrimaryCannon();
        esperar(1);
        controller.fireSecondaryWeapon();
        controller.shutDown();
        //String line;

        //while ((line = reader.readLine()) != null) {
           // controller.takeOff();
           // esperar(1);
           // controller.land();
            //esperar(1);
            //controller.firePrimaryCannon();
            //esperar(1);
            //controller.fireSecondaryWeapon();
            //controller.shutDown();
        //};
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    };
}
