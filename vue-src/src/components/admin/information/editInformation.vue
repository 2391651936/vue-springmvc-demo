<template>
    <div>
        <template v-if="id === undefined">
            <first-title name="创建公告"></first-title>
        </template>
        <template v-else>
            <first-title name="修改公告"></first-title>
        </template>

        <el-form>
            <el-form-item label="标题">
                <el-input
                        v-model="information.title"
                        placeholder="请输入标题"
                        clearable>
                </el-input>
            </el-form-item>

            <el-form-item label="类别">
                <el-select
                        v-model="information.informationType.id"
                        placeholder="请选择类别" style="width: 100%;">
                    <el-option
                            v-for="informationType in informationTypes"
                            :key="informationType.id"
                            :value="informationType.id"
                            :label="informationType.name">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="信息内容">
                <el-input
                        type="textarea"
                        :rows="4"
                        placeholder="请输入内容"
                        v-model="information.context">
                </el-input>
            </el-form-item>

            <el-form-item label="是否发布">
                <el-switch
                        v-model="information.isRelease"
                        activeColor="#13ce66"
                        inactiveColor="#ff4949" style="margin-left: 1%;">
                </el-switch>
            </el-form-item>

            <router-link :to="{name: 'information'}">
                <el-button size="small" plain="">返回</el-button>
            </router-link>
            <el-button size="small" type="primary" plain
                       @click="submit">提交</el-button>
        </el-form>
    </div>
</template>

<script>
	import firstTitle from '../../title.vue'
	import ElFormItem from "../../../../node_modules/element-ui/packages/form/src/form-item.vue";
	import ElForm from "../../../../node_modules/element-ui/packages/form/src/form.vue";

    export default {
		name: 'editInformation',
        data() {
			return {
                id: "",
                informationTypes: [],
                information: {
                	title: "",
					informationType: {
                		id: "",
                        name: ""
                    },
					context: "",
					isRelease: true,
                },
                url: "/informations"
            }
        },
        components: {
	        ElForm,
	        ElFormItem,
	        firstTitle
        },
        created: function () {
			// 获取所有类别
            this.$http.get(this.HOST + "/admin/informationTypes").then(response => {
            	this.informationTypes = response.data;
            }, response => {
            	console.log(response);
            });

            // 获取由上个页面传过来的 id
			this.id = this.$route.query.id;
			if (this.id !== undefined) {
				this.$http.get(this.HOST + "/admin/informations/" + this.id).then(res => {
					this.information = res.data;
				}, res => {
					console.log(res);
				});
            }
		},
        methods: {
			submit: function () {
				// id === undefined 代表创建
				if (this.id === undefined) {
					this.$http.post(this.HOST + "/information", JSON.stringify(this.information)).then(res => {
						if (res.data === 1) {
							this.$message({
								message: "操作成功，请返回",
								type: "success"
							});
						} else if (res.data === -1) {
							this.$message({
								message: "系统错误，出现异常",
								type: "error"
							});
						}
					}, res => {
						console.log(res);
					});
                } else {

                }
			}
        }
    }
</script>