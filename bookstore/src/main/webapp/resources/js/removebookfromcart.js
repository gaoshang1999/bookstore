$(document).ready(function() {

	$('.removeBookFromCart').click(removeBookFromCart);
})

var contextRoot = "/" + window.location.pathname.split('/')[1];

function removeBookFromCart(element) {
	var bookId = element.target.id;
	console.log(bookId)
	$.ajax({
		type : 'GET',
		url : contextRoot + '/cart/remove/' + bookId,
		dataType : "json",
		// data : bookId,
		/*
		 * headers : { 'headers' :
		 * $("meta[name='_csrf_header']").attr("content"), 'token' :
		 * $("meta[name='_csrf']").attr("content") },
		 */
		contentType : 'application/json',
		success : function(response) {
			console.log("done")

			decrementCart();

		},
		error : function(errorObject) {

			console.log(errorObject.responseText)

		}
	});

}

function decrementCart() {
	var NumbersOfItemsInCart = Number($('#cart-badge').html()) - 1;
	$('#cart-badge').html(NumbersOfItemsInCart)
}
