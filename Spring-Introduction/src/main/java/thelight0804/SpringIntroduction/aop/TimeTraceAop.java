package thelight0804.SpringIntroduction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 메서드 시간 측정
 */
@Aspect //여러 클래스를 모듈화 시키는 어노테이션으로 AOP에 사용된다
//@Component SpringConfig에 @Bean을 사용했기 때문에 필요 X
public class TimeTraceAop {

  //@Bean 경로
  @Around("execution(* thelight0804.SpringIntroduction..*(..)) &&"
    + " !target(thelight0804.SpringIntroduction.SpringConfig)")
  //@Component 경로
  //@Around("execution(* thelight0804.SpringIntroduction..*(..))")
  public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{

    long start = System.currentTimeMillis();
    //TimeTraceAop start 확인
    System.out.println("start: " + joinPoint.toLongString());
    try{
      return joinPoint.proceed();
    }finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      //TimeTraceAop finish 확인
      System.out.println("finish = " + joinPoint.toLongString());
      //시간 출력
      System.out.println("timeMs = " + timeMs + '\n');
    }
  }
}
