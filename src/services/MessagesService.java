package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MessagesService implements Runnable {

    private ServerSocket serverSocket;
    private List<PeerHandler> peerHandlers;
    public MessagesService() throws IOException {
        var configFilePath = "src/config.properties";
        var propsInput = new FileInputStream(configFilePath);
        var props = new Properties();
        props.load(propsInput);
        peerHandlers = new ArrayList<>();
        serverSocket = new ServerSocket(Integer.parseInt(props.getProperty("SERVER_PORT")));
    }

    @Override
    public void run() {
        try{
            while (!serverSocket.isClosed()) {
                var peerSocket = serverSocket.accept();
                var peerHandler = new PeerHandler(peerSocket);
                peerHandlers.add(peerHandler);
                new Thread(peerHandler).start();
            }
        } catch (IOException e) {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
