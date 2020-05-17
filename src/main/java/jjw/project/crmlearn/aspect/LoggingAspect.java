package jjw.project.crmlearn.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect extends DeclarationAspect {
	
	//logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//before
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: calling method: " + method);
		
	}
	
	@Before("allDoa()")
	public void logBeforeDoa() {
		
	}
	@Before("allService()")
	public void logBeforeService() {
		
	}
	
	@Before("allController()")
	public void logBeforeController() {
		
	}
	
	
	//afterReturning
	@AfterReturning("allDoa()")
	public void logReturnDoa() {
		
	}
	@AfterReturning("allService()")
	public void logReturnService() {
		
	}
	
	@AfterReturning("allController()")
	public void logReturnController() {
		
	}

}
