<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">

/* .textselect{

	contenteditable : true;
}
 */
.tdselected{
border-color : black;
/* overflow-x:auto; */

}
#tdid{
text-transform: uppercase;
}

.divcoll {

	overflow:hidden;
		overflow-x:auto; 
overflow-y:auto; 
	height: 20px;
	width:70px;
/* 	position:absolute;  */
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.inputtext {
	display: none;
	/* overflow : inherit;  */
	border: 1px;
	 height: 20px;
	width: 70px; 
 	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	-moz-box-sizing: border-box; 
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
		width: 70px; 
	height: 20px;
	overflow-x:auto;
}
</style>
<script>
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
				tag += '<td   class="celltd" id=td'+th[i]+j+'><div id='+th[i]+j+' contentEditable="false" class="divcoll" ></div></td>'
			}
			tag += '</tr>'
		}

		tag += '</table>';
		
		var divTable = document.getElementById("createTable");
		divTable.innerHTML = tag;

	}

	$(document).ready(function() {
		CreateTable();
		/*  		$('textarea').css('display','none'); */
	/* 	$('textarea').hide(); */
		
		
	
	});

	$(function() {

		/* 		$('textarea').click(function(){
		 $(this).show();
		 }); */

		/* 		$('#cell'+th[i]+j).dblclick(function(){
		 $('#input'+th[i]+j).show();
		 $('#input'+th[i]+j).focus();
		
		 });  */
		/* 	$('#tdA1').click(function(){
				$(this).css('border-color','black');

			}); */

		/* 		$('#cellA1').dblclick(function(){
		 $('#inputA1').show();
		 $('#inputA1').focus();
		
		 });
		
		 $(".celltd").each$("#cellA1").click(function() {
		 $("#inputA1").show();
		 });
		 $("#tdA1").dbclick(function() {
		
		 $("#inputA1").show();
		 });
		 */
		/* 		$('td div:nth-last-child(2).attr("id")').dblclick(function(){ 

		 var inputid = $('td textarea:nth-last-child(1)').attr('id');

		 inputid.show(); 

		 });

		 */

		/* 	$('td div:nth-last-child(2)').attr('id').click(function(){

			$('td div:nth-last-child(2)').attr('id').css('border-color' , 'black');

			 
		 */

		/* 		$('div', this).click(function() {
		 $(this).css('border-color', 'black');

		 });
		 */
	/* 	$('#tdA1').click(function() {
			$(this).css('border-color', 'black');

		});
		$("#tdA1").dblclick(function() {
			$('#inputA1').focus();
			$("#inputA1").show();
		}); */
/* 	 	$('++textarea',this).dblclick(function(){
		 	var idz = $(this).attr('id'); 
			
			$('#input'+idz).show();
			$('#input'+idz).focus(); 
		
	 	
	 	}); */
/* 		&("셀렉터").on("이벤트 발생조건","추가선택자",function(){ 이벤트 발생했을때 실행할 문장 } ); */
		
		$('td',this).click(function() {
			if($(this).attr('class')=="tdselected" ){
			}else{
				$('td:not(this)').attr('class','celltd');
				$(this).attr("class","tdselected");
			}
			var tdid = $(this).attr('id');
			$('#address').val(tdid.substring(2,4));	
		});
		
		$('td',this).dblclick(function(){
			$('div').attr('contentEditable','false'); 
		
			var tableTdId = $(this).attr('id').substring(2,4);
			$(this).attr('class','tdselected');
		/*  	$('#'+tableTdId).attr('contentEditable','true').focus();  */
	
			$('.textselect').attr('class','divcoll');
			$('#'+tableTdId).attr('class','textselect').focus();
			
			$('.textselect').attr('contentEditable','true'); 
			
		});
		
 	
		$('#address').keydown(function(e){	
			
			if(e.keyCode==13){
				var address = $('#address').val().toUpperCase(); 
				$('#address').val().toUpperCase();
	/* 	 	$('[name='+address+']').show().focus(); */
			$('#td'+address).css('border-color','black');
				$('td:not(#td'+address+')').css('border-color','#BCE55C'); 
			}
			
		});

		
		
/* 	 	$('div',this).dblclick(function() {
	 	$('td:not(#input'+idz+')').attr('class','inputtext'); 
			var idz = $(this).attr('id');
			$('#input'+idz).attr('class','textselected');
		 			var idz = $(this).attr('id');
		$('#input'+idz).show();
			$('#input'+idz).focus(); 
			$('.right')  
		});  */

		
/* 	 	var dd = $('div',this).dblclick(function() {
			$(this).attr('contentEditable','true').focus();
			$(this).attr('name','textarea'); 
		$(this).attr('class','textarea'); 
				 		var idz = $(this).attr('id');

			$('#input'+idz).attr('class','textselected').focus(); 
	 	});  
		 */

	
	
	});
		 
</script>
</head>
<body>
<form>
<input type="submit" value="함수">
</form>
<br>
<div id="formulaBar">
	<div class="left">
		<input type="text" id="address">
	</div>
	<div class="center" >수식</div>
	<div class="right"></div>
</div>
	<div id="createTable"></div>

</body>
</html>

