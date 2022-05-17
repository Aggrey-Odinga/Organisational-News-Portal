package Dao;

import models.Department;
import models.Users;

import java.util.List;

public interface DepartmentDao {
//    List
    List<Department> getAll();
    List<Users> getAllDepartmentUsers(int departmentId);

//    Create
    void add(Department department);

//    Read
    Department findById(int id);

//    Delete
    void deleteById(int id);
    void clearAllDepartment();
}
