package es.florida;

import org.jasypt.util.text.StrongTextEncryptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class App {
    public static final  int Server_PORT = 6789;
    private static final String PASSW = "1234";
    private static Socket socket;
    private static final int threads = 2;


    public static void main(String[] args) throws IOException, InterruptedException {

        /*ExecutorService executorService = Executors.newFixedThreadPool(threads);
        ServerSocket server = new ServerSocket(Server_PORT);
        Socket clientConnection;

        while (true) {
            clientConnection = server.accept();
            System.out.println("Cliente conectado al puerto "+ clientConnection.getPort());
            executorService.execute(new ENEMY_SPOTED(clientConnection));
        }*/



        DronController controller = new DronController();
        socket = controller.connect();

        controller.takeOff();

        controller.land();

        controller.firePrimaryCannon();

        controller.fireSecondaryWeapon();
        controller.shutDown();

        socket.close();

    }


    /*private static class ENEMY_SPOTED implements Runnable {

        Socket connection;

    public ENEMY_SPOTED(Socket clientConnection) {
    this.connection = clientConnection;
    }

    @Override
    public void run() {
    System.out.println("El comando ha llegado");
    System.out.println("Cliente activo "+ Thread.currentThread().getName());
    }
    }*/
    public static void enviarComandos(String comando, boolean wait, boolean encrypt) throws InterruptedException, IOException {
        OutputStream output = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(new OutputStreamWriter(output));
        if (encrypt)
            comando = encriptar(comando);
        printer.println(comando);
        printer.flush();
        if (wait)
            Thread.sleep(1000);

    }

    private static String encriptar(String key){
        StrongTextEncryptor encryptPassword  = new StrongTextEncryptor();
        encryptPassword.setPassword(PASSW);
        return encryptPassword.encrypt(key);
    }
    //Metodo para encriptar que le pasas por parametro un string llamado key o cualquier otro nombre
    //Objeto StrongTextEncryptor encrypt  = new StrongTextEncryptor();(Va dentro del metodo anterior)
    //Variable encrypt tenemos que pasarle una contraseña -> encrypt.setPassword(...);
}
