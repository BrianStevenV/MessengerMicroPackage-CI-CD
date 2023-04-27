package com.integrador.micropackage.Module.PackageFactory;

import com.integrador.micropackage.Module.TypePackage;
import com.integrador.micropackage.Module.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageFactoryImp {
    public Package createPackageImp(String dni, TypePackage typePackage, Double weight, Double declaredValue){
        return new Package(dni, typePackage, weight, declaredValue);
    }
}
