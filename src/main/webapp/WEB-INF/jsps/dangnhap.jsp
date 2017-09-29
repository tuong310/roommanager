<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<div>
 <spring:form method="post" commandName="tk" action="Login">
        <script type="text/javascript"> 
        </script> 
          <div class="loginDisplay" align="center">
             <span class="style1">User Name:</span>
             <input type="text" name="username" class="style1" style="height:18px;width:90px">
             <span>&nbsp;&nbsp; PassWord:&nbsp;</span>
            <input type="password" name="passwork" class="style1" style="height:18px;width:70px">
            <span class="style1">&nbsp;</span>
            <input type="submit" value="Login" class="style1" style="font-weight:bold;height:22px;wihth=90px;margin-left: 0px">
        </div>
 </spring:form>
 </div>