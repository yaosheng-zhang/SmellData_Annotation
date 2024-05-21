import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router';
import DashBoard from './components/DashBoard.vue';
import DataCollection from './components/DataCollection.vue';


Vue.use(VueRouter);

const routes = [
  { path: '/home', component: DashBoard },
  { path: '/data', component: DataCollection }
];
const router = new VueRouter({
  routes,
  mode: 'history', // 可选项，使用 HTML5 history 模式，去除 URL 中的 #
});

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
