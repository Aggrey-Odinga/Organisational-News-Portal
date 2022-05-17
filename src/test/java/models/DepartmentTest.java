package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void instantiatesDepartmentObjectsCorrectly_true(){
        Department departments = new Department();
        assertTrue(departments instanceof Department);
    }

    @Test
    public void getNameOfDepartmentReturnsCorrectly_String() {
        Department departments = new Department();
        departments.setName("Human Resource");
        assertEquals("Human Resource", departments.getName());
    }

    @Test
    public void setDepartmentNameSetsCorrectly_String() {
        Department departments = new Department();
        departments.setName("Transport");
        assertNotEquals("Security", departments.getName());
    }

    @Test
    public void getEmployeesReturnsCorrectly_String() {
        Department departments = new Department();
        departments.setEmployees("Griffin");
        assertEquals("Griffin", departments.getEmployees());
    }

    @Test
    public void setEmployeesNameReturnsCorrectly_String() {
        Department departments = new Department();
        departments.setEmployees("Ryan");
        assertNotEquals("Griffin", departments.getEmployees());
    }

    @Test
    public void getDepartmentDescriptionReturnsCorrectly_String() {
        Department departments = new Department();
        departments.setDescription("Finance");
        assertEquals("Finance", departments.getDescription());
    }

    @Test
    public void setDescriptionCorrectlySetsDescription_String() {
        Department departments = new Department();
        departments.setDescription("Dining");
        assertEquals("Dining", departments.getDescription());
    }


}