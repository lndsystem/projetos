var PrintNet = PrintNet || {};
/*	  
(function($) {
	$.fn.waiting = function(options) {
		options = $.extend({
			modo : 'normal'
		}, options);
		this.fadeOut(options.modo);
		return this;
	};
})(jQuery);

$(document).ready(function() {
	$(".jquery-waiting-base-container").waiting({
		modo : "slow"
	});
});
*/

function sleep_ms(millisecs) {
    var initiation = new Date().getTime();
    while ((new Date().getTime() - initiation) < millisecs);
}

/*
 * PrintNet.Tooltip = (function () { function Tolltip() { this.tooltip =
 * $('.js-tooltip'); }
 * 
 * Tooltip.prototype.iniciar = function() { this.tooltip.tooltip(); }
 * 
 * return Tooltip; })();
 */

PrintNet.ModalConfiguracoes = (function() {
	function ModalConfiguracoes() {
		this.loading = $('.jquery-waiting-base-container');
		this.modal = $('.js-show-modal-configuracoes');
		this.link = $('.js-button-config');
	}

	ModalConfiguracoes.prototype.iniciar = function() {
		this.link.on('click', onClinkConfig.bind(this));
	}

	function onClinkConfig(evento) {
		console.log('Entrou');
		this.loading.removeClass('hidden');
		this.loading.fadeIn("slow");
		
		var linkClicado = $(evento.currentTarget);
		var url = linkClicado.data('url');
		var codigo = linkClicado.data('codigo');
		
		console.log('url: ' + url);
		console.log('codigo: ' + codigo);
		
		$.ajax({
			url: url,
			method: 'GET',
			contentType: 'application/json',
			success: onCarregarModal.bind(this)
		});
	}
	
	function onCarregarModal(parametros) {
		this.modal.find('.modal-title').html('<strong>Parametros</strong>');
		
		var strParametros = '<div class="form-horizontal">';
		parametros.forEach(function(parametro, index) {
			strParametros += 
				'<div class="form-group">' +
					'<label class="col-sm-4  control-label">' + parametro.chave + '</label>' + 
					'<div class="col-sm-8">' + 
						'<input type="text" disabled="disabled" class="form-control" value="' + parametro.valor + '"/>' +
					'</div>' + 
				'</div>';
		});
		strParametros += '</div>';
		
		
		this.modal.find('.modal-body').html(strParametros);
		
		this.loading.fadeOut("slow");
		this.modal.modal('show');
	}

	return ModalConfiguracoes;
}());

PrintNet.CheckboxAll = (function() {
	function CheckboxAll() {

	}

	CheckboxAll.prototype.iniciar = function() {

	}

	return CheckboxAll;
})();

$(function() {
	// var tooltip = new PrintNet.Tooltip();
	// tooltip.iniciar();

	var modalConfiguracoes = new PrintNet.ModalConfiguracoes();
	modalConfiguracoes.iniciar();
});