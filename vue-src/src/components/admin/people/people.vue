<template>
    <div>
        <el-row>
            <el-col :span="3">
                <firstTitle name="人员管理"></firstTitle>
            </el-col>
            <el-col :span="6">
                <el-select v-model="peopleType"
                           @change="_selectChange"
                           clearable
                           placeholder="请选择类别"
                           style="margin-top: 4%;">
                    <el-option v-for="type in peopleTypes"
                                :key="type.id"
                                :value="type.id"
                                :label="type.name"></el-option>
                </el-select>
            </el-col>
            <el-col :span="6" style="padding-top: 20px;">
                <router-link :to="{name: 'editInformation'}">
                    <el-button size="mini" type="success" plain>创建</el-button>
                </router-link>
            </el-col>
        </el-row>

        <el-table
                :data="people"
                style="width: 100%">
            <el-table-column
                    prop="username"
                    label="账号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="peopleType.name"
                    label="类别"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名">
            </el-table-column>
            <el-table-column
                    prop="phone"
                    label="电话">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="邮箱">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini">编辑</el-button>
                    <el-button size="mini" type="danger">删除</el-button>
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
		name: 'people',
        data() {
			return {
				people: [],
                peopleTypes: [],
                currentPage: 1,
                pageSize: 10,
                total: 0,
                peopleType: ""
            };
        },
        components: {
	        firstTitle
        },
        methods: {
			_getPeople() {
                this.$http.get(this.$store.state.domain + "/admin/people", {params: {
                	page: this.currentPage, per_page: this.pageSize, peopleType: this.peopleType
                }}).then(res => {
                    this.people = res.data;
                }, res => {
                	console.log(res);
                });
            },
            _getCount() {
				this.$http.get(this.$store.state.domain + "/admin/people/count", {params: {
					peopleType: this.peopleType
                }}).then(res => {
                	this.total = res.body;
                }, res => {
                	console.log(res);
                });
            },
	        _sizeChange(currentPage) {
                this.currentPage = currentPage;
                this._getPeople();
            },
            _selectChange() {
				this._getPeople();
				this._getCount();
            }
        },
        created() {
            this._getPeople();
            this._getCount();
	        this.$http.get(this.$store.state.domain + "/admin/peopleTypes").then(res => {
		        this.peopleTypes = res.data;
	        }, res => {
		        console.log(res);
	        });
        }
    }
</script>