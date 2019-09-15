import java.util.ArrayList;
import java.util.List;

public class CorrectionWidthSpeaker {
    public MultiLineSettings correctionWidth(MultiLineSettings multiLineSettings, List<List<Cell>> multiLineFormatSettings){
        List<Integer> maxLength = maxLengthElements(multiLineFormatSettings);
        MultiLineSettings newMultiLineSettings = multiLineSettings;
        for (int i = 0; i < newMultiLineSettings.getHeader().size(); i++) {
            if (newMultiLineSettings.getHeader().get(i).getWidthSpeaker() > maxLength.get(i)){
                newMultiLineSettings.getHeader().get(i).setWidthSpeaker(maxLength.get(i));
            }
        }
        return newMultiLineSettings;
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
