import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class MultiLineSettingsBuilder {
    private Header header = new Header();

    public MultiLineSettingsBuilder(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            for (int i = 0; i < strings.size(); i++) {
                getHeader().addName(strings.get(i).substring(0, strings.get(i).indexOf(";")));
                getHeader().addWidthSpeaker(Integer.valueOf(strings.get(i).substring(strings.get(i).indexOf(";") + 1)));
                inputStream.close();
            }
        }
    }

    public Header getHeader() {
        return header;
    }
}
