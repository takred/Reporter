public class MultiLineCell {
    private Cell cell;
    private int counter = 0;
    public MultiLineCell(Cell cell){
        this.cell = cell;
    }
    public Integer getCounter(){
        return counter;
    }
    public void setCounter(int counter){
        this.counter = counter;
    }
    public Cell getCell(){
        return cell;
    }
    public void setCellValue(String value){
        cell.value = value;
    }
}
