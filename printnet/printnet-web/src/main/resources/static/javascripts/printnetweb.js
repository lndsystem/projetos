var PrintNet = PrintNet || {};

PrintNet.Tooltip = (function () {
	function Tolltip() {
		this.tooltip = $('.js-tooltip');
	}
	
	Tooltip.prototype.iniciar = function() {
		this.tooltip.tooltip();
	}
	
	return Tooltip;
})();

$(function() {
	var tooltip = new PrintNet.Tooltip();
	tooltip.iniciar();
});

PrintNet.CheckboxAll = (function() {
	function CheckboxAll() {
		
	}
	
	CheckboxAll.prototype.iniciar = function() {
		
	}
	
	return CheckboxAll;
})