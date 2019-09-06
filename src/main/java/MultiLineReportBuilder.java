import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MultiLineReportBuilder {
    public void saveReport(List<List<Cell>> listCell, MultiLineSettingsBuilder category) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("multiLineReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        List<Integer> maxLengthBorder = maxLengthElements(listCell);
        for (int i = 0; i < category.header.getName().size(); i++) {
            writer.print("| " + category.header.getName().get(i) + " ");
            if (category.header.getName().get(i).length() < category.header.getWidthSpeaker().get(i)) {
                for (int j = 0; j < category.header.getWidthSpeaker().get(i) - category.header.getName().get(i).length(); j++) {
                    writer.print(" ");
                }
            }
            if (i == category.header.getName().size() - 1) {
                writer.print("|");
                writer.println();
            }
        }

        for (int j = 0; j < category.header.getName().size(); j++) {
            writer.print("|-");
            for (int k = 0; k < category.header.getWidthSpeaker().get(j) + 1; k++) {
                writer.print("-");
            }
        }
        writer.print("|");
        writer.println("");

        for (int i = 0; i < listCell.size(); i++) {
            for (int j = 0; j < listCell.get(i).size(); j++) {
                if (listCell.get(i).get(j).value.length() > category.header.getWidthSpeaker().get(j)){
                    writer.print("| " + listCell.get(i).get(j).value.substring(0, category.header.getWidthSpeaker().get(j)) + " ");
                } else {
                    writer.print("| " + listCell.get(i).get(j).value + " ");
                }
                if (category.header.getWidthSpeaker().get(j) > listCell.get(i).get(j).value.length()){
                    for (int k = 0; k < category.header.getWidthSpeaker().get(j) - listCell.get(i).get(j).value.length(); k++) {
                        writer.print(" ");
                    }
                }
                if (category.header.getName().get(j).length() < category.header.getWidthSpeaker().get(j)) {
                    for (int k = 0; k < category.header.getWidthSpeaker().get(j) - listCell.get(i).get(j).value.length(); k++) {
                        writer.print(" ");
                    }
                }
            }
            writer.print("|");
            writer.println();
            for (int j = 0; j < category.header.getName().size(); j++) {
                writer.print("|-");
                for (int k = 0; k < category.header.getWidthSpeaker().get(j) + 1; k++) {
                    writer.print("-");
                }
            }
            writer.print("|");
            writer.println("");
        }
        writer.close();
    }

    public List<Integer> maxLengthElements(List<List<Cell>> listCell) {
        List<Integer> maxLength = new ArrayList<>();
        for (int i = 0; i < listCell.get(0).size(); i++) {
            Integer count = 0;
            for (int j = 0; j < listCell.size(); j++) {
                if (count < listCell.get(j).get(i).value.length()) {
                    count = listCell.get(j).get(i).value.length();
                }
            }
            maxLength.add(count);
        }
        return maxLength;
    }
}
