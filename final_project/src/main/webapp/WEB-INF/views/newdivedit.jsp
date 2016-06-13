<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
	// html dom 이 다 로딩된 후 실행된다.
	$(document).ready(function() {
		$(".menu>a").click(function() {
			$(this).next("ul").toggleClass("hide");
		});
	});
</script>
<script type="text/javascript" src="js/jquery.battatech.excelexport.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
#address {
	text-transform: uppercase;
}

.divcoll {
	overflow: hidden;
	height: 20px;
	width: 90px;
	/* position:absolute;   */
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.textselect {
	overflow: hidden;
	border-style: solid;
	border-width: 1px;
	word-wrap: break-word;
}

.tdselect {
	border-color: #0100FF;
	/* overflow-x:auto; */
}

table, td, th {
	border-style: solid;
	border-width: 1px;
	border-color: #BCE55C;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

tr, td {
	width: 90px;
	height: 22px;
}
</style>
<script>
	function key_event() {
		//엔터
		if (event.keyCode == 13) {
			event.preventDefault();
			var numtdid = $('.tdselect').attr('id').substring(3, 6);
			var sum = Number(numtdid) + 1;
			var stringid = $('.tdselect').attr('id').substring(0, 3) + sum;
			$('.tdselect').attr('class', 'celltd');
			$('.textselect').attr('class', 'divcoll').attr('contentEditable',
					'false');
			$('#' + stringid).attr('class', 'tdselect');
			$('.tdselect > .divcoll').attr('class', 'textselect').attr(
					'contentEditable', 'true').focus();
			$('#address').val(stringid.substring(2, 6));
		}
		//오른쪽 방향키
		 if(event.keyCode == 39){
			 
		
			 var colltdid = $('.tdselect').attr('id').substring(2, 3);
			var rowtdid = $('.tdselect').attr('id').substring(3,6);	
			 var th = [ "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
							"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
							"X", "Y", "Z" ];
			var or_row_tdid= th.indexOf(colltdid)+1;
		 	var re_row_tdid = th[or_row_tdid];
			var id = 'td'+re_row_tdid+rowtdid;
	
			 $('.tdselect').attr('class','celltd'); 
			 $('.textselect').attr('class','divcoll').attr('contentEditable','false'); 
		 	$('#'+id).attr('class','tdselect');
			$('.tdselect > .divcoll').attr('class', 'textselect').attr(
					'contentEditable', 'true').focus();
			$('#address').val(id.substring(2, 6)); 
		} 
		//왼쪽방향키
		if(event.keyCode==37){
			
			 var colltdid = $('.tdselect').attr('id').substring(2, 3);
				var rowtdid = $('.tdselect').attr('id').substring(3,6);	
				 var th = [ "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
								"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
								"X", "Y", "Z" ];
				var or_row_tdid= th.indexOf(colltdid)-1;
			 	var re_row_tdid = th[or_row_tdid];
				var id = 'td'+re_row_tdid+rowtdid;
		
				 $('.tdselect').attr('class','celltd'); 
				 $('.textselect').attr('class','divcoll').attr('contentEditable','false'); 
			 	$('#'+id).attr('class','tdselect');
				$('.tdselect > .divcoll').attr('class', 'textselect').attr(
						'contentEditable', 'true').focus();
				$('#address').val(id.substring(2, 6)); 
		}
		//위쪽 방향키
		if(event.keyCode==38){
			var numtdid = $('.tdselect').attr('id').substring(3, 6);
			var sum = Number(numtdid) - 1;
			var stringid = $('.tdselect').attr('id').substring(0, 3) + sum;
			$('.tdselect').attr('class', 'celltd');
			$('.textselect').attr('class', 'divcoll').attr('contentEditable',
					'false');
			$('#' + stringid).attr('class', 'tdselect');
			$('.tdselect > .divcoll').attr('class', 'textselect').attr(
					'contentEditable', 'true').focus();
			$('#address').val(stringid.substring(2, 6));
		}
		//아래쪽 방향키
		if(event.keyCode==40){
			var numtdid = $('.tdselect').attr('id').substring(3, 6);
			var sum = Number(numtdid) + 1;
			var stringid = $('.tdselect').attr('id').substring(0, 3) + sum;
			$('.tdselect').attr('class', 'celltd');
			$('.textselect').attr('class', 'divcoll').attr('contentEditable',
					'false');
			$('#' + stringid).attr('class', 'tdselect');
			$('.tdselect > .divcoll').attr('class', 'textselect').attr(
					'contentEditable', 'true').focus();
			$('#address').val(stringid.substring(2, 6));
			}
	};

	function CreateTable() {
		/* 		table 태그 생성 */
		var tag = '<table  cellpadding="0" cellspacing="0" class="view" id="viewtable" readonly="true">'
		/* 		맨 위에줄 ABCD...제목 */
		var th = [ "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
				"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
				"X", "Y", "Z" ];

		tag += '<thead id="thead">'
		/* 	제목의 수만큼 열을 th태그를 만들고 값을 넣어줌 id를 통해 구별한다. id는 문자열th로 시작해서 th인데스를 합친다*/
		for (var a = 0; a < th.length; a++) {
			tag += '<th id=th'+th[a]+'>' + th[a] + '</th>'
		}
		/*  행을 만들어준다. 아이디는 그냥 행의 번호로 설정한다.  */
		for (var j = 1; j < 100; j++) {

			tag += '<tr id='+j+' class="divrow">'
			/* 셀을 만들어준다. 아이디는 문자열 cell로 시작해서 th인덱스와 행번호와 합친다. */
			for (var i = 0; i < th.length; i++) {
				tag += '<td   class="celltd" id=td'+th[i]+j+'><div   contentEditable="false" id='
						+ th[i]
						+ j
						+ ' onkeyDown="key_event()" class="divcoll" ></div></td>'
			}
			tag += '</tr>'
		}

		tag += '</table>';

		var divTable = document.getElementById("createTable");
		divTable.innerHTML = tag;

	}

	$(document).ready(function() {
		CreateTable();
		for (var z = 1; z < 100; z++) {
			$('#' + z).val(z);
		}

	});

	$(function() {

		$('td', this).click(function() {
			/* 	$('td:not(this)').attr('class', 'celltd');
				$(this).attr("class", "tdselect");
			 */
			$('.tdselect').attr('class', 'celltd');
			$(this).attr('class', 'tdselect');
			var tdid = $(this).attr('id');
			$('#address').val(tdid.substring(2, 5));
		});

		$('.tdselect').keydown(function(e) {
			var tdid = $('.tdselect').attr('id');

		});
		//마우스 더블 클릭시 td select와 div textselect div를 편집할수있게 만들어준다. 
		$('td', this).dblclick(function() {
			$('div').attr('contentEditable', 'false');

			var tableTdId = $(this).attr('id').substring(2, 5);
			/* 		$(this).attr('class','tdselected'); */
			/*  	$('#'+tableTdId).attr('contentEditable','true').focus();  */
			$('.textselect').attr('class', 'divcoll');
			$('#' + tableTdId).attr('class', 'textselect').focus();
			$('.textselect').attr('contentEditable', 'true');

		});

		$('textselect').keydown(function(e) {
			if (e.keyCode == 13) {
				alert('ddd');
			}
		});

		$('#address').keydown(function(e) {
			if (e.keyCode == 13) {
				$('.tdselect').attr('class', 'celltd');
				var address = $('#address').val().toUpperCase();
				$('#address').val().toUpperCase();
				$('#td' + address).attr('class', 'tdselect');
				$('.tdselect > div').attr('contentEditable', 'true').focus();
			}
		});

	});
</script>
</head>
<body>
	<form>
		<input type="submit" value="함수">
	</form>
	<br>
	<div id="formulaBar">
		<div class="left" style='float: left'>
			<input type="text" id="address">
		</div>
		<div class="center" style='float: left'>수식</div>
		<div class="right" style='float: left'></div>
	</div>
	<div id="createTable"></div>



	<button id="btnExport" type="button">저장</button>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(e) {
				$("#viewtable").battatech_excelexport({
					containerid : "viewtable",
					datatype : 'table'
				});
			});
		});
	</script>
</body>
</html>