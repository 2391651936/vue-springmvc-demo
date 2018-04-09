<template>
    <div>
        <div class="loginPage">
            <h1>登录</h1>
            <el-form>
                <el-form-item label="账号">
                    <el-input type="text" id="user" v-model="user.username" placeholder="请输入账号" @blur="usernameBlur"></el-input>
                    <span class="err">{{ err.usernameErr }}</span>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input type="password" id="password" v-model="user.password" placeholder="请输入密码" @blur="passwordBlur"></el-input>
                    <span class="err">{{ err.passwordErr }}</span>
                </el-form-item>
                <el-button type="primary" @click="submitForm">提交</el-button>
                <el-button @click="reset">重置</el-button>
            </el-form>
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
                err: {
                	usernameErr: "",
                    passwordErr: ""
                }
            };
        },
        methods: {
    		reset: function () {
                this.user.username = "";
                this.user.password = "";
		    },
	        submitForm: function () {
    			let flag = true;
                for (let prop in this.user) {
                	if (this.user.hasOwnProperty(prop)) {
                		if (this.user[prop] === "") {
			                this.$notify({
				                message: '请填写账号密码',
				                type: 'warning'
			                });
			                return;
                        }
                    }
                }
                this.$http.post("http://localhost:8080/v1/login", JSON.stringify(this.user)).then(res => {
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
                    	this.$store.commit("updateUserInfo", data);
                        this.ROUTER.push({name: "information"});
                    }
                }, res => {
                    console.log(res)
                });
            },
	        usernameBlur: function () {
    			this.err.usernameErr = this.user.username === ""? "账号不能为空": "";
	        },
            passwordBlur: function () {
                this.err.passwordErr = this.user.password === ""? "密码不能为空": "";
            }
        }
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