<template>
	<div>
		<router-link to="/main/test/blank">空白</router-link>&nbsp;
		<router-link to="/main/test/login">登录</router-link>&nbsp;
		<router-link to="/main/test/logout">退出</router-link>&nbsp;
		<router-link to="/main/test/getinfo">信息</router-link>&nbsp;
		<router-link to="/main/test/tag">标签</router-link>&nbsp;
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
				]
			}
		},
		methods: {


		},
		mounted() {
			

		}
	}
</script>

<style>
</style>
