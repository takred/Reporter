import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReportBuilder {
    public void saveReport(List<List<Cell>> listA, List<String> category) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("MyReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        for (int i = 0; i < category.size(); i++) {
            writer.print(category.get(i));
            if (i == category.size() - 1) {
                writer.println();
            } else {
                writer.print(";");
            }
        }
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listA.get(i).size(); j++) {
                writer.print(listA.get(i).get(j).value);
                if (j != listA.size() - 1) {
                    writer.print(";");
                }
            }
            if (i != listA.size() - 1) {
                writer.println();
            }
        }
        writer.close();
    }
}
