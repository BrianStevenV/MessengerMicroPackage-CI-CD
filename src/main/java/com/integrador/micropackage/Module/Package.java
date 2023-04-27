package com.integrador.micropackage.Module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Package")
@ApiModel(description ="this model represent the Package data.")
public class Package implements Serializable {
    @ApiModelProperty(value = "ID Package", example ="XV563BH8")
    @Id
    @Column(name = "Id_Package")
    private String id;
    @ApiModelProperty(value = "Package type", example ="MEDIUM")
    @Column(name = "Type_Package")
    private TypePackage typePackage;
    @ApiModelProperty(value = "Weight", example ="3.0")
    @Column(name = "Weight")
    private Double weight;
    @ApiModelProperty(value = "Declared Value", example ="30000.0")
    @Column(name = "Declared_Value")
    private Double declaredValue;
}
