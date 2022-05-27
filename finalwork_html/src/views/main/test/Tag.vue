<template>
	<div>
		null2
		<input type="button" @click="myshow()" value="显示"/>
		<input type="button" @click="myhide()" value="隐藏"/>
		<div class="mytag">
		<router-link to="/main/test/blank">空白</router-link>&nbsp;
		<router-link to="/main/test/login">登录</router-link>&nbsp;
		<router-link to="/main/test/logout">退出</router-link>&nbsp;
		<router-link to="/main/test/getinfo">信息</router-link>&nbsp;
		<router-link to="/main/test/tag">标签</router-link>&nbsp;
		</div>
	</div>
</template>

<script>
	export default {
		name: "edit",
		props: [],
		data() {
			return {
				deptlist: null,
				dname: null
			}
		},
		methods: {
			myshow(){
				var t = document.getElementsByClassName('mytag')[0];//选取id为test的元素
				t.style.display = 'block';	// 以块级样式显示
			},
			myhide(){
				var t = document.getElementsByClassName('mytag')[0];//选取id为test的元素
				t.style.display = 'none';	// 隐藏选择的元素
			}
		},
		mounted() {
			
			

		}
	}
</script>

<style>
</style>
