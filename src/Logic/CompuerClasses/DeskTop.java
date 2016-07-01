package Logic.CompuerClasses;

/**
 * Created by student on 01-Jul-16.
 */
public class DeskTop extends Computer{

    String keyboard;
    String mouse;
    Tower tower;

    public String getKeyboard() {
        return keyboard;
    }
    public String getMouse() {
        return mouse;
    }
    public Tower getTower() {
        return tower;
    }

    public DeskTop(CPUType cpu, int ramGb, int hddSizeGb, String make, Double price, GPUType gpu, String keyboard, String mouse, Tower tower) {
        super(cpu, ramGb, hddSizeGb, make, price, gpu);
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.tower = tower;
    }
}
