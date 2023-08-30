package com.nagarro.rl.week16.p2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CodeInspectorTest {

    @Test
    void testInspectCode() throws ClassNotFoundException {
        List<CodeInspectionResult> results = CodeInspector.inspectCode("com.nagarro.rl.week16.p2.Car");

        // Create a list of expected inspection results in the correct order
        List<CodeInspectionResult> expectedResults = new ArrayList<>(Arrays.asList(
                CodeInspectionResult.PRIVATE_LOWERCASE_FIELD,
                CodeInspectionResult.PUBLIC_LOWERCASE_METHOD,
                CodeInspectionResult.PUBLIC_LOWERCASE_METHOD,
                CodeInspectionResult.PRIVATE_LOWERCASE_FIELD,
                CodeInspectionResult.PRIVATE_LOWERCASE_FIELD,
                CodeInspectionResult.PUBLIC_LOWERCASE_METHOD,
                CodeInspectionResult.PUBLIC_LOWERCASE_METHOD,
                CodeInspectionResult.PUBLIC_LOWERCASE_METHOD
        ));

        // Check that the actual inspection results match the expected results
        Assertions.assertEquals(expectedResults, results);
    }


    @Test
    void testInspectCodeWithInvalidClass() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> CodeInspector.inspectCode("com.nagarro.rl.week16.p2.InvalidClass"));
    }
}