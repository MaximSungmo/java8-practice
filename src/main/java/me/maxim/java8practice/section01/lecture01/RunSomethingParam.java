package me.maxim.java8practice.section01.lecture01;

@FunctionalInterface
public interface RunSomethingParam {

  // 펑셔널 인터페이스는 추상메소드가 하나만 있어야한다.
  int doIt(int num);
}
