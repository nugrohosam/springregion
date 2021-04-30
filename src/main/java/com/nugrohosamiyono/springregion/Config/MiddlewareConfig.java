package com.nugrohosamiyono.springregion.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Exceptions.UnauthorizedException;
import com.nugrohosamiyono.springregion.Middlewares.AuthorizationMiddleware;
import com.nugrohosamiyono.springregion.Middlewares.LocaleMiddleware;
import com.nugrohosamiyono.springregion.Routes.Rule;
import com.nugrohosamiyono.springregion.Routes.RouteRule;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class MiddlewareConfig extends WebMvcConfigurerAdapter {

	@Autowired
	Middleware middleware;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.middleware);
	}
}

@Component
class Middleware extends HandlerInterceptorAdapter {

	@Autowired
	AuthorizationMiddleware authorizationMiddleware;

	@Autowired
	LocaleMiddleware localeMiddleware;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws UnauthorizedException {


		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			String controllerName = handlerMethod.getBeanType().getCanonicalName();
			String actionName = handlerMethod.getMethod().getName();

			String keyRoutesController = controllerName + ":" + actionName;
			Rule route = RouteRule.routes.get(keyRoutesController);

			this.localeMiddleware.checkLang(request, response);

			if (route != null) {
				this.authorizationMiddleware.checkAuth(request, response, route.auth);
				this.authorizationMiddleware.checkRoles(request, response, route.roles);
				this.authorizationMiddleware.checkPermission(request, response, route.permissions);
			}
		}

		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	}

}