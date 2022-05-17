package Dao;

import models.Department;
import models.Users;

import java.util.List;

public interface UsersDao {


    List<Users> getAll();

//    Create
    void add(Users user);
    void addUserToDepartment(Users user, Department department);

//    Read
    Users findById(int id);

//    Delete
    void deleteById(int id);
    void clearAllUsers();


}
