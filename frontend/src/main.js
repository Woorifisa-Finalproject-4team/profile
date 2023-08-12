import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css'
import bootstrap from 'bootstrap/dist/js/bootstrap.bundle.js'
import router from './router'
import axios from 'axios'


axios.defaults.baseURL = "http://localhost:8080";
const app = createApp(App)
app.config.globalProperties.axios = axios;

app.use(bootstrap)
app.use(createPinia())
app.use(router)

app.mount('#app')
