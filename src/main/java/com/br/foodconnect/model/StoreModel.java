package com.br.foodconnect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store")
public class StoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpnj;
    private Boolean isEnabled;
    private String FoodCourt;

    public StoreModel(Long id, String name, String cpnj, Boolean isEnabled, String foodCourt) {
        this.id = id;
        this.name = name;
        this.cpnj = cpnj;
        this.isEnabled = isEnabled;
        FoodCourt = foodCourt;
    }

    public StoreModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public String getFoodCourt() {
        return FoodCourt;
    }

    public void setFoodCourt(String foodCourt) {
        FoodCourt = foodCourt;
    }
}
