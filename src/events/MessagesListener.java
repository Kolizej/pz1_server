package events;

import models.MessageDto;

public interface MessagesListener {
    void messageTransfer(MessageDto message);
}
