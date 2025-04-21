function page_nav(frm,num){
	if(typeof(frm)!='object'){
		frm=document.forms[0];
	}
	with(frm){	 
	  pageIndex.value=num;
	  submit();
  }
}
