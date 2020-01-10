package com.example.demo.View;

import com.example.demo.Dto.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.lang.StringUtils;

@Service
public class DrinkTableGenerator {

    private TableHelper tableHelper;

    @Autowired
    public DrinkTableGenerator(TableHelper tableHelper) {
        this.tableHelper = tableHelper;
    }

    public String generateTable(Drink drink) {
        StringBuilder builder = new StringBuilder();

        builder.append(drink.getId() + ".\n");
        builder.append("|" + StringUtils.repeat("-", 28) + "|\n");

        String name = tableHelper.generateAttribute("", drink.getName(), "", "", "", " ", "");
        int numberSpaces = name.length() % 2 == 1 ? ((28 - name.length() + 1) / 2) : ((28 - name.length()) / 2);

        builder.append("|" + StringUtils.repeat(" ", numberSpaces) + name + StringUtils.repeat(" ", numberSpaces) + "|\n");
        builder.append("|" + StringUtils.repeat("-", 28) + "|\n");

        tableHelper.createDrinkRecord(builder, drink, 28);

        builder.append("|" + StringUtils.repeat(" ", 28) + "|\n");
        builder.append("|" + StringUtils.repeat("-", 28) + "|\n\n");

        return builder.toString();
    }
}
