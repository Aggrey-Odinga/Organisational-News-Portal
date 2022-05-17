import Dao.Sql2oDepartmentDao;
import Dao.Sql2oNewsDao;
import Dao.Sql2oUsersDao;
import com.google.gson.Gson;
import models.Department;
import models.News;
import models.Users;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oUsersDao usersDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
//        String connectionString = "jdbc: h2:~/news_portal.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "root");


        departmentDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);

        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            usersDao.add(users);
            res.status(201);
            return gson.toJson(users);
        });

        get("/users", "application/json", (req, res) -> {
            res.header("Content-Type", "application/json");
            return gson.toJson(usersDao.getAll());
        });

        get("/users/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int userId = Integer.parseInt(req.params("id"));
            return gson.toJson(usersDao.findById(userId));
        });

        post("/department/new", "application/json", (req,res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
        get("/department", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });
        get("/department/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDao.findById(departmentId));
        });
        post("/news/new", "application/json", (req,res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });
        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            return gson.toJson(newsDao.getAll());//send it back to be displayed
        });

        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            return gson.toJson(newsDao.findById(departmentId));
        });
        post("/department/:departmentId/users/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Users user = gson.fromJson(req.body(), Users.class);

            user.setId(departmentId); //we need to set this separately because it comes from our route, not our JSON input.
            usersDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });





    }
}
