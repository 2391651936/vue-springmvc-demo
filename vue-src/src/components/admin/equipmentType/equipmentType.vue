<template>
    <div>
        <el-row>
            <el-col :span="6">
                <first-title name="设备类别管理"></first-title>
            </el-col>
            <el-col :span="6" style="padding-top: 20px;">
                <router-link :to="{name: 'editEquipmentType'}">
                    <el-button size="mini" type="success" plain>创建</el-button>
                </router-link>
            </el-col>
        </el-row>

        <el-table style="width: 100%" :data="equipmentTypes">
            <el-table-column
                    prop="name"
                    label="名称"
                    width="180">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <router-link :to="{name: 'editEquipmentType', query: {id: scope.row.id}}">
                        <el-button size="mini">编辑</el-button>
                    </router-link>
                    <el-button size="mini" type="danger" @click="_delete(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <div class="block">
            <el-pagination
                    @current-change="_sizeChange"
                    :current-page="currentPage"
                    :page-size="pageSize"
                    layout="prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
	import firstTitle from '../../title.vue'

	export default {
		name: "equipmentType",
		data() {
			return {
				equipmentTypes: [],
                currentPage: 1,
                pageSize: 10,
                total: 0,
            };
        },
        components: {firstTitle},
        methods: {
			_getEquipmentType() {
                this.$http.get(this.$store.state.domain + "/admin/equipmentType", {params: {
                	page: this.currentPage, maxNumber: this.pageSize
                }}).then(res => {
                	this.equipmentTypes = res.data;
                }, res => {
                	console.log(res);
                });
            },
            _getCount() {
				this.$http.get(this.$store.state.domain + "/admin/equipmentType/count").then(res => {
					this.total = res.body;
                }, res => {
					console.log(res);
                });
            },
            _sizeChange(currentPage) {
                this.currentPage = currentPage;
                this._getEquipmentType();
            },
			_delete(id) {
				this.$confirm('是否删除?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.$http.delete(this.$store.state.domain + "/admin/equipmentType", {params: {id: id}}).then(res => {
						if (res.body === 1) {
							this._getEquipmentType();
							this._getCount();
							this.$message({
								type: 'success',
								message: '删除成功!'
							});
						} else {
							this.$message({
								type: 'waring',
								message: '服务器异常'
							});
						}
					}, res => {
						this.$message({
							type: 'waring',
							message: '服务器异常'
						});
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
            }
        },
        created() {
            this._getEquipmentType();
            this._getCount();
        },
	}
</script>

<style scoped>

</style>