/**
 * Created by hebiao on 2019/2/26.
 */
/**
 * Created by hebiao on 2018/12/28.
 */
var app=new Vue({
    el:'#app-author',
    data:{
        dataList:''
    },
    methods:{
        getDataList:function (pageNo) {
            $.ajax({
                url:"/main/findAuthor.do" ,
                type:"post",
                dataType:"json" ,
                data:{
                    "pageNo":pageNo,
                },
                success:function(data){
                    app.dataList=data.pageData;
                }
            })
        },
        /**拼接路径*/
        bindsrc:function (id) {
            return "/main/findAuthorDetails.do?cid="+id;
        }

    }

})


/**初始化查询慢生活界面数据*/
$("document").ready(function(){
    app.getDataList("1");
})

