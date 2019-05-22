var mostrar = true;
var grafico = [];
var listDivAlert = [];
var listHtmlDivOriginal = [];

var controleQuantDiv = 0;
var controleQuantAparecer = 4;
var controleDivAtivo = 0;

var urlServer = "http://192.168.0.170:8080/monitor/";
//var urlServer = "http://192.168.0.206:8080/";

$(document).ready(function() {
	App.init();
	carregarHtmlOriginal();
	carregarServers();
	setInterval(function() {
		carregarServers();
	}, 300000);
	
	setInterval(function() {
		 location.reload();
	}, 1800000);
	
});
function carregarHtmlOriginal() {
	var dvis = document.getElementsByName("divdados")
	controleQuantDiv = 0;
	for (di in dvis) {
		idDiv = dvis[di].id;
		if (idDiv != undefined) {
			controleQuantDiv++;
			listHtmlDivOriginal[idDiv] = $('#' + idDiv).html()
			// $('#' + idDiv).hide();
		}
	}
}

function rotacao() {
	var dvis = document.getElementsByName("divdados");
	var coutRt = 0;
	var countEx = 0;
	for (di in dvis) {
		idDiv = dvis[di].id;
		coutRt++;
		if (idDiv != undefined) {
			if (coutRt => controleDivAtivo && countEx < controleQuantAparecer) {
				countEx++;
				$('#' + idDiv).show();
			}
		}
	}
	controleDivAtivo = coutRt;
}

function alterarBackGroud() {
	var bk = "#aa0000";
	if (!mostrar) {
		bk = "#242a30";
	}
	for (div in listDivAlert) {
		if (mostrar) {
			bk = listDivAlert[div].cor;
		}
		$("#" + listDivAlert[div].di).animate({
			backgroundColor : bk
		}, 1000);
	}
	mostrar = !mostrar
	// jQuery(this).delay(5000);
	// alterarBackGroud(div,!mostrar);
}
function limparDivs() {
	var dvis = document.getElementsByName("divdados")
	for (di in dvis) {
		idDiv = dvis[di].id;
		if (idDiv != undefined) {
			$('#' + idDiv).html(listHtmlDivOriginal[idDiv]);
		}
	}
}
function carregarServers() {
	limparDivs()
	var dvis = document.getElementsByName("divdados")
	for (di in dvis) {
		idDiv = dvis[di].id;
		if (idDiv != undefined) {
			id = idDiv.replace("div_", "");
			var url = urlServer + "app/monitorserver/result?";
			var postData = "idServidor=" + id;
			$.ajax({
				url : url,
				dataType : "json",
				data : postData,
				type : "GET",
				success : function(dt) {
					var ret = [];
					var idLocal = 0;
					for (pt in dt) {
						us = dt[pt].usoCPUPercent;
						if (us == 'null') {
							us = 0;
						}
						ret.push({
							data : tratarData(dt[pt].data),
							usoCpu : us
						});
						idLocal = pt;
					}
					elem = "chart1_" + dt[0].idServidor
					elementoDados(dt[0], "divConteudo_" + dt[0].idServidor, dt[0].idServidor);

					grafico[dt[0].idServidor] = Morris.Area({
						element : elem,
						data : ret,
						xkey : 'data',
						ykeys : [ 'usoCpu' ],
						labels : [ 'usoCpu' ],
						pointSize : 2,
						lineColors : [ '#FFFFFF' ],
						gridTextColor : '#FFFFFF',
						goalLineColors : '#000000',
						xLabelAngle : 35,
						hideHover : 'auto',
						resize : true,
						yLabelFormat : function(y) {
							return y + '%';
						},
						hoverCallback : function(index, options, content, row) {
							return "<h5>Data: " + row.data + "</h5><h5 >Uso CPU: " + row.usoCpu + "%</h5>";
						}
					});
				}
			});
		}
	}
	setInterval(function() {
		alterarBackGroud();
	}, 2000);

}
function tratarData(unix_timestamp) {
	return moment(unix_timestamp).format("YYYY-MM-DD HH:mm:ss");
}
function elementoDados(dados, div, idPainel) {
	console.log(dados.sistemaOperacional);
	if (dados.sistemaOperacional != null && dados.sistemaOperacional.toLowerCase().indexOf("linux") !== -1) {
		$('<i></i>', {
			class : "fa fa-linux fa-2x"
		}).appendTo('#icon_' + idPainel);
	} else {
		$('<i></i>', {
			class : "fa fa-windows fa-2x"
		}).appendTo('#icon_' + idPainel);
	}

	criarExibicaoDado(div, 'Data atualização', moment(dados.data).format("DD-MM-YYYY HH:mm:ss"), 'small', 'small');
	criarExibicaoDado(div, 'Arquitetura', dados.arquitetura, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(div, 'Quantidade nucleos', dados.nucleos, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(div, 'Uso processador', dados.usoCPUPercent, 'dadosExibir', 'dadosExibir');

	divMem = div + "_mem";
	$('<div></div>', {
		id : divMem,
		class : "mar"
	}).appendTo('#' + div);

	criarExibicaoDado(divMem, 'Total Memória', dados.memoriaTotalMb, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(divMem, 'Memória Livre', dados.memoriaLivreMb, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(divMem, 'Memória Usada', dados.memoriaUsadaMb, 'dadosExibir', 'dadosExibir');
	console.log(div)
	coMen = calcularAlerta(dados.memoriaTotalMb, dados.memoriaUsadaMb);
	if (coMen != null) {
		listDivAlert.push({
			di : divMem,
			cor : coMen
		});
	}

	divDisco = div + "_disk";
	$('<div></div>', {
		id : divDisco
	}).appendTo('#' + div);

	criarExibicaoDado(divDisco, 'Tamanho', dados.diskSizePorEscrito, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(divDisco, 'Espaço Livre', dados.diskSizeFreePorEscrito, 'dadosExibir', 'dadosExibir');
	criarExibicaoDado(divDisco, 'Espaço utilizado', dados.diskSizeUsagePorEscrito, 'dadosExibir', 'dadosExibir');

	coDisk = calcularAlerta(dados.diskSize, dados.diskSizeUsage);
	if (coDisk != null) {
		listDivAlert.push({
			di : divDisco,
			cor : coDisk
		});
	}
}
function calcularAlerta(quantidadeTotal, quantidadeEmUso) {
	percentso = (quantidadeEmUso * 100) / quantidadeTotal;
	console.log("TOTAL"+quantidadeTotal);
	console.log("EM USO"+quantidadeEmUso);
	console.log(percentso);
	cor = null;
	if (percentso > 90) {
		cor = "#aa0000";
	}else if (percentso > 75) {
		cor = "#FF8C00";
	} 
	return cor;
}
function criarExibicaoDado(divAppend, htmlDescricao, htmlConteudo, classDescricao, classConteudo) {
	$('<dt></dt>', {
		class : classDescricao,
		'html' : htmlDescricao
	}).appendTo('#' + divAppend);

	$('<dd></dd>', {
		class : classConteudo,
		'html' : htmlConteudo
	}).appendTo('#' + divAppend);
}