package main.java.task1;

import java.lang.reflect.Field;

public class ObjectCreater {

    public static UserProfile copyParams(Person person, Passport passport, Class<UserProfile> userProfileClass){
        Field[] personParams = person.getClass().getDeclaredFields();
        Field[] passportParams = passport.getClass().getDeclaredFields();
        Field[] userProfileParams = userProfileClass.getDeclaredFields();
        try {
            for (Field fieldUser : userProfileParams) {
                for (Field fieldPerson : personParams) {
                    if (fieldPerson.getName() == fieldUser.getName()) {
                        Object value = fieldPerson.get(fieldUser.getName());
                        fieldPerson.set(fieldUser, value);
                    }
                }
                for (Field fieldPassport : passportParams) {
                    if (fieldPassport == fieldUser) {
                        Object value = fieldPassport.get(fieldUser);
                        fieldPassport.set(fieldUser, value);
                    }
                }
            }
            return userProfileClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
