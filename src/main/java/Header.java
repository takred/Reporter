import java.util.ArrayList;
import java.util.List;

public class Header {
    private String name;
    private int widthSpeaker;
    public Header(String name, int widthSpeaker){
        this.name = name;
        this.widthSpeaker = widthSpeaker;
    }
    public Header(){}
    public String getName(){
        return name;
    }
    public void addName(String string){
        name = string;
    }
    public Integer getWidthSpeaker(){
        return widthSpeaker;
    }
    public void setWidthSpeaker(int maxWidth){
        widthSpeaker = maxWidth;
    }
    public void addWidthSpeaker(int width){
        widthSpeaker = width;
    }
}
