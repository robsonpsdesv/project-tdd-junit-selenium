package com.tdd.spring;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationViewTests {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "/home/binps/Documents/Faculdade/faculdade-8-periodo/TDD/N2/04/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/produto/novo");
        WebElement produtoDescricao = driver.findElement(By.name("descricao"));
        produtoDescricao.sendKeys("Notebook");
        WebElement valorUnitario = driver.findElement(By.name("valorUnitario"));
        valorUnitario.sendKeys("555.00");
        WebElement submit = driver.findElement(By.name("enviar"));
        submit.submit();

        boolean consulta = driver.getPageSource().contains("descricao");

        Assert.assertTrue(consulta);

    }

}
