package Logic.CompuerClasses;

/**
 * Created by student on 01-Jul-16.
 */
public abstract class Computer {

    //computer parts declaration
    CPUType cpu;
    int ramGb;
    int hddSizeGb;
    String make;
    Double price;
    GPUType gpu;

    Boolean sold = false;

    //getters for all
    public CPUType getCpu() {
        return cpu;
    }
    public int getRamGb() {
        return ramGb;
    }
    public int getHddSizeGb() {
        return hddSizeGb;
    }
    public String getMake() {
        return make;
    }
    public Double getPrice() {
        return price;
    }
    public GPUType getGpu() {
        return gpu;
    }
    public Boolean getSold() {
        return sold;
    }

    //price setter
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setSold(Boolean sold) {
        this.sold = sold;
    }


    public Computer(CPUType cpu, int ramGb, int hddSizeGb, String make, Double price, GPUType gpu) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.hddSizeGb = hddSizeGb;
        this.make = make;
        this.price = price;
        this.gpu = gpu;
    }
}


