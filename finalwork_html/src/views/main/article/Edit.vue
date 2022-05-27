<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>修改文章</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input disabled="true" type="text" name="" id="" value="" v-model="$route.query.id" /></td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text" name="" id="" value="" v-model="article.title" /></td>
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
		
	</div>
</template>

<script>
	import WangEditor from "wangeditor";

	export default {
		name: "edit",
		props: [],
		data() {
			return {
				article: {
					id: 1,
					title: "aa",
					article: "bb"
				},
				deptlist: null,
				dname: null,
				did: 2,
				timer: null,
				msg: "",
				change: true
			}
		},
		methods: {

			refresh() {
				if (this.$route.query.change) {
					this.update1();
					this.$route.query.change = false;
				}
			},

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
					that.editor.txt.html(that.article.article)
					console.log(that.article);
				})
			},


			submit() {
				var that = this;

				this.$axios.post("/article/updateArticle", {
					id: this.$route.query.id,
					title: this.article.title,
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
				that.$route.query.change = true;
			},
			submit2() {
				alert(this.editor.txt.html());
			}
		},
		mounted() {




			let that = this;
			this.editor = new WangEditor('#WangEditor'); //这个地方传入div元素的id 需要加#号
			// 配置 onchange 事件
			// this.editor.change = function() { // 这里是change 不是官方文档中的 onchange
			// 	// 编辑区域内容变化时，实时打印出当前内容
			// 	alert(this.txt.html())
			// 	console.log(this.txt.html())
			// }
			this.editor.create(); // 生成编辑器
			//this.editor.txt.html('<p>输入内容...</p>')

			this.update1();
			this.timer = setInterval(this.refresh, 300);

		}
	}
</script>

<style>
</style>
