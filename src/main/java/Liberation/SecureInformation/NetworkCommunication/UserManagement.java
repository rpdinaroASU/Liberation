package Liberation.SecureInformation.NetworkCommunication;

import Liberation.SecureInformation.PermisionControl.LoginSystem;

import javax.net.ssl.*;
import java.io.*;

public class UserManagement {
    private final LoginSystem loginSystem;
    private final String HOST = "localhost";
    private final int PORT = 300;

    private SSLSocket serverSocket;

    private ObjectOutputStream sendStream;

    private ObjectInputStream receiveStream;

    /**
     * Initializes a User Management session with the permission system that connected to it
     * @param loginSystem the login System used to connect with the user managment session
     */
    public UserManagement(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        establishSecureConnection();
    }

    /**
     * Establish a secure connection with a server
     */
    private void establishSecureConnection() {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            serverSocket = (SSLSocket) sslSocketFactory.createSocket(HOST,PORT);
            receiveStream = (ObjectInputStream) serverSocket.getInputStream();
            sendStream = (ObjectOutputStream) serverSocket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
