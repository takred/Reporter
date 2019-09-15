import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class NewReportBuilder {
    public void saveReport(List<List<Cell>> listCell, List<String> category) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("myNewReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        List<Integer> maxLengthBorder = maxLengthElements(listCell);
        for (int i = 0; i < category.size(); i++) {
            writer.print("| " + category.get(i) + " ");
            if (category.get(i).length() < maxLengthBorder.get(i)) {
                for (int j = 0; j < maxLengthBorder.get(i) - category.get(i).length(); j++) {
                    writer.print(" ");
                }
            }
            if (i == category.size() - 1) {
                writer.print("|");
                writer.println();
            }
        }

        for (int j = 0; j < category.size(); j++) {
            writer.print("|-");
            for (int k = 0; k < maxLengthBorder.get(j) + 1; k++) {
                writer.print("-");
            }
        }
        writer.print("|");
        writer.println("");

        for (int i = 0; i < listCell.size(); i++) {
            for (int j = 0; j < listCell.get(i).size(); j++) {
                writer.print("| " + listCell.get(i).get(j).getValue() + " ");
                if (category.get(j).length() < maxLengthBorder.get(j)) {
                    for (int k = 0; k < maxLengthBorder.get(j) - listCell.get(i).get(j).getValue().length(); k++) {
                        writer.print(" ");
                    }
                }
            }
            writer.print("|");
            writer.println();
            for (int j = 0; j < category.size(); j++) {
                writer.print("|-");
                for (int k = 0; k < maxLengthBorder.get(j) + 1; k++) {
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
                if (count < listCell.get(j).get(i).getValue().length()) {
                    count = listCell.get(j).get(i).getValue().length();
                }
            }
            maxLength.add(count);
        }
        return maxLength;
    }
}
