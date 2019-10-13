package CatLadyExercise;

public abstract class Cat {
    private String name;
    private String breedType;
    private Double customParam;

    public String getName() {
        return name;
    }

    public String getBreedType() {
        return breedType;
    }

    public Double getCustomParam() {
        return customParam;
    }

    public Cat(String name, String breedType, Double customParam) {
        this.name = name;
        this.breedType = breedType;
        this.customParam = customParam;
    }

    public void Printer() {
        System.out.println(String.format("%s %s %.2f", this.getBreedType(), this.getName(), this.getCustomParam()));
    }
}

