package java15.sealed;

/**
 * Sealed class must have subclass.
 */
public sealed class Shape permits Circle,Square,Rectangle{
    public double side;
    public Shape(){
        System.out.println("Shape");
    }
}
