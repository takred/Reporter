import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SettingsBuilder {
    List<String> settings;

    public SettingsBuilder(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            settings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();
        }
    }
}
