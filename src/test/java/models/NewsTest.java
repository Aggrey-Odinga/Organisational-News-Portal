package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNewsNameReturnsCorrectly_String() {
        News news = new News();
        news.setName("General");
        assertEquals("General", news.getName());
    }

    @Test
    public void setNewsNameSetsCorrectName() {
        News news = new News();
        news.setName("Holiday");
        assertNotEquals("Time management", news.getName());
    }

    @Test
    public void getAuthorReturnsCorrectly_String() {
        News news = new News();
        news.setAuthor("Wajakoya");
        assertNotEquals("Kalonzo", news.getAuthor());
    }

    @Test
    public void setAuthorSetsAuthorCorrectly_String() {
        News news = new News();
        news.setAuthor("GREG");
        assertNotEquals("TORY", news.getAuthor());
    }

    @Test
    public void getNewsDescriptionReturnsCorrectly_String() {
        News news = new News();
        news.setDescription("Service Equity");
        assertEquals("Service Equity", news.getDescription());
    }

    @Test
    public void setNewsDescriptionSetsCorrectly_String() {
        News news = new News();
        news.setDescription("Products Viability");
        assertNotEquals("product preference", news.getDescription());
    }
}