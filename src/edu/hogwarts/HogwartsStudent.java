package edu.hogwarts;

public class HogwartsStudent extends Student implements HogwartsPerson {

    private String house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(int enrollmentYear, int graduationYear, String firstName, String middleName, String lastName, String house, boolean prefect, String[] teams) {
        super(enrollmentYear, graduationYear, firstName, middleName, lastName);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent() {};

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    public House linkToHouse() {
        return new House(house, "Unknown Founder", new String[]{});
    }


    public void study() {
        System.out.println(getFullName() + " is studying.");
    }
}