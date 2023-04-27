package com.integrador.micropackage.DTO;

import com.integrador.micropackage.Module.TypePackage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PackageDTO {
    private Integer dni;
    private TypePackage typePackage;
    private String weight;
    private Double declaredValue;
}
