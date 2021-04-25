package com.nugrohosamiyono.springregion.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nugrohosamiyono.springregion.Exceptions.UnauthorizedException;
import com.nugrohosamiyono.springregion.Middlewares.AuthorizationMiddleware;
import com.nugrohosamiyono.springregion.Middlewares.LocaleMiddleware;
import com.nugrohosamiyono.springregion.Routes.DataRoute;
import com.nugrohosamiyono.springregion.Routes.Route;

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

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws UnauthorizedException {

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			String controllerName = handlerMethod.getBeanType().getCanonicalName();
			String actionName = handlerMethod.getMethod().getName();

			String keyRoutesController = controllerName + ":" + actionName;
			DataRoute route = Route.routes.get(keyRoutesController);

			this.localeMiddleware.checkLang(request, response);
			this.authorizationMiddleware.checkAuth(request, response, route.auth);
			this.authorizationMiddleware.checkRoles(request, response, route.roles);
			this.authorizationMiddleware.checkPermission(request, response, route.permission);
		}

		return true;
	}

}