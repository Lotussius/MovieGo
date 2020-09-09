package control;

import itf.IUser;
import model.*;
import util.BaseException;
import util.DBPool;
import util.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User_Manager implements IUser
{
    DBPool dbPool=new DBPool();

    public void add(int uno) throws BaseException
    {

    }

     public void delete(User u) throws BaseException
    {

    }

     public void update(int col,String s) throws BaseException //将第col列内容修改为s
    {

        Connection conn=null;

        try
        {
            conn=dbPool.getConnection();
            PreparedStatement pst=null;
            String sql=null;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            switch (col)
            {
                case 0:throw new BaseException("NO. can't be altered");
                case 1:sql="update User set uname=? where uno=?";pst=conn.prepareStatement(sql);pst.setString(1,s);break;
                case 2:
                    if(!(s.equals("male")) || !(s.equals("male"))) //性别输入格式错误
                        throw new BaseException("please enter \"male\" or \"female\"";
                    sql="update User set usex=? where uno=?";pst=conn.prepareStatement(sql);pst.setInt(1,s.equals("female")?0:1);break;//female为0，male为1
                case 3:sql="update User set upwd=? where uno=?";pst=conn.prepareStatement(sql);pst.setString(1,s);break;
                case 4:sql="update User set utel=? where uno=?";pst=conn.prepareStatement(sql);pst.setString(1,s);break;
                case 5:sql="update User set umail=? where uno=?";pst=conn.prepareStatement(sql);pst.setString(1,s);break;
                case 6:sql="update User set ucity=? where uno=?";pst=conn.prepareStatement(sql);pst.setString(1,s);break;
                case 7:sql="update User set udate=? where uno=?";pst=conn.prepareStatement(sql);pst.setTimestamp(1, new Timestamp(sdf.parse(s).getTime()));break;
            }

            pst.setInt(2,User.currUser.uno);

        }

        catch(SQLException ex)
        {
            ex.printStackTrace();
            throw new DbException(ex);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            throw new BaseException("wrong date format");
        }
        finally
        {
            if(conn!=null)
                try {
                    conn.rollback();
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return;

    }

    public void alter_pwd(String old,String new1,String new2) throws BaseException
    {
        if(!(new1.equals(new2)))    //密码不一致
            throw new BaseException("password inconsistency");

        Connection conn=null;

        try
        {
            conn=dbPool.getConnection();

            String sql="select * from User where uno=? and upwd=?"; //验证旧密码
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setInt(1,User.currUser.uno);
            pst.setString(2,old);
            if(!pst.execute())  //密码错误
                throw new BaseException("wrong password");

            sql="update User set upwd=? where uno=";    //更新密码
            pst=conn.prepareStatement(sql);
            pst.setString(1,new1);
            pst.setInt(2,User.currUser.uno);
            pst.execute();

            pst.close();
            conn.close();
            System.out.println("password updating success");

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            throw new DbException(ex);
        }
        finally
        {
            if(conn!=null)
                try {
                    conn.rollback();
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return;
    }


}
