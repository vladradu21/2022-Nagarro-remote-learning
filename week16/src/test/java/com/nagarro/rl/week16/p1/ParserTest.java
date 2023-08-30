package com.nagarro.rl.week16.p1;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void testParseDataFromFile() throws CannotParseTheFileException {
        // Arrange
        String fileName = "src\\main\\java\\com\\nagarro\\rl\\week16\\p1\\W1P1input.txt";

        // Act
        Map<String, Personality> personalitiesMap = Parser.parseDataFromFile(fileName);

        // Assert
        assertNotNull(personalitiesMap);
        assertFalse(personalitiesMap.isEmpty());
    }

    @Test
    public void testParseDataFromFileFails(){
        // Arrange
        String wrongFileName = "src\\main\\java\\com\\nagarro\\rl\\week16\\p1\\W1P1input1.tx";

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            Parser.parseDataFromFile(wrongFileName);
        });

        assertEquals("Failed to parse the file", exception.getMessage());
    }

}