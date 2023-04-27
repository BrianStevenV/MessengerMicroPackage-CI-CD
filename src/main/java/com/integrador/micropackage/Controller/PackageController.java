package com.integrador.micropackage.Controller;

import com.integrador.micropackage.Repository.PackageRepository;
import com.integrador.micropackage.Service.PackageService;
import com.integrador.micropackage.Module.Package;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value="---", description = "This is controller to access the service of Package")
public class PackageController {
    private PackageService packageService;
    private PackageRepository packageRepository;

    @ApiResponses(value={
            @ApiResponse( code = 201, message = "created Package success."),
            @ApiResponse( code = 404, message = "Field incorrect, please you should input the weight."),
            @ApiResponse( code = 500, message ="That's an internal error."),
    })
    @ApiOperation(value="package", notes= "this create a Package and save in the database", response = Package.class)
    @PostMapping("/package")
    @ResponseStatus(HttpStatus.CREATED)
    public Package create(@ApiParam(value = "Package object", required = true) @RequestParam("weight") String weightStr){
        Double weight = Double.parseDouble(weightStr);
        Package pack = new Package();
        pack.setWeight(weight);
        return packageService.createPackage(pack);
    }

}
