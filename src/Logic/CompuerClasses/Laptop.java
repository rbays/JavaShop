package Logic.CompuerClasses;

/**
 * Created by student on 01-Jul-16.
 */
public class Laptop extends Computer{
    int screenSize;
    LaptopType type;

    public int getScreenSize() {
        return screenSize;
    }
    public LaptopType getType() {
        return type;
    }

    public Laptop(CPUType cpu, int ramGb, int hddSizeGb, String make, Double price, GPUType gpu, int screenSize, LaptopType type) {
        super(cpu, ramGb, hddSizeGb, make, price, gpu);
        this.screenSize = screenSize;
        this.type = type;
    }
}
