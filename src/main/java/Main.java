import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File("settings.csv");
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            strings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();
        }
//        NewReportBuilder newReportBuilder = new NewReportBuilder();
        ReportBuilder reportBuilder = new ReportBuilder();
        DataBuilder dataBuilder = new DataBuilder("data.csv");
        SettingsBuilder settingsBuilder = new SettingsBuilder("settings.csv");
        List<List<Cell>> formatSettings = getLists(dataBuilder, settingsBuilder);
        reportBuilder.saveReport(formatSettings, strings);
//        newReportBuilder.saveReport(formatSettings, strings);
    }

    private static List<List<Cell>> getLists(DataBuilder dataBuilder, SettingsBuilder settingsBuilder) {
        List<List<Cell>> formatSettings = new ArrayList<>();
        for (int i = 1; i < dataBuilder.categoryList.size(); i++) {
            List<Cell> templateListCell = new ArrayList<>();
            for (int k = 0; k < settingsBuilder.settings.size(); k++) {
                for (int j = 0; j < dataBuilder.categoryList.get(i).size(); j++) {
                    if (settingsBuilder.settings.get(k).equals(dataBuilder.categoryList.get(0).get(j)) &&
                            templateListCell.size() < settingsBuilder.settings.size()) {
                        templateListCell.add(new Cell(settingsBuilder.settings.get(k), dataBuilder.categoryList.get(i).get(j)));
                        break;
                    }
                }
            }
            formatSettings.add(templateListCell);
        }
        return formatSettings;
    }
}
