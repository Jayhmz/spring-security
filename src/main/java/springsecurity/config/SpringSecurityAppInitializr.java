package springsecurity.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringSecurityAppInitializr extends AbstractAnnotationConfigDispatcherServletInitializer	{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] arr = {SpringAppConfig.class};
		
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMapping = { "/" };
		return urlMapping;
	}

}
