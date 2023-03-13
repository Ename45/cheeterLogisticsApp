package data.repositories;

import data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRepository;

    @BeforeEach
    public void setUp(){
        packageRepository = new PackageRepositoryImpl();
    }

    @Test
    @DisplayName("Create new package test")
    public void saveOnePackage_countIsOneTest(){
        assertEquals(0, packageRepository.count());

        Package aPackage = new Package();
        packageRepository.save(aPackage);

        assertEquals(1, packageRepository.count());
    }

    @Test
    @DisplayName("Generate Id test")
    public void saveOnePackage_idIsOneTest(){
        Package aPackage = new Package();
        assertEquals(0, aPackage.getId());
        Package savedPackage = packageRepository.save(aPackage);
        assertEquals(1, savedPackage.getId());
    }

    @Test
    @DisplayName("Find by Id test")
    public void saveOnePackage_findPackageById_returnsSavedPackageTest(){
        Package aPackage = new Package();
        aPackage.setPayOnDelivery(true);
        packageRepository.save(aPackage);
        Package foundPackage = packageRepository.findById(1);
        assertEquals(1, foundPackage.getId());
        assertTrue(foundPackage.isPayOnDelivery());
        assertEquals(aPackage, foundPackage);
    }

    @Test
    @DisplayName("Update test")
    public void saveTwoItemsWithSameId_countIsOneTest(){
        Package aPackage = new Package();
        aPackage.setWeightInGram(34);
//        var savedAPackage = packageRepository.save(aPackage);
        packageRepository.save(aPackage);
        Package savedAPackage = packageRepository.findById(1);
        assertEquals(aPackage, savedAPackage);


        Package secondPackage = new Package();
        secondPackage.setId(1);
        secondPackage.setWeightInGram(22);

        packageRepository.save(secondPackage);

        Package foundPackage = packageRepository.findById(1);

        assertEquals(foundPackage, secondPackage);
        assertNotEquals(foundPackage, aPackage);
    }

    @Test
    @DisplayName("Delete test")
    public void deletePackageTest(){
        Package aPackage = new Package();
        Package bPackage = new Package();
        Package cPackage = new Package();

        packageRepository.save(aPackage);
        packageRepository.save(bPackage);
        packageRepository.save(cPackage);

        packageRepository.delete(bPackage);
        Package dPackage = new Package();
        packageRepository.save(dPackage);

        assertEquals(4, dPackage.getId());
    }
}