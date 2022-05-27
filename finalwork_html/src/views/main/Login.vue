<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>登录</th>
			</tr>
			
			<tr>
				<td>用户名(username)</td>
				<td><input type="text" name="" id="" value="" v-model="username" /></td>
			</tr>
			<tr>
				<td>密码(password)</td>
				<td><input type="password" name="" id="" value="" v-model="password" /></td>
			</tr>
			
			<tr>
				<td><input type="button" name="" id="" value="确定" @click="submit"/></td><td>{{msg}}</td>
			</tr>
		</table>
		<div><b></b></div>
		
	</div>
</template>

<script>
	export default {
		name: "edit",
		props: [],
		data() {
			return {
				deptlist: null,
				dname: null,
				msg:""
			}
		},
		methods: {
			submit(){
				var that = this;
				
				this.$axios.post("/user/login", {
					username: this.username,
					password: this.password
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.msg=resp.data;
					if (resp.data=="成功登录"){
						that.gotohome();
					}
					//console.log(resp);
				})
				// alert(this.$route.query.id);
			},
			gotohome(id,name) {
				// alert(id);
				this.$router.push({
					path: "/main/articlelist",
					query: {
						
					}
				})
				
			}
		},
		mounted() {
			
			

		}
	}
</script>

<style>
</style>
