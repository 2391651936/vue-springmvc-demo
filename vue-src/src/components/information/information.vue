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
                    <router-link :to="{name: 'editInformation', params:{id: scope.row.id}}">
                        <el-button
                            size="mini"
                            >编辑
                        </el-button>
                    </router-link>
                    <el-button
                            size="mini"
                            type="danger"
                            >删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
	import firstTitle from '../title.vue'
	import ElCol from "element-ui/packages/col/src/col";

	export default {
		name: 'information',
		data() {
			return {
				informations: [],
                replace: true
			}
		},
		components: {
			ElCol,
			firstTitle},
        created: function () {
            this.$http.get(this.HOST + "/informations", {page: 1, per_page: 10}).then(response => {
            	this.informations = response.data;
            }, response => {
            	console.log(response);
            });
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
