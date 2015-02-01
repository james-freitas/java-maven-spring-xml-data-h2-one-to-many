<%@include file="../templates/header.jsp" %>

	<!-- Titulo da pagina -->
	<header>
		<h2 class="list-header">
			<a href="novaCategoria" rel="bookmark" title="Permlink">Nova Categoria</a>
		</h2>
	</header>
	
<content>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categorias}" var="categoria" >
			<tr>
				<td>${categoria.nome}</td>
				<td><a href="mostraCategoria?id=${categoria.id}" class="icon-edit">Editar</a></td>
				<td><a href="removeCategoria?id=${categoria.id}" class="icon-cancel">Excluir</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Formulario ou tabela se houver --></content>

<%@include file="../templates/footer.jsp" %>