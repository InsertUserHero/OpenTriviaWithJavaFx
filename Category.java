/**
 * This object holds the info of 1 category
 * used in Trivia as a list of categories.
 */
public class Category {
    String name;
    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "\"trivia_categories\":[{\n" +
                "id: " + id + " name " + name;
    }
}
