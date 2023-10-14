package com.SpotifyAutomation.SpotifyBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/spotify")
public class SpotifyBotController {

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("Service is up", HttpStatus.OK);
    }
    private final SpotifyBotService spotifyBotService;

    @Autowired
    public SpotifyBotController(SpotifyBotService spotifyBotService) {
        this.spotifyBotService = spotifyBotService;
    }
    @PostMapping("/runAutomation")
    public ResponseEntity<String> runAutomation(@RequestBody SpotifyBotDTO spotifyBotDTO){
        ResponseEntity<String> response = new ResponseEntity<>("Request received, processing in progress", HttpStatus.OK);

        CompletableFuture.runAsync(() -> {
            try {
                spotifyBotService.runSpotifyAutomation(spotifyBotDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return response;
    }
}
