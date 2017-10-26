/**
 * 
 */

$(document).ready(function() {

	$('.resetCart').click(resetCart);
})

function resetCart() {
	$('#cart-badge').html(0)
}