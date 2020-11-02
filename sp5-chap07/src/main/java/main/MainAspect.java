package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.RecCalculator;
import config.Appctx;

public class MainAspect {

	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Appctx.class);
		
		RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
		long fiveFact = cal.factorial(5);
		
		System.out.println("cal.facotrial(5) = " + fiveFact);
		System.out.println(cal.getClass().getName());
		
		ctx.close();
		
	}
	
}
