package Dao;

import models.Department;
import models.Users;
import org.eclipse.jetty.server.Authentication;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {
    private static Sql2oUsersDao usersDao;
    private static Sql2oDepartmentDao departmentDao;
    private static Connection connection;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "root");
        usersDao = new Sql2oUsersDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllGetsAllUsers() {
        Users users = new Users();
        Users users1 = new Users();
        Users users2 = new Users();
        usersDao.add(users);
        usersDao.add(users1);
        usersDao.add(users2);
        assertEquals(3, usersDao.getAll().size());

    }

    @Test
    public void add() {
    }

    @Test
    public void addUserToDepartmentAddsCorrectly() {
        Department department = new Department();
        departmentDao.add(department);
        Users testUser = new Users();
        usersDao.add(testUser);
        usersDao.addUserToDepartment(testUser, department);
        List<Users> users = departmentDao.getAllDepartmentUsers(department.getId());
        assertEquals(1, users.size());
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteById() {
        Users users = new Users("Greg", "Transport", "Human Resource");
        usersDao.add(users);
        usersDao.deleteById(users.getId());
        assertEquals(0, usersDao.getAll().size());
    }

    @Test
    public void clearAllUsersClearsAll() {
        Users users = new Users();
        Users users1 = new Users();
        usersDao.add(users);
        usersDao.add(users1);
        int daoSize = usersDao.getAll().size();
        usersDao.clearAllUsers();
        assertTrue(daoSize > 0 && daoSize > usersDao.getAll().size());
    }
}