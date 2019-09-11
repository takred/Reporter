import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MultiLineReportBuilder2 {
    public void saveReport(List<List<Cell>> listCell, MultiLineSettingsBuilder category) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("multiLineReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        List<Integer> maxLengthBorder = maxLengthElements(listCell);
        for (int i = 0; i < category.getHeader().getName().size(); i++) {
            writer.print("| " + category.getHeader().getName().get(i) + " ");
            if (category.getHeader().getName().get(i).length() < category.getHeader().getWidthSpeaker().get(i)) {
                for (int j = 0; j < category.getHeader().getWidthSpeaker().get(i) - category.getHeader().getName().get(i).length(); j++) {
                    writer.print(" ");
                }
            }
            if (i == category.getHeader().getName().size() - 1) {
                writer.print("|");
                writer.println();
            }
        }

        for (int j = 0; j < category.getHeader().getName().size(); j++) {
            writer.print("|-");
            for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) + 1; k++) {
                writer.print("-");
            }
        }
        writer.print("|");
        writer.println("");

        for (int i = 0; i < listCell.size(); i++) {
            Divider divider = new Divider();
            List<String> strings = divider.getWriteString(listCell.get(i), category);
            for (int k = 0; k < strings.size(); k++) {
                System.out.println(strings.get(k));
            }
            if (strings.size() > 1) {
                for (int j = 0; j < strings.size(); j++) {
                    writer.println(strings.get(j));

                }
            } else {
                writer.println(strings.get(0));
            }
//            writer.print("|");
//            writer.println();
            for (int j = 0; j < category.getHeader().getName().size(); j++) {
                writer.print("|-");
                for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) + 1; k++) {
                    writer.print("-");
                }
            }
            writer.print("|");
            writer.println("");
//        }
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

    public boolean counterCheck(List<MultiLineCell> hyphenation) {
        for (int i = 0; i < hyphenation.size(); i++) {
            if (hyphenation.get(i).getCounter() > 0) {
                return true;
            }
        }
        return false;
    }
}
