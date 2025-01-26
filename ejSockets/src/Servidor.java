import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase implementa un servidor que escucha en un puerto específico (5000)
 * y responde a los mensajes de los clientes. El servidor mantiene la conexión
 * abierta hasta que recibe un mensaje que provoca su cierre.
 */
public class Servidor {

    /**
     * Método principal que ejecuta el servidor.
     * El servidor escucha conexiones en el puerto 5000 y espera mensajes de los clientes.
     * Responde de acuerdo con el contenido del mensaje recibido. Si se recibe
     * un mensaje específico, el servidor finalizará la conexión con el cliente.
     *
     * @param args Los argumentos de la línea de comandos.
     * @throws IOException Si ocurre un error durante la comunicación de red.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while (true) {
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                boolean continuar = true;

                while (continuar) {
                    String mensaje = in.readUTF();
                    System.out.println("Cliente dice: " + mensaje);

                    switch (mensaje) {
                        case "¿Quién es?":
                            out.writeUTF("Soy yo");
                            break;

                        case "¿Qué vienes a buscar?":
                            out.writeUTF("A ti");
                            break;

                        case "Ya es tarde":
                            out.writeUTF("¿Por qué?");
                            break;

                        case "Porque ahora soy yo la que quiere estar sin ti":
                            out.writeUTF("Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta");
                            continuar = false; // Finaliza la conexión
                            break;

                        default:
                            out.writeUTF("Error");
                            break;
                    }
                }

                System.out.println("Cliente desconectado");
                sc.close();
            }

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
