package itf;

import model.Order;

public interface IOrder
{
    public void add(int ono);
    public void delete(Order o);
    public void update(int col,String s);

    
}
