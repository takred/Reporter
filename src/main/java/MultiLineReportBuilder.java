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
            List<MultiLineCell> hyphenation = new ArrayList<>();
            for (int k = 0; k < listCell.get(i).size(); k++) {
                hyphenation.add(new MultiLineCell(listCell.get(i).get(k)));
            }
            for (int j = 0; j < listCell.get(i).size(); j++) {
//                System.out.println(listCell.get(i).size());

//                for (int l = 0; l < hyphenation.size(); l++) {
//                    System.out.println(hyphenation.get(l).getCell().value);
//                    System.out.println(hyphenation.get(l).getCell().name);
//                }
                if (listCell.get(i).get(j).value.length() > category.getHeader().getWidthSpeaker().get(j)) {
                    writer.print("| " + listCell.get(i).get(j).value.substring(0, category.getHeader().getWidthSpeaker().get(j)) + " ");
                    hyphenation.get(j).setCellValue(listCell.get(i).get(j).value.substring(category.getHeader().getWidthSpeaker().get(j)));
                    hyphenation.get(j).setCounter(1);
                } else {
                    writer.print("| " + listCell.get(i).get(j).value + " ");
                }
                if (category.getHeader().getWidthSpeaker().get(j) > listCell.get(i).get(j).value.length()) {
                    for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) - listCell.get(i).get(j).value.length(); k++) {
                        writer.print(" ");
                    }
                }
                if (category.getHeader().getName().get(j).length() < category.getHeader().getWidthSpeaker().get(j)) {
                    for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) - listCell.get(i).get(j).value.length(); k++) {
                        writer.print(" ");
                    }
                }
//                while (counterCheck(hyphenation)) {
//                    for (int k = 0; k < hyphenation.size(); k++) {
//                        for (int l = 0; l < hyphenation.size(); l++) {
//                            System.out.println(hyphenation.get(l).getCell().value);
//                            System.out.println(hyphenation.get(l).getCell().name);
//                        }
//                        System.out.println("Всё");
//                        if (hyphenation.get(k).getCounter() > 0) {
//                            if (hyphenation.get(k).getCell().value.length() > category.header.getWidthSpeaker().get(k)) {
//                                writer.print("| " + hyphenation.get(k).getCell().value.substring(0, category.header.getWidthSpeaker().get(k)) + " ");
//                                hyphenation.get(k).setCellValue(listCell.get(i).get(k).value.substring(category.header.getWidthSpeaker().get(k)));
//                                hyphenation.get(k).setCounter(1);
//                            } else {
//                                writer.print("| " + hyphenation.get(j).getCell().value + " ");
//                                hyphenation.get(k).setCounter(0);
//                            }
//                        } else {
//                            writer.print("| ");
//                            for (int l = 0; l < category.header.getWidthSpeaker().get(k); l++) {
//                                writer.print(" ");
//                            }
//                            writer.print(" |");
//                        }
//                        if(k == hyphenation.size() - 1){
//                            writer.println(" |");
//                        }
//                    }
//                    System.out.println("мда");
////                    if (!counterCheck(hyphenation)) {
////                        break;
////                    }
//                }
            }
            writer.print("|");
            writer.println();
            for (int j = 0; j < category.getHeader().getName().size(); j++) {
                writer.print("|-");
                for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) + 1; k++) {
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

    public boolean counterCheck(List<MultiLineCell> hyphenation) {
        for (int i = 0; i < hyphenation.size(); i++) {
            if (hyphenation.get(i).getCounter() > 0) {
                return true;
            }
        }
        return false;
    }
}
