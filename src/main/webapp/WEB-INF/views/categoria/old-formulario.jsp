<%@include file="../templates/header.jsp"%>

<!-- Titulo da pagina -->
<header>
	<h2 class="list-header">
		Categoria
	</h2>
</header>

<content>

<form action="adicionaCategoria">
	<ul class="group">
		<li class="name">
			<label for="name">Nome</label> 
			<input type="text" name="nome" id="name" placeholder="Nome da categoria"
			autofocus >
			<form:errors path="categoria.nome" cssStyle="color: red;" />
		</li>
	</ul>
	<input class="send" type="submit" name="submit" value="Salvar" />
</form>


</content>

<%@include file="../templates/footer.jsp"%>