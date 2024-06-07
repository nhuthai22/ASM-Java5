const cartTable = document.querySelector('.cart-table');
const addBtn = document.querySelector('.add-to-cart');
    const product = JSON.parse(localStorage.getItem('product'));
    const id = product.id;
    const name = product.name;
    const price = product.price;
addBtn.addEventListener('click', () => {

    // Tạo dòng mới
    const newRow = document.createElement('tr');


    newRow.innerHTML += `
    <td>${id}</td>
  `;
    newRow.innerHTML += `
    <td>${name}</td> 
  `;


    newRow.innerHTML += `
    <td>${price}</td>
  `;

    cartTable.appendChild(newRow);

})