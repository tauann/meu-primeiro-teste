package tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class SignTest {

    @Test
    fun testFazerLoginNoTaskit() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe")
        val navegador: WebDriver = ChromeDriver()
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))

        navegador.get("http://www.juliodelima.com.br/taskit")

        navegador.findElement(By.linkText("Sign in")).click()
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("teste1403")
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("teste1403")
        navegador.findElement(By.linkText("SIGN IN")).click()
        val saudacao: String = navegador.findElement(By.className("me")).text

        assertEquals("Hi, teste1403", saudacao)

        navegador.quit()
    }
}