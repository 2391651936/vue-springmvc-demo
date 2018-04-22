<template>
    <div>
        <template v-if="id === undefined">
            <first-title name="创建设备类别"></first-title>
        </template>
        <template v-else>
            <first-title name="修改设备类别"></first-title>
        </template>

        <el-form>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="名称">
                        <el-input
                                v-model="equipmentType.name"
                                placeholder="请输入名称"
                                style="width: 100%">
                        </el-input>
                    </el-form-item>

                    <el-form-item>
                        <router-link :to="{name: 'equipmentType'}">
                            <el-button size="small" plain="">返回</el-button>
                        </router-link>
                        <el-button size="small" type="primary" plain
                                   @click="submit">提交</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>

<script>
	import firstTitle from "../../title";
	export default {
		name: "editEquipmentType",
		components: {firstTitle},
		data() {
			return {
				id: "",
                equipmentType: {
					name: ""
                }
            }
        },
        created() {
			this.id = this.$route.query.id;
            if (this.id !== undefined) {
            	this.$http.get(this.$store.state.domain + "/admin/equipmentType/" + this.id).then(res => {
            		this.equipmentType = res.data;
                }, res => {
            		console.log(res);
                });
            }
        },
        methods: {
			submit() {
				if (this.id === undefined) {
					this.$http.post(this.$store.state.domain + "/admin/equipmentType", JSON.stringify(this.equipmentType)).then(res => {
						this.$judge(res.data, "equipmentType");
                    }, res => {
						console.log(res);
                    });
                } else {
					this.$http.put(this.$store.state.domain + "/admin/equipmentType", JSON.stringify(this.equipmentType)).then(res => {
						this.$judge(res.data, "equipmentType");
                    }, res => {
						console.log(res);
                    });
                }
            }
        }
	}
</script>

<style scoped>

</style>