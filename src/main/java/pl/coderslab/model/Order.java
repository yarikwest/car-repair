package pl.coderslab.model;

import java.sql.Date;

public class Order {
    private int id;
    private Date acceptRepair;
    private Date planStartRepair;
    private Date startRepair;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private int statusId;
    private int vehicleId;
    private double costOfRepair;
    private double costOfParts;
    private double costOfWorkHour;
    private double numberWorkHour;

    public Order() {
    }

    public Order(Date acceptRepair, Date planStartRepair, Date startRepair, int employeeId
            , String problemDescription, String repairDescription, int statusId, int vehicleId, double costOfRepair
            , double costOfParts, double costOfWorkHour, double numberWorkHour) {
        this.acceptRepair = acceptRepair;
        this.planStartRepair = planStartRepair;
        this.startRepair = startRepair;
        this.employeeId = employeeId;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.statusId = statusId;
        this.vehicleId = vehicleId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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
