package by.itsm.patients.web.controller.impl;

import by.itsm.patients.web.controller.AbstractCrudController;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.web.model.SaleDto;
import by.itsm.patients.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController extends AbstractCrudController<Sale, SaleDto> {

    @Autowired
    public SaleController(ICrudService<Sale, SaleDto> service) {
        super(service);
    }
}
