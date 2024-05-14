<template>
  <el-form ref="form" :model="form" :rules="rules" label-width="80px">
    <el-form-item label="班级的ID" prop="userName">
      <el-input v-model="form.userName" maxlength="50" disabled/>
    </el-form-item>
    <el-form-item label="班级名称" prop="nickName">
      <el-input v-model="form.nickName" maxlength="30" />
    </el-form-item> 
    <el-form-item label="学校名称" prop="schoolName" >
      <el-input v-model="form.schoolName" maxlength="11"/>
    </el-form-item>    
    <el-form-item label="学校层次">
      <el-radio-group v-model="form.schoolLayer">
        <el-radio label="小学">小学</el-radio>
        <el-radio label="初中">初中</el-radio>
        <el-radio label="高中">高中</el-radio>
        <el-radio label="大学">大学</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
      <el-button type="danger" size="mini" @click="close">关闭</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserProfile } from "@/api/system/user";

export default {
  props: {
    user: {
      type: Object
    }
  },
  data() {
    return {
      form: {},
      // 表单校验
      rules: {
        nickName: [
          { required: true, message: "班级名称不能为空", trigger: "blur" }
        ],
        schoolName: [
          { required: true, message: "学校名称不能为空", trigger: "blur" }
        ],
        schoolLayer: [
          { required: true, message: "请选择学校层次", trigger: "blur" }
        ]
      }
    };
  },
  watch: {
    user: {
      handler(user) {
        if (user) {
          this.form = { userName:user.userName, nickName: user.nickName, schoolName: user.schoolName, schoolLayer: user.schoolLayer};
        }
      },
      immediate: true
    }
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserProfile(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.user.nickName = this.form.nickName;
            this.user.schoolName = this.form.schoolName;
            this.user.schoolLayer = this.form.schoolLayer;
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
