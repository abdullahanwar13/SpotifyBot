# SpotifyBot
Elevate your Spotify experience with this specialized automation tool designed explicitly for Chrome Browser. Say goodbye to manual playlist management and enjoy uninterrupted music playback effortlessly.

Spotify Automation Tool with Chrome Driver and API Flexibility
Take command of your Spotify experience with our innovative automation tool developed on Java Spring Boot. Built for Chrome, 
This tool lets you precisely control your Spotify playlist via API calls.
Tailor the playtime for each album and individual songs, ensuring a personalized and uninterrupted listening journey.
The power of Java Spring Boot ensures robustness and efficiency, while Chrome Driver provides versatility.
This tool isn't just about automation; it's about customizing your Spotify adventure.
With integrated VPN support (on-demand), you can simulate listening sources from diverse regions, adding a dynamic layer to your experience. 
Effortlessly transition between albums, make API calls to adjust playtimes and enjoy Spotify in a way that suits your preferences. Explore the endless possibilities and elevate your Spotify experience today.

Features
Album Play Duration: Customize the playtime for each album, ensuring a precisely defined one-hour duration.

Song Play Duration: Navigate through individual songs within an album, with a minimum playtime of 45 seconds.

Rotation: Seamlessly switch between albums, creating a continuous and personalized listening experience.

API Flexibility: Set album playtime, song playtime, and album links via API calls, providing dynamic control.

VPN Integration: Simulate unique listening sources with integrated VPN support. Your listening source can appear from different regions or IP addresses.

Getting Started
Clone the repository.

bash
Copy code
git clone https://github.com/your-username/SpotifyAutomationTool.git
Build the project using Maven.

bash
Copy code
mvn clean install
Run the application.

bash
Copy code
java -jar target/spotify-automation-tool.jar
Access the tool via http://localhost:8080.

API Usage
bash
Copy code
curl -X POST http://localhost:8080/api/spotify/runAutomation -d '{
    "albumLinks": [
        "",
        "",
        ""
    ],
    "timeDurationForEachAlbum": "album duration",
    "timeDurationForEachSong": "song duration",
    "spotifyLoginUsername": "spotify-email",
    "spotifyLoginPassword": "spotify-password"
}'

License
This project is licensed under the MIT License.
