<template>
    <div>
        <template v-if="id === undefined">
            <first-title name="创建公告"></first-title>
        </template>
        <template v-else>
            <first-title name="修改公告"></first-title>
        </template>

        <div class="form-control">
            <label>标题</label>
            <el-input
                    v-model="information.title"
                    placeholder="请输入标题"
                    clearable>
            </el-input>
        </div>

        <div class="form-control">
            <label>类别</label>
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
        </div>

        <div class="form-control">
            <label>信息内容</label>
            <el-input
                    type="textarea"
                    :rows="4"
                    placeholder="请输入内容"
                    v-model="information.context">
            </el-input>
        </div>

        <div class="form-control">
            <label>是否发布</label>
            <el-switch
                    v-model="information.isRelease"
                    activeColor="#13ce66"
                    inactiveColor="#ff4949" style="margin-left: 1%;">
            </el-switch>
        </div>

        <div>
            <router-link :to="{name: 'information'}">
                <el-button size="small" plain="">返回</el-button>
            </router-link>
            <el-button size="small" type="primary" plain
                        @click="submit">提交</el-button>
        </div>
    </div>
</template>

<script>
	import firstTitle from '../title.vue'

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
			firstTitle
        },
        created: function () {
			// 获取所有类别
            this.$http.get(this.HOST + "/informationTypes").then(response => {
            	this.informationTypes = response.data;
            }, response => {
            	console.log(response);
            });

            // 获取由上个页面传过来的 id
			this.id = this.$route.params.id;
			if (this.id !== undefined) {
				this.$http.get(this.HOST + "/informations/" + this.id).then(res => {
					this.information = res.data;
					console.log(this.information)
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