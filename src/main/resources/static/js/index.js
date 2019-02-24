$(function(){
	var base = {
		init:function(){
			var _this = this;
			_this.menu();
		},
		menu:function(){
			var _this = this;
			$('.icon-bars').on('click',function(){
				$('#nav,.icon-close').toggle();
			})
			$('.icon-close').on('click',function(){
				$('#nav,.icon-close').hide();
			})
		}
	}
	base.init();
})