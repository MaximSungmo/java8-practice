package me.maxim.java8practice.section01.lecture02;

import java.util.function.Function;

/* Funtion() 함수형 인터페이스는 입력 값과 리턴 값을 받는다.*/
public class Plus10 implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
