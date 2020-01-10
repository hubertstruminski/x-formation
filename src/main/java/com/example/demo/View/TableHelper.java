package com.example.demo.View;

import com.example.demo.Dto.Drink;
import com.example.demo.Dto.Lunch;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TableHelper {

    public String generateAttribute(String preffix, String name, String suffix, String preffix2,
                                     String suffix2, String endString, String zero) {
        int nameLength = preffix.length() + name.length() + zero.length() + suffix.length();
        String result;

        if(nameLength % 2 == 1) {
            result = preffix2 + name + zero + suffix2 + endString;
        } else {
            result = preffix2 + name + zero + suffix2;
        }

        return result;
    }

    public void createBodyContent(StringBuilder builder, String preffix, String name,
                                   String suffix, String preffix2, String suffix2, String endString, String zero, int spaces) {
        String result = generateAttribute(preffix, name, suffix, preffix2, suffix2, endString, zero);
        int numberSpaces = result.length() % 2 == 1 ? ((spaces - result.length() + 1) / 2) : ((spaces - result.length()) / 2);

        builder.append("|" + StringUtils.repeat(" ", numberSpaces) + result + StringUtils.repeat(" ", numberSpaces) + "|\n");
    }

    public void createLunchRecord(StringBuilder builder, Lunch lunch) {
        builder.append("|" + StringUtils.repeat(" ", 58) + "|\n");
        createBodyContent(builder, "Kitchen: ", lunch.getKitchenType().getKitchen(), "",
                "Kitchen: ", "", " ", "", 58);
        createBodyContent(builder, "Main Course: ", lunch.getMainCourse().getName(), "",
                "Main Course: ", "", " ", "", 58);
        createBodyContent(builder, "Dessert: ", lunch.getDessert().getName(), "",
                "Dessert: ", "", " ", "", 58);

        builder.append("|" + StringUtils.repeat(" ", 58) + "|\n");
        createBodyContent(builder, "Price ", String.valueOf(lunch.getPrice()), " PLN",
                "Price ", " PLN", " ", "0", 58);

        builder.append("|" + StringUtils.repeat(" ", 58) + "|\n");
    }

    public void createDrinkRecord(StringBuilder builder, Drink drink, int size) {
        builder.append("|" + StringUtils.repeat(" ", size) + "|\n");
        createBodyContent(builder,"Capacity: ", String.valueOf(drink.getCapacity()), " ml",
                "Capacity: ", " ml", " ", "", size);
        builder.append("|" + StringUtils.repeat(" ", size) + "|\n");
        createBodyContent(builder, "Price ", String.valueOf(drink.getPrice()), " PLN",
                "Price ", " PLN", " ", "0", size);
    }
}
