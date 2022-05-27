<template>
	<div>
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>修改</th>
			</tr>
			<tr>
				<td>id</td>
				<td><input type="text" name="" id="" value="" v-model="$route.query.id" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="" id="" value="" v-model="$route.query.name" /></td>
			</tr>
			<tr>
				<td>age</td>
				<td><input type="text" name="" id="" value="" v-model="$route.query.age" /></td>
			</tr>
			<tr>
				<td>sex</td>
				<td><input type="text" name="" id="" value="" v-model="$route.query.sex" /></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="" id="" value="" v-model="$route.query.salary" /></td>
			</tr>
			<tr>
				<td>dname</td>
				<td>

					<select name="" v-model="did">
						<option v-bind:value ="d.id" v-for="(d,idx) in deptlist">{{d.name}}</option>
					</select>

					<!-- <select  name="" >
			<option >1</option>
			<option >2</option>
			<option >3</option>
		</select> -->



				</td>
			</tr>
			<tr>
				<td><input type="button" name="" id="" value="确定" @click="submit"/></td><td>{{msg}}</td>
			</tr>
		</table>
		<div><b>id是{{$route.query.id}}</b></div>
		{{deptlist}}
	</div>
</template>

<script>
	export default {
		name: "edit",
		props: [],
		data() {
			return {
				deptlist: null,
				dname: null,
				did:2,
				timer: null,
				msg:""
			}
		},
		methods: {
			refresh() {
				if(this.$route.query.change){
					this.did = this.$route.query.did;
					this.$route.query.change=false;
				}
				
				
				//this.dname = this.$route.query.dname;
				//console.log(1122);
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
					that.deptlist=resp.data;
					console.log(that.deptlist);
				})
			},
			stop(){
				//clearInterval(this.timer);
				//alert(this.$route.query.id);
			},
			submit(){
				var that = this;
				
				
				this.$axios.post("/updateEmp/"+this.$route.query.id+"/", {
					name: this.$route.query.name,
					age: this.$route.query.age,
					sex:this.$route.query.sex,
					deptid:this.did,
					salary:this.$route.query.salary
				}, {
					headers: {
						'Content-Type': 'application/json'
					}
				}).then(function(resp) {
					//console.log(resp);
					that.msg="修改成功";
					//console.log(resp);
				})
				// alert(this.$route.query.id);
			}
		},
		mounted() {
			//this.did = this.$route.query.did;
			this.timer = setInterval(this.refresh, 300);
			console.log("=========================");
			console.log(this.did);
			this.getDept();
			//console.log(this.dept);
			

		}
	}
</script>

<style>
</style>
