<template>
	<div>
		<p>{{myhello}}</p>

		<p class="nologin">
			<router-link to="/main/reg">注册用户</router-link>&nbsp;
			<router-link to="/main/login">登录</router-link>
		</p>


		<p class="admin">
			<router-link to="/main/user">用户中心</router-link>&nbsp;
			<router-link to="/main/newarticle">新文章</router-link>&nbsp;
			<router-link to="/main/admin">后台管理</router-link>&nbsp;
			<router-link to="/main/logout">退出</router-link>
		</p>

		<p class="author">
			<router-link to="/main/user">用户中心</router-link>&nbsp;
			<router-link to="/main/newarticle">新文章</router-link>&nbsp;
			<router-link to="/main/logout">退出</router-link>
		</p>

		<p class="user">
			<router-link to="/main/user">用户中心</router-link>&nbsp;
			<router-link to="/main/logout">退出</router-link>
		</p>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>id</th>
				<th>title</th>

			</tr>
			<tr v-for="item in articlelist">
				<td>{{item.id}}</td>
				<td>{{item.title}}</td>
				<td><button v-on:click="myview(item.id,item.title)">查看</button></td>
				<td><button class="myedit" id="myedit" v-on:click="edit(item.id,item.title)">修改</button></td>
				<td><button class="mydel" id="mydel" v-on:click="del(item.id)">删除</button></td>
			</tr>
		</table>
		<router-view></router-view>
		<!-- {{emplist}} -->
	</div>
</template>

<script>
	export default {
		name: "User2",
		props: [],
		data() {
			return {
				articlelist: [{
						id: 1,
						title: "aa",
						article: "bb"
					},
					{
						id: 2,
						title: "cc",
						article: "dd"
					}
				],
				myhello: "null22",
				role: null
			}
		},
		methods: {
			refresh() {
				if (this.$route.query.change) {
					this.update1();
					this.$route.query.change = false;
				}
				//this.setbutton();
			},


			edit(id, title) {
				// alert(id);
				this.$router.push({
					path: "/main/articlelist/edit",
					query: {
						change: true,
						id: id,
						title: title
					}
				})
				console.log(Edit);
			},
			myview(id, name) {
				// alert(id);
				this.$router.push({
					path: "/main/article",
					query: {
						change: true,
						id: id,
						name: name
					}
				})
				console.log(Edit);
			},
			del(id) {
				// alert(id);
				var that = this;
				this.$axios.post("/article/delArticle", {
					id: id
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					alert(resp.data);
					that.update1();
				});
			},
			update2(item) { //POST JS 对象数组
				console.log(item);
				console.log("u2");
				var that = this;
				this.$axios.post("/findEmpDeptBySalaryAndAge", {
					a1: "bbb",
					a2: "ccc"
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.emplist = resp.data;
					console.log(that.emplist);

				});

			},


			update1(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/article/findAllArticle", {}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.articlelist = resp.data;
					console.log(that.articlelist);
					//that.setbutton();
				});

			},
			hello(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/user/sayHello", {}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.myhello = resp.data;
					console.log(that.myhello);
				});

			},

			setbutton() {
				var b1 = document.getElementsByClassName('myedit');
				var b2 = document.getElementsByClassName('mydel');

				var that = this;

				var that = this;
				this.$axios.post("/user/getRole", {}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.role = resp.data;


					if (that.role == "nologin") {
						for (let i = 0; i < b1.length; i++) {
							b1[i].setAttribute("disabled", true);
							b2[i].setAttribute("disabled", true);
						}
					}
					if (that.role == "admin") {

						for (let i = 0; i < b1.length; i++) {
							b1[i].removeAttribute("disabled");
							b2[i].removeAttribute("disabled");
						}
					}
					if (that.role == "author") {
						for (let i = 0; i < b1.length; i++) {
							b1[i].removeAttribute("disabled");
							b2[i].removeAttribute("disabled");
						}
					}
					if (that.role == "user") {
						for (let i = 0; i < b1.length; i++) {
							b1[i].setAttribute("disabled", true);
							b2[i].setAttribute("disabled", true);
						}
					}

				});




			},
			getRole(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/user/getRole", {}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.role = resp.data;
					console.log(that.role);


					var t1 = document.getElementsByClassName('nologin')[0]; //选取id为test的元素
					t1.style.display = 'none'; // 隐藏选择的元素
					if (that.role == "nologin") {
						t1.style.display = 'block'; // 以块级样式显示
					}

					var t2 = document.getElementsByClassName('admin')[0]; //选取id为test的元素
					t2.style.display = 'none'; // 隐藏选择的元素
					if (that.role == "admin") {

						t2.style.display = 'block'; // 以块级样式显示
					}


					var t3 = document.getElementsByClassName('author')[0]; //选取id为test的元素
					t3.style.display = 'none'; // 隐藏选择的元素
					if (that.role == "author") {

						t3.style.display = 'block'; // 以块级样式显示
					}

					var t4 = document.getElementsByClassName('user')[0]; //选取id为test的元素
					t4.style.display = 'none'; // 隐藏选择的元素
					if (that.role == "user") {

						t4.style.display = 'block'; // 以块级样式显示
					}
				});

			},

		},
		mounted() {
			this.update1();
			this.hello();
			this.getRole();
			var that = this;

			this.timer = setInterval(this.refresh, 300);
			this.timer2 = setInterval(this.setbutton, 300);
		}
	}
</script>

<style>
	.myedit {}
</style>
