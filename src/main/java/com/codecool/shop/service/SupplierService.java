package com.codecool.shop.service;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class SupplierService {
    private final SupplierDao supplierDao;

    public SupplierService(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public Supplier getSupplier(int id){
        return supplierDao.find(id);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierDao.getAll();
    }


}