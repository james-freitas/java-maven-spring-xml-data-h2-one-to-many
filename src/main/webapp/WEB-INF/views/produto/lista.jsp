<%@include file="../templates/header.jsp" %>

	<!-- Titulo da pagina -->
	<header>
		<h2 class="list-header">
			<a href="novoProduto" rel="bookmark" title="Permlink">Novo Produto</a>
		</h2>
	</header>
	
<content>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Preco</th>
			<th>Categoria</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtos}" var="produto" >
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.preco}</td>
				<td>${produto.categoria.nome}</td>
				<td><a href="mostraProduto?id=${produto.id}" class="icon-edit">Editar</a></td>
				<td><a href="removeProduto?id=${produto.id}" class="icon-cancel">Excluir</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Formulario ou tabela se houver --></content>

<%@include file="../templates/footer.jsp" %>