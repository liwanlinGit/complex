//window.locaUrl="http://localhost:8092"; 
//zuul 网关
window.locaUrl="http://localhost:8085/api";

(function(){
	function AjaxRequest(opts){
		this.type=opts.type||"get";
		this.url=opts.url;
		this.param=opts.param||{};
		this.dataType=opts.dataType||"json";
		this.callBack=opts.callBack;
		this.token=opts.token||false;
		this.init();
	}
	AjaxRequest.prototype={
	     init:function(){
	    	 this.sendRequest();
	     },
	   //渲染loader
	      showLoader: function(){
	          if(this.isShowLoader){
	                var loader = '<div class="ajaxLoader"><div class="loader">加载中...</div></div>';
	                $("body").append(loader);
	          }
	       },
	        //隐藏loader
	        hideLoader: function(){
	            if(this.isShowLoader){
	               $(".ajaxLoader").remove();
	            }
	       },
	     //发送请求
	        sendRequest: function(){
	            var self = this;
	            $.ajax({
	                type: this.type,
	                url: this.url,
	                data: this.param,
	                dataType: this.dataType,
	                beforeSend: this.token?function(XMLHttpRequest){
	                	XMLHttpRequest.setRequestHeader("token",sessionStorage.getItem("token"));
	                }:null,
	                async: false,
	                crossDomain: true,
	                xhrFields: {
	             	      withCredentials: true
	                },
	                success: function(data){
	                	self.callBack(data);
	                },
	                error:function(data){
	                	self.callBack("服务器错误");
	                 }
	            })
	        }
	}
	 window.AjaxRequest = AjaxRequest;
})();

$.min_ajax=function(data,url,type,dataType,isToken){
	var res_data;
	new AjaxRequest({
		type: type,
	    url: url,
	    param: data,
	    isShowLoader: true,
	    dataType: dataType,
	    token:isToken,
	    callBack:function(data){
	    	if(data.statusCode==500){
    			layer.msg(res_data.data);
    		}else if(data.statusCode==503){
    			layer.confirm(data.data+",需要重新登录", {
    	            btn: ["确定"] //按钮
    	        }, function(index){
    	           location.href="/view/login.html";
    	        });
    		}else if(data.statusCode==200||data.statusCode==204){
    			res_data=data;
    		}else{
    			layer.msg('服务器出错！');
    		}
	    }
	});
	return res_data;
}



