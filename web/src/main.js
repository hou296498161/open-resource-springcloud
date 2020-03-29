import Vue from 'vue'
import App from './App.vue'


import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/en'

import 'element-ui/lib/theme-chalk/index.css';

import router from './router/index'
import login from "@/api/Login";
import ZuulRouter from "@/api/ZuulRouter";
import Authentication from "@/api/Authentication";



Vue.use(ElementUI,locale)

Vue.prototype.$Login=new login();

Vue.prototype.$ZuulRouter=new ZuulRouter();

Vue.prototype.$Authentication=new Authentication();

Vue.config.productionTip = false

window.vue=new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
