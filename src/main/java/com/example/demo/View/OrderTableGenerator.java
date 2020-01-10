package com.example.demo.View;

import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableGenerator {

    private TableHelper tableHelper;

    @Autowired
    public OrderTableGenerator(TableHelper tableHelper) {
        this.tableHelper = tableHelper;
    }

    public String generateOrderTable(List<Lunch> lunches, List<Drink> drinks, String price) {
        StringBuilder builder = new StringBuilder();

        builder.append("|" + StringUtils.repeat("-", 58) + "|\n");
        builder.append("|" + StringUtils.repeat(" ", 58) + "|\n");

        tableHelper.createBodyContent(builder,"", "Your order is", "", "", "", " ", "", 58);

        for(Lunch lunch: lunches) {
            tableHelper.createBodyContent(builder,"Lunch: ", lunch.getName(), "",
                    "Lunch: ", "", " ", "", 58);
            tableHelper.createLunchRecord(builder, lunch);
        }

        for(Drink drink: drinks) {
            tableHelper.createBodyContent(builder,"Drink: ", drink.getName(), "",
                    "Drink: ", "", " ", "", 58);
            tableHelper.createBodyContent(builder,"with lemon: ", String.valueOf(drink.isWithLemon()), "",
                    "with lemon: ", "", " ", "", 58);
            tableHelper.createBodyContent(builder,"with cubes: ", String.valueOf(drink.isWithCubes()), "",
                    "with cubes: ", "", " ", "", 58);
            tableHelper.createDrinkRecord(builder, drink, 58);

        }

        builder.append("|" + StringUtils.repeat(" ", 58) + "|\n");

        tableHelper.createBodyContent(builder, "Total price: ", price, " PLN",
                "Total price: ", " PLN", " ", "0", 58);

        builder.append("|" + StringUtils.repeat("-", 58) + "|\n");

        return builder.toString();
    }
}
