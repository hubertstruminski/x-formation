package com.example.demo.View;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuTableGenerator {

    private TableHelper tableHelper;

    @Autowired
    private MenuTableGenerator(TableHelper tableHelper) {
        this.tableHelper = tableHelper;
    }

    public String generateMenu() {
        StringBuilder builder = new StringBuilder();

        builder.append("|" + StringUtils.repeat("-", 38) + "|\n");
        builder.append("|" + StringUtils.repeat(" ", 38) + "|\n");

        tableHelper.createBodyContent(builder, "", "1. Drink menu", "",
                "", "", " ", "", 38);
        builder.append("|" + StringUtils.repeat(" ", 38) + "|\n");
        tableHelper.createBodyContent(builder, "", "2. Polish lunch menu", "",
                "", "", " ", "", 38);
        tableHelper.createBodyContent(builder, "", "3. Italian lunch menu", "",
                "", "", " ", "", 38);
        tableHelper.createBodyContent(builder, "", "4. Mexican lunch menu", "",
                "", "", " ", "", 38);
        tableHelper.createBodyContent(builder, "", "5. Compute receipt", "",
                "", "", " ", "", 38);
        builder.append("|" + StringUtils.repeat(" ", 38) + "|\n");

        tableHelper.createBodyContent(builder, "", "5. Exit", "",
                "", "", " ", "", 38);

        builder.append("|" + StringUtils.repeat(" ", 38) + "|\n");
        builder.append("|" + StringUtils.repeat("-", 38) + "|\n\n");

        return builder.toString();
    }
}

