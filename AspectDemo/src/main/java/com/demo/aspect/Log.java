package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Aspect
@Component //for beans to register implicitly
@Aspect //Turning this class into an aspect
public class Log {
	
	//Advice
	//@Before(value = "execution(void com.demo.vehicle.Car.drives(..))") 
	//.. indicates that it matches any number of parameters
	public void vehicleAboutToMove(JoinPoint jp) throws Exception{
		boolean canSaveLog = true;
		System.out.println("Join Kind: " +jp.getKind());
		System.out.println("Join Point Static Part: " + jp.getStaticPart());
		Object[] args = jp.getArgs();
		for(Object arg : args)
			System.out.println("Join Point Args: " + arg.toString());
		
		System.out.println("Join Point Target: " + jp.getTarget());
		if(canSaveLog)
			System.out.println("[Log][Beofre] Saving to log: Vehicle action: About to move.");
		else
			throw new RuntimeException("CANNOT_ALLOW_UNLOGGED_DRIVING");
	}
	
	//Advice After (finally)
//	@After(value = "execution(String com.demo.vehicle.Car.drive(..))")
//	public void vehicleAboutToStop() {
//		System.out.println("[Log][After]Saving to log: Vehicle action: About to stop.");
//	}
	
	
	//After Returning
//	  @AfterReturning(pointcut = "execution(String com.demo.vehicle.Car.drive(..))", returning = "ret") 
//	  public void vehicleMove(String ret){
//		  System.out.println("[Log][After Returning] Saving to log: Vehicle action: About to move. \n Returning: " + ret);
//	  }
	  
	  
	//After Throwing Exception
//	  @AfterThrowing(pointcut = "execution(String com.demo.vehicle.Car.drive(..))", throwing = "ex") 
//	  public void vehicleMove(Exception ex){
//		  System.out.println("[Log][After Throwing] Saving to log: Excepion Occured. \n Returned: " + ex.getMessage());
//	  }
	  
	  
	//Around
	  //@Around("execution(String com.demo.vehicle.Car.drives(..))") 
	  public String vehicleMoveAround(ProceedingJoinPoint pjp) throws Throwable{
		  System.out.println("[Log][Before Around] Vehicle has not been driven yet.");
		  Object returnedObj = new Object();
		  try {
			  Object[] inputArgs = pjp.getArgs();
			  for(Object obj : inputArgs)
				  System.out.println("[Log][Before Around][Input] "+obj.toString());
			  returnedObj = pjp.proceed(); //stops the execution of actual method if not invoked.
		  }catch(Exception e) {
			  System.out.println("[Log][Exception Around] "+e.toString());
		  }
		  System.out.println("[Log][After Around] Vehicle may have been driven.");
		  return returnedObj.toString();
	  }
	  
	
	//@Before("anyMethodThatReturnsString() || anyMethodExecutionInCarThatStartsWith_dr()")
	 // @Before("!anyMethodExecutionInCarThatStartsWith_dr()")
	public void vehicleAboutToTakeAction() {
		System.out.println("[Log][Before] Saving to log. Vehicle action.");
	}
	 
	//Defining Pointcut. Applies to any method in class Car that starts with dr, has any number of arguments, and can retry any value.
	@Pointcut("execution(* com.demo.vehicle.Car.dr*(..))") //Expression
	public void anyMethodExecutionInCarThatStartsWith_dr() {} //Signature
	
	@Pointcut("execution(String *(..))")
	public void anyMethodThatReturnsString() {}
	
	
	/*
	 * Join Point Designator exercises
	 */
	//@Before("matchAllJointPoints()")
	//@Before("matchAllCarClassJointPoints()")
	//@Before("matchAllWithinVehicleJointPoints()")
	//@Before("matchAnyNumberAndTypeOfArgumentsJoinPoint() && matchAllWithinVehicleJointPoints()")
	//@Before("matchCarBeanJoinPoint()")
	//@Before("matchAllBeansStartWithmyJoinPoint()")
	//@Before("annotationMethodExample()")
	@Before("annotationClassExample() || annotationMethodSimpleExample()")
	public void performLog(JoinPoint jp) {
		System.out.println("[Log]--------------------------------");
		System.out.println("[Log] Saving to log!");
		System.out.println("[Log] Current join point: " + jp.getStaticPart());
	}
	
	@Pointcut("execution(* *(..))")
	public void matchAllJointPoints() {}
	
	@Pointcut("execution(* com.demo.vehicle.Car.*(..))")
	public void matchAllCarClassJointPoints() {}
	
	//Within example
	//Use .* to match all sub packages and classes within them
	@Pointcut("within(com.demo.vehicle..*)")
	public void matchAllWithinVehicleJointPoints() {}
	
	//Args example, matches any method that doesn't take any arugment
	@Pointcut("args()")
	public void matchNoArgsJoinPoint() {}
	
	//Args example, matches any method that take one float arugment
	@Pointcut("args(float)")
	public void matchOneFloatArgsJoinPoint() {}
	
	//Args example, matches any method that take more than one arugment
	@Pointcut("args(Integer, boolean, String)")
	public void matchMultipleArgsJoinPoint() {}
	
	//Args example, matches any method that take just one arugment of any type
	@Pointcut("args(*)")
	public void matchOneArgsOfAnyTypeJoinPoint() {}
	
	//Args example, matches any method that take any number of arugment of any type
	@Pointcut("args(..)")
	public void matchAnyNumberAndTypeOfArgumentsJoinPoint() {}	
	
	
	/*
	 * Bean Examples
	 */
	//Bean example for a specific bean
	@Pointcut("bean(car)")
	public void matchCarBeanJoinPoint() {}
	
	//Bean example for regular expression matchin bean
	@Pointcut("bean(my*)")
	public void matchAllBeansStartWithmyJoinPoint() {}
	
	
	/*
	 * Annotation Example
	 */
	//Any method with any return type, any number of arguments and implements this annotation
	@Pointcut("execution(@com.demo.aspect.RandomDemoAnnotation * *(..))")
	public void annotationMethodExample() {}
	
	//Alternate way of using method based annotation
	@Pointcut("@annotation(RandomDemoAnnotation)")
	public void annotationMethodSimpleExample() {}	
	
	//Any class that implements this annotation
	@Pointcut("execution(* (@com.demo.aspect.RandomDemoAnnotation *).* (..))")
	public void annotationClassExample() {}
}
