<%-- 
    Document   : company
    Created on : Jan 15, 2022, 4:53:34 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="job_section layout_padding-bottom">
    <div class="heading_container">
        <br><br>
        <div class="heading_container">
            <h2>Recommended companies <br>
                <c:if test="${companies.size()==1}"><span>1 Company here</span></c:if>
                <c:if test="${companies.size()>1}"><span>${companies.size()} Companies here</span></c:if>
            </h2>
        </div>

        <div class="container" id="myTabContent">
            <div class="" id="jb-1" role="tabpanel" aria-labelledby="jb-1-tab">
                <div class="">
                    <div class="">
                        <!-- career -->
                        <c:forEach items="${companies}" var="c">
                            <c:url value="/companyDetail" var="action">
                                <c:param name="recruitId" value="${c.recruitId}"/>
                            </c:url>
                            <div class="">
                                <h3>${c.companyName}</h3>
                                <a href="${action}">See information</a>
                            </div>
                        </c:forEach>
                        <!-- career -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>