package g2048.ui.events;

import java.util.EventObject;

public class ChangeEvent extends EventObject {
    private EventType eventType;
    public ChangeEvent(Object source){
        super(source);
        eventType= null;
    }

    public void setEvent(EventType eventType){
        this.eventType= eventType;
    }

    public EventType getEvent(){
        return eventType;
    }
}
