function openPop(obj) {

    let popCover=document.getElementById("popCover");
    let popDiv = document.getElementById("popDiv");
    let header=document.getElementById("header");

    // 遮罩显示
    popCover.style.display = "block";
    // 弹窗显示
    popDiv.style.display = "block";
    //禁用其他元素
    document.body.style.setProperty('overflow','hidden');
    //降低标题栏层次
    header.style.zIndex="1";

    //获取数据
    let topicId = $(obj).data('id');
    let topicTitle = $(obj).data('title');
    let topicSubtitle = $(obj).data('subtitle');
    let topicCover = $(obj).data('cover');

    //赋值
    document.getElementById("parm-title").innerText=topicTitle;
    document.getElementById("parm-subtitle").innerText=topicSubtitle;
    document.getElementById("parm-cover").setAttribute("src",topicCover);
    document.getElementById("topicId").setAttribute("value",topicId);

    //评论列表加载
    globalUrl='/remarkList/'+topicId;
    flashRemark();
}

function flashRemark(){
    //评论列表更新
    $('#remark').load(globalUrl);
}

function closePop() {

    let popCover=document.getElementById("popCover");
    let popDiv = document.getElementById("popDiv");
    let header=document.getElementById("header");

    //遮罩关闭
    popCover.style.display = "none";
    // 弹窗关闭
    popDiv.style.display = "none";
    //解除禁用元素
    document.body.style.removeProperty("overflow");
    //恢复标题栏层次
    header.style.zIndex="2";
}

function showEditor(){
    let topicCreate=document.getElementById("topicCreate");
    let topicButton=document.getElementById("topicButton");

    if(topicButton.innerText=="创建话题"){
        //显示创建话题模块
        topicCreate.style.visibility="visible";
        topicButton.innerText="取消创建";
    }else{
        //隐藏创建话题模块
        topicCreate.style.visibility="hidden";
        topicButton.innerText="创建话题";
    }
}

function changePicture() {
    let read= new FileReader();
    let file=document.getElementById('file').files[0];
    read.readAsDataURL(file);
    read.onload=function (e) {
        document.getElementById('showPicture').style.backgroundImage="url('"+this.result+"')";
    };
}

function clearPicture(){
    document.getElementById('showPicture').style.backgroundImage="none";
}

function submitRemark(){
    let topicId = document.getElementById("topicId").getAttribute("value");
    let message = document.getElementById("message").value;
    console.log(message);
    let submitUrl = '/submitRemark/'+topicId+'/'+message
    $.ajax({
        url: submitUrl,
        type: "POST",
        success: function (response) {
            flashRemark();
        },
        error: function () {
            alert('评论失败');
        }
    });
}