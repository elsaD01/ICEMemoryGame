public class User {

    private final String username;

    private final String password;

    private final String id;

    private int highscore;

    public User(String username, String password, String id, int highscore){

        this.username = username;
        this.password = password;
        this.id = id;
        this.highscore = highscore;
    }

    public String getUsername(){

        return username;
    }

    public String getPassword(){

        return password;
    }

    public String getId(){

        return id;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getHighscore() {
        return highscore;


    }


}
