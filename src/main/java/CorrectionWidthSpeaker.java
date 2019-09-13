import java.util.ArrayList;
import java.util.List;

public class CorrectionWidthSpeaker {
    public void correctionWidth(MultiLineSettingsBuilder multiLineSettingsBuilder, List<List<Cell>> multiLineFormatSettings){
        List<Integer> maxLength = maxLengthElements(multiLineFormatSettings);
        for (int i = 0; i < multiLineSettingsBuilder.getHeader().size(); i++) {
            if (multiLineSettingsBuilder.getHeader().get(i).getWidthSpeaker() > maxLength.get(i)){
                multiLineSettingsBuilder.getHeader().get(i).setWidthSpeaker(maxLength.get(i));
            }
        }
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
