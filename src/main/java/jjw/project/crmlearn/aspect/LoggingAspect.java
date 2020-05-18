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
		Object[] args = joinPoint.getArgs();
		for(Object temp: args) {
			myLogger.info(" ==>> arugument :" + temp);
		}
		
		
	}
	
	//afterReturning
	@AfterReturning(pointcut ="appFlow()",
					returning = "result")
	public void logReturnDoa(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("====>> in @AfterReturning: calling method: " + method);
		myLogger.info("====>> result returned: " + result);
	}


}
