
<%@include file="../templates/header.jsp"%>

<!-- Titulo da pagina -->
<header>
	<h2 class="list-header">
		Editar Categoria
	</h2>
</header>

<content>

<form:form modelAttribute="categoria" role="form" action="editaCategoria">
	<form:errors />

	<ul class="group">
		<li class="unique-field">
			<input type="hidden" name="id" id="id" value="${categoria.id}" />
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" type="text" id="nome" value="${categoria.nome}" /> 
			<form:errors path="nome" cssStyle="color: #a94442;" />
		</li>
	</ul>

	<button class="sendUnique" type="submit" name="submit">Salvar</button>
</form:form>

</content>

<%@include file="../templates/footer.jsp"%>



