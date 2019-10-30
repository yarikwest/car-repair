package pl.coderslab.model;

import java.sql.Date;

public class Order {
    private int id;
    private Date acceptRepair;
    private Date planStartRepair;
    private Date startRepair;
    private Date endRepair;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private double costOfRepair;
    private double costOfParts;
    private double costOfWorkHour;
    private double numberWorkHour;

    public Order() {
    }

    public Order(Date acceptRepair, Date planStartRepair, Date startRepair, Date endRepair, Employee employee
            , String problemDescription, String repairDescription, Status status, Vehicle vehicle, double costOfRepair
            , double costOfParts, double costOfWorkHour, double numberWorkHour) {
        this.acceptRepair = acceptRepair;
        this.planStartRepair = planStartRepair;
        this.startRepair = startRepair;
        this.endRepair = endRepair;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.costOfRepair = costOfRepair;
        this.costOfParts = costOfParts;
        this.costOfWorkHour = costOfWorkHour;
        this.numberWorkHour = numberWorkHour;
    }

    public Order(int id, Date acceptRepair, Date planStartRepair, Date startRepair, Date endRepair, Employee employee
            , String problemDescription, String repairDescription, Status status, Vehicle vehicle, double costOfRepair
            , double costOfParts, double costOfWorkHour, double numberWorkHour) {
        this.id = id;
        this.acceptRepair = acceptRepair;
        this.planStartRepair = planStartRepair;
        this.startRepair = startRepair;
        this.endRepair = endRepair;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.costOfRepair = costOfRepair;
        this.costOfParts = costOfParts;
        this.costOfWorkHour = costOfWorkHour;
        this.numberWorkHour = numberWorkHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAcceptRepair() {
        return acceptRepair;
    }

    public void setAcceptRepair(Date acceptRepair) {
        this.acceptRepair = acceptRepair;
    }

    public Date getPlanStartRepair() {
        return planStartRepair;
    }

    public void setPlanStartRepair(Date planStartRepair) {
        this.planStartRepair = planStartRepair;
    }

    public Date getStartRepair() {
        return startRepair;
    }

    public void setStartRepair(Date startRepair) {
        this.startRepair = startRepair;
    }

    public Date getEndRepair() {
        return endRepair;
    }

    public void setEndRepair(Date endRepair) {
        this.endRepair = endRepair;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getCostOfRepair() {
        return costOfRepair;
    }

    public void setCostOfRepair(double costOfRepair) {
        this.costOfRepair = costOfRepair;
    }

    public double getCostOfParts() {
        return costOfParts;
    }

    public void setCostOfParts(double costOfParts) {
        this.costOfParts = costOfParts;
    }

    public double getCostOfWorkHour() {
        return costOfWorkHour;
    }

    public void setCostOfWorkHour(double costOfWorkHour) {
        this.costOfWorkHour = costOfWorkHour;
    }

    public double getNumberWorkHour() {
        return numberWorkHour;
    }

    public void setNumberWorkHour(double numberWorkHour) {
        this.numberWorkHour = numberWorkHour;
    }
}
