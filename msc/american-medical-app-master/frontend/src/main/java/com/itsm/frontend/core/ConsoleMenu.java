package com.itsm.frontend.core;

import com.itsm.common.entity.Client;
import com.itsm.common.entity.Product;
import com.itsm.common.entity.State;
import com.itsm.common.entity.Transaction;
import com.itsm.frontend.factory.Factory;
import com.itsm.frontend.service.AddServiceInterface;
import com.itsm.frontend.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("ConsoleMenu")
public class ConsoleMenu implements Runnable{
    private final CrudMenu clientCRUD;
    private final CrudMenu productCRUD;
    private final CrudMenu stateCRUD;
    private final Factory<Transaction> transactionFactory;
    private final AddServiceInterface<Transaction> transactionAddService;
    private final TransactionListMenuInterface transactionListMenu;

    private final Scanner sc;

    @Autowired
    public ConsoleMenu(Storage<Client> clientStorage,
                       Storage<Product> productStorage,
                       Storage<State> stateStorage,
                       Factory<Client> clientFactory,
                       Factory<Product> productFactory,
                       Factory<State> stateFactory,
                       Factory<Transaction> transactionFactory,
                       AddServiceInterface<Transaction> transactionAddService,
                       TransactionListMenuInterface transactionListMenu) {

        this.transactionFactory = transactionFactory;
        this.transactionAddService = transactionAddService;
        this.transactionListMenu = transactionListMenu;
        clientCRUD = new CrudMenu(clientStorage,clientFactory);
        productCRUD = new CrudMenu(productStorage,productFactory);
        stateCRUD = new CrudMenu(stateStorage,stateFactory);
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.print("### Main menu \n" +
                    " 1. Client  CRUD \n" +
                    " 2. Product CRUD \n" +
                    " 3. State   CRUD \n" +
                    " 4. Sell operation \n" +
                    " 5. Sell list for user \n" +
                    " 0. exit \n" +
                    "> ");
            switch (sc.nextInt()) {
                case 1:
                    clientCRUD.run();
                    break;
                case 2:
                    productCRUD.run();
                    break;
                case 3:
                    stateCRUD.run();
                    break;
                case 4:
                    Transaction t = transactionFactory.create(0);
                    try {
                        transactionAddService.add(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    transactionListMenu.run();
                    break;
                case 0:
                    System.out.println("Bye.");
                    return;
                default:
                    System.out.println("No such menu item.");

            }
        }
    }


}
