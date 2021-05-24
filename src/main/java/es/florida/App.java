package es.florida;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
    public static final int SERVER_PORT = 6789;

    public static void main(String[] args) throws IOException {

        //DronController controller = new DronController();
        //Socket dronSocket = controller.connect();

        //controller.takeOff();
        //esperar(1);
        //controller.land();
        //esperar(1);
        //controller.firePrimaryCannon();
        //esperar(1);
        //controller.fireSecondaryWeapon();
        //controller.shutDown();

        //dronSocket.close();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket server = new ServerSocket(SERVER_PORT);
        Socket clientConnection;
        while (true) {
            clientConnection = server.accept();
            System.out.println("Client connected to port "+ clientConnection.getPort());
            executorService.execute(new ENEMY_SPOTTED(clientConnection));
        }
    }
    private static class ENEMY_SPOTTED implements Runnable {

        private Socket connection;

        public ENEMY_SPOTTED(Socket clientConnection) {
            this.connection = clientConnection;
        }

        @Override
        public void run() {
            System.out.println("HA LLEGADO EL COMANDO");
            System.out.println("Cliente escuchando en "+ Thread.currentThread().getName());
        }
    }

    //public static void esperar(int segundos){
        //try {
            //Thread.sleep(segundos * 1000);
        //} catch (Exception e) {
            //System.out.println(e);
        //}
    //};


}
