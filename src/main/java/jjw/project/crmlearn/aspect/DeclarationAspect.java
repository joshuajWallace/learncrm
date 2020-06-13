package jjw.project.crmlearn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public abstract class DeclarationAspect {
	
	@Pointcut("execution(* jjw.project.crmlearn.doa.*.*(..))")
	public void allDoa() {}
	
	@Pointcut("execution(* jjw.project.crmlearn.services.*.*(..))")
	public void allService() {}
	
	@Pointcut("execution(* jjw.project.crmlearn.controller.*.*(..))")
	public void allController() {}
	
	@Pointcut("allController() || allDoa() || allService()")
	public void appFlow() {}

}
