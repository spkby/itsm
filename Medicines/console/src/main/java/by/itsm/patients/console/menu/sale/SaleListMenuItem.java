package by.itsm.patients.console.menu.sale;

import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListMenuItem implements IMenuItem {

    @Autowired
    private ISaleService saleService;

    @Override
    public String getTitle() {
        return "Print all sales";
    }

    @Override
    @Transactional
    public int doAction() {
        saleService.findAll().forEach(System.out::println);
        return 0;
    }
}
