import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
//    public List<List<A>> listA(String fileName){}
    public static void main(String[] args) throws IOException {
        List<List<Cell>> listsA = new ArrayList<List<Cell>>();
        List<Cell> listCell = new ArrayList<Cell>();
        Cell cell = new Cell("year", "1998");
        listCell.add(cell);
        cell = new Cell("name", "audi");
        listCell.add(cell);
        cell = new Cell("price", "50000");
        listCell.add(cell);
        listsA.add(listCell);
        listCell = new ArrayList<Cell>();
        cell = new Cell("year", "2001");
        listCell.add(cell);
        cell = new Cell("name", "mercedes");
        listCell.add(cell);
        cell = new Cell("price", "200000");
        listCell.add(cell);
        listsA.add(listCell);
        listCell = new ArrayList<Cell>();
        cell = new Cell("year", "2008");
        listCell.add(cell);
        cell = new Cell("name", "kea");
        listCell.add(cell);
        cell = new Cell("price", "780000");
        listCell.add(cell);
        listsA.add(listCell);
        List<String> strings = new ArrayList<>();
        File file = new File("settings.csv");
        if (!file.exists()){
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            strings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();
        }
        ReportBuilder reportBuilder = new ReportBuilder();
//        reportBuilder.saveReport(listsA, strings);
        DataBuilder dataBuilder = new DataBuilder("data.csv");
        SettingsBuilder settingsBuilder = new SettingsBuilder("settings.csv");
//        for (int i = 0; i < dataBuilder.categoryList.size(); i++) {
//            for (int j = 0; j < dataBuilder.categoryList.get(i).size(); j++) {
//                System.out.println(dataBuilder.categoryList.get(i).get(j));
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < settingsBuilder.settings.size(); i++) {
//            System.out.println(settingsBuilder.settings.get(i));
//        }
        List<List<Cell>> formatSettings = new ArrayList<>();
        for (int i = 1; i < dataBuilder.categoryList.size(); i++) {
            List<Cell> templateListCell = new ArrayList<>();
            for (int k = 0; k < settingsBuilder.settings.size(); k++) {
                for (int j = 0; j < dataBuilder.categoryList.get(i).size(); j++) {
                    if (settingsBuilder.settings.get(k).equals(dataBuilder.categoryList.get(0).get(j)) &&
                            templateListCell.size() < settingsBuilder.settings.size()) {
//                        System.out.println(settingsBuilder.settings.get(k) + " - категория которая сравнивается");
//                        System.out.println(dataBuilder.categoryList.get(0).get(j)+ " - категория с которой сравнивают");
                        templateListCell.add(new Cell(settingsBuilder.settings.get(k), dataBuilder.categoryList.get(i).get(j)));
                        break;
                    }
                }
            }
//            System.out.println("Один раз!");
            formatSettings.add(templateListCell);
        }
//        for (int i = 0; i < formatSettings.size(); i++) {
//            for (int j = 0; j < formatSettings.get(i).size(); j++) {
//                System.out.println(formatSettings.get(i).get(j).value);
//            }
//            System.out.println();
//        }
//        System.out.println(formatSettings.size());
//        System.out.println(formatSettings.get(0).size());
//        for (int i = 0; i < settingsBuilder.settings.size(); i++) {
//            System.out.println(settingsBuilder.settings.get(i));
//        }
        reportBuilder.saveReport(formatSettings, strings);
//        saveReport(listsA, strings);
    }
}
