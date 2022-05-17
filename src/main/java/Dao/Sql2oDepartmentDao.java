package Dao;

import models.Department;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{

    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public List<Department> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM department").executeAndFetch(Department.class);
        }
    }

    @Override
    public List<Users> getAllDepartmentUsers(int departmentId) {
        ArrayList<Users> users = new ArrayList<>();

        String joinQuery = "SELECT userId FROM department_users WHERE departmentId = :departmentId";

        try (Connection con = sql2o.open()) {
            List<Integer> allUsersIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer userId : allUsersIds) {
                String userQuery = "SELECT * FROM users WHERE id = :userId";
                users.add(
                        con.createQuery(userQuery)
                                .addParameter("userId", userId)
                                .executeAndFetchFirst(Users.class));
            }
        }catch (Sql2oException ex){
                System.out.println(ex);
            }

            return users;

    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (name, description, employees) VALUES (:name, :description, :employees)";

        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(department).executeUpdate().getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Department findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM department WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from department WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllDepartment() {
        String sql = "DELETE from department";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
