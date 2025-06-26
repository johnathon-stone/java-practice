package org.example.command;

import org.example.shoppingcart.OrderServices;
import org.example.utilities.Utilities;

public class DisplayOrder implements Command{

    @Override
    public void execute(Utilities utilities, OrderServices services) {
        utilities.displayOrderList(services.getCustomerOrder());
    }
}
