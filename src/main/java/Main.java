import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public List<List<A>> listA(String fileName){}
    public static void saveReport(List<List<A>> listA) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("MyReport.txt");
        PrintWriter writer = new PrintWriter(outputStream);
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listA.get(i).size(); j++) {
                if (j != listA.get(i).size() - 1) {
                    writer.print(listA.get(i).get(j).value + ";");
                } else {
                    writer.println(listA.get(i).get(j).value);
                }
            }
        }
        writer.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        List<List<A>> listsA = new ArrayList<List<A>>();
        List<A> listA = new ArrayList<A>();
        A a = new A("year", "1998");
        listA.add(a);
        a = new A("name", "audi");
        listA.add(a);
        a = new A("price", "50000");
        listA.add(a);
        listsA.add(listA);
        listA = new ArrayList<A>();
        a = new A("year", "2001");
        listA.add(a);
        a = new A("name", "mercedes");
        listA.add(a);
        a = new A("price", "200000");
        listA.add(a);
        listsA.add(listA);
        listA = new ArrayList<A>();
        a = new A("year", "2008");
        listA.add(a);
        a = new A("name", "kea");
        listA.add(a);
        a = new A("price", "780000");
        listA.add(a);
        listsA.add(listA);
        saveReport(listsA);
    }
}
