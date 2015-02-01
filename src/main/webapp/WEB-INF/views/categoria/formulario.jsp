<%@include file="../templates/header.jsp"%>

<!-- Titulo da pagina -->
<header>
	<h2 class="list-header">Dados da Categoria</h2>
</header>

<content>

	<form:form modelAttribute="categoria" role="form" action="adicionaCategoria" >
		<form:errors />

		<ul class="group">
			<li class="unique-field">
				<form:label path="nome">Nome</form:label>
				<form:input path="nome" type="text" id="nome" /> 
				<form:errors path="nome" cssStyle="color: #a94442;" />
			</li>
		</ul>

		<button class="sendUnique" type="submit" name="submit">Salvar</button>
		
	</form:form>




</content>

<%@include file="../templates/footer.jsp"%>