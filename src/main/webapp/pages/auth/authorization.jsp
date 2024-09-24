<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register</title>
</head>
<body>
<%@include file="../_header.jsp"%>

<div class="row justify-content-center">
<div class="col-4">
        <form class="mt-3 needs-validation" action="/auth/register" method="post">

            <div class="row mb-3">
                <div class="col">
                    <label for="firstname" class="form-label">First name</label>
                    <input name="firstname" type="text" class="form-control" id="firstname" required pattern="(^[A-Za-z]{3,16})([ ]{0,1})([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col">
                    <label for="lastname" class="form-label">Last name</label>
                    <input name="lastname" type="text" class="form-control" id="lastname" required pattern="(^[A-Za-z]{3,16})([ ]{0,1})([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})?([ ]{0,1})?([A-Za-z]{3,16})">
                </div>
            </div>
            <div class="row mb-3">

                        <div class="mb-3">
                            <label for="Email" class="form-label">Email address</label>
                            <input name="email" type="email" class="form-control" id="Email" required pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$">
                            <c:if test="${emailUsed != null}">
                                <div class="alert alert-danger" role="alert">
                                        ${emailUsed}
                                </div>
                            </c:if>
                        </div>

                        <div class="mb-3">
                            <label for="Password" class="form-label">Password</label>
                            <input name="password" type="password" class="form-control" id="Password" required>
                        </div>



                                          <div class="d-grid gap-2 col-6 mx-auto">
                                              <button class="btn btn-primary" type="submit">Sign In</button>
                                          </div>

                                          <p class="fs-6">    </p>

                                          <p class="text-body-secondary">
                                              Already have an account? <a href="/login">Log in</a>
                                          </p>

                                      </form>
                                  </div>
                              </div>

                              </body>
                              </html>