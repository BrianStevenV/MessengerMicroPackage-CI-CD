package com.integrador.micropackage.Repository;

import org.springframework.data.repository.CrudRepository;
import com.integrador.micropackage.Module.Package;

public interface PackageRepository extends CrudRepository<Package, String> {
}
