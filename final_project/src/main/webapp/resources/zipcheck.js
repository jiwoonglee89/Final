/**
 * 
 */
function dongCheck() {
		if (document.zipForm.area4.value == "") 
		{
			alert("동이름을 입력하세요");
			document.zipForm.area4.focus();
			return;
		}
		document.zipForm.submit();
	}

function sendAddress(zipcode, area1, area2, area3, area4) {
	var address = area1 + " " + area2 + " " + area3 + " " + area4;
	opener.document.joinF.zipcode.value = zipcode;
	opener.document.joinF.address.value = address;
	self.close();
}