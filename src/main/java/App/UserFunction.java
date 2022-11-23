package App;
import java.sql.SQLException;
import java.util.Scanner;

import JukeboxException.Jukeboxexception;
import dao.*;
import entity.User;

public class UserFunction {
    UserdaoInterface udi = new Userdao();
    Scanner sc = new Scanner(System.in);
    int ui;

    public void userFunc() throws SQLException, ClassNotFoundException, Jukeboxexception {
        do{
                System.out.println("1.   Create New USer ");
                System.out.println("2.   Check User Details ");
                System.out.println("3.   Delete user Details ");
                System.out.println("4.   Update User Details ");
                System.out.println("5.   For EXIT");
                ui = sc.nextInt();

                if (ui <= 0 || ui > 5 )
                {
                    System.out.println("Please Enter Between 1 - 5");
                }

                switch (ui) {
                    case 1: {
                        System.out.println("Enter user Name");
                        String un = sc.next();
                        System.out.println("Create your password");
                        String pwd = sc.next();
                        int userId = udi.getUserId();
                        User u = new User(userId, un, pwd);
                        try {
                            udi.addUser(u);
                            System.out.println("User Added successful!!!!");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Enter Your user ID");
                        int ui = sc.nextInt();
                        System.out.println("Enter your password");
                        String pass = sc.next();
                        try {
                            udi.retrieveUser(ui, pass);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }

                        break;
                    }
                    case 3: {
                        String pwd = null;
                        System.out.println("Enter Your user ID");
                        int ui = sc.nextInt();
                        System.out.println("Enter your password");
                        String pass = sc.next();
                            pwd = udi.getUserInfo(ui);
                        if(pwd==null)
                        {
                            System.out.println("Enter a valid user ID \n");
                        }
                        else if(pwd.equals(pass)) {
                            try {
                                udi.deleteUser(ui, pass);
                                System.out.println("Record Deleted Successful !!!!!");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        else{
                            System.out.println("Enter valid password");
                            System.out.println();
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("please select the below options for update:");
                        System.out.println("1.      Change User Name");
                        System.out.println("2.      Change Password");
                        int ui = sc.nextInt();
                        switch (ui) {
                            case 1: {
                                System.out.println("Enter Your user ID");
                                int id = sc.nextInt();
                                System.out.println("Enter your password");
                                String pass = sc.next();
                                System.out.println("Enter your new user Name");
                                String un = sc.next();
                                try {
                                    udi.updateUserName(id, pass, un);
                                    System.out.println("User Name updated Successfully");
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 2: {
                                String pwd;
                                System.out.println("Enter Your user ID");
                                int id = sc.nextInt();
                                System.out.println("Enter your Password");
                                String pass = sc.next();
                                System.out.println("Enter your new Password");
                                String newPass = sc.next();
                                pwd = udi.getUserInfo(id);
                                if(pwd==null)
                                {
                                    System.out.println("Enter a valid user ID \n");
                                }
                                else if(pwd.equals(pass)) {
                                    try {
                                        udi.updateUserPassword(id, pass, newPass);
                                        System.out.println("Password updated successfully !!!");
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                                else {
                                    System.out.println("Enter valid password");
                                    System.out.println();
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
        }while(ui !=5);
    }
}
