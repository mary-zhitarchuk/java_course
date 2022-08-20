package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
    Далее сделать реализацию интерфейса Service для генерации массива рандомных целых
    чисел. Размер массива и граница, в рамках которой будут генерироваться числа, задаются
    входными параметрами (либо через атрибуты аннотации).
*/
public class ListServiceImpl implements Service, Serializable {
    @Override
    public List<Integer> doWork(Object... objects) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (int) objects[0]; i++){
            list.add(new Random().nextInt((int)objects[1]));
        }
        return list;
    }
}
