package front.menu;

import front.DAO.impl.IPatientDAO;
import front.DAO.impl.IProductDAO;
import front.DAO.impl.ITransactionDAO;
import front.models.Patient;
import front.models.Product;
import front.models.SellTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import front.utils.UserHelper;

import java.time.LocalDateTime;

@Component
public class SellProductMenu extends MenuHelper implements ISellProductMenu {

    @Autowired
    IMainMenu mainMenu;

    @Autowired
    IPatientDAO patientDAO;

    @Autowired
    ITransactionDAO transactionDAO;

    @Autowired
    IProductDAO productDAO;

    @Override
   // @Transactional
    public void sellProduct() {
        System.out.println("Enter patient ID");
        Integer patientId = readMenuClauseConsole();
        Patient patient = patientDAO.find(patientId);

        System.out.println("Enter product ID");
        Integer productId = readMenuClauseConsole();
        Product product = productDAO.find(productId);

        //check the match of States
        if (patient.getState().equals(product.getState())) {
            SellTransaction sellTransaction = new SellTransaction(patient, product, LocalDateTime.now(), UserHelper.getCurrentUser());
            transactionDAO.create(sellTransaction);
            System.out.println("Product and Patient states are matched");
            System.out.println("Product has just been sold");
        } else {
            System.out.println("Mismatch states between Patient and Product");
        }
        mainMenu.performMenu();
    }
}
