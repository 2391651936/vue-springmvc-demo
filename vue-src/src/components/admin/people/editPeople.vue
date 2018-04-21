<template>
    <div>
        <template v-if="id === undefined">
            <first-title name="创建人员"></first-title>
        </template>
        <template v-else>
            <first-title name="修改人员"></first-title>
        </template>

        <el-form>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="人员类别">
                        <el-select
                                v-model="people.peopleType.id"
                                placeholder="请选择人员类别"
                                style="width: 100%;">
                            <el-option
                                    v-for="peopleType in peopleTypes"
                                    :key="peopleType.id"
                                    :value="peopleType.id"
                                    :label="peopleType.name"></el-option>
                        </el-select>
                    </el-form-item>

                    <el-form-item label="电话">
                        <el-input
                                v-model="people.phone"
                                placeholder="请输入电话"
                                clearable></el-input>
                    </el-form-item>

                    <el-form-item label="账号">
                        <el-input
                                v-model="people.username"
                                placeholder="请输入账号"
                                :disabled="disabled"
                                clearable></el-input>
                    </el-form-item>

                    <el-form-item>
                        <router-link :to="{name: 'people'}">
                            <el-button size="small" plain="">返回</el-button>
                        </router-link>
                        <el-button size="small" type="primary" plain
                                   @click="submit">提交</el-button>
                    </el-form-item>
                </el-col>


                <el-col :offset="2" :span="10">
                    <el-form-item label="姓名">
                        <el-input
                                v-model="people.name"
                                placeholder="请输入姓名"
                                clearable></el-input>
                    </el-form-item>

                    <el-form-item label="邮箱">
                        <el-input
                                v-model="people.email"
                                placeholder="请输入邮箱"
                                clearable></el-input>
                    </el-form-item>

                    <el-form-item :label="name">
                        <el-input
                                v-model="people.password"
                                type="password"
                                placeholder="请输入密码"
                                clearable></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>

<script>
	import firstTitle from '../../title.vue'

	export default {
		name: "editPeople",
		data() {
			return {
				id: '',
                name: "密码",
				disabled: false,
                people: {
                    peopleType: {
						id: "",
                        name: ""
                    },
                },
                peopleTypes: {
					type: Object,
                    default: {}
                }
            }
        },
		components: {firstTitle},
		created() {
			this.id = this.$route.query.id;
            if (this.id === undefined) {
				this.$http.get(this.$store.state.domain + "/admin/peopleTypes").then(res => {
					this.peopleTypes = res.data;
				}, res => {
					console.log(res);
				});
            } else {
            	this.name = "新密码";
            	this.disabled = true;
                this.$http.get(this.$store.state.domain + "/admin/people/" + this.id).then(res => {
                	this.people = res.data;
                	console.log(this.people)
                }, res => {
                	console.log(res);
                });
            }
        },
        methods: {
			submit() {
				if (this.id === undefined) {
					this.$http.post(this.$store.state.domain + "/admin/people", JSON.stringify(this.people)).then(res => {
						this.$judge(res.data, "people");
					}, res => {
						console.log(res);
					});
                } else {
					this.$http.put(this.$store.state.domain + "/admin/people", JSON.stringify(this.people)).then(res => {
						this.$judge(res.data, "people");
                    }, res => {
						console.log(res)
                    })
                }
            }
        }
	}
</script>

<style scoped>

</style>