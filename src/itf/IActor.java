package itf;

import model.Actor;

public interface IActor
{
    public void add(int acno);
    public void delete(Actor s);
    public void update(int col,String s);
}
