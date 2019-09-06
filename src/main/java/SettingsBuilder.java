import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SettingsBuilder {
    List<String> settings = new ArrayList<>();

    public SettingsBuilder(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            if (strings.get(0).contains(";")) {
                for (int i = 0; i < strings.size(); i++) {
                    settings.add(strings.get(i).substring(0, strings.get(i).indexOf(";")));
                }
            } else {
                settings = bufferedReader.lines().collect(Collectors.toList());
            }
            inputStream.close();
        }
    }
}
