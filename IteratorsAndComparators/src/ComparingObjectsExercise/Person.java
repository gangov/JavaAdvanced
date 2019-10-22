package ComparingObjectsExercise;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.compareTo(other.getName()) == 0) {
            if (this.age == other.getAge()) {
                return this.town.compareTo(other.getTown());
            }
            return Integer.compare(this.age, other.getAge());
        }
        return this.name.compareTo(other.getName());
    }
}
