<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>新文章</th>
			</tr>

			<tr>
				<td>title</td>
				<td><input type="text" name="" id="" value="" v-model="articletitle" /></td>
			</tr>
			<tr>
				<td>article</td>
				<td>
					<div id="WangEditor" class="editor"></div>
				</td>
			</tr>

			<tr>
				<td><input type="button" name="" id="" value="确定" @click="submit()" /></td>
				<td>{{msg}}</td>
			</tr>
		</table>
		<div><b>id是{{$route.query.id}}</b></div>
		{{deptlist}}
	</div>
</template>

<script>
	import WangEditor from "wangeditor";

	export default {
		name: "edit",
		props: [],
		data() {
			return {
				deptlist: null,
				dname: null,
				did: 2,
				timer: null,
				msg: ""
			}
		},
		methods: {


			getDept() { //POST JS 
				var that = this;

				this.$axios.post("/findAllDept", {
					a1: "bbb",
					a2: "ccc"
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.deptlist = resp.data;
					console.log(that.deptlist);
				})
			},
			stop() {
				//clearInterval(this.timer);
				//alert(this.$route.query.id);
			},
			submit() {
				var that = this;


				this.$axios.post("/article/addArticle" , {
					title: this.articletitle,
					article: this.editor.txt.html()
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.msg = resp.data;
					//console.log(resp);
				})
				// alert(this.$route.query.id);
			},
			submit2() {
				alert(this.editor.txt.html());
			}
		},
		mounted() {




			let that = this
			this.editor = new WangEditor('#WangEditor') //这个地方传入div元素的id 需要加#号
			// 配置 onchange 事件
			// this.editor.change = function() { // 这里是change 不是官方文档中的 onchange
			// 	// 编辑区域内容变化时，实时打印出当前内容
			// 	alert(this.txt.html())
			// 	console.log(this.txt.html())
			// }
			this.editor.create() // 生成编辑器
			//this.editor.txt.html('<p>输入内容...</p>')




		}
	}
</script>

<style>
</style>
