
window.onload=iniCropper();

function iniCropper(newImgURL) {
    var $image = $('#image'),
        image = $image[0];
    $image
        .cropper('destroy') // 销毁旧的裁剪区域
        .attr('src', newImgURL) // 重新设置图片路径

    $image.cropper({
        dragMode: 'move',
        //剪裁框的长宽比
        aspectRatio: 1,
        //剪裁框的占比
        //autoCropArea: .8,
        restore: false,
        //各种剪裁模式
        viewMode: 3,
        //网格模式
        guides: false,
        center: true,
        highlight: false,
        //剪裁框可移动
        cropBoxMovable: true,
        //剪裁框可按比例缩放
        cropBoxResizable: true,
        toggleDragModeOnDblclick: false,
        rotatable: true,
        checkOrientation: true,
        ready: function() {
            //console.log('ready')
            //croppable = true;
            //loadding(false)
            console.log('crop')
        },
        crop: function() {
            console.log('crop')
        }

    });
}

/* 上传图片 */
$('#uploadButton').on('click', function() {
    $('#selectImage').click()
})

/* 裁剪图片 */
$('#cutButton').click(function() {
    var dataURL = $('#image').cropper("getCroppedCanvas", {
        width: 750,
        imageSmoothingQuality: 'high',
    });
    let userImg = dataURL.toDataURL('image/png');
    console.log(userImg);
    $('#result').attr('src', userImg);
    $('#fileUpload').val(userImg);
})

// 为文件选择框绑定 change 事件
$('#selectImage').on('change', function(e) {
    // 获取用户选择的文件
    var filelist = e.target.files
    if (filelist.length === 0) {
        return alert('请选择照片！')
    }

    // 1. 拿到用户选择的文件
    var file = e.target.files[0]
    // 2. 将文件，转化为路径
    var imgURL = URL.createObjectURL(file)
    // 3. 重新初始化裁剪区域
    iniCropper(imgURL)
})

//上传图片更新头像
$('#saveButton').on('click', function() {
    $('#image').cropper('getCroppedCanvas', {
    }).toBlob(function (blob) {
        let formData = new FormData();
        let tempName = new Date().getTime()+'.png';
        formData.append("fileUpload", blob, tempName);
        $.ajax({
            url: '/updateProfile', //要上传的地址
            type: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function (url) {
                alert("头像更新成功");
                location.reload();
            },
            error:function (){
                alert("头像更新失败")
            }
        });
    })
})

/*
* 密码更新表单验证
* */
$("#password").focus(function(){
    $("#notice1").text(' ');
})
$("#password").blur(function(){
    if($("#password").val()==""){
        $("#notice1").text("密码不能为空");
    }
});

$("#checkPassword").focus(function(){
    $("#notice2").text(' ');
})
$("#checkPassword").blur(function(){
   if($("#password").val()!==$("#checkPassword").val()){
        $("#notice2").text("两次输入密码不一致");
    }
});

/* 提交更新密码表单 */
function submitPassword(){
    $.ajax({
        url: '/updatePassword',
        type: 'post',
        data: $('#updatePassword').serialize(),
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        processData: false,
        success: function () {
            alert('密码更新成功')
        },
        error: function () {
            console.log(this.data)
            alert('密码更新失败');
        }
    });
}


/* 提交基本信息表单 */
function submitBasic(){
    $.ajax({
        url: '/updateBasic',
        type: 'post',
        data: $('#updateBasic').serialize(),
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        processData: false,
        success: function () {
            alert('基本信息更新成功')
        },
        error: function () {
            console.log(this.data)
            alert('基本信息更新失败');
        }
    });
}


/* 提交联系方式表单 */
function submitContact(){
    $.ajax({
        url: '/updateContact',
        type: 'post',
        data: $('#updateContact').serialize(),
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        processData: false,
        success: function () {
            alert('联系方式更新成功')
        },
        error: function () {
            console.log(this.data)
            alert('联系方式更新失败');
        }
    });
}

/* 提交个人介绍表单 */
function submitIntro(){
    $.ajax({
        url: '/updateIntro',
        type: 'post',
        data: $('#updateIntro').serialize(),
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        processData: false,
        success: function () {
            alert('个人介绍更新成功')
        },
        error: function () {
            console.log(this.data)
            alert('个人介绍更新失败');
        }
    });
}