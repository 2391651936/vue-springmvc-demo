// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import Element from "element-ui"
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import VueResource from 'vue-resource'

Vue.config.productionTip = false;

Vue.use(Element);
Vue.use(VueResource);
Vue.http.options.xhr = { withCredentials: true };
Vue.use(Vuex);

const store = new Vuex.Store({
	state: {
		domain: "http://127.0.0.1:8080/v1",
		token: "",
	},
	mutations: {
		//更新用户信息
		updateToken(state, id) {
			state.token = id;
		}
	}
});

Vue.http.interceptors.push((request, next) => {
	request.credentials = true;
	next();
});

router.beforeEach((to, form, next) => {
	if (to.meta.requireAuth) {
		if (store.state.token !== "") {
			next();
		} else {
			next({name: "login"});
		}
	} else {
		next();
	}
});

Vue.prototype.$judge = function (data, name) {
	if (data === 1) {
		this.$message({
			message: "操作成功",
			type: "success"
		});
		this.$router.push({name: name});
	} else if (data === -1) {
		this.$message({
			message: "系统错误，出现异常",
			type: "error"
		});
	} else if (data === 0) {
		this.$message({
			message: "已经存在",
			type: "error"
		});
	}
};

/* eslint-disable no-new */
new Vue({
	el: '#app',
	router,
	store,
	components: { App },
	template: '<App/>',
});


Date.prototype.format = function(fmt) {
	let o = {
		"M+" : this.getMonth()+1,                 //月份
		"d+" : this.getDate(),                    //日
		"h+" : this.getHours(),                   //小时
		"m+" : this.getMinutes(),                 //分
		"s+" : this.getSeconds(),                 //秒
		"q+" : Math.floor((this.getMonth()+3)/3), //季度
		"S"  : this.getMilliseconds()             //毫秒
	};
	if(/(y+)/.test(fmt)) {
		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	}
	for(let k in o) {
		if(new RegExp("("+ k +")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
		}
	}
	return fmt;
};