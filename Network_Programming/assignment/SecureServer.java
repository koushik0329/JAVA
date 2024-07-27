import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer {
    private static final int SERVER_PORT = 8800;  // Server listening port
    private static final String KEYSTORE_PATH = "/home/seed/Downloads/assign3/keystore.jks";  // Path to the keystore file
    private static final String KEYSTORE_PASSWORD = "koushik";  // Keystore password

    public static void main(String[] args) {
        try {
            // Load the keystore
            KeyStore serverKeystore = KeyStore.getInstance("JKS");
            serverKeystore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            // Initialize SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(serverKeystore, KEYSTORE_PASSWORD.toCharArray());
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create SSL server socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT);

            System.out.println("Server started. Listening on port " + SERVER_PORT + "...");

            // Wait for a client connection
            SSLSocket serverSSLSocket = (SSLSocket) sslServerSocket.accept();

            // Create reader and writer for the socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(serverSSLSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(serverSSLSocket.getOutputStream(), true);

            // Read and print the client's message
            String clientMessage = reader.readLine();
            System.out.println("Received message from client: " + clientMessage);

            // Send response back to the client
            writer.println("Server response: Message received! " + clientMessage);

            // Close the connections
            reader.close();
            writer.close();
            serverSSLSocket.close();
            sslServerSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}