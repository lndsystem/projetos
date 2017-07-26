var PrintNet = PrintNet || {};

PrintNet.ModalInformacoes = (function() {
	function ModalInformacoes() {
		this.loading = $('.jquery-waiting-base-container');
		this.modal = $('.js-show-modal-informacoes');
		this.link = $('.js-button-info');
		
	}
	
	ModalInformacoes.prototype.iniciar = function() {
		this.link.on('click', onClickInfo.bind(this));
	}
	
	function onClickInfo(evento){
		this.loading.removeClass('hidden');
		this.loading.fadeIn("slow");
		
		var linkClicado = $(evento.currentTarget);
		var url = linkClicado.data('url');
		this.codigo = linkClicado.data('codigo');
		
		
		$.ajax({
			url: url,
			method: 'GET',
			contentType: 'application/json',
			success: onCarregarModal.bind(this)
		});
	}
	
	function onCarregarModal(execucoes){
		this.modal.find('.modal-title').html('<strong>Informações (Processo: ' + this.codigo + ')</strong>');
		
		if(typeof image_array !== 'undefined' && image_array.length > 0){
						
		}else{
			
		}
		
		this.loading.fadeOut("slow");
		this.modal.modal('show');
	}
	
	return ModalInformacoes;
})();

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
		this.loading.removeClass('hidden');
		this.loading.fadeIn("slow");
		
		var linkClicado = $(evento.currentTarget);
		var url = linkClicado.data('url');
		this.codigo = linkClicado.data('codigo');
		
		$.ajax({
			url: url,
			method: 'GET',
			contentType: 'application/json',
			success: onCarregarModal.bind(this)
		});
	}
	
	function onCarregarModal(parametros) {
		this.modal.find('.modal-title').html('<strong>Parametros (Processo: ' + this.codigo + ')</strong>');
		
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
	var modalConfiguracoes = new PrintNet.ModalConfiguracoes();
	modalConfiguracoes.iniciar();
	
	var modalInformacoes = new PrintNet.ModalInformacoes();
	modalInformacoes.iniciar();
});