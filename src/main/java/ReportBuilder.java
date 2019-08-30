import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class ReportBuilder {
    public void saveReport(List<List<A>> listA, List<String> category) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("MyReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        for (int i = 0; i < category.size(); i++) {
            if (i != category.size() - 1) {
                writer.print(category.get(i) + ";");
            } else {
                writer.println(category.get(i));
            }
        }
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listA.get(i).size(); j++) {
                if (i == listA.size() - 1 && j == listA.get(listA.size() - 1).size() - 1) {
                    writer.print(listA.get(i).get(j).value);
                } else {
                    if (j != listA.get(i).size() - 1) {
                        writer.print(listA.get(i).get(j).value + ";");
                    } else {
                        writer.println(listA.get(i).get(j).value);
                    }
                }
            }
        }
        writer.close();
    }
}
