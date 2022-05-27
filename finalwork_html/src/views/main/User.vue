<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>修改</th>
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
				<td>signature</td>
				<td><input type="text" name="" id="" value="" v-model="userlist.signature" /></td>
			</tr>
			
			<tr>
				<td><input type="button" name="" id="" value="确定" @click="submit"/></td><td>{{msg}}</td>
			</tr>
		</table>
		<router-link to="/main/user/changepw">修改密码</router-link>
		<router-view></router-view>
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
				
				
				this.$axios.post("/user/updateUser", {
					
					signature:this.userlist.signature
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
