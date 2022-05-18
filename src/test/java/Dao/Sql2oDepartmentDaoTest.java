package Dao;

import models.Department;
import models.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oUsersDao usersDao;
    private static Connection connection;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "root");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAllDepartment();
    }

    @Test
    public void getAllGetsAllDepartments() {
        Department department = new Department();
        Department department1 = new Department();
        departmentDao.add(department);
        departmentDao.add(department1);
        assertEquals(2, departmentDao.getAll().size());
    }

    @Test
    public void getAllDepartmentUsersReturnsCorrectly() {
        Users users = new Users();
        usersDao.add(users);
        Users users1 = new Users("Griffin", "HR", "Manager");
        usersDao.add(users1);
        Department department = new Department();
        departmentDao.add(department);
    }

    @Test
    public void add() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAllDepartment() {
    }
}