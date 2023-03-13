package data.repositories;

import data.models.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository{
//    private int count;
    private int lastIdCreated;
    private List<Package> packages = new ArrayList<>();

    public Package save(Package aPackage) {
        boolean isSaved = aPackage.getId() != 0;
        if(isSaved) update(aPackage);

        else saveNewPackage(aPackage);

        return aPackage;
    }
    private void saveNewPackage(Package aPackage){
        aPackage.setId(generatePackageId());
        packages.add(aPackage);
        lastIdCreated++;
    }

//    private void update(Package aPackage){
//        Package savedPackage = findById(aPackage.getId());
//        int indexOfSavedPackage = packages.indexOf(savedPackage);
//        packages.set(indexOfSavedPackage, aPackage);
////        packages[indexOfSavedPackage] = aPackage; for an array
//    }

//                         OR
    private void update(Package aPackage){
//        Package savedPackage = findById(aPackage.getId());
//        savedPackage.setWeightInGram(aPackage.getWeightInGram());
//        savedPackage.setPayOnDelivery(aPackage.isPayOnDelivery());
//        savedPackage.setEvents(a);

//                  OR

            Package savedPackage = findById(aPackage.getId());
//            packages.remove(savedPackage);
            delete(savedPackage);
            packages.add(aPackage);

    }

    public void delete(Package aPackage) {
        packages.remove(aPackage);
//        count--; WE CHANGED THE VARIABLE FROM COUNT TO LastIdCreated
    }

    public void delete(int id) {
//        Package aPackage = findById(id);
//        if (aPackage != null) {
//            packages.remove(aPackage);
//            count--;}  WE CHANGED THE VARIABLE FROM COUNT TO LastIdCreated
        Package foundPackage = findById(id);
        delete(foundPackage);
    }

    private int generatePackageId(){
        return lastIdCreated +1;
    }

    public Package findById(int id) {
        for (Package aPackage: packages) if (aPackage.getId() == id) return aPackage;

        return null;
    }

    public long count() {
//        return count;
        return packages.size();
    }



    public List<Package> findAll() {
        return packages;
    }


}
