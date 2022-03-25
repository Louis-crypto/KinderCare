package com.moringaschool.kindercare;

public class VaccineModel {
    private int id;
    private String vaccineName;
    private String description;
    private int doses;
    private String ageLimit;
    private boolean isAvailable;

    public VaccineModel(int id, String vaccineName, String description, int doses, String ageLimit, boolean isAvailable) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.description = description;
        this.doses = doses;
        this.ageLimit = ageLimit;
        this.isAvailable = isAvailable;
    }

    public VaccineModel() {
    }

    public VaccineModel(String vaccineName, String vaccineDescription, Integer vaccineDoses, String vaccineAgeLimit, boolean vaccineAvailability) {
    }

    @Override
    public String toString() {
        return "VaccineModel{" +
                "id=" + id +
                ", vaccineName='" + vaccineName + '\'' +
                ", description='" + description + '\'' +
                ", doses=" + doses +
                ", ageLimit=" + ageLimit +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
