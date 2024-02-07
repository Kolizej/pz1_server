package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PeerHandler implements Runnable {
    private Socket peerSocket;
    private PrintWriter outStream;
    private BufferedReader inStream;

    public PeerHandler(Socket socket) throws IOException {
        this.peerSocket = socket;
        outStream = new PrintWriter(socket.getOutputStream(), true);
        inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    @Override
    public void run() {
        try {
            String inputMessage;
            while ((inputMessage = inStream.readLine()) != null) {
                //TODO: parse json, transfer message to destination:
                // get dest peer
                // create messageJson
                // destPeer.outStream.println(messageJson);
            }
        } catch (IOException e) {
            //TODO: create ErrorsListener, send error to listener
        } finally {
            try {
                outStream.close();
                inStream.close();
                peerSocket.close();
            } catch (IOException e) {
                //TODO: create ErrorsListener, send error to listener
            }
        }
    }
}
