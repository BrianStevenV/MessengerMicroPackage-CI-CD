package com.integrador.micropackage.Service;

import com.integrador.micropackage.Module.Package;
import com.integrador.micropackage.Module.TypePackage;
import com.integrador.micropackage.Repository.PackageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;
    private static final Double VALUE_LIGHT = 30000.0;
    private static final Double VALUE_MEDIUM = 40000.0;
    private static final Double VALUE_LARGE = 50000.0;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    private static String generateRandomAlphanumeric(int length) {
        return IntStream.range(0, length)
                .map(i -> random.nextInt(CHARACTERS.length()))
                .mapToObj(CHARACTERS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private TypePackage typeAssign(Double weight) {
        if (weight < 2) {
            return TypePackage.LIGHT;
        } else if (weight < 5) {
            return TypePackage.MEDIUM;
        } else {
            return TypePackage.LARGE;
        }
    }


    private Double valueGenerate(Double weight, TypePackage type) {
        Double result;
        switch (type) {
            case LARGE:
                result = VALUE_LARGE;
                break;
            case MEDIUM:
                result = VALUE_MEDIUM;
                break;
            case LIGHT:
                result = VALUE_LARGE;
                break;
            default:
                throw new IllegalArgumentException("Unknown package type.");
        }
        return result;
    }

    public Package createPackage(Package pack){
        String id = generateRandomAlphanumeric(8);
        pack.setId(id);

        TypePackage type = typeAssign(pack.getWeight());
        pack.setTypePackage(type);

        Double value = valueGenerate(pack.getWeight(), type);
        pack.setDeclaredValue(value);
        packageRepository.save(pack);

        return pack;
    }

}
