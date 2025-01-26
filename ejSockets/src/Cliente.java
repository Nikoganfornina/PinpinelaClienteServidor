import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Esta clase implementa un cliente que se conecta a un servidor en un puerto específico.
 * El cliente envía mensajes al servidor y recibe respuestas hasta que se cierra la conexión.
 */
public class Cliente {

    /**
     * Método principal que ejecuta el cliente.
     * Se conecta al servidor en la dirección "127.0.0.1" y el puerto 5000.
     * Permite al usuario escribir mensajes que se envían al servidor,
     * y muestra las respuestas del servidor. La conexión se termina si
     * el servidor responde con un mensaje específico.
     *
     * @param args Los argumentos de la línea de comandos.
     * @throws IOException Si ocurre un error durante la comunicación de red.
     */
    public static void main(String[] args) throws IOException {
        String HOST = "127.0.0.1";
        int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);

        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            boolean continuar = true;

            while (continuar) {
                System.out.print("Escribe tu mensaje: ");
                String mensajeCliente = scanner.nextLine();
                out.writeUTF(mensajeCliente);

                String respuesta = in.readUTF();
                System.out.println("Servidor responde: " + respuesta);

                if (respuesta.equals("Por eso vete, olvida mi nombre, mi cara, mi casa y pega la vuelta")) {
                    continuar = false;
                }
            }

            sc.close();
            System.out.println("Cliente desconectado");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
