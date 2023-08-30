package com.nagarro.rl.week16.p1;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Personality> parseDataFromFile(String fileName) throws CannotParseTheFileException {

        Map<String, Personality> personalitiesMap = new HashMap<>();

        try {
            String[] personalitiesDataList = ReadFromFile.readLinesFromTextFile(fileName);

            for (String personalityData : personalitiesDataList) {
                Personality personality = createPersonalityObject(personalityData);
                personalitiesMap.put(personality.getName(), personality);
            }
        } catch (Exception e) {
            throw new CannotParseTheFileException("Failed to parse the file");
        } finally {
            System.out.println("Try catch finished");
        }

        return personalitiesMap;
    }

    private static Personality createPersonalityObject(String personalityData) throws Exception {
        String[] attributes = personalityData.split(", ");
        Personality pers;

        Class<?>[] constructorParamTypes;
        Object[] constructorArgs;

        if(Character.isLetter(attributes[2].charAt(0))) {
            constructorParamTypes = new Class<?>[] {String.class, String.class, Integer.class};
            constructorArgs = new Object[] {attributes[0], attributes[1], Integer.parseInt(attributes[2].substring(2))};
        } else {
            constructorParamTypes = new Class<?>[] {String.class, String.class, Integer.class, Integer.class};
            constructorArgs = new Object[] {attributes[0], attributes[1], Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3])};
        }

        Constructor<Personality> constructor = Personality.class.getConstructor(constructorParamTypes);
        pers = constructor.newInstance(constructorArgs);

        return pers;
    }
}
