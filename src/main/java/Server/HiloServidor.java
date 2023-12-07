package Server;

import Clases.Comentario;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class HiloServidor extends Thread {

    @Override
    public void run() {
        try {

            ServerSocket serverSocket = new ServerSocket(10570);
            System.out.println("Inciando server");

            while (true) {

                Socket socketCliente = serverSocket.accept();

                ObjectInputStream deserealizador = new ObjectInputStream(socketCliente.getInputStream());

                ArrayList<Object> listaDeObjetos = (ArrayList<Object>) deserealizador.readObject();

                Comentario comentario = (Comentario) listaDeObjetos.get(0);

                String figura = (String) listaDeObjetos.get(1);

                Comentario.crearComentarioBD(comentario, figura);

                deserealizador.close();
                socketCliente.close();
            }
        } catch (IOException ex) {
            System.out.println("Ocurrión un error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocurrión un error");
        }
    }

}
