package itf;

import model.Discount;

public interface IDiscount
{
    public void add(int dno);
    public void delete(Discount d);
    public void update(int col,String s);
}
