package Liberation.UserDatabase;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.Socket;

public class OrganizerCredentialDatabase implements Database {
    private final int port = 300;
    private final SSLServerSocket sslServerSocket;
    public OrganizerCredentialDatabase() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            new Thread(this::clientSolicit);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method when called from a separate thread will wait for clients to connect
     * and add them to a queue for authentication.
     */
    private void clientSolicit(){
        while (true) {
            try {
                Socket client = sslServerSocket.accept();
                new Thread(() -> {
                    new DatabaseQueries(client, this);
                });
            } catch (IOException e) {
                System.out.println("Unexpected Client Error");
                e.printStackTrace();
            }
        }
    }
    private static class DatabaseQueries {
        private final Socket client;
        private final Database database;
        public DatabaseQueries(Socket client, Database database) {
            this.client = client;
            this.database = database;
            new Thread(this::getQuery);
        }

        private void getQuery() {
            ObjectInputStream clientQueryReader;
            ObjectOutputStream clientResults;
            try {
                clientQueryReader = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
                clientResults = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            while(client.isConnected()) {
                try {
                    String function = (String) clientQueryReader.readObject();
                    if(function.equals("doesClientExist")){
                        boolean result = doesClientExistEmail(clientQueryReader);
                        clientResults.writeBoolean(result);
                    }
                    else if(function.equals("createNewClient")){
                        boolean result = createNewClient(clientQueryReader);
                        clientResults.writeBoolean(result);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public boolean doesClientExistEmail(ObjectInputStream clientQueryReader) {
            try {
                String email = (String) clientQueryReader.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        public boolean createNewClient(ObjectInputStream clientQueryReader) {
            try {
                String email = (String) clientQueryReader.readObject();
                String password = (String) clientQueryReader.readObject();
                String key = (String) clientQueryReader.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }

}
