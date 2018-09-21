
package data;


public class CupCake {
    private String name;
    private Top top;
    private Bottom bottom;
    private int fullPrice;

    public CupCake(Top top, Bottom bottom) {
        this.top = top;
        this.bottom = bottom;
        this.name = bottom.getName().substring(0, 2) + top.getName().substring(0, 2);
        this.fullPrice = bottom.getPrice() + top.getPrice();
    }

    public String getName() {
        return name;
    }

    public Top getTop() {
        return top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public int getFullPrice() {
        return fullPrice;
    }
    
    
    
    
}
