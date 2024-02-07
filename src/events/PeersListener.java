package events;

import models.PeerDto;

public interface PeersListener {
    void peerConnected(PeerDto peer);
    void peerDisconnected(PeerDto peer);
}
