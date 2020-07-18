package me.maxim.java8practice.section01.lecture02;

import me.maxim.java8practice.section01.lecture01.RunSomething;
import me.maxim.java8practice.section01.lecture01.RunSomethingParam;

import java.util.function.*;

public class Foo {

  public static void main(String[] args) {
    /* 1. Funtion으로 정의한 클래스 인스턴스로 만들어서 사용하기 */
    Plus10 plus10 = new Plus10();
    System.out.println(plus10.apply(10)); // 결과 값 = 20

    Function<Integer, Integer> plus20 = (i) -> i + 20;
    System.out.println(plus20.apply(1)); // 결과 값 = 21

    Function<Integer, Integer> multiply2 = (i) -> i * 2;

    /* 고차함수로 사용하는 방식 - 1. compose 함수 */
    // plus20 함수와 multiply2 함수를 조합하여 사용하고 싶은 경우
    // (i * 2 ) (+20);
    Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
    System.out.println(multiply2AndPlus20.apply(2)); // 결과 값 2* 2 + 20 = 24

    /* 고차함수로 사용하는 방식 - 1. andThen 함수 */
    Function<Integer, Integer> plus20AndMultiply2 = plus20.andThen(multiply2);
    System.out.println(plus20AndMultiply2.apply(2)); // 결과 값 (20 + 2) * 2 = 44

    // --------------------------------------------------------------------------- //

    // BiFunction<T, U, R> 2개의 파라미터를 받아내는 Function

    // Consumer<T> return void;
    Consumer<Integer> printJust = (i) -> System.out.println(i);
    printJust.accept(10);

    // Supplier<T>  T 타입의 값을 받아서 T 타입으로 리턴하는 함수
    Supplier<Integer> get10 = () -> 10;
    System.out.println(get10.get());

    // Predicate<T> 해당 값에 대해 boolean으로 리턴
    Predicate<String> startsWithOkay = (s) -> s.startsWith("okay");
    System.out.println(startsWithOkay.test("okay")); // true
    System.out.println(startsWithOkay.test("2okay")); // false

    // Function<Integer, Integer> 와 같이 parameter type 과 return type이 같은 경우에 사용하면 좋음
    UnaryOperator<Integer> plus100 = (i) -> i + 100;

    // BiFunction 에서 parameter type 과 return type이 모두 같은 경우에 사용
    BinaryOperator<Integer> plusTwoParameter = (first, second) -> first + second;

    // 이 외에도 java.util.function 클래스에 포함된 내용을 찾아서 사용할 거 찾으면 유용할 것 같음.
  }
}
