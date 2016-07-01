package Logic;

import Logic.CompuerClasses.*;

/**
 * Created by student on 01-Jul-16.
 */
public class ComputerSample {
    public Computer comp1 = new Laptop(CPUType.INTEL,8,500,"Dell",800.00, GPUType.GTX970,20, LaptopType.POWERBOOK);
    public Computer comp2 = new DeskTop(CPUType.INTEL,16,2000,"Dell",850.00,GPUType.GTX1070,"Mechanical", "Optical", Tower.FULL);
    public Computer comp3 = new DeskTop(CPUType.INTEL,4,250,"Dell",350.00,GPUType.GTX970,"Membrane","Roller", Tower.MID);
    public Computer comp4 = new Laptop(CPUType.AMD,16,250,"Asus",600.00,GPUType.R7370,18,LaptopType.ULTRABOOK);
}
