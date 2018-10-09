<template>
    <div>
        <div class="loginPage">
            <h1>登录</h1>
            <el-form :model="user" :rules="rules" ref="ruleForm" label-width="55px">
                <el-form-item label="账号" prop="username">
                    <el-input type="text" 
                              id="user" v-model="user.username" 
                              placeholder="请输入账号" 
                              @keyup.enter.native="submitForm"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" 
                              id="password" 
                              v-model="user.password" 
                              placeholder="请输入密码" 
                              @keyup.enter.native="submitForm"></el-input>
                </el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
                <el-button @click="reset">重置</el-button>
            </el-form>
            <a href="http://baidu.com">baidu</a>
        </div>
    </div>
</template>

<script>
    export default {
    	name: "login",
        data() {
    		return {
                user: {
                	username: "",
                    password: "",
                },
                rules: {
                    username: [
                        {required:  true, message: "请输入账号", trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: "请输入密码", trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
    		reset: function () {
                this.user.username = "";
                this.user.password = "";
		    },
	        submitForm: function () {
                this.$refs.ruleForm.validate((valid) => {
                    if (valid) {
                        this.$http.post(this.$store.state.domain + "/login", JSON.stringify(this.user)).then(res => {
                            let data = res.bodyText;
                            if (data === 1001) {
                                this.$notify({
                                    message: '账号不存在',
                                    type: 'warning'
                                });
                            } else if (data === 1002) {
                                this.$notify({
                                    message: '账号或密码不正确',
                                    type: 'warning'
                                });
                            } else {
                                this.$store.commit("updateToken", data);
                                this.$router.push({name: "information"});
                            }
                        }, res => {
                            console.log(res)
                        });
                    }
                    
                });
            },
        },
    }
</script>

<style>
    .loginPage{
        width: 30%;
        margin: 0 auto;
    }
    .err{
        color: red;
    }
</style>