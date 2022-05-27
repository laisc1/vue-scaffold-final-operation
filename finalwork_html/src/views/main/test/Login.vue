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
				emplist: [{
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
				mydata:"null"
			}
		},
		methods: {
			
			
			
			login(item) { //POST JS 对象数组
				var that = this;
				this.$axios.post("/test/login", {
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.emplist = resp.data;
					that.mydata = resp.data;
					console.log(that.emplist);
				});
			
			},


		},
		mounted() {
			this.login();

		}
	}
</script>

<style>
</style>
