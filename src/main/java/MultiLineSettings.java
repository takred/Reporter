import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiLineSettings {
    private List<Header> header = new ArrayList<>();

    public MultiLineSettings(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            for (int i = 0; i < strings.size(); i++) {
                String name = strings.get(i).substring(0, strings.get(i).indexOf(";"));
                int width = Integer.valueOf(strings.get(i).substring(strings.get(i).indexOf(";") + 1));
                header.add(new Header(name, width));
                inputStream.close();
            }
        }
    }
    public MultiLineSettings(MultiLineSettings multiLineSettings){

        for (int i = 0; i < multiLineSettings.getHeader().size(); i++) {
            Header header = multiLineSettings.getHeader().get(i);
            this.header.add (new Header(header.getName(),
                    header.getWidthSpeaker()));
        }
    }

    public List<Header> getHeader() {
        return header;
    }
//    public void setWidthSpeaker(int maxWidth, int index){
//        header.get(index).getWidthSpeaker() = maxWidth;
//    }
}
