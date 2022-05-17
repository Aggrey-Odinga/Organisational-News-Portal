package Dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao{

    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public List<News> getAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news").executeAndFetch(News.class);
        }
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (name, author, description) VALUES (:name, :author, :description)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sql,true).bind(news).executeUpdate().getKey();
            news.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public News findById(int id) {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news WHERE id = :id").addParameter("id", id).executeAndFetchFirst(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id";
        try (Connection connection = sql2o.open()) {
            connection.createQuery(sql).addParameter("id", id).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from news";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
