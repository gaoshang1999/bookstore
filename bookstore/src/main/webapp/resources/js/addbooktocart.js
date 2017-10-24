$(document).ready(function() {

	$('.addBookToCart').click(addBookToCart);
})

var contextRoot = "/" + window.location.pathname.split('/')[1];

function addBookToCart(element) {
	var bookId = element.target.id;
	$.ajax({
		type : 'GET',
		url : contextRoot + '/cart/add/' + bookId,
		dataType : "json",
		// data : bookId,
		// headers:{'headers':
		// $("meta[name='_csrf_header']").attr("content"),'token':$("meta[name='_csrf']").attr("content")},
		contentType : 'application/json',
		success : function(response) {
			console.log("done")
			incerementCart();
		},
		error : function(errorObject) {

			console.log(errorObject.responseText)

		}
	});

}

function incerementCart() {
	var NumbersOfItemsInCart = Number($('#cart-badge').html()) + 1;
	$('#cart-badge').html(NumbersOfItemsInCart)
}
