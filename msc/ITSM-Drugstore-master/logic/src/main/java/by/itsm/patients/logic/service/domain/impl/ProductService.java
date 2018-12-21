package by.itsm.patients.logic.service.domain.impl;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.domain.IProductRepository;
import by.itsm.patients.logic.service.AbstractCrudService;
import by.itsm.patients.logic.service.domain.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService extends AbstractCrudService<Product> implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    @Transactional
    public Product getByProductName(String productName) {
        try {

            return productRepository.findByName(productName);

        } catch (DatabaseException e) {
            throw e;
        }
    }

//    @Override
//    @Transactional
//    public Product getExist(String productName) {
//
//        try {
//            Product product = getByProductName(productName);
//            if (product == null) {
//                throw new NotFoundException(Constants.PRODUCT + Constants.WITH_PRODUCT_NAME + productName + Constants.NOT_FOUND);
//            }
//            return product;
//
//        } catch (DatabaseException e) {
//            throw e;
//        }
//    }
//
//    @Override
//    @Transactional
//    public Product getNew(String productName, Integer stateId) {
//        try {
//            if (getByProductName(productName) != null) {
//                throw new IncorrectlyEnteredDataException(Constants.PRODUCT + Constants.WITH_PRODUCT_NAME + productName + Constants.ALREADY_EXISTS);
//            }
//            Product product = new Product(productName, stateRepository.find(stateId));
//
//            return product;
//        } catch (DatabaseException e) {
//            throw e;
//        }
//    }

}
