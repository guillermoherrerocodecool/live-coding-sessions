package com.codecool.karmatm.logic.reader;

import com.codecool.karmatm.data.ActionType;
import com.codecool.karmatm.data.Karma;

public class KarmaTransformer implements DataTransformer<Karma> {
   
    @Override
    public Karma transform(String line) {
        String[] columns = line.split(";");
        return new Karma(columns[1],
                parseToActionType(columns[0])
        );
    }

    private ActionType parseToActionType(String column) {
        return ActionType.valueOf(column.toUpperCase());
    }
}
