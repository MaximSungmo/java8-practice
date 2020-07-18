package me.maxim.java8practice.section01.lecture01;

@FunctionalInterface
public interface RunSomething {

  // 펑셔널 인터페이스는 추상메소드가 하나만 있어야한다.
  void doIt();

//  void aa(); // 두개를 정의하면 에러가 발생한다.

  static void printName() {
    System.out.println("Maxim");
  }

  default void printAge() {
    System.out.println("29");
  }
}
