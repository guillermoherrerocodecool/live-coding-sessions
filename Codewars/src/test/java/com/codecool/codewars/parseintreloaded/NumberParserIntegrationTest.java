package com.codecool.codewars.parseintreloaded;

import com.codecool.codewars.parseintreloaded.multiplier.MultipliersProvider;
import com.codecool.codewars.parseintreloaded.tens.ConvertersProvider;
import com.codecool.codewars.parseintreloaded.tens.TensParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberParserIntegrationTest {
    ConvertersProvider convertersProvider = new ConvertersProvider();
    TensParser tensParser = new TensParser(convertersProvider.getConverters());
    MultipliersProvider multipliersProvider = new MultipliersProvider();
    NumberParser numberParser = new NumberParser(tensParser, multipliersProvider.getMultipliers());

    @ParameterizedTest
    @CsvFileSource(
            resources = "/parseintreloaded/numberparser.csv",
            numLinesToSkip = 1
    )
    void parse(int expected, String literal) {
        int result = numberParser.parse(literal);

        assertEquals(expected, result);
    }
}