<template>
  <el-card class="box-card">
    <!-- Dialog 对话框 弹出新增和修改表单 -->
    <el-row>
      <el-button size="mini" type="primary" @click="add">新增</el-button>
      <el-dialog :title="title" :visible.sync="dialogFormVisible" width="30%">
        <el-form :model="form" :rules="rules" ref="form">
          <el-form-item label="id:" hidden>
            <el-input v-model="form.id"></el-input>
          </el-form-item>
          <el-form-item label="姓名:" prop="username">
            <el-input v-model="form.username" placeholder="请输入姓名" style="width:80%"></el-input>
          </el-form-item>
          <el-form-item label="密码:" prop="password">
            <el-input v-model="form.password" placeholder="请输入密码" style="width:80%" show-password></el-input>

          </el-form-item>
          <el-form-item label="年龄:" prop="age">
            <el-input v-model.number="form.age" placeholder="请输入年龄" style="width:80%"></el-input>
          </el-form-item>
          <el-form-item label="性别:" prop="gender">
            <el-select v-model="form.gender" placeholder="请选择性别" style="width:80%">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="手机号:" prop="phone">
            <el-input v-model="form.phone" placeholder="请输入手机号" style="width:80%"></el-input>
          </el-form-item>
		  <el-form-item label="日期" prop="date">
		    <el-date-picker
		      v-model="form.created_at"
		      type="datetime"
		      placeholder="选择日期"
			  value-format="yyyy-MM-dd HH:mm"
		      style="width: 80%">
		    </el-date-picker>
		  </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="submit()">提 交</el-button>
        </div>
      </el-dialog>
    </el-row>

    <!-- 表格 -->
    <el-table
      ref="singleTable"
      stripe
      :data="tableData"
      style="width: 100%">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        property="id"
        label="ID"
        width="50"
        align="center">
      </el-table-column>
      <el-table-column
        property="username"
        label="姓名"
        width="120"
        align="center">
      </el-table-column>
      <el-table-column
        property="password"
        label="密码"
        align="center">
        </el-table-column>
      <el-table-column
        property="age"
        label="年龄"
        width="120"
        align="center">
      </el-table-column>
      <el-table-column
        property="gender"
        label="性别"
        width="120"
        align="center">
      </el-table-column>
      <el-table-column
        property="phone"
        label="手机号"
        align="center">
      </el-table-column>
	  <el-table-column
	    property="created_at"
	    label="注册时间"
	    align="center">
	  </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="edit(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
            size="mini"
            type="danger"
            @click="remove(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script>
  export default {
    name: "User",
    data() {
      return {
        title: '',
        currentRow: null,
        dialogFormVisible: false,
        form: {},
        tableData: [],
        rules: {
          username: [{required: true, message: '请输入姓名', trigger: 'blur'}],
					// created_at:[{required: true, message: '请输入密码', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}],
          age: [{required: true, message: '请输入年龄', trigger: 'blur'},
            {type: 'number', message: '年龄必须为数字值', trigger: 'blur'},
            {pattern: /^(0|[1-9]\d?|200)$/, message: '范围在0-200', trigger: 'blur'}],
          gender: [{required: true, message: '请选择性别', trigger: 'change'}],
          phone: [{required: true, message: '请输入手机号', trigger: 'blur'}]
        }
      }
    },
    methods: {
      // 表单重置初始化
      reset() {
        this.form = {
          id: null,
          password:null,
          username: null,
          age: null,
          gender: null,
          phone: null,
		  created_at:null
        }
      },

      // 增
      add() {
        this.reset()
        this.dialogFormVisible = true
        this.title = "新增用户数据"
      },

      // 删
      remove(index, row) {
        console.log(row.id)
        this.$axios({
          method: 'post',
          url: 'http://localhost:9090/user/remove/' + row.id,
        }).then((response) => {
          this.$message({
            message: '删除成功!',
            type: 'success'
          });
          this.getList();
        }).catch((error) => {
        })
      },

      // 改
      edit(index, row) {
        this.reset()
        this.form = JSON.parse(JSON.stringify(row));
        this.dialogFormVisible = true
        this.title = "修改用户数据"
      },

      //查
      getList() {
        this.$axios({
          method: 'get',
          url: 'http://localhost:9090/user/info',
        }).then((response) => {
          this.tableData = response.data
        }).catch((error) => {
        })
      },

      //提交按钮
      submit() {
        this.$refs['form'].validate((valid) => {
          if (valid) {
            if (this.form.id == null) {
              
              this.$axios({
                method: 'post',
                data: this.form,
                url: 'http://localhost:9090/user/add',
              }).then((response) => {
                this.$message({
                  message: '新增成功!',
                  type: 'success'
                });
                this.dialogFormVisible = false
                console.log(this.form);
                this.getList();
              }).catch((error) => {
              })
            } else {
              this.$axios({
                method: 'post',
                data: this.form,
                url: 'http://localhost:9090/user/edit',
              }).then((response) => {
                this.$message({
                  message: '修改成功!',
                  type: 'success'
                });
                this.getList();
                this.dialogFormVisible = false
              }).catch((error) => {
              })
            }
          } else {
            return false;
          }
        })
      }
    },
    mounted() {
      this.getList();
    }
  }
</script>

<style scoped>
</style>
