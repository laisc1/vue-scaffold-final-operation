import Vue from "vue"
import VueRouter from "vue-router"
Vue.use(VueRouter)

import MainView from "../MainView.vue"
import Main from "../views/Main.vue"
import ArticleList from "../views/main/ArticleList.vue"

import Edit from "../views/main/article/Edit.vue"
import Test from "../views/main/Test.vue"
import TestBlank from "../views/main/test/Blank.vue"
import TestLogin from "../views/main/test/Login.vue"
import TestLogout from "../views/main/test/Logout.vue"
import TestInfo from "../views/main/test/Info.vue"
import TestTag from "../views/main/test/Tag.vue"
import Article from "../views/main/Article.vue"
import Login from "../views/main/Login.vue"
import Logout from "../views/main/Logout.vue"
import Reg from "../views/main/Reg.vue"
import Admin from "../views/main/Admin.vue"
import AdminEdit from "../views/main/admin/Edit.vue"
import NewArticle from "../views/main/NewArticle.vue"
import User from "../views/main/User.vue"
import ChangePw from "../views/main/user/ChangePw.vue"

const routes2 = [{
		path: '/',
		redirect: '/main/articlelist',
		component: MainView
	},
	{
		path: '/main',
		component: Main,
		children: [{
				path: 'articlelist',
				component: ArticleList,
				children: [{
					path: 'edit',
					component: Edit,
					props: true
				}]
			},
			{
				path: 'test',
				redirect: 'test/blank',
				component: Test,
				children: [{
						path: 'blank',
						component: TestBlank,
						props: true
					},
					{
						path: 'login',
						component: TestLogin,
						props: true
					},
					{
						path: 'logout',
						component: TestLogout,
						props: true
					},
					{
						path: 'getinfo',
						component: TestInfo,
						props: true
					},
					{
						path: 'tag',
						component: TestTag,
						props: true
					}
				]
			},
			{
				path: 'article',
				component: Article,
				props: true
			},
			{
				path: 'login',
				component: Login,
				props: true
			},
			{
				path: 'logout',
				component: Logout,
				props: true
			},
			{
				path: 'reg',
				component: Reg,
				props: true
			},
			{
				path: 'admin',
				component: Admin,
				props: true,
				children: [{

					path: 'edit',
					component: AdminEdit,
					props: true,

				}]
			},
			{
				path: 'newarticle',
				component: NewArticle,
				props: true
			},
			{
				path: 'user',
				component: User,
				props: true,
				children: [{
					path: 'changepw',
					component: ChangePw,
					props: true
				}]
			},
		]
	},

]


const router = new VueRouter({
	"routes": routes2
})
export default router;
