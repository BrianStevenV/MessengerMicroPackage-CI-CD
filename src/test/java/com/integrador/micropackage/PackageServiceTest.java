package com.integrador.micropackage;

import com.integrador.micropackage.Module.TypePackage;
import com.integrador.micropackage.Repository.PackageRepository;
import com.integrador.micropackage.Service.PackageService;
import com.integrador.micropackage.Module.Package;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class PackageServiceTest {
    PackageRepository packageRepository;
    PackageService packageService;

    @Before
    public void SetUp(){
        this.packageRepository = mock(PackageRepository.class);
        this.packageService = new PackageService(packageRepository);
    }

    @Test
    public void validaCreatePackage(){
        Package package1 = new Package();
        package1.setWeight(5.0);
        Package service = packageService.createPackage(package1);
        assertNotNull(service);
    }

    @Test
    public void testCreatePackageGeneratesId() {
        Package pack = new Package();
        pack.setWeight(5.0);
        Package result = packageService.createPackage(pack);

        assertNotNull(result.getId());
        assertEquals(8, result.getId().length());
    }

    @Test
    public void testCreatePackageAssignsCorrectType() {
        Package pack = new Package();
        pack.setWeight(1.5);

        Package result = packageService.createPackage(pack);

        assertEquals(TypePackage.LIGHT, result.getTypePackage());
    }

    @Test
    public void testCreatePackageAssignsCorrectValue() {
        Package pack = new Package();
        pack.setWeight(4.0);

        Package result = packageService.createPackage(pack);

        assertEquals(Double.valueOf(40000.0), result.getDeclaredValue());
    }

}
