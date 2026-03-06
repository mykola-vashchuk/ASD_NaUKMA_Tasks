package HW_5;

interface MediaSource {
    String id();
    String type(); // "audio" або "video"
    int sizeMb();
    boolean open();
}
