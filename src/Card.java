

public class Card {
    public String picture;
    public String description;
    public boolean cardFlipped;

    public Card(String picture, String description){
        this.picture= picture;
        this.description=description;
        this.cardFlipped=false;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }
}
