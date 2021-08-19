package worker;

import exceptions.InvalidWorkerFieldException;

public class OrdinaryCoordinates extends DefaultCoordinates {
    //x не может быть null
    //Максимальное значение y: 241

    @Override
    public void setX(Double x){
        if(x == null) throw new InvalidWorkerFieldException();
        this.x = x;
    }

    @Override
    public void setY(float y){
        if(y > 241) throw new InvalidWorkerFieldException();
        this.y = y;
    }
}
