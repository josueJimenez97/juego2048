package g2048.ui.events;

public enum EventType {
    WIN("you win"),
    LOST("you lost"),
    BOARD_CHANGE("board changed"),
    END_GAME("end game"),
    MOVEMENT("");
    private String eventKey;

    EventType(String eventKey){
        this.eventKey=eventKey;
    }

    public void setName(String eventKey){
        this.eventKey=eventKey;
    }

    public String getName(){
        return eventKey;
    }

}
