import Vue from 'vue'
import App from './MainView.vue'

import router2 from './router/Main1.js'

import axios from 'axios'
Vue.prototype.$axios = axios



Vue.config.productionTip = false

//axios.defaults.baseURL = "http://localhost:8020";

axios.defaults.withCredentials = true

new Vue({
  render: h => h(App),
  router:router2,
}).$mount('#app')