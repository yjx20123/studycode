public enum meiju {
    first(1, 2),
    second(1, 2);

    meiju() {
    }

    meiju(int id, int age) {
        this.id = id;
        this.age = age;
    }

    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
