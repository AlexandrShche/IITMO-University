package worker;

import exceptions.InvalidWorkerFieldException;

public class OrdinaryLocation extends DefaultLocation{
    //x не может быть null
    //name может быть null
    @Override
    public void setX(Double x){
        if(x == null) throw new InvalidWorkerFieldException();
        this.x = x;
    }
}
