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