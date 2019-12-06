package com.tdd.spring;

import com.tdd.spring.service.ProdutoService;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class ApplicationViewTests {


//    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/carrinho";

    static final String USER = "postgres";
    static final String PASS = "postgres";


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "/home/robsonsilva/Documents/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/produto/novo");
        WebElement produtoDescricao = driver.findElement(By.name("descricao"));
        produtoDescricao.sendKeys("Monitor");
//        WebElement valorUnitario = driver.findElement(By.name("valorUnitario"));
//        valorUnitario.sendKeys("555.00");
        WebElement submit = driver.findElement(By.name("enviar"));
        submit.submit();

        boolean consulta = driver.getPageSource().contains("descricao");
        Assert.assertTrue(consulta);

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Conectando ao banco de dados");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Conexão com banco de dados realizada com sucesso!");
            stmt = conn.createStatement();
            String sql = "SELECT id, descricao FROM produto ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");

                System.out.println("ID: " + id);
                System.out.println("Descrição: " + descricao);
            }

            rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Goodbye!");

        }

    }
}
