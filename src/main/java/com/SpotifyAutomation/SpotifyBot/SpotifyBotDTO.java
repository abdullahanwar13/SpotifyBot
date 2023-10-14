package com.SpotifyAutomation.SpotifyBot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SpotifyBotDTO {
    private String[] albumLinks;
    private String timeDurationForEachAlbum;
    private String timeDurationForEachSong;
    private String spotifyLoginUsername;
    private String spotifyLoginPassword;
}
