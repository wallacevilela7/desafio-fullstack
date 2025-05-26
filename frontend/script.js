let currentPage = 0;
const pageSize = 4;

async function fetchProducts(page = 0) {
  try {
    const response = await fetch(`http://localhost:8080/api/v1/products?page=${page}&pageSize=${pageSize}`);
    if (!response.ok) throw new Error("Erro ao buscar produtos");
    const data = await response.json();

    renderProduct(data.items);
    updatePagination(data.paginationResponse.page, data.paginationResponse.totalPages, data.paginationResponse.hasNext);
  } catch (err) {
    console.error(err);
    document.getElementById('product-list').innerHTML = "<p>Erro ao carregar produtos</p>";
  }
}

function renderProduct(products) {
  const list = document.getElementById('product-list');
  list.innerHTML = "";

  if (products.length === 0) {
    list.innerHTML = "<p>Nenhum produto encontrado!</p>";
    return;
  }

  products.forEach(product => {
    const div = document.createElement('div');
    div.className = "product";

    div.innerHTML = `
      <strong>${product.name}</strong><br />
      <p>Preço: R$ ${product.price.toFixed(2)}</p>
    `;

    list.appendChild(div);
  });
}

function updatePagination(current, totalPages, hasNext) {
  currentPage = current;
  const pageInfo = document.getElementById('page-info');
  pageInfo.textContent = `Página ${current + 1} de ${totalPages}`;

  document.getElementById('prev-btn').disabled = current === 0;
  document.getElementById('next-btn').disabled = !hasNext;
}


document.getElementById('prev-btn').addEventListener('click', () => {
  if (currentPage > 0) {
    fetchProducts(currentPage - 1);
  }
});

document.getElementById('next-btn').addEventListener('click', () => {
  fetchProducts(currentPage + 1);
});

// Inicializa
fetchProducts();
