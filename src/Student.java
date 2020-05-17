
import store.MyConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Student 
{
public void insertUpdateDeleteStudent(char operation, Integer id,String fname ,String lname,String sex,
        String bdate,String phone,String address,String description) throws Exception 
{
   
        Connection con = MyConnection.getConnection();
    
    PreparedStatement ps;
    if(operation == 'i')
    {
            try {
                ps =con.prepareStatement("insert into student(first_name,last_name,sex,birthdate,phone,address,description) values (?,?,?,?,?,?,?)");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, bdate);
                ps.setString(5, phone);
                ps.setString(6, address);
                ps.setString(7, description);
                
               if(ps.executeUpdate()>0)
               {
                   System.out.println("New Patient Added");

               }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
             if(operation == 'u')
    {
            try {
                ps =con.prepareStatement("update student set first_name=?, last_name=?,sex=?,birthdate=?,phone=?,address=? where id=?");
                
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, bdate);
                ps.setString(5, phone);
                ps.setString(6, address);
                ps.setInt(7, id);
                
               if(ps.executeUpdate()>0)
               {
                   System.out.println("New Patient updated");

               }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(operation == 'd')
    {
            try {
                ps =con.prepareStatement("delete from student where  id=?");
                
                ps.setInt(1, id);
                
  
               if(ps.executeUpdate()>0)
               {
                   System.out.println("New Patient deleted");

               }
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
}
}
public void fillStudentJtable(JTable table,String valueToSearch) 
{
  
      
    
    PreparedStatement ps;
    try
    {
        Connection  con = MyConnection.getConnection();
        ps=con.prepareStatement("select * from student where concat('first_name','last_name','phone','address') like ?");
        ps.setString(1,"%"+ valueToSearch+"%");
    
    ResultSet rs = ps.executeQuery();
    DefaultTableModel model=(DefaultTableModel)table.getModel();
   Object[]row;
    while (rs.next())
        {        
          row = new Object[8];
          row[0]=rs.getInt(1);
          row[1]=rs.getString(2);
          row[2]=rs.getString(3);
          row[3]=rs.getString(4);
          row[4]=rs.getString(5);
          row[5]=rs.getString(6);
          row[6]=rs.getString(7);
          row[7]=rs.getString(8);
          model.addRow(row);
          
    }
  
    
    }
   catch(Exception ex)
   {
       System.out.println(ex.getMessage());
   }
    
    
}
public void deleteStudent(int id) throws Exception
{
    Connection con =MyConnection.getConnection();
    PreparedStatement ps;
    ps =con.prepareStatement("delete from student where id =?");
    ps.setInt(1, id);
   if(ps.executeUpdate()>0)
   {
       JOptionPane.showMessageDialog(null, "patient deleted");
   }
           
    
}
public  void updateStudent( Integer id,String fname ,String lname,String sex,
        String bdate,String phone,String address,String description) throws Exception
{
    Connection con =MyConnection.getConnection();
    PreparedStatement ps;
    ps =con.prepareStatement("update student set first_name=?,last_name=?,sex =?,birthdate=?,phone =?,address=?,description =? where id =?");
    ps.setString(1, fname);
    ps.setString(2, lname);
    ps.setString(3, sex);
    ps.setString(4, bdate);
    ps.setString(5, phone);
    ps.setString(6, address);
    ps.setString(7, description);
    ps.setInt(8, id);
    if(ps.executeUpdate()>0)
    {
         JOptionPane.showMessageDialog(null, "patient updated");
    }
    
}

public void fillStudentJtables(JTable table,String valueToSearch) 
{
  
      
    
    PreparedStatement ps;
    try
    {
        Connection  con = MyConnection.getConnection();
        ps=con.prepareStatement("select * from student where first_name  like ?");
        ps.setString(1,"%"+ valueToSearch+"%");
    
    ResultSet rs = ps.executeQuery();
    DefaultTableModel model=(DefaultTableModel)table.getModel();
   Object[]row;
    while (rs.next())
        {        
          row = new Object[8];
          row[0]=rs.getInt(1);
          row[1]=rs.getString(2);
          row[2]=rs.getString(3);
          row[3]=rs.getString(4);
          row[4]=rs.getString(5);
          row[5]=rs.getString(6);
          row[6]=rs.getString(7);
          row[7]=rs.getString(8);
          model.addRow(row);
          
    }
  
    
    }
   catch(Exception ex)
   {
       System.out.println(ex.getMessage());
   }
    
    
}
           
    
}

