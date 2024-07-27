import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import javax.swing.*;

public class SecureClient {
    private static final String SERVER_HOST = "localhost";  // Server host
    private static final int SERVER_PORT = 8800;  // Server port
    private static final String TRUSTSTORE_PATH = "/home/seed/Downloads/assign3/truststore.jks";  // Path to the truststore file
    private static final String TRUSTSTORE_PASSWORD = "koushik";  // Truststore password

    public static void main(String[] args) {
        try {
            // Load the truststore
            KeyStore clientTruststore = KeyStore.getInstance("JKS");
            clientTruststore.load(new FileInputStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());

            // Initialize SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(clientTruststore);
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(SERVER_HOST, SERVER_PORT);

            // Create reader and writer for the socket
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            // Get user message and send to the server
            String userMessage = JOptionPane.showInputDialog("Enter message to send to server");
            writer.println(userMessage);

            System.out.println("Sent message to server: " + userMessage);

            // Read and display server's response
            String serverResponse = reader.readLine();
            JOptionPane.showMessageDialog(null, "The server sent: " + serverResponse);

            System.out.println("Server response: " + serverResponse);

            // Close the connections
            reader.close();
            writer.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}