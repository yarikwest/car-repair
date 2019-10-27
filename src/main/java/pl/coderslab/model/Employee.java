package pl.coderslab.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private String note;
    private double costOfWorkHour;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String address, String telephone, String note, double costOfWorkHour) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
        this.note = note;
        this.costOfWorkHour = costOfWorkHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getCostOfWorkHour() {
        return costOfWorkHour;
    }

    public void setCostOfWorkHour(double costOfWorkHour) {
        this.costOfWorkHour = costOfWorkHour;
    }
}
