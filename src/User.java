public class User {

    private final String username;

    private final String password;

    private String id;

    public User(String username, String password, String id){

        this.username = username;
        this.password = password;
        this.id = id;
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


}
