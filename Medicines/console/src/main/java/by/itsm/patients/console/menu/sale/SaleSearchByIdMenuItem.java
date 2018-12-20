package by.itsm.patients.console.menu.sale;

import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleSearchByIdMenuItem implements IMenuItem {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private MenuHelper helper;

    @Override
    public String getTitle() {
        return "Search by id";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter sale id:");
        int id = helper.readInt();
        Sale sale = saleService.findBy(id);
        if (sale == null) {
            System.out.println("sale not found");
        } else {
            System.out.println(sale);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
