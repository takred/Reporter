import java.util.ArrayList;
import java.util.List;

public class Header {
    private List<String> name = new ArrayList<>();
    private List<Integer> widthSpeaker = new ArrayList<>();

    public List<String> getName(){
        return name;
    }
    public void addName(String string){
        name.add(string);
    }
    public List<Integer> getWidthSpeaker(){
        return widthSpeaker;
    }
    public void addWidthSpeaker(Integer integer){
        widthSpeaker.add(integer);
    }
}
