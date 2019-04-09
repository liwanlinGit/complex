//判断是否登录
$(function(){
	var res_data=$.min_ajax(null,locaUrl+"/sysuser/check","post","json",true);
	if(res_data.statusCode==200){
		var data=JSON.parse(res_data.data);
		$("[name='username_index']").text(data.name);
	}
	
})





