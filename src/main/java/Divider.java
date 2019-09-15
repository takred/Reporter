import java.util.ArrayList;
import java.util.List;

public class Divider {
    public List<String> getWriteString(List<Cell> multiLineCells, MultiLineSettings category) {
        List<String> newFormatRecord = new ArrayList<>();
        int counterIteration = 0;
        List<Cell> copyMultiLineCells = multiLineCells;
        for (int i = 0; i < copyMultiLineCells.size(); i++) {
            if (copyMultiLineCells.get(i).getValue().length() >= category.getHeader().get(i).getWidthSpeaker() &&
                    counterIteration <= copyMultiLineCells.get(i).getValue().length() /
                            category.getHeader().get(i).getWidthSpeaker()) {
                if (copyMultiLineCells.get(i).getValue().length() % category.getHeader().get(i).getWidthSpeaker() > 0) {
                    counterIteration = (copyMultiLineCells.get(i).getValue().length() / category.getHeader().get(i).getWidthSpeaker()) + 1;
                } else {
                    counterIteration = copyMultiLineCells.get(i).getValue().length() / category.getHeader().get(i).getWidthSpeaker();
                }
            }
        }
        if (counterIteration == 0){
            counterIteration = 1;
        }
        for (int c = 0; c < counterIteration; c++) {
            String savePiece = "";
            for (int j = 0; j < copyMultiLineCells.size(); j++) {
                if (copyMultiLineCells.get(j).getValue().length() > category.getHeader().get(j).getWidthSpeaker()) {
                    savePiece = savePiece + "| " + copyMultiLineCells.get(j).getValue().substring(0, category.getHeader().get(j).getWidthSpeaker()) + " ";
                    if (category.getHeader().get(j).getName().length() < category.getHeader().get(j).getWidthSpeaker()) {
                        for (int k = 0; k < category.getHeader().get(j).getWidthSpeaker() - copyMultiLineCells.get(j).getValue().length(); k++) {
                            savePiece = savePiece + " ";
                        }
                    }
                    copyMultiLineCells.get(j).setValue(copyMultiLineCells.get(j).getValue().substring(category.getHeader().get(j).getWidthSpeaker()));
                } else {
                    savePiece = savePiece + "| " + copyMultiLineCells.get(j).getValue() + " ";
                    if (copyMultiLineCells.get(j).getValue().length() < category.getHeader().get(j).getWidthSpeaker()) {
                        for (int k = 0; k < category.getHeader().get(j).getWidthSpeaker() - copyMultiLineCells.get(j).getValue().length(); k++) {
                            savePiece = savePiece + " ";
                        }
                    }
                    copyMultiLineCells.get(j).setValue(" ");
                }
            }
            savePiece = savePiece + "|";
            newFormatRecord.add(savePiece);
        }
        return newFormatRecord;
    }
}
