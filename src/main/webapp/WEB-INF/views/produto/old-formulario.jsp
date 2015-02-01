<%@include file="../templates/header.jsp"%>

<!-- Titulo da pagina -->
<header>
	<h2 class="list-header">Produto</h2>
</header>

<content>

<form action="adicionaCategoria">
	<ul class="group">
		<li class="name"><label for="name">Nome</label> <input
			type="text" name="nome" id="name" placeholder="Nome do Produto"
			autofocus></li>
		<li class="name"><label for="name">Preco</label> <input
			type="text" name="nome" id="name" placeholder="Preco do Produto"
			autofocus></li>
		<li class="type"><label for="type">Categoria</label> 
		<select
			name="type" id="type">
				<option></option>
				<option>Esportes</option>
				<option>Livros</option>
		</select>
		</li>

	</ul>
	<input class="send" type="submit" name="submit" value="Salvar" />
</form>


</content>

<%@include file="../templates/footer.jsp"%>