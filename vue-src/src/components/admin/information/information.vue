<template>
    <div>
        <el-row>
            <el-col :span="6">
                <firstTitle name="公告管理"></firstTitle>
            </el-col>
            <el-col :span="6" style="padding-top: 20px;">
                <router-link :to="{name: 'editInformation'}">
                    <el-button size="mini" type="success" plain>创建</el-button>
                </router-link>
            </el-col>
        </el-row>

        <el-table
                :data="informations"
                style="width: 100%">
            <el-table-column
                    label="标题"
                    width="300">
                <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                        <div>
                            内容：<span v-html="scope.row.context"></span>
                        </div>
                        <div slot="reference" class="name-wrapper">
                            <el-tag size="medium">{{ scope.row.title }}</el-tag>
                        </div>
                    </el-popover>
                </template>
            </el-table-column>
            <el-table-column
                    label="时间"
                    width="300">
                <template slot-scope="scope">
                    <i class="el-icon-time"></i>
                    <span>{{ new Date(scope.row.releaseTime).format("yyyy-MM-dd hh:mm:ss") }}</span>
                </template>
            </el-table-column>
            <el-table-column
                    label="状态"
                    width="200">
                <template slot-scope="scope">
                    <span>{{ scope.row.isRelease? "已发布": "未发布" }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <router-link :to="{name: 'editInformation', query:{id: scope.row.id}}">
                        <el-button
                            size="mini"
                            >编辑
                        </el-button>
                    </router-link>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="_delete(scope.row.id)"
                            >删除
                    </el-button>
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
		name: 'information',
		data() {
			return {
				informations: [],
                currentPage: 1,
                pageSize: 10,
                total: 0,
			}
		},
		components: {
			firstTitle
        },
        methods: {
			_getInformations: function() {
				this.$http.get(this.$store.state.domain + "/admin/informations", {
					params: {page: this.currentPage, per_page: this.pageSize}
				}, {emulateJSON: true}).then(response => {
					this.informations = response.data;
				}, response => {
					console.log(response);
				});
            },
            _sizeChange: function (currentPage) {
				this.currentPage = currentPage;
                this._getInformations();
            },
	        _delete: function (id) {
		        this.$confirm('是否删除此公告?', '提示', {
			        confirmButtonText: '确定',
			        cancelButtonText: '取消',
			        type: 'warning'
		        }).then(() => {
		        	this.$http.delete(this.$store.state.domain + "/admin/informations", {params: {id: id}}).then(res => {
                        if (res.body === 1) {
                        	this._getInformations();
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
	        },
            _getCount: function () {
	            this.$http.get(this.$store.state.domain + "/admin/information/count").then(res => {
		            this.total = res.body;
	            }, res => {
		            console.log(res);
	            });
            }
        },
		created: function () {
            this._getCount();
			this._getInformations();
		},
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
