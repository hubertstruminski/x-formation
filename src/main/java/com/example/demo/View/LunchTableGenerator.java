package com.example.demo.View;

import com.example.demo.Dto.Lunch;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LunchTableGenerator {

    private TableHelper tableHelper;

    @Autowired
    private LunchTableGenerator(TableHelper tableHelper) {
        this.tableHelper = tableHelper;
    }

    public String generateTable(Lunch lunch) {
        StringBuilder builder = new StringBuilder();

        builder.append(lunch.getId() + ".\n");
        builder.append("|" + StringUtils.repeat("-", 58) + "|\n");

        String name = tableHelper.generateAttribute("", lunch.getName(), "", "", "", " ", "");
        int numberSpaces = name.length() % 2 == 1 ? ((58 - name.length() + 1) / 2) : ((58 - name.length()) / 2);

        builder.append("|" + StringUtils.repeat(" ", numberSpaces) + name + StringUtils.repeat(" ", numberSpaces) + "|\n");
        builder.append("|" + StringUtils.repeat("-", 58) + "|\n");

        tableHelper.createLunchRecord(builder, lunch);
        builder.append("|" + StringUtils.repeat("-", 58) + "|\n\n");

        return builder.toString();
    }
}
