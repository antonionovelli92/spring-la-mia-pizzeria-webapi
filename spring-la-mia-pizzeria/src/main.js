
import { createApp } from 'vue';
import { routes } from '../src/router/index';
import App from './App.vue';
import 'bootstrap/dist/css/bootstrap.min.css';
const app = createApp(App);
app.use(routes);
app.mount('#app');
