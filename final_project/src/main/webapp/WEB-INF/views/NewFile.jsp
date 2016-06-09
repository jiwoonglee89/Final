<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
    // html dom 이 다 로딩된 후 실행된다.
    $(document).ready(function(){
        $(".menu>a").click(function(){
            $(this).next("ul").toggleClass("hide");
        });
    });
</script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
.divcoll {
	height: 20px;
	width: 70px;
}

.inputtext {
	display: block;
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
	height: 20px;
	width: 70px;
}
</style>
<script>
	function CreateTable() {
		/* 		table 태그 생성 */
		var tag = '<table  cellpadding="0" cellspacing="0" class="view" id="viewtable">'
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
				tag += '<td class="celltd" id=td'+th[i]+j+'><div id='+th[i]+j+' class="divcoll"><textarea   class="inputtext" id=input'+th[i]+j+'></textarea></div></td>'
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
		$('textarea').hide();
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
	 	
		$('td',this).click(function() {
			$('td:not(this)').css('border-color','#BCE55C');
			$(this).css('border-color','black');
			$(this).sele
		});

		$('div',this).dblclick(function() {
			var idz = $(this).attr('id');
			
			$('#input'+idz).show();
			$('#input'+idz).focus(); 
		
	/* 	$('textarea:not(#input'+idz+')').hide();  */
		/* 	var inputt = 'textarea:not(#input'+idz+')' */
			
			
		});		
	});
</script>
</head>
<body>

<form>
<input type="submit" value="함수">
</form>
<br>
	<div id="createTable"></div>

</body>
</html>


