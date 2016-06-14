function dongCheck() {
		if (!document.zipForm.area4.value) 
		{
			alert("검색어를 입력하세요!");
			document.zipForm.area4.focus();
			return false;
		}
		document.zipForm.submit();
		//return true;
	}

function sendAddress(zipcode, area1, area2, area3, area4) {
	var address = area1 + " " + area2 + " " + area3 + " " + area4;
	opener.document.joinF.zipcode.value = zipcode;
	opener.document.joinF.address.value = address;
	self.close();
}