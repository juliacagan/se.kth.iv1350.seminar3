package se.kth.iv1350.view;

import java.util.*;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.Inspection;

/**
 * Created by User on 2017-05-01.
 */
public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        doHardCodedCashStuff();
    }

    private void doHardCodedStuff() {
        controller.nextCustomer();
        controller.closeDoor();
        controller.enterRegNumber("ABC 123");
        CreditCardDTO creditCardDTO = new CreditCardDTO("Bobby", "123456", "123", new Date(1000));
        controller.makeCardPayment(100, creditCardDTO);
        Inspection inspection1 = controller.nextInspection();
        inspection1.setPassed(true);
        controller.enterInspectionResults(inspection1);
        System.out.println(inspection1);

        Inspection inspection2 = controller.nextInspection();
        inspection2.setPassed(false);
        controller.enterInspectionResults(inspection2);
        System.out.println(inspection2);

        Inspection inspection3 = controller.nextInspection();
        inspection3.setPassed(true);
        controller.enterInspectionResults(inspection3);
        System.out.println(inspection3);

    }

    private void doHardCodedCashStuff() {
        controller.nextCustomer();
        controller.closeDoor();
        controller.enterRegNumber("ABC 123");
        controller.makeCashPayment(100, 120);
        Inspection inspection1 = controller.nextInspection();
        inspection1.setPassed(true);
        controller.enterInspectionResults(inspection1);
        System.out.println(inspection1);

        Inspection inspection2 = controller.nextInspection();
        inspection2.setPassed(false);
        controller.enterInspectionResults(inspection2);
        System.out.println(inspection2);

        Inspection inspection3 = controller.nextInspection();
        inspection3.setPassed(true);
        controller.enterInspectionResults(inspection3);
        System.out.println(inspection3);

    }
}
