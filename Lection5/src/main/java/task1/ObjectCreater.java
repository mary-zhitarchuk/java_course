package main.java.task1;

import java.lang.reflect.Field;

public class ObjectCreater {

    public static UserProfile copyParams(Person person, Passport passport, Class<UserProfile> userProfileClass) throws IllegalAccessException, InstantiationException {
        UserProfile userProfile = userProfileClass.newInstance();
        Field[] personParams = person.getClass().getDeclaredFields();
        Field[] passportParams = passport.getClass().getDeclaredFields();
        Field[] userProfileParams = userProfileClass.getDeclaredFields();
        try {
            for (Field fieldUser : userProfileParams) {
                fieldUser.setAccessible(true);
                for (Field fieldPerson : personParams) {
                    if (fieldPerson.getName().equals(fieldUser.getName())) {
                        fieldPerson.setAccessible(true);
                        Object value = fieldPerson.get(person);
                        fieldUser.set(userProfile, value);
                    }
                }
                for (Field fieldPassport : passportParams) {
                    if (fieldPassport.getName().equals(fieldUser.getName())) {
                        fieldPassport.setAccessible(true);
                        Object value = fieldPassport.get(passport);
                        fieldUser.set(userProfile, value);
                    }
                }
            }
            return userProfile;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
