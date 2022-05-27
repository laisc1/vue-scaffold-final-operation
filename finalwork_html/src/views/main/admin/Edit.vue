<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>修改</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input disabled="true" type="text" name="" id="" value="" v-model="$route.query.id" /></td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="" id="" value="" v-model="userlist.username" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="" id="" value="" v-model="userlist.password" /></td>
			</tr>
			<tr>
				<td>role</td>
				<td><input type="text" name="" id="" value="" v-model="userlist.role" /></td>
			</tr>
			<tr>
				<td>signature</td>
				<td><input type="text" name="" id="" value="" v-model="userlist.signature" /></td>
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
				userlist: null,
				dname: null,
				did:2,
				timer: null,
				msg:""
			}
		},
		methods: {
			refresh() {
				if(this.$route.query.change){
					this.getUser();
					this.$route.query.change=false;
				}
				
				
				//this.dname = this.$route.query.dname;
				//console.log(1122);
			},
			
			getUser() { //POST JS 
				var that = this;

				this.$axios.post("/user/findUserWithNoPassword", {
					id: this.$route.query.id
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.userlist=resp.data;
					console.log(that.userlist);
				})
			},
			stop(){
				//clearInterval(this.timer);
				//alert(this.$route.query.id);
			},
			submit(){
				var that = this;
				
				
				this.$axios.post("/user/updateUserByAdmin", {
					id: this.$route.query.id,
					username: this.userlist.username,
					password:this.userlist.password,
					role:this.userlist.role,
					signature:this.userlist.signature
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.msg=resp.data;
					that.$route.query.change2=true;
					//console.log(resp);
				})
				// alert(this.$route.query.id);
			}
		},
		mounted() {
			//this.did = this.$route.query.did;
			this.timer = setInterval(this.refresh, 300);
			this.getUser();
			//console.log(this.dept);
			

		}
	}
</script>

<style>
</style>
