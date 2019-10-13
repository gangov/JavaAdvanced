package GoogleExercise;

public class Parent {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }


    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getBirthday());
    }
}
