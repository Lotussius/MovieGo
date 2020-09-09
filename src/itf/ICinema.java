package itf;

import model.Cinema;

public interface ICinema
{
    public void add(int cno);
    public void delete(Cinema c);
    public void update(int col,String s);
}
