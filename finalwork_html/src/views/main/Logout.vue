<template>
	<div>
		状态：
		{{mydata}}
		
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
				
				mydata:"null"
			}
		},
		methods: {
			
			
			
			logout(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/user/logout", {
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					
					that.mydata = resp.data;
					console.log(that.emplist);
					that.gotohome();
				});
			
			},
			
			gotohome() {
				// alert(id);
				this.$router.push({
					path: "/main/articlelist",
					query: {
						
					}
				})
				
			}


		},
		mounted() {
			this.logout();

		}
	}
</script>

<style>
</style>
