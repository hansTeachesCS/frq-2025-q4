public class Cell {
    private int value;

    public Cell() {
        value = (int)(Math.random() * 9 + 1);
    }

    public int getFill() {
        return (int)(value*200/9);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        value = val;
    }
 
    public String toString() {
        return value + "";
    }
}
