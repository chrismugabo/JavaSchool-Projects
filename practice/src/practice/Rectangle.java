package practice;

public class Rectangle
{
    public Rectangle( double len, double wid )
    {
        length = len; width = wid;
    }
     
    public double area( )
    {
        return length * width;
    }
    
    public double perimeter( )
    {
        return 2 * ( length + width );
    }
    
    public String toString( )
    {
        return "Rectangle: " + length + " " + width;
    }
    
    public double getLength( )
    {
        return length;
    }
    
    public double getWidth( )
    {
        return width;
    }

   public boolean equals(Object rhs) {
       if(!(rhs instanceof Rectangle))
    	   return false;
       Rectangle rhRectangle=(Rectangle) rhs;
       return (rhRectangle.length== length && rhRectangle.width== width);
    }
    

    private double length;
    private double width;
}