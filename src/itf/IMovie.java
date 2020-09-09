package itf;

import model.Movie;
import model.Staff;

public interface IMovie
{
    public void add(int mno);
    public void delete(Movie m);
    public void update(int col,String s);
}
