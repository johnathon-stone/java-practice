package org.example.command;

import org.example.shoppingcart.OrderServices;
import org.example.utilities.Utilities;

public interface Command {

    public void execute(Utilities utilities, OrderServices services);
}
