package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setUserIdSetsCorrectly_int() throws Exception {
        Users users = new Users();
        users.setId(4);
        assertNotEquals( 1, users.getId());
    }

    @Test
    public void getUserNameReturnsCorrectly_String() {
        Users users = new Users();
        users.setName("Greg");
        assertEquals("Greg", users.getName());
    }

    @Test
    public void setNameSetsCorrectUserName_String() {
        Users users = new Users();
        users.setName("Gray");
        assertNotEquals("Greg", users.getName());
    }

    @Test
    public void getUserDepartmentReturnsCorrectly_String() {
        Users users = new Users();
        users.setDepartment("HR");
        assertEquals("HR", users.getDepartment());
    }

    @Test
    public void setDepartmentSetsCorrectDepartment_String() {
        Users users = new Users();
        users.setDepartment("IT");
        assertEquals("IT", users.getDepartment());
    }

    @Test
    public void getUserRoleReturnsCorrectly_String() {
        Users users = new Users();
        users.setRole("Management");
        assertEquals("Management", users.getRole());
    }

    @Test
    public void setRoleSetsCorrectRole_String() {
        Users users = new Users();
        users.setRole("Transport");
        assertNotEquals("Management", users.getRole());
    }

}