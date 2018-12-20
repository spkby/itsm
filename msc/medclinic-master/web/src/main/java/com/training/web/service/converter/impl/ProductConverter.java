package com.training.web.service.converter.impl;

import com.training.Product;
import com.training.State;
import com.training.web.model.ProductIDto;
import com.training.web.repository.StateRepository;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<Product, ProductIDto> {

    private final StateRepository stateRepository;

    @Autowired
    public ProductConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public ProductIDto convert(Product entity) {
        ProductIDto dto = new ProductIDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setState_id(entity.getState().getId());
        return dto;
    }

    @Override
    public Product convert(ProductIDto dto) {
        State state = stateRepository.findById(dto.getState_id())
                .orElseThrow(() -> new IllegalArgumentException("Can't find state with id = " + dto.getState_id()));

        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setState(state);

        return product;
    }
}
