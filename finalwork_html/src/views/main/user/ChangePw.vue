<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>修改密码</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input disabled="true" type="text" name="" id="" value="" v-model="userlist.id" /></td>
			</tr>
			<tr>
				<td>username</td>
				<td><input disabled="true" type="text" name="" id="" value="" v-model="userlist.username" /></td>
			</tr>
			
			
			<tr>
				<td>原密码</td>
				<td><input type="password" name="" id="" value="" v-model="userlist.oldPw" /></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" name="" id="" value="" v-model="userlist.newPw" /></td>
			</tr>
			<tr>
				<td><input type="button" name="" id="" value="确定" @click="submit"/></td><td>{{msg}}</td>
			</tr>
		</table>
		
	</div>
</template>

<script>
	export default {
		name: "myedit",
		props: [],
		data() {
			return {
				userlist: {
					id:0,
					username:"nologin",
					signature:"null"
				},
				dname: null,
				did:2,
				timer: null,
				msg:""
			}
		},
		methods: {
			
			getUser() { //POST JS 
				var that = this;

				this.$axios.post("/user/getUser", {
					
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.userlist=resp.data;
				})
			},
			stop(){
				//clearInterval(this.timer);
				//alert(this.$route.query.id);
			},
			submit(){
				var that = this;
				
				
				this.$axios.post("/user/updatePassword", {
					
					id:that.userlist.id,
					oldPw:that.userlist.oldPw,
					newPw:that.userlist.newPw
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.msg=resp.data;
					
					//console.log(resp);
				})
				// alert(this.$route.query.id);
			}
		},
		mounted() {
			//this.did = this.$route.query.did;
			this.getUser();
			//console.log(this.dept);
			

		}
	}
</script>

<style>
</style>
