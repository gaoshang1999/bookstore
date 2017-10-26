$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
	$(".quantities").change(updateBookCountInCart);
	$(".resetCart").click(updateCart)
});

function updateBookCountInCart() {
	var quantities = document.getElementsByClassName("quantities");
	var unitPrice = document.getElementsByClassName("unitPrice");
	var totalBooks = 0 ;
	var totalCost = 0 ;
	var index = 0;
	for ( var quantity of quantities) {
		var q = Number(quantity.value)		
		totalBooks += q ;
		totalCost += q*Number(unitPrice[index].innerHTML.substring(1, 5));
		index++;
	}
	$("#bookCartCount").html(totalBooks);
	$("#totalCost").html(totalCost);
}
function updateCart() {
	$('#cart-badge').html(0) 
	}