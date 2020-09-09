package itf;

import model.Award;

public interface IAward
{
    public void add(int awno);
    public void delete(Award aw);
    public void update(int col,String s);
}
