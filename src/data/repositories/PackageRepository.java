package data.repositories;

import data.models.Package;

import java.util.List;

public interface PackageRepository {
//    THIS REPO IS RESPONSIBLE FOR STORING AND RETRIEVING A PACKAGE
    Package save(Package aPackage);
    long count();
    void delete(Package aPackage);
    void delete(int id);
    List<Package> findAll();
    Package findById(int id);
}
