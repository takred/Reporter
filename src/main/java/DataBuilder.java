import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBuilder {
    public List<List<String>> categoryList = new ArrayList<>();
    public DataBuilder(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();
            int countSemicolon = strings.get(0).length() - strings.get(0).replaceAll(";", "").length();
            for (int i = 0; i < strings.size(); i++) {
                List<String> copyList = new ArrayList<>();
                int position = 0;
                for (int j = 0; j < countSemicolon + 1; j++) {
                    if (strings.get(i).indexOf(";", position) != -1) {
                        copyList.add(strings.get(i).substring(position, strings.get(i).indexOf(";", position)));
                    } else {
                        copyList.add(strings.get(i).substring(position));
                    }
                    if (j == countSemicolon){
                        categoryList.add(copyList);
                    }
                    position = (strings.get(i).indexOf(";", position)) + 1;
                }
            }
        }
    }
}
