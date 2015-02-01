<%@include file="../templates/header.jsp"%>

<!-- Titulo da pagina -->
<header>
	<h2 class="list-header">Dados do Produto</h2>
</header>

<content>

<form:form modelAttribute="produto" role="form"  action="editaProduto">
	<form:errors/>
	
	<ul class="group">
		<li class="firstField">
			<input type="hidden" name="id" id="id" value="${produto.id}" />
			<label for="nome">Nome</label>
			<input name="nome" type="text" value="${produto.nome}" placeholder="Nome do produto" autofocus="autofocus" /> 
			<form:errors path="nome" cssStyle="color: #a94442;" />
		</li>
		<li class="secondField">
			<form:label path="preco">Preco</form:label>
			<form:input path="preco" value="${produto.preco}" type="number" step="0.01" placeholder="0.00" required="required" /> 
			<form:errors path="preco" cssStyle="color: #a94442;" />
		</li>
		<li class="selectUnique">
			<label>Categoria:</label>
			<select name="idCategoria" id="idCategoria" >
				<c:forEach items="${categorias}" var="categoria">
					<option 
						value="${categoria.id}" 
						${categoria.id eq idCategoriaSelecionada ? 'selected' : ''}>${categoria.nome}</option>
				</c:forEach>	
			</select>
		</li>

		<li class="description">
			<form:label path="descricao">Descricao</form:label>
			<form:textarea path="descricao" placeholder="Detalhes do produto" />
		</li>
	</ul>
	<button class="send" type="submit" name="submit">Salvar</button>
	
</form:form>


</content>

<%@include file="../templates/footer.jsp"%>