package com.SpotifyAutomation.SpotifyBot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotifyBotService {
    static WebDriver driver;

    public void runSpotifyAutomation(SpotifyBotDTO spotifyBotDTO) {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        // Initialize the ChromeDriver


        try {
            driver.manage().window().maximize();
            // Navigate to a URL
            driver.get("https://open.spotify.com");

            performLogin(spotifyBotDTO.getSpotifyLoginUsername(), spotifyBotDTO.getSpotifyLoginPassword());

//            String[] albumLinks = spotifyBotDTO.getAlbumLinks();

            String[] albumLinks = {"https://open.spotify.com/artist/2NkEXPNPJyiuIRnO9oTvnY","",""};
            for (String albumLink : albumLinks) {
                playAlbum(driver, albumLink);
            }

            // Perform some tasks (replace this with your specific tasks)
            // For example, printing the title of the page
            System.out.println("Page Title: " + driver.getTitle());

            // Add more tasks as needed

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Close the browser window
            driver.quit();
        }
    }
    public static void performLogin(String email, String pwd) throws InterruptedException {
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.cssSelector("[data-testid='login-button']"));
        login.click();

        Thread.sleep(1000);
        WebElement emailField = driver.findElement(By.cssSelector("[data-testid='login-username']"));

// Click on the Enter Email and enter email address
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

        Thread.sleep(1000);
        WebElement pwdField = driver.findElement(By.cssSelector("[data-testid='login-password']"));

// Click on the Enter Password and enter pwd
        pwdField.click();
        pwdField.clear();
        pwdField.sendKeys(pwd);

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.cssSelector("[data-testid='login-button']"));

// Click on the login button
        loginButton.click();
    }
    private void playAlbum(WebDriver driver, String albumLink) throws InterruptedException {
        // Navigate to the album link
        Thread.sleep(5000);
        driver.get(albumLink);

        // Calculate the time left for the total album playback
        long remainingAlbumTime = 3600;

        List<WebElement> songs = driver.findElements(By.cssSelector("[data-testid='play-button']"));
        Thread.sleep(1000);
        WebElement song = songs.get(1);

        // Calculate the time to play the current song
        long songPlaybackTime = Math.min(5, remainingAlbumTime);

        // Play the current song
        playSong(song);
        sleepInSeconds((int) songPlaybackTime);

        // Initialize elapsed time and specify total playback time
        long elapsedTime = 0;
        long totalAlbumPlaybackTime = 300;  // 1 hour in seconds

        while (elapsedTime < totalAlbumPlaybackTime) {
            // Calculate the time to shuffle to the next song (every 45 seconds)
            long shuffleTime = Math.min(48, totalAlbumPlaybackTime - elapsedTime);
            sleepInSeconds((int) shuffleTime);

            // Find and shuffle to the next song
            WebElement nextSongButton = driver.findElement(By.cssSelector("[data-testid='control-button-skip-forward']"));
            shuffleSong(nextSongButton);

            // Update elapsed time
            elapsedTime += shuffleTime;
        }

        // Return or perform any cleanup after playing for an hour
        System.out.println("Album played for an hour. Returning from the method.");
    }

    private void shuffleSong(WebElement nextSong){
        nextSong.click();
    }
    private void playSong(WebElement song) {
        // Click on the song element to play it
        song.click();
    }

    private void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
