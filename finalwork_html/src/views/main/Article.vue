<template>
	<div>

		<div>
			<h1>{{article.title}}</h1>
			<div v-html="article.article"></div>
		</div>
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
				article:{
						id: 1,
						title: "aa",
						article: "bb"
					}
				
			}
		},
		methods: {
			
			
			
			update1() { //POST JS 对象数组
				var that = this;
				this.$axios.post("/article/findArticleById", {
					id: that.$route.query.id
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					//console.log(JSON.stringify(resp));
					that.article = resp.data;
					console.log(that.article);
				});
			
			}


		},
		mounted() {
			this.update1();

		}
	}
</script>

<style>
</style>
