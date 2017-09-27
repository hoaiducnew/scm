<%@ include file="header.jsp" %>

<form:form modelAttribute="addProduct" action="addProduct" enctype="multipart/form-data">
<form:errors path="*" cssStyle="Color:RED"></form:errors>
<fieldset>
          <p>
            <label for="type"><spring:message code="product.type" /> </label>
				<form:select path="category.id" id="category">
					<c:forEach items="${category}" var="type">
						<form:option value="${type.id}" label="${type.type}" />
					</c:forEach>
				</form:select>

			</p>  
			
			<p>
            <label for="name"><spring:message code="name" /> </label>
            <form:input path="name" id="name" />
            
        </p> 
        
        <p>
            <label for="description"><spring:message code="description" /> </label>
            <form:input path="description" id="description" />
            
        </p> 
        
        
        <p>
            <label for="capacity"><spring:message code="capacity" /> </label>
            <form:input path="capacity" id="capacity" />
            
        </p>
        
         <p>
            <label for="image"><spring:message code="image" /> </label>
            <form:input path="image" id="image" type="file" />
            
        </p> 
        
        <p id="buttons">
            <input name="reset" type="reset" >
            <input name="submit" type="submit"  value="Add Product">
        </p>
       
    </fieldset>
</form:form>

<%@ include file="footer.jsp" %>