public class Main {
    public static void main(String[] args) {

        //The background music
        SoundInput.runMusic("SoundTrack/music.wav");

        UserMenu userMenu = new UserMenu();
        userMenu.setupUserMenu();
    }
}