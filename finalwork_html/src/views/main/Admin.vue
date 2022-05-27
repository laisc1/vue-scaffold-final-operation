<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>id</th>
				<th>username</th>
				<th>role</th>
				<th>signature</th>
			</tr>
			<tr v-for="item in userlist">
				<td>{{item.id}}</td>
				<td>{{item.username}}</td>
				<td>{{item.role}}</td>
				<td>{{item.signature}}</td>
				
				<td><button v-on:click="edit(item.id)">修改</button></td>
				<td><button v-on:click="del(item.id)">删除</button></td>
			</tr>
		</table>
		<router-view></router-view>
	</div>
</template>

<script>
	export default {
		name: "User2",
		props: [],
		data() {
			return {
				userlist: [{
						id: 1,
						username: "aa",
						role: "bb",
						signature:"cc"
					},
					{
						id: 2,
						username: "dd",
						role: "ee",
						signature:"ff"
					}
				],
				myhello:"null22",
				role:null
			}
		},
		methods: {
			
			refresh() {
				if(this.$route.query.change2){
					this.update1();
					this.$route.query.change2=false;
				}},
				
				
			edit(id) {
				// alert(id);
				this.$router.push({
					path: "/main/admin/edit",
					query: {
						change: true,
						id: id
					}
				})
				console.log(Edit);
			},
			
			
			update1(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/user/findAllUserWithNoPassword", {  
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.userlist = resp.data;
					
				});
			
			},
			del(id) {
				var that = this;
				this.$axios.post("/user/delUser", {  
					id:id
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
				
			}
			

		},
		mounted() {
			this.update1();
			this.timer = setInterval(this.refresh, 300);
			
		}
	}
</script>

<style>
</style>