package me.maxim.java8practice.section01.lecture01;

public class Foo {

  public static void main(String[] args) {
    // 함수형 인터페이스를 익명 클래스로 구현하는 방법
    RunSomething runSomething =
        new RunSomething() {
          @Override
          public void doIt() {
            System.out.println("doIt");
          }
        };

    // 함수형 인터페이스 방식으로 사용하는 방법 (1줄 간단하게 람다로 표현되는 경우)
    RunSomething runSomething1 = () -> System.out.println("doIt1");

    // 함수형 인터페이스 방식으로 사용하는 방법 (여러 줄인 경우)
    RunSomething runSomething2 =
        () -> {
          System.out.println("doIt2");
          System.out.println("두줄");
        };

    runSomething.doIt();
    runSomething1.doIt();
    runSomething2.doIt();

    /* 같은 값을 넣었을 때, 무조건 같은 값이 나와야 하는 경우를 보장해준다.(순수 함수) */
    // 1. 함수 안에서 함수 바깥의 값을 참조해서 사용하는 경우에는 상태 값에 의존하므로 순수 함수로 볼 수 없다.
    // 2. 외부의 값을 변경하려는 경우에는 참조만 가능하다. (final 인 경우만)
    RunSomethingParam runSomethingParam = (number) -> number + 10;

    System.out.println(runSomethingParam.doIt(1));
    System.out.println(runSomethingParam.doIt(1));
    System.out.println(runSomethingParam.doIt(1));
  }
}
