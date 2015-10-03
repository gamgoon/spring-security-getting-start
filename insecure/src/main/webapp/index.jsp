<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">

  <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
  <jsp:output omit-xml-declaration="true" />
  <jsp:output doctype-root-element="HTML"
              doctype-system="about:legacy-compat" />
<html lang="en">
  <head>
    <title>Hello World</title>
    <c:url var="faviconUrl" value="/resources/img/favicon.ico"/>
    <link rel="icon" type="image/x-icon" href="${faviconUrl}"/>
    <c:url var="bootstrapUrl" value="/resources/css/bootstrap.css"/>
    <link href="${bootstrapUrl}" rel="stylesheet"></link>
    <c:url var="bootstrapResponsiveUrl" value="/resources/css/bootstrap-responsive.css"/>
    <link href="${bootstrapResponsiveUrl}" rel="stylesheet"></link>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>
    <div class="container">
        <h1>TODO Secure this</h1>
        <p>We would like to secure this page</p>
        <p>
        	Hello <b><c:out value="${pageContext.request.remoteUser }"/></b>
        </p>
        <c:url var="logoutUrl" value="/logout" />
        <form class="form-inline" action="${logoutUrl}" method="post">
        	<input type="submit" value="Log out" />
        	<!-- CSRF 공격을 막기위해 CSRF 토큰을 반드시 request에 추가해야한다. 
        		 Spring MVC's tag library 나 Thymeleaf를 사용하면 자동으로 추가된다고 한다. -->
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</body>
</html>
</jsp:root>
