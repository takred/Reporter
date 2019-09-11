import java.util.ArrayList;
import java.util.List;

public class Divider {
    public List<String> getWriteString(List<Cell> multiLineCells, MultiLineSettingsBuilder category) {
        List<String> newFormatRecord = new ArrayList<>();
        int counterIteration = 0;
        List<Cell> copyMultiLineCells = multiLineCells;
        for (int i = 0; i < copyMultiLineCells.size(); i++) {
            if (copyMultiLineCells.get(i).value.length() >= category.getHeader().getWidthSpeaker().get(i) &&
                    counterIteration <= copyMultiLineCells.get(i).value.length() /
                            category.getHeader().getWidthSpeaker().get(i)) {
                if (copyMultiLineCells.get(i).value.length() % category.getHeader().getWidthSpeaker().get(i) > 0) {
                    counterIteration = (copyMultiLineCells.get(i).value.length() / category.getHeader().getWidthSpeaker().get(i)) + 1;
                } else {
                    counterIteration = copyMultiLineCells.get(i).value.length() / category.getHeader().getWidthSpeaker().get(i);
                }
            }
        }
        if (counterIteration == 0){
            counterIteration = 1;
        }
        for (int c = 0; c < counterIteration; c++) {
            String savePiece = "";
            for (int j = 0; j < copyMultiLineCells.size(); j++) {
                if (copyMultiLineCells.get(j).value.length() > category.getHeader().getWidthSpeaker().get(j)) {
                    savePiece = savePiece + "| " + copyMultiLineCells.get(j).value.substring(0, category.getHeader().getWidthSpeaker().get(j)) + " ";
                    if (category.getHeader().getName().get(j).length() < category.getHeader().getWidthSpeaker().get(j)) {
                        for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) - copyMultiLineCells.get(j).value.length(); k++) {
                            savePiece = savePiece + " ";
                        }
                    }
                    copyMultiLineCells.get(j).value = copyMultiLineCells.get(j).value.substring(category.getHeader().getWidthSpeaker().get(j));
                } else {
                    savePiece = savePiece + "| " + copyMultiLineCells.get(j).value + " ";
                    if (copyMultiLineCells.get(j).value.length() < category.getHeader().getWidthSpeaker().get(j)) {
                        for (int k = 0; k < category.getHeader().getWidthSpeaker().get(j) - copyMultiLineCells.get(j).value.length(); k++) {
                            savePiece = savePiece + " ";
                        }
                    }
                    copyMultiLineCells.get(j).value = " ";
                }
            }
            savePiece = savePiece + "|";
            newFormatRecord.add(savePiece);
        }
        return newFormatRecord;
    }
}
