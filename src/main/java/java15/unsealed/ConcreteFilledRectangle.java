package java15.unsealed;

import java15.sealed.FilledRectangle;

public class ConcreteFilledRectangle extends FilledRectangle {
    public ConcreteFilledRectangle(double red,double green,double blue, double length, double width){
        super(red,green,blue,length, width);
        System.out.println("ConcreteFilledRectangle");
    }

    @Override
    public String toString() {
        return "ConcreteFilledRectangle{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
