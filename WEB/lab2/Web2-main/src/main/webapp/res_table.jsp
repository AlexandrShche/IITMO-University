<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table align="center" class="result_table">
    <jsp:useBean id="check" class="com.example.web2.model.Point" scope="session"/>
    <tr>
        <th class="variable">X</th>
        <th class="variable">Y</th>
        <th class="variable">R</th>
        <th>Result</th>
        <th>Time</th>
    </tr>
    <tbody>
    <tr>
        <th class='the_X'><jsp:getProperty name="check" property="x"/>
        </th>
        <th class='the_Y'><jsp:getProperty name="check" property="y"/>
        </th>
        <th class='the_R'><jsp:getProperty  name="check" property="r"/>
        </th>
        <th class='the_Result' style='color:<%=(check.getResult() ? "lime" : "red")%>'><jsp:getProperty name="check" property="result"/>
        </th>
        <th><%=check.getClock().getDateString()%>
        </th>
    </tr>
    </tbody>
</table>