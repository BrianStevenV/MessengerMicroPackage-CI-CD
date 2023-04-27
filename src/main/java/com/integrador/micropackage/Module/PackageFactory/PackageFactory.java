package com.integrador.micropackage.Module.PackageFactory;

import com.integrador.micropackage.Module.TypePackage;

public interface PackageFactory {
    public Package createPackage(Integer dni, TypePackage typePackage, Double weight, Double declaredValue);
}
